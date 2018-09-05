/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.modelo.dao;

import edu.hypatia.simu.modelo.entidades.Persona;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author davrivas
 */
@Local
public interface PersonaFacadeLocal {

    void create(Persona persona);

    void edit(Persona persona);

    void remove(Persona persona);

    Persona find(Object id);

    List<Persona> findAll();

    List<Persona> findRange(int[] range);

    int count();

    Persona findByEmailContrasena(String email, String contrasena);

    int loadUsers(String pathFile);

    List<Persona> findAllAdmin();
}
