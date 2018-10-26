package app.springbootdemo.service;


import app.springbootdemo.controller.mapper.TimeTableViewMapper;
import app.springbootdemo.controller.model.TimeTableView;
import app.springbootdemo.database.dbmodel.*;
import app.springbootdemo.database.mapper.EmployeeMapper;
import app.springbootdemo.database.mapper.IllMapper;
import app.springbootdemo.database.repository.*;
import app.springbootdemo.exceptions.StartTimeAlreadyRecordedException;
import app.springbootdemo.service.mapper.EmployeeBOMapper;
import app.springbootdemo.service.mapper.TimeTableBOMapper;
import app.springbootdemo.service.model.*;
import javafx.util.Duration;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.*;
import java.time.temporal.TemporalUnit;
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

    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }

    public void ill(IllBO illBO) {
        Date illFromDate = illBO.getIllFromDate();//+ "8:00";
        Date illToDate = illBO.getIllToDate();// + "16:00";
        Employee emp = employeeRepository.findById((illBO.getEmpId())).get();
        Ill ill = new Ill();
        ill.setEmployee(emp);
        ill.setDate(LocalDate.now());
        emp.getTimeTable().add(ill);
        illRepository.save(ill);

        // emp.getTimeTable().add(IllMapper.from());
    }


    public void holiDay(HoliDayBO holiDayBO) {
        Date setStartDate = holiDayBO.getFromDate();
        Date endDate = holiDayBO.getToDate();// + "16:00";
        Employee emp = employeeRepository.findById((holiDayBO.getId())).get();
        HoliDay holiDay = new HoliDay();
        holiDay.setEmployee(emp);
        holiDay.setDate(LocalDate.now());
        //holiDay.setStartDate(Date);
        // holiDay.setEndDate(LocalDate.now());
        emp.getTimeTable().add(holiDay);
        holiDayRepository.save(holiDay);
    }


    public void startTime(long pEmployeeId) {
        Employee emp = employeeRepository.findById(pEmployeeId).get();
        Set<TimeTable> lastTimeTable = timeTableRepository.findStartTimeforEmpId(pEmployeeId);
        if (lastTimeTable.size() >= 1) {
            throw new StartTimeAlreadyRecordedException("Start time already logged");
        }
        TimeTable lcWorkingDay = new TimeTable();
        lcWorkingDay.setEmployee(emp);
        lcWorkingDay.setDate(LocalDate.now());
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
            timeTableRepository.save(currentTimeTable);
            //currentTimeTable.getEndDate().getMonth();
        }

    }


    public void startBreakTime(long pEmployeeId) {
        Employee emp = employeeRepository.findById(pEmployeeId).get();
        Optional<TimeTable> currentTimeTableOptional = timeTableRepository.currentTimeTableForEmployee1(emp.getId()).stream().findFirst();
        if (currentTimeTableOptional.isPresent()) {
            TimeTable currentTimeTable = currentTimeTableOptional.get();
            // currentTimeTable.setStartDate(LocalDate.now());
            currentTimeTable.setBegin_break(LocalTime.now());
            timeTableRepository.save(currentTimeTable);
        }
    }


    public void stopBreakTime(long pEmployeeId) {
        Employee emp = employeeRepository.findById(pEmployeeId).get();
        Optional<TimeTable> currentTimeTableOptional = timeTableRepository.currentTimeTableForEmployee2(emp.getId()).stream().findFirst();
        if (currentTimeTableOptional.isPresent()) {
            TimeTable currentTimeTable = currentTimeTableOptional.get();
            //currentTimeTable.setEndDate(LocalDate.now());
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


    public void updateEmployeeDetails(EmployeeBO employeeBO, long id) {

        Employee emp = employeeRepository.findById((id)).get();
        emp.setFirstName(employeeBO.getFirstName());
        emp.setLastName(employeeBO.getLastName());
        emp.setEmail(employeeBO.getEmail());

        employeeRepository.save(emp);

    }

    public Set<TimeTableView> getEmployeeTimeTableForaMonth(long id, int month, int year) {

        List<TimeTable> timeTableList = timeTableRepository.getTimeTableForEmployee(id, month, year);
        Set<TimeTableView> timeTableViewSet = new HashSet<>();
        double work;
        double breaks = 0;
        double hours;


        for (TimeTable timeTable : timeTableList) {
            TimeTableBO timeTableBO = TimeTableBOMapper.from(timeTable);
            TimeTableView timeTableView = TimeTableViewMapper.from(timeTableBO);
            if (timeTableView.getBegin() != null && timeTableView.getEnd() != null) {
                work = java.time.Duration.between(timeTableView.getBegin(), timeTableView.getEnd()).toMinutes();

                if (timeTableView.getBegin_break() != null && timeTableView.getEnd_break() != null) {
                    breaks = java.time.Duration.between(timeTableView.getBegin_break(), timeTableView.getEnd_break()).toMinutes();
                }
                hours = work - breaks;
                hours = hours / 60;
                timeTableView.setTotalDayHours(hours);
            } else if (timeTableView.getDate() != null && timeTableView.getEnd() == null) {
                timeTableView.setTotalDayHours(8);
            }
            timeTableViewSet.add(timeTableView);
        }
        return timeTableViewSet;
    }

    public Set<TimeTableView> getEmployeeTimeTableForaYear(long id, int year) {

        List<TimeTable> timeTableList = timeTableRepository.getTimeTableForEmployeeYearly(id, year);
        Set<TimeTableView> timeTableViewSet = new HashSet<>();
        double work;
        double breaks = 0;
        double hours;


        for (TimeTable timeTable : timeTableList) {
            TimeTableBO timeTableBO = TimeTableBOMapper.from(timeTable);
            TimeTableView timeTableView = TimeTableViewMapper.from(timeTableBO);
            if (timeTableView.getBegin() != null && timeTableView.getEnd() != null) {
                work = java.time.Duration.between(timeTableView.getBegin(), timeTableView.getEnd()).toMinutes();

                if (timeTableView.getBegin_break() != null && timeTableView.getEnd_break() != null) {
                    breaks = java.time.Duration.between(timeTableView.getBegin_break(), timeTableView.getEnd_break()).toMinutes();
                }
                hours = work - breaks;
                hours = hours / 60;
                timeTableView.setTotalDayHours(hours);
            } else if (timeTableView.getDate() != null && timeTableView.getEnd() == null) {
                timeTableView.setTotalDayHours(8);
            }
            timeTableViewSet.add(timeTableView);
        }
        return timeTableViewSet;
}}