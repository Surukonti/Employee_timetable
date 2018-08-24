package app.springbootdemo.database.dbmodel;


import javax.persistence.*;
import javax.swing.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @Column
    @NotBlank
    private String firstName;

    @Column
    @NotBlank
    private String lastName;


    @OneToMany(mappedBy = "employee",cascade=CascadeType.ALL)
    private Set<TimeTable> timeTable;


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

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public Set<TimeTable> getTimeTable() {
        return timeTable;
    }

    public void setTimeTable(Set<TimeTable> timeTable) {
        this.timeTable = timeTable;
    }

    public long getId() {
        return id;
    }

    public Employee(@NotBlank String firstName, @NotBlank String lastName, Set<TimeTable> timeTable) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.timeTable = timeTable;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return String.format("Employee[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName);
    }

}
