/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.controlador.reparacion;

import edu.hypatia.simu.modelo.dao.TipoReparacionFacadeLocal;
import edu.hypatia.simu.modelo.entidades.TipoReparacion;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author davrivas
 */
@Named(value = "tipoReparacionControlador")
@RequestScoped
public class TipoReparacionControlador {
    
    @EJB
    private TipoReparacionFacadeLocal trfl;
    private List<TipoReparacion> servicios;

    public TipoReparacionControlador() {
    }

    public List<TipoReparacion> getServicios() {
        return trfl.findAll();
    }
    
}
