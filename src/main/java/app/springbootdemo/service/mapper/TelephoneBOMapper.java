package app.springbootdemo.service.mapper;

import app.springbootdemo.controller.model.TelephoneView;
import app.springbootdemo.database.dbmodel.Telephone;
import app.springbootdemo.service.model.TelephoneBO;

public class TelephoneBOMapper {

    public static TelephoneBO from(TelephoneView telephoneView) {

        TelephoneBO telephoneBO = new TelephoneBO();
        telephoneBO.setEmpId(telephoneView.getEmpId());
        telephoneBO.setPhone(telephoneView.getPhone());
        telephoneBO.setType(telephoneView.getType());


        return telephoneBO;
    }


    public static TelephoneBO from(Telephone telephone) {
        TelephoneBO telephoneBO = new TelephoneBO();
        telephoneBO.setEmpId(telephone.getId());
        telephoneBO.setPhone(telephone.getPhone());
        telephoneBO.setType(telephone.getType());


        return telephoneBO;
    }
}
