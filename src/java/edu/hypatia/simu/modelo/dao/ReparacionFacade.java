/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.modelo.dao;

import edu.hypatia.simu.modelo.entidades.Mecanico;
import edu.hypatia.simu.modelo.entidades.Reparacion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author davrivas
 */
@Stateless
public class ReparacionFacade extends AbstractFacade<Reparacion> implements ReparacionFacadeLocal {

    @PersistenceContext(unitName = "simuPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReparacionFacade() {
        super(Reparacion.class);
    }

    @Override
    public List<Reparacion> reparacionesSinRevisar(Mecanico mecanico) {
        try {
            TypedQuery<Reparacion> q = getEntityManager().createQuery("SELECT r FROM Reparacion r WHERE r.mecanico = :mecanico AND r.descripcion = :noDesc", Reparacion.class);
            q.setParameter("mecanico", mecanico);
            q.setParameter("noDesc", null);
            return q.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Reparacion> reparacionesRevisadas(Mecanico mecanico) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
