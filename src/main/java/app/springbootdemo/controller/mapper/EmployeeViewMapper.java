package app.springbootdemo.controller.mapper;

import app.springbootdemo.controller.model.EmployeeView;
import app.springbootdemo.service.model.EmployeeBO;

import java.util.stream.Collectors;

public class EmployeeViewMapper {

    /**
     *
     * @param employeeBO
     * @return
     */

    public static EmployeeView from(EmployeeBO employeeBO) {
        EmployeeView empl = new EmployeeView();
        empl.setFirstName(employeeBO.getFirstName());
        empl.setLastName(employeeBO.getLastName());
        empl.setEmail(employeeBO.getEmail());
        empl.setId(employeeBO.getId());
        empl.setTimeTable(employeeBO.getTimeTable().stream().map(TimeTableViewMapper::from).collect(Collectors.toSet()));

        return empl;

    }
}
