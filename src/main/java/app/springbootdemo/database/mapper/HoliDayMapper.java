package app.springbootdemo.database.mapper;

import app.springbootdemo.database.dbmodel.HoliDay;
import java.lang.String;
import java.time.LocalDate;
import java.util.Date;

public class HoliDayMapper {
    public static HoliDay from (LocalDate date) {
        HoliDay holiDay = new HoliDay();
//        holiDay.setStartDate(LocalDate.now());
        holiDay.setStartDate(date);
      //  holiDay.setBegin_break(beginBreak);
       // holiDay.setEnd_break(endBreak);
       // holiDay.setEndDate(LocalDate.now());

        return holiDay;
    }
}


