package app.springbootdemo.reports;

import app.springbootdemo.controller.model.EmployeeView;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ReportBean extends EmployeeView {

    //@NotBlank
    private long year;
   // @NotBlank
    private long month;
   // @NotBlank
    private String monthName;

//    public long getYear() {
//        return year;
//    }
//
//    public void setYear(long year) {
//        this.year = year;
//    }
//
//    public long getMonth() {
//        return month;
//    }
//
//    public void setMonth(long month) {
//        this.month = month;
//    }
//
//    public String getMonthName() {
//        return monthName;
//    }
//
//    public void setMonthName(String monthName) {
//        this.monthName = monthName;
//    }
}
