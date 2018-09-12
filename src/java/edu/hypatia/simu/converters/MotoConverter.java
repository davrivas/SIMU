/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.converters;

import edu.hypatia.simu.modelo.dao.MotoFacadeLocal;
import edu.hypatia.simu.modelo.entidades.Moto;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author davrivas
 */
@FacesConverter(forClass = Moto.class)
public class MotoConverter implements Converter<Moto> {
    
    private MotoFacadeLocal mfl;

    public MotoConverter() {
        mfl = CDI.current().select(MotoFacadeLocal.class).get();
    }
    

    @Override
    public Moto getAsObject(FacesContext fc, UIComponent uic, String value) {
        try {
            Integer id = Integer.valueOf(value);
            return mfl.find(id);
        } catch (NumberFormatException numberFormatException) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Moto obj) {
         if(obj != null){
            return obj.getIdMoto().toString();
        }
        return "";
    }
    
}
