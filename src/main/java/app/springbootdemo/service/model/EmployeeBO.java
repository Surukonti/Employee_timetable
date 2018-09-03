package app.springbootdemo.service.model;

import java.util.HashSet;
import java.util.Set;

public class EmployeeBO {

    private long id;

    private String firstName;

    private String lastName;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;

    private Set<TimeTableBO> timeTable  = new HashSet<>();;


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

    public Set<TimeTableBO> getTimeTable() {
        return timeTable;
    }

    public void setTimeTable(Set<TimeTableBO> timeTable) {
        this.timeTable = timeTable;
    }
}
