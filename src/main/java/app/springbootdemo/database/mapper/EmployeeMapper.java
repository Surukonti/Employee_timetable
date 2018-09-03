package app.springbootdemo.database.mapper;

import app.springbootdemo.database.dbmodel.Employee;
import app.springbootdemo.service.model.EmployeeBO;

import java.util.stream.Collectors;

public class EmployeeMapper {


    public static Employee from(EmployeeBO employeeBO) {

        Employee empl = new Employee();


        empl.setFirstName(employeeBO.getFirstName());
        empl.setLastName(employeeBO.getLastName());
        empl.setEmail(employeeBO.getEmail());
        empl.setId(employeeBO.getId());
        empl.setTimeTable(employeeBO.getTimeTable().stream().map(TimeTableMapper::from).collect(Collectors.toSet()));

        return empl;

    }
}
