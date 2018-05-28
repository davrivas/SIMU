/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.converters;

import edu.hypatia.simu.modelo.dao.TipoServicioReparacionFacadeLocal;
import edu.hypatia.simu.modelo.entidades.TipoServicioReparacion;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author davrivas
 */
@FacesConverter(forClass = TipoServicioReparacion.class)
public class TipoServicioReparacionConverter implements Converter<TipoServicioReparacion> {
    
    private TipoServicioReparacionFacadeLocal tsrfl;

    public TipoServicioReparacionConverter() {
        tsrfl = CDI.current().select(TipoServicioReparacionFacadeLocal.class).get();
    }
    

    @Override
    public TipoServicioReparacion getAsObject(FacesContext fc, UIComponent uic, String value) {
        try {
            Integer id = Integer.valueOf(value);
            return tsrfl.find(id);
        } catch (NumberFormatException numberFormatException) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, TipoServicioReparacion obj) {
         if(obj != null){
            return obj.getIdTipoServicioReparacion().toString();
        }
        return "";
    }
    
}
