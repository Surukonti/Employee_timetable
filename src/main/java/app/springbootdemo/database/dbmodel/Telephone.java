package app.springbootdemo.database.dbmodel;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "Telephone")
public class Telephone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @Column
    @NotBlank
    private long phone;

    @Column
    @NotBlank
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_id", nullable = false)
    private Employee employee;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Telephone() {
        this.phone = phone;
        this.type = type;
        this.employee = employee;
    }
}