/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.modelo.dao.jpaa;

import edu.hypatia.simu.modelo.dao.jpal.MarcaFacadeLocal;
import edu.hypatia.simu.modelo.entidades.Marca;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author davr
 */
@Stateless
public class MarcaFacade extends AbstractFacade<Marca> implements MarcaFacadeLocal {

    @PersistenceContext(unitName = "simuPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MarcaFacade() {
        super(Marca.class);
    }

    @Override
    public List<Marca> listarMarcaMoto() {
        try {
            Query q = getEntityManager().createNativeQuery("SELECT * FROM tbl_marcas WHERE tipo_producto=1", Marca.class);
            return q.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

}
