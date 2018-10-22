package app.springbootdemo.service.mapper;

import app.springbootdemo.controller.model.TimeTableView;
import app.springbootdemo.database.dbmodel.TimeTable;
import app.springbootdemo.service.model.TimeTableBO;

public class TimeTableBOMapper {

//    public static TimeTableBO from (TimeTableView timeTableView) {
//        TimeTableBO timeTableBO = new TimeTableBO();
//        timeTableBO.setBegin(timeTableView.getStartDate());
//        timeTableBO.setBegin_break(timeTableView.getBegin_break());
//        timeTableBO.setEnd_break(timeTableView.getEnd_break());
//        timeTableBO.setEnd(timeTableView.getEndDate());
//        timeTableBO.setId(timeTableView.getId());
//        return timeTableBO;
//    }
//
//    public static TimeTableBO from (TimeTable timeTable) {
//        TimeTableBO timeTableBO = new TimeTableBO();
//        timeTableBO.setBegin(timeTable.getBegin());
//        timeTableBO.setBegin_break(timeTable.getBegin_break());
//        timeTableBO.setEnd_break(timeTable.getEnd_break());
//        timeTableBO.setEnd(timeTable.getEnd());
//        timeTableBO.setId(timeTable.getId());
//        return timeTableBO;
//    }



    public static TimeTableBO from (TimeTableView timeTableView) {
        TimeTableBO timeTableBO = new TimeTableBO();
        timeTableBO.setBegin(timeTableView.getBegin());
        timeTableBO.setEnd(timeTableView.getEnd());
        timeTableBO.setDate(timeTableView.getDate());
        timeTableBO.setBegin_break(timeTableView.getBegin_break());
        timeTableBO.setEnd_break(timeTableView.getEnd_break());
        timeTableBO.setId(timeTableView.getId());
        return timeTableBO;
    }

    public static TimeTableBO from (TimeTable timeTable) {
        TimeTableBO timeTableBO = new TimeTableBO();
        timeTableBO.setBegin(timeTable.getBegin());
        timeTableBO.setBegin_break(timeTable.getBegin_break());
        timeTableBO.setEnd_break(timeTable.getEnd_break());
        timeTableBO.setEnd(timeTable.getEnd());
        timeTableBO.setId(timeTable.getId());
        timeTableBO.setDate(timeTable.getDate());
        return timeTableBO;
    }
}
