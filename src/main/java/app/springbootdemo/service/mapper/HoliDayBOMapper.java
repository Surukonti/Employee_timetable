package app.springbootdemo.service.mapper;

import app.springbootdemo.controller.model.HoliDayView;
import app.springbootdemo.service.model.HoliDayBO;


public class HoliDayBOMapper {

    public static HoliDayBO from (HoliDayView holiDayView) {
        HoliDayBO holiDayBO = new HoliDayBO();
        holiDayBO.setId(holiDayView.getId());
       // holiDayBO.setLeaveType(holiDayView.getLeaveType());
        holiDayBO.setFromDate(holiDayView.getFromDate());
        holiDayBO.setToDate(holiDayView.getToDate());

        return holiDayBO;
    }

}
