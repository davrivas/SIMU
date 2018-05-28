/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.modelo.dao;

import edu.hypatia.simu.modelo.entidades.TipoServicioReparacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author davrivas
 */
@Local
public interface TipoServicioReparacionFacadeLocal {

    void create(TipoServicioReparacion tipoServicioReparacion);

    void edit(TipoServicioReparacion tipoServicioReparacion);

    void remove(TipoServicioReparacion tipoServicioReparacion);

    TipoServicioReparacion find(Object id);

    List<TipoServicioReparacion> findAll();

    List<TipoServicioReparacion> findRange(int[] range);

    int count();
    
}
