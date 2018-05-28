/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.converters;

import edu.hypatia.simu.modelo.entidades.Proveedor;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import edu.hypatia.simu.modelo.dao.ProveedorFacadeLocal;

/**
 *
 * @author APRENDIZ
 */
@FacesConverter(forClass = Proveedor.class)
public class ProveedorConverter implements Converter<Proveedor> {

    private ProveedorFacadeLocal pfl;

    public ProveedorConverter() {
        pfl = CDI.current().select(ProveedorFacadeLocal.class).get();
    }

    @Override
    public Proveedor getAsObject(FacesContext context, UIComponent component, String value) {

        try {
            String id = String.valueOf(value);
            return pfl.find(id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Proveedor obj) {
        if (obj != null) {
            return obj.getIdProveedor().toString();
        }
        return "";
    }

}
