/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.modelo.dao.jpa;

import edu.hypatia.simu.modelo.dao.MarcaFacadeLocal;
import edu.hypatia.simu.modelo.entidades.Marca;
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
            TypedQuery<Marca> q = getEntityManager().createQuery("SELECT m FROM Marca m INNER JOIN m.tipoProducto tp WHERE tp.idTipoProducto = 1", Marca.class);
            return q.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
   public List<Marca> listarMarcaAccesorio(){
        try {
            TypedQuery<Marca> q = getEntityManager().createQuery("SELECT m FROM Marca m INNER JOIN m.tipoProducto tp WHERE tp.idTipoProducto = 2", Marca.class);
            return q.getResultList();
        } catch (NoResultException e) {
            return null;
        }
   }
   
   

   
   
    
   
    

   
   
   
   
  

}
