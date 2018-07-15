/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.modelo.dao.jpa;

import edu.hypatia.simu.modelo.dao.EstadoMotoFacadeLocal;
import edu.hypatia.simu.modelo.entidades.EstadoMoto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author davrivas
 */
@Stateless
public class EstadoMotoFacade extends AbstractFacade<EstadoMoto> implements EstadoMotoFacadeLocal {

    @PersistenceContext(unitName = "simuPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoMotoFacade() {
        super(EstadoMoto.class);
    }
    
}
