/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.controlador.transaccion;

import edu.hypatia.simu.modelo.entidades.Accesorio;
import edu.hypatia.simu.modelo.entidades.Producto;
import edu.hypatia.simu.modelo.entidades.Proveedor;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import edu.hypatia.simu.modelo.dao.AccesorioFacadeLocal;
import edu.hypatia.simu.modelo.dao.MarcaProductoFacadeLocal;
import edu.hypatia.simu.modelo.dao.ProductoFacadeLocal;
import edu.hypatia.simu.modelo.dao.ProveedorFacadeLocal;
import edu.hypatia.simu.modelo.dao.TipoAccesorioFacadeLocal;
import edu.hypatia.simu.modelo.entidades.MarcaProducto;
import edu.hypatia.simu.modelo.entidades.TipoAccesorio;

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
    private ProveedorFacadeLocal prfl;
    
    @EJB
    private ProductoFacadeLocal pfl;
    
    @EJB
    private MarcaProductoFacadeLocal mpfl;
    
    @EJB
    private TipoAccesorioFacadeLocal tafl;
    
    private List<Producto> productos;
    
    private Accesorio accesorio = new Accesorio();
    private Producto producto = new Producto();
    private MarcaProducto MarcaProducto = new MarcaProducto();
    
    private Accesorio accesorioSeleccionado;
    
    private List<Accesorio> accesorios;
    
    public List<Accesorio> getAccesorios() {
        return afl.findAll();
    }
    
    public Accesorio getAccesorio() {
        return accesorio;
    }
    
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
    
    public MarcaProducto getMarcaProducto() {
        return MarcaProducto;
    }
    
    public void setMarcaProducto(MarcaProducto MarcaProducto) {
        this.MarcaProducto = MarcaProducto;
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
    public String seleccionar() {
        return "registrarAccesorio.xhtml?faces-redirect=true";
    }
    
    public List<Producto> getProductos() {
        return pfl.findAll();
    }
    
    public List<Proveedor> listarProveedor() {
        return prfl.findAll();
    }
    
    public List<TipoAccesorio> listarTipoAccesorio() {
        return tafl.findAll();
    }
    
    public List<MarcaProducto> listarMarcaAccesorio() {
        return mpfl.findAll();
    }
    
    public String registrar() {
        
        pfl.create(producto);

        accesorio.setProducto(producto);
        afl.create(accesorio);
        
        return "listarAccesorio.xhtml?faces-redirect=true";
    }
}
