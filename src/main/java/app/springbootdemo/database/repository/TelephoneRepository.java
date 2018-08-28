package app.springbootdemo.database.repository;

import app.springbootdemo.database.dbmodel.Telephone;
import org.springframework.data.repository.CrudRepository;

public interface TelephoneRepository extends CrudRepository<Telephone, Long> {
}
