/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.modelo.dao.jpa;

import edu.hypatia.simu.modelo.dao.ProveedorFacadeLocal;
import edu.hypatia.simu.modelo.entidades.Proveedor;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author davrivas
 */
@Stateless
public class ProveedorFacade extends AbstractFacade<Proveedor> implements ProveedorFacadeLocal {

    @PersistenceContext(unitName = "simuPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProveedorFacade() {
        super(Proveedor.class);
    }
    
}
