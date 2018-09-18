/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.modelo.dao.jpa;

import edu.hypatia.simu.modelo.dao.MotoFacadeLocal;
import edu.hypatia.simu.modelo.entidades.Moto;
import edu.hypatia.simu.modelo.entidades.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author davr
 */
@Stateless
public class MotoFacade extends AbstractFacade<Moto> implements MotoFacadeLocal {

    @PersistenceContext(unitName = "simuPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MotoFacade() {
        super(Moto.class);
    }

    @Override
    public List<Moto> motosEnReparacion(Usuario cliente) {
        try {
            TypedQuery<Moto> q = getEntityManager().createQuery("SELECT m FROM Moto m WHERE m.cliente = :cliente", Moto.class);
            q.setParameter("cliente", cliente);
            return null;
        } catch (NoResultException e) {
            System.out.println(e.getStackTrace());
            return null;
        }
    }
    
}
