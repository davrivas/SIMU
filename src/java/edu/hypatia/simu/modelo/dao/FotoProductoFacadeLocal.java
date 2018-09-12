/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.modelo.dao;

import edu.hypatia.simu.modelo.entidades.FotoProducto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author davr
 */
@Local
public interface FotoProductoFacadeLocal {

    void create(FotoProducto fotoProducto);

    void edit(FotoProducto fotoProducto);

    void remove(FotoProducto fotoProducto);

    FotoProducto find(Object id);

    List<FotoProducto> findAll();

    List<FotoProducto> findRange(int[] range);

    int count();
    
}
