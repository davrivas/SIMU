/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.converters;

import edu.hypatia.simu.modelo.dao.CiudadFacadeLocal;
import edu.hypatia.simu.modelo.entidades.Ciudad;
import javax.ejb.EJB;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author NICOLAS
 */
@FacesConverter(forClass = Ciudad.class)
public class CiudadConverter implements Converter<Ciudad> {

    @EJB
    private CiudadFacadeLocal cfl;

    public CiudadConverter() {
        cfl = CDI.current().select(CiudadFacadeLocal.class).get();
    }

    @Override
    public Ciudad getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            Integer id = Integer.valueOf(value);
            return cfl.find(id);
        } catch (NumberFormatException numberFormatException) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Ciudad obj) {
        if (obj != null) {
            return obj.getIdCiudad().toString();
        }
        return "";
    }

}
