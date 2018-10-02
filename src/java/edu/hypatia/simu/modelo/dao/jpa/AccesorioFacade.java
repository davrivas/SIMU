/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.modelo.dao.jpa;

import edu.hypatia.simu.modelo.dao.AccesorioFacadeLocal;
import edu.hypatia.simu.modelo.entidades.Accesorio;
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
public class AccesorioFacade extends AbstractFacade<Accesorio> implements AccesorioFacadeLocal {

    @PersistenceContext(unitName = "simuPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccesorioFacade() {
        super(Accesorio.class);
    }
    
    public List<Accesorio> listarAccesorio(){
    TypedQuery<Accesorio>t=getEntityManager().createQuery("SELECT a FROM Accesorio a INNER JOIN a.producto p INNER JOIN p.marca m INNER JOIN m.tipoProducto t WHERE t.idTipoProducto = 2", Accesorio.class);
    return t.getResultList();
    }
    
    
     public List<Accesorio> filtrarPorMarcaAccesorio(String marca){
        try {
            TypedQuery<Accesorio> q = getEntityManager().createQuery("SELECT a FROM Accesorio a INNER JOIN a.producto p INNER JOIN p.marca m INNER JOIN m.tipoProducto t WHERE t.idTipoProducto = 2 and m.marca = :marca", Accesorio.class);
            q.setParameter("marca", marca);
            return q.getResultList();
        } catch (NoResultException e) {
            return null;
        }
   }
     
     public List<Accesorio> filtrarPorPrecio(Double precioMin, Double precioMax){
     TypedQuery<Accesorio>t= getEntityManager().createQuery("SELECT a FROM Accesorio a INNER JOIN a.producto p INNER JOIN p.marca m INNER JOIN m.tipoProducto t WHERE t.idTipoProducto = 2 AND p.precio BETWEEN :precioMin AND :precioMax", Accesorio.class);
     t.setParameter("precioMin", precioMin);
     t.setParameter("precioMax", precioMax);
     return t.getResultList();
     
     }
 
}
