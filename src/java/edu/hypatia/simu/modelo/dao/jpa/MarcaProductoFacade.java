/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.modelo.dao.jpa;

import edu.hypatia.simu.modelo.dao.MarcaProductoFacadeLocal;
import edu.hypatia.simu.modelo.entidades.MarcaProducto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    public List<MarcaProducto> listarMarcaMoto(){
        try {
            Query q = getEntityManager().createNativeQuery("SELECT * FROM tbl_marcas_producto WHERE tipo_producto=1", MarcaProducto.class);
            return q.getResultList();
        } catch (NoResultException e) {
            return null;
        }
        }
    }