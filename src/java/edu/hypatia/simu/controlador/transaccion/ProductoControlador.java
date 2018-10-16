/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.controlador.transaccion;

import edu.hypatia.simu.modelo.dao.AccesorioFacadeLocal;
import edu.hypatia.simu.modelo.dao.MotoFacadeLocal;
import edu.hypatia.simu.modelo.dao.ProductoFacadeLocal;
import edu.hypatia.simu.modelo.entidades.Accesorio;
import edu.hypatia.simu.modelo.entidades.Moto;
import edu.hypatia.simu.modelo.entidades.Producto;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author asus
 */
@Named(value = "productoControlador")
@SessionScoped
public class ProductoControlador implements Serializable {

    private List<Producto> productos; 
    private List<Accesorio> accesorios;
    private List<Moto> motos;
    
    @EJB
    private ProductoFacadeLocal pfl;
    
    @EJB
    private AccesorioFacadeLocal afl;
    
    @EJB
    private MotoFacadeLocal mfl;
    
    
    Accesorio accesorio = new Accesorio();
    Producto producto = new Producto();
    private Accesorio accesorioFiltro = new Accesorio();

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    

  
    public ProductoControlador() {
    }
    

    public List<Producto> getProductos(){
        if (productos==null || productos.isEmpty()) {
            productos=pfl.findAll();
        }
        return productos;
    }
    
      public List<Accesorio> getAccesorios(){
        if (accesorios==null || accesorios.isEmpty()) {
            accesorios=afl.listarAccesorio();
        }
        return accesorios;
    }
       public List<Moto> getMotos(){
        if (motos==null || motos.isEmpty()) {
            motos=mfl.listarMoto();
        }
        return motos;
    }
    
    

    public Accesorio getAccesorio() {
        return accesorio;
    }

    public void setAccesorio(Accesorio accesorio) {
        this.accesorio = accesorio;
    }
     private String marca;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    

    
    
    public void filtrarPorMarcaAccesorio(){
    accesorios = afl.filtrarMarcaAccesorio(marca);
    }

   
    
    public void filtrarPorMarcaMoto(){
    motos = mfl.filtrarPorMarcaMoto(marca);
    }
  
   private Double precioMin;  
   private Double precioMax;  

    public Double getPrecioMin() {
        return precioMin;
    }

    public void setPrecioMin(Double precioMin) {
        this.precioMin = precioMin;
    }

    public Double getPrecioMax() {
        return precioMax;
    }

    public void setPrecioMax(Double precioMax) {
        this.precioMax = precioMax;
    }
    public void filtrarAccesorioPorPrecio(){
    accesorios =afl.filtrarPorPrecio(precioMin, precioMax);
        System.out.println("Esta pasando por el metodo del filtro");
    }
     public void filtrarMotoPorPrecio(){
    motos =mfl.filtrarPorPrecio(precioMin, precioMax);
        System.out.println("Esta pasando por el metodo del filtro");
    }
     
   
    
    
}
    

