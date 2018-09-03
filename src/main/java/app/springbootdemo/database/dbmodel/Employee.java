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

    @Column
    @NotBlank
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }




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

    public Employee(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

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

    public Employee(@NotBlank String firstName, @NotBlank String lastName, @NotBlank String email, Set<TimeTable> timeTable) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.timeTable = timeTable;
        this.email = email;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return String.format("Employee[id=%d, firstName='%s', lastName='%s', email='%s']", id, firstName, lastName, email);
    }

}
