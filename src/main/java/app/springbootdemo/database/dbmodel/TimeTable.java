package app.springbootdemo.database.dbmodel;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Time_Table")
@DiscriminatorColumn(name="time_type",
        discriminatorType=DiscriminatorType.STRING)

public class TimeTable implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    @JsonBackReference
    private Employee employee;

    @Column(name = "Start_Time")
    //@DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME)
    @JsonDeserialize(using=StartDateTimeDeserialize.class)
    private LocalTime begin;

    @Column(name = "end_Time")
    @JsonDeserialize(using=EndDateTimeDeserialize.class)
    private LocalTime end;


    @Column(name = "Start_Date")
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME)
    @JsonDeserialize(using=StartDateTimeDeserialize.class)
    private LocalDate startDate;

    @Column(name = "end_Date")
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME)
    @JsonDeserialize(using=EndDateTimeDeserialize.class)
    private LocalDate endDate;


    @Column(name = "begin_break")
    //@DateTimeFormat(iso=DateTimeFormat.ISO.TIME)
    @JsonDeserialize(using=BreakDateTimeDeserialize.class)
    private LocalTime begin_break;

    @Column(name = "end_break")
    @JsonDeserialize(using=BreakDateTimeDeserialize.class)
    private LocalTime end_break;





    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public LocalTime getBegin() {
        return begin;
    }

    public void setBegin(LocalTime begin) {
        this.begin = begin;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalTime getBegin_break() {
        return begin_break;
    }

    public void setBegin_break(LocalTime begin_break) {
        this.begin_break = begin_break;
    }

    public LocalTime getEnd_break() {
        return end_break;
    }

    public void setEnd_break(LocalTime end_break) {
        this.end_break = end_break;
    }


    public Employee getEmployee() {

        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    public TimeTable() {
    }
}


