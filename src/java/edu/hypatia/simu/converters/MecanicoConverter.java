/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.converters;

import edu.hypatia.simu.modelo.dao.MecanicoFacadeLocal;
import edu.hypatia.simu.modelo.entidades.Mecanico;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author davrivas
 */
@FacesConverter(forClass = Mecanico.class)
public class MecanicoConverter implements Converter<Mecanico> {
    
    private MecanicoFacadeLocal mfl;

    public MecanicoConverter() {
        mfl = CDI.current().select(MecanicoFacadeLocal.class).get();
    }
    

    @Override
    public Mecanico getAsObject(FacesContext fc, UIComponent uic, String value) {
        try {
            Integer id = Integer.valueOf(value);
            return mfl.find(id);
        } catch (NumberFormatException numberFormatException) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Mecanico obj) {
         if(obj != null){
            return obj.getIdMecanico().toString();
        }
        return "";
    }
    
}
