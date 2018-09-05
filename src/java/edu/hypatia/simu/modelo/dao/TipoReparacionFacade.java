/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.modelo.dao;

import edu.hypatia.simu.modelo.dao.jpa.AbstractFacade;
import edu.hypatia.simu.modelo.dao.jpa.TipoReparacionFacadeLocal;
import edu.hypatia.simu.modelo.entidades.TipoReparacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author davr
 */
@Stateless
public class TipoReparacionFacade extends AbstractFacade<TipoReparacion> implements TipoReparacionFacadeLocal {

    @PersistenceContext(unitName = "simuPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoReparacionFacade() {
        super(TipoReparacion.class);
    }
    
}
