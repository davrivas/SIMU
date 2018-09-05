/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.modelo.dao.jpal;

import edu.hypatia.simu.modelo.entidades.DetalleTransaccion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author davr
 */
@Local
public interface DetalleTransaccionFacadeLocal {

    void create(DetalleTransaccion detalleTransaccion);

    void edit(DetalleTransaccion detalleTransaccion);

    void remove(DetalleTransaccion detalleTransaccion);

    DetalleTransaccion find(Object id);

    List<DetalleTransaccion> findAll();

    List<DetalleTransaccion> findRange(int[] range);

    int count();
    
}
