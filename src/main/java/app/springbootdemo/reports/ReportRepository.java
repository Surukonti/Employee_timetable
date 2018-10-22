package app.springbootdemo.reports;

import app.springbootdemo.database.dbmodel.TimeTable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends CrudRepository<TimeTable, Long>,ReportRepositoryCustom {
}
