package app.springbootdemo.service;


import app.springbootdemo.database.dbmodel.*;
import app.springbootdemo.database.mapper.EmployeeMapper;
import app.springbootdemo.database.repository.*;
import app.springbootdemo.exceptions.StartTimeAlreadyRecordedException;
import app.springbootdemo.service.mapper.EmployeeBOMapper;
import app.springbootdemo.service.model.*;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Service
public class EmployeeService {


    final EmployeeRepository employeeRepository;

    final TimeTableRepository timeTableRepository;

    final HoliDayRepository holiDayRepository;

    final IllRepository illRepository;

    final TelephoneRepository telephoneRepository;

    final AddressRepository addressRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, TimeTableRepository timeTableRepository, HoliDayRepository holiDayRepository,
                           IllRepository illRepository, TelephoneRepository telephoneRepository, AddressRepository addressRepository) {
        this.employeeRepository = employeeRepository;
        this.timeTableRepository = timeTableRepository;
        this.holiDayRepository = holiDayRepository;
        this.illRepository = illRepository;
        this.telephoneRepository = telephoneRepository;
        this.addressRepository = addressRepository;
    }


    public List<Employee> getAll() {
        List<Employee> list = new ArrayList<>();
        Iterable<Employee> employees = employeeRepository.findAll();
        employees.forEach(list::add);
        return list;
    }

    public EmployeeBO postEmployee(EmployeeBO employeeBO) {
        EmployeeBO employeeBO1 = EmployeeBOMapper.from(employeeRepository.save(EmployeeMapper.from(employeeBO)));
        return employeeBO1;
    }


    public List<Employee> findByLastName(String lastName) {
        List<Employee> employee = employeeRepository.findByLastName(lastName);
        return employee;
    }
    public Optional<Employee> findEmployeewithId(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee;
    }


    public void deleteEmployee(long id){
        employeeRepository.deleteById(id);
    }


    public void ill(IllBO illBO) {
        Date startDate = illBO.getIllFromDate();// + "8:00";
        Date endDate = illBO.getIllToDate();// + "16:00";
        Employee emp = employeeRepository.findById((illBO.getEmpId())).get();
        Ill ill = new Ill();
        ill.setEmployee(emp);
        ill.setBegin(LocalTime.now());
        ill.setEnd(LocalTime.now());
        ill.setBegin_break(null);
        ill.setEnd_break(null);
        emp.getTimeTable().add(ill);
        illRepository.save(ill);


        //System.out.println(emp.getFirstName());
        //System.out.println(emp.getId());
        //emp.getTimeTable().add(IllMapper.from(startTime, endTime, begin_Break, end_Break));
        //System.out.println("/////////////////////////////////////////   " + timeTable.getEmployee().getId());
    }


    public void holiDay(HoliDayBO holiDayBO) {
        Date startDate = holiDayBO.getFromDate();
        Date endDate = holiDayBO.getToDate();// + "16:00";
        Employee emp = employeeRepository.findById((holiDayBO.getId())).get();
        HoliDay holiDay = new HoliDay();
        holiDay.setEmployee(emp);
        holiDay.setBegin(LocalTime.now());
        holiDay.setEnd(LocalTime.now());
        holiDay.setBegin_break(null);
        holiDay.setEnd_break(null);
        emp.getTimeTable().add(holiDay);
        holiDayRepository.save(holiDay);

    }


    public void startTime(long pEmployeeId){

        Employee emp = employeeRepository.findById(pEmployeeId).get();
        Set<TimeTable> lastTimeTable = timeTableRepository.findStartTimeforEmpId(pEmployeeId);
        if(lastTimeTable.size()>=1) {
            throw new StartTimeAlreadyRecordedException("Start time already logged");
        }
        TimeTable lcWorkingDay = new TimeTable();
        lcWorkingDay.setEmployee(emp);
        lcWorkingDay.setStartDate(LocalDate.now());
        lcWorkingDay.setBegin(LocalTime.now());
        emp.getTimeTable().add(lcWorkingDay);
        timeTableRepository.save(lcWorkingDay);


    }

    public void endTime(long pEmployeeId) {
        Employee emp = employeeRepository.findById(pEmployeeId).get();
        Optional<TimeTable> currentTimeTableOptional = timeTableRepository.findForCurrentTimeTableForEmployee(emp.getId()).stream().findFirst();
        if (currentTimeTableOptional.isPresent()) {
            TimeTable currentTimeTable = currentTimeTableOptional.get();
            currentTimeTable.setEnd(LocalTime.now());
            currentTimeTable.setEndDate(LocalDate.now());
            timeTableRepository.save(currentTimeTable);
        }

    }


    public void startBreakTime(long pEmployeeId) {
        Employee emp = employeeRepository.findById(pEmployeeId).get();
        Optional<TimeTable> currentTimeTableOptional = timeTableRepository.currentTimeTableForEmployee1(emp.getId()).stream().findFirst();
        if (currentTimeTableOptional.isPresent()) {
            TimeTable currentTimeTable = currentTimeTableOptional.get();
            currentTimeTable.setStartDate(LocalDate.now());
            currentTimeTable.setBegin_break(LocalTime.now());
            timeTableRepository.save(currentTimeTable);
        }
    }


    public void stopBreakTime(long pEmployeeId){
        Employee emp = employeeRepository.findById(pEmployeeId).get();
        Optional<TimeTable> currentTimeTableOptional = timeTableRepository.currentTimeTableForEmployee2(emp.getId()).stream().findFirst();
        if (currentTimeTableOptional.isPresent()) {
            TimeTable currentTimeTable = currentTimeTableOptional.get();
            currentTimeTable.setEndDate(LocalDate.now());
            currentTimeTable.setEnd_break(LocalTime.now());
            timeTableRepository.save(currentTimeTable);

        }
    }

    public void addAddress(AddressBO addressBO) {

        Address address = new Address();
        Employee emp = employeeRepository.findById((addressBO.getEmpId())).get();
        address.setEmployee(emp);
        address.setStreet(addressBO.getStreet());
        address.setPostcode(addressBO.getPostcode());
        address.setType(addressBO.getType());
        addressRepository.save(address);

    }

    public void addContactDetails(TelephoneBO telephoneBO) {

        Telephone telephone = new Telephone();
        Employee emp = employeeRepository.findById((telephoneBO.getEmpId())).get();
        telephone.setEmployee(emp);
        telephone.setPhone(telephoneBO.getPhone());
        telephone.setType(telephoneBO.getType());
        telephoneRepository.save(telephone);
    }


    public void updateEmployeeDetails(EmployeeBO employeeBO,long id) {

        Employee emp = employeeRepository.findById((id)).get();
        emp.setFirstName(employeeBO.getFirstName());
        emp.setLastName(employeeBO.getLastName());
        emp.setEmail(employeeBO.getEmail());

        employeeRepository.save(emp);

    }
}