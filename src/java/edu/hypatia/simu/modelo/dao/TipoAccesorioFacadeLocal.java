/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.modelo.dao.jpal;

import edu.hypatia.simu.modelo.entidades.TipoAccesorio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author davr
 */
@Local
public interface TipoAccesorioFacadeLocal {

    void create(TipoAccesorio tipoAccesorio);

    void edit(TipoAccesorio tipoAccesorio);

    void remove(TipoAccesorio tipoAccesorio);

    TipoAccesorio find(Object id);

    List<TipoAccesorio> findAll();

    List<TipoAccesorio> findRange(int[] range);

    int count();
    
}
