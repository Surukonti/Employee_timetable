package app.springbootdemo.database.mapper;

import app.springbootdemo.database.dbmodel.Address;
import app.springbootdemo.service.model.AddressBO;


public class AddressMapper {

    public static Address from(AddressBO addressBO) {
        Address address = new Address();
        address.setId(addressBO.getEmpId());
        address.setPostcode(addressBO.getPostcode());
        address.setStreet(addressBO.getStreet());
        address.setType(addressBO.getType());


        return address;
    }

}
