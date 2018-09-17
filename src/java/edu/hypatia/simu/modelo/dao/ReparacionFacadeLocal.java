/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.modelo.dao;

import edu.hypatia.simu.modelo.entidades.Reparacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author davr
 */
@Local
public interface ReparacionFacadeLocal {

    void create(Reparacion reparacion);

    void edit(Reparacion reparacion);

    void remove(Reparacion reparacion);

    Reparacion find(Object id);

    List<Reparacion> findAll();

    List<Reparacion> findRange(int[] range);

    int count();
    
}
