package app.springbootdemo.controller.mapper;

import app.springbootdemo.controller.model.TimeTableView;
import app.springbootdemo.service.model.TimeTableBO;

public class  TimeTableViewMapper {

    public static TimeTableView from (TimeTableBO timeTableBO) {
        TimeTableView timeTable = new TimeTableView();
        timeTable.setBegin(timeTableBO.getBegin());
        timeTable.setBegin_break(timeTableBO.getBegin_break());
        timeTable.setEnd_break(timeTableBO.getEnd_break());
        timeTable.setEnd(timeTableBO.getEnd());
        timeTable.setDate(timeTableBO.getDate());
        timeTable.setId(timeTableBO.getId());

        return timeTable;
    }
}
