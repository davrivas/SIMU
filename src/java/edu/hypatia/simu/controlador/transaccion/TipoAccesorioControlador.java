/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.controlador.transaccion;

import edu.hypatia.simu.modelo.dao.jpal.TipoAccesorioFacadeLocal;
import edu.hypatia.simu.modelo.entidades.TipoAccesorio;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author davrivas
 */
@Named(value = "tipoAccesorioControlador")
@RequestScoped
public class TipoAccesorioControlador {

    @EJB
    private TipoAccesorioFacadeLocal tafl;
    private List<TipoAccesorio> tiposAccesorios;

    /**
     * Creates a new instance of TipoAccesorioControlador
     */
    public TipoAccesorioControlador() {
    }

    public List<TipoAccesorio> getTiposAccesorios() {
        return tafl.findAll();
    }

}
