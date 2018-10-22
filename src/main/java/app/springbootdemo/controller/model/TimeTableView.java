package app.springbootdemo.controller.model;

import java.lang.String;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class TimeTableView {

    private static final long serialVersionUID = 1L;

    private long id;

    private LocalTime begin;

    private LocalTime begin_break;

    private LocalTime end_break;

    private LocalTime end;

    private LocalDate date;

   // private LocalDate endDate;



    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

//    public LocalDate getEndDate() {
//        return endDate;
//    }
//
//    public void setEndDate(LocalDate endDate) {
//        this.endDate = endDate;
//    }
}
