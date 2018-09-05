/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.modelo.dao;

import edu.hypatia.simu.modelo.dao.jpa.AbstractFacade;
import edu.hypatia.simu.modelo.dao.jpa.TipoAccesorioFacadeLocal;
import edu.hypatia.simu.modelo.entidades.TipoAccesorio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author davr
 */
@Stateless
public class TipoAccesorioFacade extends AbstractFacade<TipoAccesorio> implements TipoAccesorioFacadeLocal {

    @PersistenceContext(unitName = "simuPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoAccesorioFacade() {
        super(TipoAccesorio.class);
    }
    
}
