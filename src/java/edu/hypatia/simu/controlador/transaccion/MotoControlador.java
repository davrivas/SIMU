/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.controlador.transaccion;

import edu.hypatia.simu.controlador.mail.Mail;
import edu.hypatia.simu.controlador.usuario.sesion.SesionControlador;
import edu.hypatia.simu.modelo.entidades.Moto;
import edu.hypatia.simu.modelo.entidades.Producto;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import edu.hypatia.simu.modelo.dao.UsuarioFacadeLocal;
import edu.hypatia.simu.modelo.dao.EstadoMotoFacadeLocal;
import edu.hypatia.simu.modelo.dao.MarcaFacadeLocal;
import edu.hypatia.simu.modelo.dao.MotoFacadeLocal;
import edu.hypatia.simu.modelo.dao.ProductoFacadeLocal;
import edu.hypatia.simu.modelo.entidades.Usuario;
import edu.hypatia.simu.modelo.entidades.EstadoMoto;
import edu.hypatia.simu.modelo.entidades.Marca;
import edu.hypatia.simu.util.FilesUtil;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.Part;

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
    private MarcaFacadeLocal mpl;

    @EJB
    private MotoFacadeLocal mfl;

    @EJB
    private UsuarioFacadeLocal clf;

    @EJB
    private ProductoFacadeLocal productofl;

    @EJB
    private MarcaFacadeLocal marcaProductofl;

    @EJB
    private EstadoMotoFacadeLocal emfl;

    private List<Moto> motos;

    private Moto motoSeleccionada;

    private Moto moto = new Moto();
    private Producto producto = new Producto();

    private Marca marcaProducto = new Marca();
    private List<Marca> marcasMoto;

    private Part foto;

    public Part getFoto() {
        return foto;
    }

    public void setFoto(Part foto) {
        this.foto = foto;
    }

    public MotoControlador() {
    }

    public List<Marca> getMarcasMoto() {
        return marcaProductofl.listarMarcaMoto();
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

    public List<Usuario> listarCliente() {
        return clf.findAll();
    }

    public List<EstadoMoto> listarEstadoMoto() {
        return emfl.findAll();
    }

    public List<Marca> listarMarcaProducto() {
        return marcaProductofl.findAll();
    }

    public String registrar() {

        productofl.create(producto);

        moto.setEstadoMoto(emfl.find(3));
        moto.setProducto(producto);
        moto.setCliente(sc.getUsuario());
        mfl.create(moto);

        return "listarMoto.xhtml?faces-redirect=true";
    }

    public void registrarMotoOfrecida() throws Exception {
        FilesUtil.subirFoto(foto,
                FacesContext.getCurrentInstance().getExternalContext().getRealPath("") + "/resources/img/moto/",
                foto.getSubmittedFileName());
        producto.setUrlFoto(foto.getSubmittedFileName());
        producto.setAltFoto(marcaProducto.getMarca() + " " + producto.getReferencia());
        producto.setMarca(marcaProducto);
        productofl.create(producto);
        moto.setProducto(producto);
        moto.setEstadoMoto(emfl.find(1));
        moto.setCliente(sc.getUsuario());
        mfl.create(moto);

        Mail.sendMail("simucolombia@gmail.com", "Moto ofrecida", sc.getUsuario().getNombre() + " " + sc.getUsuario().getApellido()
                + "<h1>Compra de Moto</h1>"
                + "<p>Hola administradores de SIMU, el cliente " + sc.getUsuario().getNombre() + " " + sc.getUsuario().getApellido() + " ha ofertado una moto </p>"
                + "Moto: " + producto.getMarca().getMarca() + producto.getReferencia() + "<br/>"
                + "Cilindraje: " + moto.getCilindraje() + "<br/>"
                + "Kilometraje: " + moto.getKilometraje() + "<br/>"
                + "Color: " + moto.getColor()
                + "<hr>");
        moto = null;
    }

    public List<Moto> listarMotos() {
        return mfl.findAll();
    }

    public List<Marca> listarMarcasMotos() {
        return mpl.listarMarcaMoto();
    }

    public List<Moto> listarMotosOfrecidas() {
        return mfl.findAll();
    }

    private String marcaSeleccionada;

    public String getMarcaSeleccionada() {
        return marcaSeleccionada;
    }

    public void setMarcaSeleccionada(String marcaSeleccionada) {
        this.marcaSeleccionada = marcaSeleccionada;
    }

    public List<Moto> listarMotosOfrecidasAlAdmin() {
        return mfl.listarMotosOfrecidas();
    }

    public String aceptarMoto(Moto mo) {
        seleccionarMoto(mo);
        moto.setEstadoMoto(emfl.find(3));
        Mail.sendMail(moto.getCliente().getEmail(), "Moto aceptada",
                "Su moto con placa " + moto.getPlaca() + " ha sido aceptada en SIMU<br>"
                + "Pronto nos pondremos en contacto contigo.");
        moto.setCliente(null);
        mfl.edit(moto);
        moto = new Moto();
        return "index.xhtml?faces-redirect=true";
    }

    public String rechazarMoto(Moto mo) {
        seleccionarMoto(mo);
        moto.setEstadoMoto(emfl.find(2));
        Mail.sendMail(moto.getCliente().getEmail(), "Moto descartada",
                "Su moto con placa " + moto.getPlaca() + " ha sido descartada de SIMU<br>"
                + "Muchas gracias por su oferta");
        moto.setCliente(null);
        mfl.edit(moto);
        moto = new Moto();
        return "index.xhtml?faces-redirect=true";
    }

}
