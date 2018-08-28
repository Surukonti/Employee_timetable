package app.springbootdemo.service.mapper;

import app.springbootdemo.controller.model.AddressView;
import app.springbootdemo.database.dbmodel.Address;
import app.springbootdemo.service.model.AddressBO;

public class AddressBOMapper {

    public static AddressBO from (AddressView addressView) {
        AddressBO addressBO = new AddressBO();
        addressBO.setEmpId(addressView.getEmpId());
        addressBO.setPostcode(addressView.getPostcode());
        addressBO.setStreet(addressView.getStreet());
        addressBO.setType(addressView.getType());

        return addressBO;
    }

    public static AddressBO from (Address address) {
        AddressBO addressBO = new AddressBO();
        addressBO.setEmpId(address.getId());
        addressBO.setPostcode(address.getPostcode());
        addressBO.setStreet(address.getStreet());
        addressBO.setType(address.getType());

        return addressBO;
    }
}
