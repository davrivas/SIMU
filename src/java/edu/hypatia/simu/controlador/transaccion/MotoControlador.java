/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.controlador.transaccion;

import edu.hypatia.simu.controlador.mail.Mail;
import edu.hypatia.simu.controlador.persona.sesion.SesionControlador;
import edu.hypatia.simu.modelo.entidades.Moto;
import edu.hypatia.simu.modelo.entidades.Producto;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import edu.hypatia.simu.modelo.dao.ClienteFacadeLocal;
import edu.hypatia.simu.modelo.dao.jpa.EstadoMotoFacadeLocal;
import edu.hypatia.simu.modelo.dao.MarcaProductoFacadeLocal;
import edu.hypatia.simu.modelo.dao.jpa.MotoFacadeLocal;
import edu.hypatia.simu.modelo.dao.jpa.ProductoFacadeLocal;
import edu.hypatia.simu.modelo.entidades.Cliente;
import edu.hypatia.simu.modelo.entidades.EstadoMoto;
import edu.hypatia.simu.modelo.entidades.MarcaProducto;
import edu.hypatia.simu.modelo.entidades.Persona;
import javax.inject.Inject;

/**
 *
 * @author NICOLAS
 */
@Named(value = "motoControlador")
@SessionScoped
public class MotoControlador implements Serializable {

    @Inject
    private SesionControlador sc;

    @EJB
    private MarcaProductoFacadeLocal mpl;

    @EJB
    private MotoFacadeLocal mfl;

    @EJB
    private ClienteFacadeLocal clf;

    @EJB
    private ProductoFacadeLocal productofl;

    @EJB
    private MarcaProductoFacadeLocal marcaProductofl;

    @EJB
    private EstadoMotoFacadeLocal emfl;

    private List<Moto> motos;

    private Moto motoSeleccionada;

    private Moto moto = new Moto();
    private Producto producto = new Producto();

    private MarcaProducto marcaProducto = new MarcaProducto();
    private List<MarcaProducto> marcasMoto;

    public MotoControlador() {
    }

    public List<MarcaProducto> getMarcasMoto() {
        return marcaProductofl.listarMarcaMoto();
    }

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

    public List<Producto> listarProducto() {
        return productofl.findAll();
    }

    public List<Cliente> listarCliente() {
        return clf.findAll();
    }

    public List<EstadoMoto> listarEstadoMoto() {
        return emfl.findAll();
    }

    public List<MarcaProducto> listarMarcaProducto() {
        return marcaProductofl.findAll();
    }


    public String registrar() {

        productofl.create(producto);

        moto.setEstadoMoto(emfl.find(5));
        moto.setProducto(producto);
        moto.setCliente(sc.getPersona().getCliente());
        mfl.create(moto);

        return "listarMoto.xhtml?faces-redirect=true";
    }

    public void registrarMotoOfrecida() {
        producto.setMarcaProducto(marcaProducto);
        productofl.create(producto);
        moto.setProducto(producto);
        moto.setEstadoMoto(emfl.find(2));
        moto.setCliente(sc.getPersona().getCliente());
        mfl.create(moto);

         Mail.sendMail("simucolombia@gmail.com", "Moto ofrecida", sc.getPersona().getNombre() + " " + sc.getPersona().getApellido()
                + "<h1>Compra de Moto</h1>"
                + "<p>Hola administradores de SIMU, el cliente " + sc.getPersona().getNombre() + " " + sc.getPersona().getApellido()+ " ha ofertado una moto </p>"
                + "Moto: " + producto.getMarcaProducto().getMarcaProducto() + producto.getReferencia() + "<br/>"
                + "Cilindraje: " + moto.getCilindraje() + "<br/>"
                + "Kilometraje: " + moto.getKilometraje() + "<br/>"
                + "Color: " + moto.getColor()
                 + "<hr>");
        moto = null;
    }

}
