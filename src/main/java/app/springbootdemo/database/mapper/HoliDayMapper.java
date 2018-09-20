package app.springbootdemo.database.mapper;

import app.springbootdemo.database.dbmodel.HoliDay;
import java.lang.String;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class HoliDayMapper {
//    public static HoliDay from (Date startTime, Date beginBreak, Date endBreak, Date endTime) {
//        HoliDay holiDay = new HoliDay();
//        holiDay.setBegin(startTime);
//        holiDay.setBegin_break(beginBreak);
//        holiDay.setEnd_break(endBreak);
//        holiDay.setEnd(endTime);
//
//        return holiDay;
//    }

    public static HoliDay from (Date startTime, LocalTime beginBreak, LocalTime endBreak, Date endTime) {
        HoliDay holiDay = new HoliDay();
        holiDay.setStartDate(LocalDate.now());
        holiDay.setBegin_break(beginBreak);
        holiDay.setEnd_break(endBreak);
        holiDay.setEndDate(LocalDate.now());

        return holiDay;
    }
}

