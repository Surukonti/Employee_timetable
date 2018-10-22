package app.springbootdemo.reports;

import app.springbootdemo.database.dbmodel.Employee;
import app.springbootdemo.database.dbmodel.TimeTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReportRepositoryCustom  {

   List<ReportBean> getReportList(long id);


}
