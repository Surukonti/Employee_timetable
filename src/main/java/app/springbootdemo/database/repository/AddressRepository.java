package app.springbootdemo.database.repository;

import app.springbootdemo.database.dbmodel.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
