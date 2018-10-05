/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.converters;

import edu.hypatia.simu.modelo.dao.MarcaFacadeLocal;
import edu.hypatia.simu.modelo.entidades.Marca;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author NICOLAS
 */
@FacesConverter(forClass = Marca.class)
public class MarcaConverter implements Converter<Marca>{

    private MarcaFacadeLocal mfl;

    public MarcaConverter() {
        mfl = CDI.current().select(MarcaFacadeLocal.class).get();
    }

    @Override
    public Marca getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            Integer id = Integer.valueOf(value);
            return mfl.find(id);
        } catch (NumberFormatException numberFormatException) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Marca obj) {
        if(obj != null){
            return obj.getIdMarca().toString();
        }
        return "";
    }
}
