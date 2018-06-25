/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.converters;

import edu.hypatia.simu.modelo.dao.MarcaProductoFacadeLocal;
import edu.hypatia.simu.modelo.entidades.MarcaProducto;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author NICOLAS
 */
@FacesConverter(forClass = MarcaProducto.class)
public class MarcaProductoConverter implements Converter<MarcaProducto>{

    private MarcaProductoFacadeLocal mpfl;

    public MarcaProductoConverter() {
        mpfl = CDI.current().select(MarcaProductoFacadeLocal.class).get();
    }

    @Override
    public MarcaProducto getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            Integer id = Integer.valueOf(value);
            return mpfl.find(id);
        } catch (NumberFormatException numberFormatException) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, MarcaProducto obj) {
        if(obj != null){
            return obj.getIdMarcaProducto().toString();
        }
        return "";
    }
}
