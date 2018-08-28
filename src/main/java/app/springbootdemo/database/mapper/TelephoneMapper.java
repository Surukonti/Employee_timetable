package app.springbootdemo.database.mapper;


import app.springbootdemo.database.dbmodel.Telephone;
import app.springbootdemo.service.model.TelephoneBO;

public class TelephoneMapper {

    public static Telephone from(TelephoneBO telephoneBO) {
        Telephone telephone = new Telephone();
        telephone.setId(telephoneBO.getEmpId());
        telephone.setPhone(telephoneBO.getPhone());
        telephone.setType(telephoneBO.getType());


        return telephone;
    }

}