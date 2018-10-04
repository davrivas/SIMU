/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.converters;

import edu.hypatia.simu.modelo.dao.UsuarioFacadeLocal;
import edu.hypatia.simu.modelo.entidades.Usuario;
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
@FacesConverter(forClass = Usuario.class)
public class UsuarioConverter implements Converter<Usuario> {

    @EJB
    private UsuarioFacadeLocal cfl;

    public UsuarioConverter() {
        cfl = CDI.current().select(UsuarioFacadeLocal.class).get();
    }

    @Override
    public Usuario getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            Integer id = Integer.valueOf(value);
            return cfl.find(id);
        } catch (NumberFormatException numberFormatException) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Usuario obj) {
        if (obj != null) {
            return obj.getIdUsuario().toString();
        }
        return "";
    }

}
