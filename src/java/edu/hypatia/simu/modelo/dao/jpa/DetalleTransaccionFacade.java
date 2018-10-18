/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.modelo.dao.jpa;

import edu.hypatia.simu.modelo.dao.DetalleTransaccionFacadeLocal;
import edu.hypatia.simu.modelo.entidades.DetalleTransaccion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author davr
 */
@Stateless
public class DetalleTransaccionFacade extends AbstractFacade<DetalleTransaccion> implements DetalleTransaccionFacadeLocal {

    @PersistenceContext(unitName = "simuPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleTransaccionFacade() {
        super(DetalleTransaccion.class);
    }

    @Override
    public List<DetalleTransaccion> listarDetalleTransaccionCliente(Integer idCliente) {
        Query q = getEntityManager().createQuery("SELECT dt FROM DetalleTransaccion dt  INNER JOIN dt.transaccion t INNER JOIN t.cliente c WHERE c.idUsuario = :idCliente ");
        q.setParameter("idCliente", idCliente);
        return q.getResultList();
    }
    
}
