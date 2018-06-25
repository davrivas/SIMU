/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.modelo.dao;

import edu.hypatia.simu.modelo.entidades.Accesorio;
import edu.hypatia.simu.modelo.entidades.MarcaProducto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author davrivas
 */
@Stateless
public class MarcaProductoFacade extends AbstractFacade<MarcaProducto> implements MarcaProductoFacadeLocal {

    @PersistenceContext(unitName = "simuPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MarcaProductoFacade() {
        super(MarcaProducto.class);
    }

    @Override
    public MarcaProducto findByTipoAccesorio() {
        try {
            TypedQuery<MarcaProducto> tq = getEntityManager().createQuery("SELECT a FROM Accesorio a WHERE a.tipoAccesorio = 2", MarcaProducto.class);
            return tq.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}
