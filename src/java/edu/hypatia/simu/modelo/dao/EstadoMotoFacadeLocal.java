/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.modelo.dao.jpal;

import edu.hypatia.simu.modelo.entidades.EstadoMoto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author davr
 */
@Local
public interface EstadoMotoFacadeLocal {

    void create(EstadoMoto estadoMoto);

    void edit(EstadoMoto estadoMoto);

    void remove(EstadoMoto estadoMoto);

    EstadoMoto find(Object id);

    List<EstadoMoto> findAll();

    List<EstadoMoto> findRange(int[] range);

    int count();
    
}
