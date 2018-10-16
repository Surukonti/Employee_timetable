package app.springbootdemo.controller.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.HashSet;
import java.util.Set;

public class EmployeeView {

    @ApiModelProperty(notes = "Auto generate id")
    private long id;

    @ApiModelProperty(notes = "name given by user")
    private String firstName;

    @ApiModelProperty(notes = "lastname given by user")
    private String lastName;

    @ApiModelProperty(notes = "specify email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;

    private Set<TimeTableView> timeTable = new HashSet<>();



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<TimeTableView> getTimeTable() {
        return timeTable;
    }

    public void setTimeTable(Set<TimeTableView> timeTable) {
        this.timeTable = timeTable;
    }
}
