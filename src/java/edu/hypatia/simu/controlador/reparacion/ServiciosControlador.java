/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.controlador.reparacion;

import edu.hypatia.simu.modelo.dao.TipoServicioReparacionFacadeLocal;
import edu.hypatia.simu.modelo.entidades.TipoServicioReparacion;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author davrivas
 */
@Named(value = "serviciosControlador")
@RequestScoped
public class ServiciosControlador {
    
    @EJB
    private TipoServicioReparacionFacadeLocal sfl;
    private List<TipoServicioReparacion> servicios;

    /**
     * Creates a new instance of ServiciosControlador
     */
    public ServiciosControlador() {
    }
    
    @PostConstruct
    public void init() {
        servicios = sfl.findAll();
    }

    public List<TipoServicioReparacion> getServicios() {
        return servicios;
    }
    
}
