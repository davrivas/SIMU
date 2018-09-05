/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.modelo.dao.jpa;

import edu.hypatia.simu.modelo.dao.PersonaFacadeLocal;
import edu.hypatia.simu.modelo.entidades.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author davrivas
 */
@Stateless
public class PersonaFacade extends AbstractFacade<Persona> implements PersonaFacadeLocal {

    @PersistenceContext(unitName = "simuPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonaFacade() {
        super(Persona.class);
    }

    @Override
    public Persona findByEmailContrasena(String email, String contrasena) {
        try {
            TypedQuery<Persona> tq = getEntityManager().createQuery("SELECT p FROM Persona p WHERE p.email = :email AND p.contrasena = :contrasena", Persona.class);
            tq.setParameter("email", email);
            tq.setParameter("contrasena", contrasena);
            return tq.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public int loadUsers(String pathFile) {
        try {
            Query q = getEntityManager().createNativeQuery("LOAD DATA LOCAL INFILE ?1 INTO TABLE tbl_personas FIELDS TERMINATED BY','LINES TERMINATED BY '\\n' IGNORE 1 LINES;");
            q.setParameter(1, pathFile);
            return q.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return 0;
        }
    }

    @Override
    public List<Persona> findAllAdmin() {
        try {
            TypedQuery q = getEntityManager().createNamedQuery("SELECT P FROM Persona p WHERE p.rol = 3 ", Persona.class);
            return q.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
    }


}
