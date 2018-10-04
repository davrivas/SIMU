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
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
    
    public List<Moto> listarMoto(){
    TypedQuery<Moto>t=getEntityManager().createQuery("SELECT m FROM Moto m INNER JOIN m.producto p INNER JOIN p.marca m INNER JOIN m.tipoProducto t WHERE t.idTipoProducto = 1", Moto.class);
    return t.getResultList();
    }
    
     public List<Moto> filtrarPorPrecio(Double precioMin, Double precioMax){
     TypedQuery<Moto>t= getEntityManager().createQuery("SELECT m FROM Moto m INNER JOIN m.producto p INNER JOIN p.marca mp INNER JOIN mp.tipoProducto t WHERE t.idTipoProducto = 1 AND p.precio BETWEEN :precioMin AND :precioMax",Moto.class);
     t.setParameter("precioMin", precioMin);
     t.setParameter("precioMax", precioMax);
     return t.getResultList();
     
     }
     
      public List<Moto> filtrarPorMarcaMoto(String marca){
        try {
            Query q = getEntityManager().createQuery("SELECT m FROM Moto m INNER JOIN m.producto p INNER JOIN p.marca mp INNER JOIN mp.tipoProducto tp WHERE tp.idTipoProducto=1  AND mp.marca = :marca", Moto.class);
            q.setParameter("marca", marca);
            return q.getResultList();
        } catch (NoResultException e) {
            return null;
        }
   }
    
}
