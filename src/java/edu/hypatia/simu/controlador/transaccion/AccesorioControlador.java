/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.controlador.transaccion;

import edu.hypatia.simu.modelo.entidades.Accesorio;
import edu.hypatia.simu.modelo.entidades.Producto;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import edu.hypatia.simu.modelo.dao.AccesorioFacadeLocal;
import edu.hypatia.simu.modelo.dao.MarcaFacadeLocal;
import edu.hypatia.simu.modelo.dao.ProductoFacadeLocal;
import edu.hypatia.simu.modelo.dao.TipoAccesorioFacadeLocal;
import edu.hypatia.simu.modelo.dao.TipoProductoFacadeLocal;
import edu.hypatia.simu.modelo.entidades.Marca;
import edu.hypatia.simu.modelo.entidades.TipoAccesorio;
import edu.hypatia.simu.modelo.entidades.TipoProducto;

/**
 *
 * @author APRENDIZ
 */
@Named(value = "accesorioControlador")
@SessionScoped
public class AccesorioControlador implements Serializable {

    
    
    public AccesorioControlador() {
    }
    
    @EJB
    private AccesorioFacadeLocal afl;
            
    @EJB
    private ProductoFacadeLocal pfl;
    
    @EJB
    private TipoProductoFacadeLocal tpfl;
    
    @EJB
    private MarcaFacadeLocal mpfl;
    
    @EJB
    private TipoAccesorioFacadeLocal tafl;
    
    
    private List<Producto> productos;
    private List<Accesorio> accesorios;
    
    private TipoProducto tipoProducto = new TipoProducto();

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
    private Accesorio accesorio = new Accesorio();
    private Producto producto = new Producto();
    private Marca marcaProducto = new Marca();
    
    private String marca;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    private Accesorio accesorioSeleccionado;
    
    public List<Accesorio> getAccesorios() {
        return afl.findAll();
    }
    
    public Accesorio getAccesorio() {
        return accesorio;
    }


//    
    public void setAccesorio(Accesorio accesorio) {
        this.accesorio = accesorio;
    }
    
    public Accesorio getAccesorioSeleccionado() {
        return accesorioSeleccionado;
    }
    
    public Producto getProducto() {
        return producto;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public Marca getMarcaProducto() {
        return marcaProducto;
    }
    
    public void setMarcaProducto(Marca marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    /*ELIMINAR*/
    public void seleccionarAccesorio(Accesorio a) {
        System.out.println("Id:" + a.getIdAccesorio());
        accesorio = a;
        accesorioSeleccionado = a;
        
    }
    
    public String eliminar() {
        try {
            System.out.println("Vamos a eliminar la moto");
            System.out.println("Id:" + accesorioSeleccionado.getIdAccesorio());
            afl.remove(accesorioSeleccionado);
            accesorios = null;
        } catch (Exception e) {
        }
        accesorioSeleccionado = null;
        return "listarMoto.xhtml?faces-redirect=true";
    }

    /*ACTUALIZAR*/
    public String editar() {
        try {
            System.out.println("Vamos a editar el accesorio:");
            System.out.println("Id:" + accesorioSeleccionado.getIdAccesorio());
            afl.edit(accesorioSeleccionado);
            accesorios = null;
        } catch (Exception e) {
        }
        accesorioSeleccionado = null;
        return "listarAccesorio.xhtml?faces-redirect=true";
    }

    /*REGISTRAR*/
   
    public List<Producto> getProductos() {
        return pfl.findAll();
    }
    
    public List<TipoAccesorio> listarTipoAccesorio() {
        return tafl.findAll();
    }
    
    public List<Marca> listarMarcaAccesorio() {
        return mpfl.listarMarcaAccesorio();
    }
    
    public String registrar() {
        
        pfl.create(producto);
        accesorio.setProducto(producto);
        afl.create(accesorio);
        
        accesorio = null;
        producto = null;
        
        return "listarAccesorio.xhtml?faces-redirect=true";
    }
    
    
    
    
    private List<Marca> listaMarca;

    public List<Marca> getListaMarca() {
        return listaMarca;
    }

    public void setListaMarca(List<Marca> listaMarca) {
        this.listaMarca = listaMarca;
    }
    
   
    public List<Accesorio> listarAccesorio(){
    return afl.listarAccesorio();
    }
   
    
   

   
   
}   
