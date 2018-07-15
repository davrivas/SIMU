/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.modelo.dao;

import edu.hypatia.simu.modelo.entidades.Cliente;
import edu.hypatia.simu.modelo.entidades.Moto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author davrivas
 */
@Local
public interface MotoFacadeLocal {

    void create(Moto moto);

    void edit(Moto moto);

    void remove(Moto moto);

    Moto find(Object id);

    List<Moto> findAll();

    List<Moto> findRange(int[] range);

    int count();
    
    List<Moto> motosEnReparacion(Cliente cliente);
    
}
