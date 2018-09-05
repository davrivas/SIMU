/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.modelo.dao.jpaa;

import edu.hypatia.simu.modelo.dao.jpal.ReparacionFacadeLocal;
import edu.hypatia.simu.modelo.entidades.Reparacion;
import edu.hypatia.simu.modelo.entidades.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author davr
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
    public List<Reparacion> reparacionesSinRevisar(Usuario mecanico) {
        try {
            TypedQuery<Reparacion> q = getEntityManager().createQuery("SELECT r FROM Reparacion r "
                    + "WHERE r.mecanico = :mecanico AND r.descripcion IS NULL", Reparacion.class);
            q.setParameter("mecanico", mecanico);

            return q.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Reparacion> reparacionesRevisadas(Usuario mecanico) {
        try {
            TypedQuery<Reparacion> q = getEntityManager().createQuery("SELECT r FROM Reparacion r "
                    + "WHERE r.mecanico = :mecanico AND r.descripcion IS NOT NULL "
                    + "ORDER BY r.fecha DESC", Reparacion.class);
            q.setParameter("mecanico", mecanico);

            return q.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Reparacion> reparacionesDelCliente(Usuario cliente) {
        try {
            TypedQuery<Reparacion> q = getEntityManager().createQuery("SELECT r FROM Reparacion r "
                    + "INNER JOIN r.moto m "
                    + "WHERE m.cliente = :cliente", Reparacion.class);
            q.setParameter("cliente", cliente);
            return q.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
    
}
