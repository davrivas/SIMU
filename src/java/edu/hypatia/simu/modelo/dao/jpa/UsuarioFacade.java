/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.modelo.dao.jpa;

import edu.hypatia.simu.modelo.dao.UsuarioFacadeLocal;
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
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "simuPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    public Usuario findByEmailContrasena(String email, String contrasena) {
        try {
            TypedQuery<Usuario> tq = getEntityManager().createQuery("SELECT u FROM Usuario u "
                    + "WHERE u.email = :email AND u.contrasena = :contrasena", Usuario.class);
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
            Query q = getEntityManager().createNativeQuery("LOAD DATA LOCAL INFILE ?1 INTO TABLE tbl_usuarios FIELDS TERMINATED BY','LINES TERMINATED BY '\\n' IGNORE 1 LINES;");
            q.setParameter(1, pathFile);
            return q.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return 0;
        }
    }

    @Override
    public List<Usuario> todosLosAdmins() {
        try {
            TypedQuery q = getEntityManager().createNamedQuery("SELECT u FROM Usuario u WHERE p.rol.idRol = 3 ", Usuario.class);
            return q.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
    }

    @Override
    public List<Usuario> todosLosMecanicos() {
        try {
            TypedQuery q = getEntityManager().createNamedQuery("SELECT u FROM Usuario u WHERE p.rol.idRol = 2", Usuario.class);
            return q.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
    }

    @Override
    public List<Usuario> todosLosClientes() {
        try {
            TypedQuery q = getEntityManager().createNamedQuery("SELECT u FROM Usuario u WHERE p.rol.idRol = 1", Usuario.class);
            return q.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
    }
    
}
