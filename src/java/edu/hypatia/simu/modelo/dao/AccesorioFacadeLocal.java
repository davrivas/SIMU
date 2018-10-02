/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.modelo.dao;

import edu.hypatia.simu.modelo.entidades.Accesorio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author davr
 */
@Local
public interface AccesorioFacadeLocal {

    void create(Accesorio accesorio);

    void edit(Accesorio accesorio);

    void remove(Accesorio accesorio);

    Accesorio find(Object id);

    List<Accesorio> findAll();

    List<Accesorio> findRange(int[] range);

    int count();
    List<Accesorio> listarAccesorio();
    List<Accesorio> filtrarPorMarcaAccesorio(String marca);
    List<Accesorio> filtrarPorPrecio(Double precioMin, Double precioMax);
   
    
}
