package app.springbootdemo.service.model;

import java.time.LocalDate;
import java.util.Date;

public class IllBO {


    private long empId;

    private LocalDate illDate;

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public LocalDate getIllDate() {
        return illDate;
    }

    public void setIllDate(LocalDate illDate) {
        this.illDate = illDate;
    }
}
