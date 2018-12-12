package app.springbootdemo.service.mapper;

import app.springbootdemo.controller.model.IllView;
import app.springbootdemo.service.model.IllBO;

public class IllBOMapper {

    public static IllBO from (IllView illView) {

        IllBO illBO = new IllBO();
        illBO.setEmpId(illView.getEmpId());
        illBO.setIllDate(illView.getIllDate());


        return illBO;
    }
}
