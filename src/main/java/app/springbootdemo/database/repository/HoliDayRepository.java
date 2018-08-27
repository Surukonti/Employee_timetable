package app.springbootdemo.database.repository;

import app.springbootdemo.database.dbmodel.HoliDay;
import org.springframework.data.repository.CrudRepository;

public interface HoliDayRepository extends CrudRepository<HoliDay, Long> {


}
