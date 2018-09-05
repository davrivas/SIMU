/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.converters;

import edu.hypatia.simu.modelo.entidades.Producto;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import edu.hypatia.simu.modelo.dao.jpa.ProductoFacadeLocal;

/**
 *
 * @author APRENDIZ
 */
@FacesConverter(forClass = Producto.class)
public class ProductoConverter implements Converter<Producto> {

    private ProductoFacadeLocal pfl;

    public ProductoConverter() {
        pfl = CDI.current().select(ProductoFacadeLocal.class).get();
    }

    @Override
    public Producto getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            String id = String.valueOf(value);
            return pfl.find(id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Producto obj) {
        if (obj != null) {
            return obj.getIdProducto().toString();
        }
        return "";
    }

}
