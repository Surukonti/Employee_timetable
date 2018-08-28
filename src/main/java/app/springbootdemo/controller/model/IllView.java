package app.springbootdemo.controller.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class IllView {


    private long empId;

    private Date illFromDate;

    private Date illToDate;

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }


    public Date getIllFromDate() {
        return illFromDate;
    }

    public void setIllFromDate(Date illFromDate) {
        this.illFromDate = illFromDate;
    }

    public Date getIllToDate() {
        return illToDate;
    }

    public void setIllToDate(Date illToDate) {
        this.illToDate = illToDate;
    }
}
