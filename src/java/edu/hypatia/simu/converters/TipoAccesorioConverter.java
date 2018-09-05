/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.converters;

import edu.hypatia.simu.modelo.dao.jpal.TipoAccesorioFacadeLocal;
import edu.hypatia.simu.modelo.entidades.TipoAccesorio;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author davrivas
 */
@FacesConverter(forClass = TipoAccesorio.class)
public class TipoAccesorioConverter implements Converter<TipoAccesorio> {

    private TipoAccesorioFacadeLocal tafl;

    public TipoAccesorioConverter() {
        tafl = CDI.current().select(TipoAccesorioFacadeLocal.class).get();
    }

    @Override
    public TipoAccesorio getAsObject(FacesContext fc, UIComponent uic, String value) {
        try {
            Integer id = Integer.valueOf(value);
            return tafl.find(id);
        } catch (NumberFormatException numberFormatException) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, TipoAccesorio obj) {
        if (obj != null) {
            return obj.getIdTipoAccesorio().toString();
        }
        return "";
    }

}
