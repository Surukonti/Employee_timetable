package app.springbootdemo.service.mapper;

import app.springbootdemo.controller.model.EmployeeView;
import app.springbootdemo.database.dbmodel.Employee;
import app.springbootdemo.service.model.EmployeeBO;

import java.util.stream.Collectors;

public class EmployeeBOMapper {


    public static EmployeeBO from(EmployeeView employeeView) {

        EmployeeBO empBO = new EmployeeBO();
        empBO.setFirstName(employeeView.getFirstName());
        empBO.setLastName(employeeView.getLastName());
        empBO.setId(employeeView.getId());
        empBO.setTimeTable(employeeView.getTimeTable().stream().map(TimeTableBOMapper::from).collect(Collectors.toSet()));

        return empBO;

    }

    public static EmployeeBO from(Employee employee) {

        EmployeeBO empBO = new EmployeeBO();
        empBO.setFirstName(employee.getFirstName());
        empBO.setLastName(employee.getLastName());
        empBO.setId(employee.getId());
        empBO.setTimeTable(employee.getTimeTable().stream().map(TimeTableBOMapper::from).collect(Collectors.toSet()));

        return empBO;

    }
}
