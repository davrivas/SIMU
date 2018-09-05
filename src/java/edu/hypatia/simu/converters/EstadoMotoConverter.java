/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.converters;

import edu.hypatia.simu.modelo.dao.jpa.EstadoMotoFacadeLocal;
import edu.hypatia.simu.modelo.entidades.EstadoMoto;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author NICOLAS
 */
@FacesConverter(forClass = EstadoMoto.class)
public class EstadoMotoConverter implements Converter<EstadoMoto>{
    
    private EstadoMotoFacadeLocal emfl;
    
     public EstadoMotoConverter() {
        emfl = CDI.current().select(EstadoMotoFacadeLocal.class).get();
    }

    @Override
    public EstadoMoto getAsObject(FacesContext context, UIComponent component, String value) {
       try {
            Integer id = Integer.valueOf(value);
            return emfl.find(id);
        } catch (NumberFormatException numberFormatException) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, EstadoMoto obj) {
         if(obj != null){
            return obj.getIdEstadoMoto().toString();
        }
        return "";
    }
    
}
