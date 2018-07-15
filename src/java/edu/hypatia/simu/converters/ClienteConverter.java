 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.converters;

import edu.hypatia.simu.modelo.dao.ClienteFacadeLocal;
import edu.hypatia.simu.modelo.entidades.Cliente;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author davrivas
 */
@FacesConverter(forClass = Cliente.class)
public class ClienteConverter implements Converter<Cliente> {
    
    private ClienteFacadeLocal cfl;

    public ClienteConverter() {
        cfl = CDI.current().select(ClienteFacadeLocal.class).get();
    }
    

    @Override
    public Cliente getAsObject(FacesContext fc, UIComponent uic, String value) {
        try {
            Integer id = Integer.valueOf(value);
            return cfl.find(id);
        } catch (NumberFormatException numberFormatException) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Cliente obj) {
         if(obj != null){
            return obj.getIdCliente().toString();
        }
        return "";
    }
    
}
