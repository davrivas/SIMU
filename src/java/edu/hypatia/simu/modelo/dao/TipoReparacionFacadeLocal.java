/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.modelo.dao;

import edu.hypatia.simu.modelo.entidades.TipoReparacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author davr
 */
@Local
public interface TipoReparacionFacadeLocal {

    void create(TipoReparacion tipoReparacion);

    void edit(TipoReparacion tipoReparacion);

    void remove(TipoReparacion tipoReparacion);

    TipoReparacion find(Object id);

    List<TipoReparacion> findAll();

    List<TipoReparacion> findRange(int[] range);

    int count();
    
}
