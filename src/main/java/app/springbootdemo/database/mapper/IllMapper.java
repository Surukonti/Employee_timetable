package app.springbootdemo.database.mapper;

import app.springbootdemo.database.dbmodel.Ill;
import java.lang.String;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class IllMapper {
//
//    public static Ill from (Date startDate, Date endDate, Date beginBreak, Date endBreak) {
//        Ill ill = new Ill();
//        ill.setStartDate(LocalDate.now());
//       // ill.setBegin_break(beginBreak);
//        //ill.setEnd_break(endBreak);
//        ill.setEndDate(LocalDate.now());
//
//
//        return ill;
//    }

    public static Ill from (LocalDate date) {
        Ill ill = new Ill();
        ill.setStartDate(date);
       // ill.setBegin_break(beginBreak);
       // ill.setEnd_break(endBreak);
        //ill.setEndDate(endDate);
       // ill.setBegin(startTime);
        //ill.setEnd(endTime);


        return ill;
    }
    }


