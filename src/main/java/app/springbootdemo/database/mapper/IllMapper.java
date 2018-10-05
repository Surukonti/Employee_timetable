package app.springbootdemo.database.mapper;

import app.springbootdemo.database.dbmodel.Ill;
import java.lang.String;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class IllMapper {

    public static Ill from (Date startDate, Date endTime, Date beginBreak, Date endBreak) {
        Ill ill = new Ill();
        ill.setStartDate(LocalDate.now());
       // ill.setBegin_break(beginBreak);
        //ill.setEnd_break(endBreak);
        ill.setEndDate(LocalDate.now());


        return ill;
    }

//    public static Ill from (LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime, LocalTime beginBreak, LocalTime endBreak) {
//        Ill ill = new Ill();
//        ill.setStartDate(startDate);
//        ill.setBegin_break(beginBreak);
//        ill.setEnd_break(endBreak);
//        ill.setEndDate(endDate);
//        ill.setBegin(startTime);
//        ill.setEnd(endTime);
//
//
//        return ill;
//    }
    }


