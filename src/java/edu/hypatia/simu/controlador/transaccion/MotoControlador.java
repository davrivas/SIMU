/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.controlador.transaccion;

import edu.hypatia.simu.modelo.entidades.Cliente;
import edu.hypatia.simu.modelo.entidades.Moto;
import edu.hypatia.simu.modelo.entidades.Producto;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import edu.hypatia.simu.modelo.dao.ClienteFacadeLocal;
import edu.hypatia.simu.modelo.dao.EstadoMotoFacadeLocal;
import edu.hypatia.simu.modelo.dao.MarcaProductoFacadeLocal;
import edu.hypatia.simu.modelo.dao.MotoFacadeLocal;
import edu.hypatia.simu.modelo.dao.ProductoFacadeLocal;
import edu.hypatia.simu.modelo.entidades.EstadoMoto;
import edu.hypatia.simu.modelo.entidades.MarcaProducto;

/**
 *
 * @author NICOLAS
 */
@Named(value = "motoControlador")
@SessionScoped
public class MotoControlador implements Serializable {

     @EJB
     private MarcaProductoFacadeLocal mpl;

    @EJB
    private MotoFacadeLocal mfl;

    @EJB
    private ClienteFacadeLocal cfl;

    @EJB
    private ProductoFacadeLocal pfl;

    @EJB
    private EstadoMotoFacadeLocal emfl;

    private List<Moto> motos;

    private Moto motoSeleccionada;

    private Moto moto = new Moto();
    
    private Producto producto = new Producto();
    
     private MarcaProducto marcaProducto = new MarcaProducto();

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public MarcaProducto getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(MarcaProducto marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

 

  

   

    public MotoControlador() {
    }

    public List<Moto> getMotos() {
        return mfl.findAll();
    }

    public Moto getMoto() {
        return moto;
    }

    public void setMoto(Moto moto) {
        this.moto = moto;
    }

    public Moto getMotoSeleccionada() {
        return motoSeleccionada;
    }

    /*ELIMINAR*/
    public void seleccionarMoto(Moto m) {
        System.out.println("Id:" + m.getPlaca());
        moto = m;
        motoSeleccionada = m;

    }

    public String eliminar() {
        try {
            System.out.println("Vamos a eliminar la moto");
            System.out.println("Id:" + motoSeleccionada.getPlaca());
            mfl.remove(motoSeleccionada);
            motos = null;
        } catch (Exception e) {
        }
        motoSeleccionada = null;
        return "listarMoto.xhtml?faces-redirect=true";
    }

    /*ACTUALIZAR*/
    public String editar() {
        try {
            System.out.println("Vamos a editar la moto:");
            System.out.println("Id:" + motoSeleccionada.getPlaca());
            mfl.edit(motoSeleccionada);
            motos = null;
        } catch (Exception e) {
        }   
        return "listarMoto.xhtml?faces-redirect=true";
    }

    /*REGISTRAR*/
    public String seleccionar() {       
        return "registrar.xhtml?faces-redirect=true";
    }

    public List<MarcaProducto> listarMarcaMoto(){
    return mpl.listarMarcaMoto();
    }
    
    
    public List<Producto> listarProducto() {
        return pfl.findAll();
    }

    public List<Cliente> listarCliente() {
        return cfl.findAll();
    }
    
    public List<EstadoMoto> listarEstadoMoto() {
        return emfl.findAll();
    }

    public String registrar() {
        mfl.create(moto);
        motoSeleccionada = null;
        return "listarMoto.xhtml?faces-redirect=true";
    }
    
    public void registrarMotoOfrecida(){
     producto.setMarcaProducto(marcaProducto);
     pfl.create(producto);
    moto.setEstadoMoto(emfl.find(2));
    moto.setProducto(producto);
    mfl.create(moto);
    }
    
}
    
