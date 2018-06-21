/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.converters;

import edu.hypatia.simu.modelo.dao.DepartamentoFacadeLocal;
import edu.hypatia.simu.modelo.entidades.Departamento;
import javax.ejb.EJB;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author APRENDIZ
 */
@FacesConverter(forClass = Departamento.class)
public class DepartamentoConverter implements Converter<Departamento> {

    @EJB
    private DepartamentoFacadeLocal dfl;
    
     public DepartamentoConverter() {
        dfl = CDI.current().select(DepartamentoFacadeLocal.class).get();
    }
    

    @Override
    public Departamento getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            Integer id = Integer.valueOf(value);
            return dfl.find(id);
        } catch (NumberFormatException numberFormatException) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Departamento obj) {
        if(obj != null){
            return obj.getIdDepartamento().toString();
        }
        return "";
    }

}
