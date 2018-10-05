/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.converters;

import edu.hypatia.simu.modelo.dao.TipoReparacionFacadeLocal;
import edu.hypatia.simu.modelo.entidades.TipoReparacion;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author davrivas
 */
@FacesConverter(forClass = TipoReparacion.class)
public class TipoReparacionConverter implements Converter<TipoReparacion> {
    
    private TipoReparacionFacadeLocal trfl;

    public TipoReparacionConverter() {
        trfl = CDI.current().select(TipoReparacionFacadeLocal.class).get();
    }
    

    @Override
    public TipoReparacion getAsObject(FacesContext fc, UIComponent uic, String value) {
        try {
            Integer id = Integer.valueOf(value);
            return trfl.find(id);
        } catch (NumberFormatException numberFormatException) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, TipoReparacion obj) {
         if(obj != null){
            return obj.getIdTipoReparacion().toString();
        }
        return "";
    }
    
}
