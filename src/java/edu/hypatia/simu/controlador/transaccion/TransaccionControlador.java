/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.controlador.transaccion;

import edu.hypatia.simu.controlador.mail.Mail;
import edu.hypatia.simu.controlador.usuario.sesion.SesionControlador;
import edu.hypatia.simu.modelo.dao.DetalleTransaccionFacadeLocal;
import edu.hypatia.simu.modelo.dao.ProductoFacadeLocal;
import edu.hypatia.simu.modelo.dao.TipoTransaccionFacadeLocal;
import edu.hypatia.simu.modelo.dao.TransaccionFacadeLocal;
import edu.hypatia.simu.modelo.entidades.DetalleTransaccion;
import edu.hypatia.simu.modelo.entidades.Producto;
import edu.hypatia.simu.modelo.entidades.TipoTransaccion;
import edu.hypatia.simu.modelo.entidades.Transaccion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Inject;

/**
 *
 * @author asus
 */
@Named(value = "transaccionControlador")
@SessionScoped // DAVID: Que sea application mejor (pienso yo)
public class TransaccionControlador implements Serializable {

    private Transaccion nuevaTransaccion;

    private DetalleTransaccion nuevoDetalleTransaccion;

    @EJB
    private ProductoFacadeLocal pfl;

    @Inject
    private SesionControlador sc;

    @EJB
    private TransaccionFacadeLocal tfl;

    @EJB
    private TipoTransaccionFacadeLocal ttfl;

    @EJB
    private DetalleTransaccionFacadeLocal dtfl;

    private Producto p;

    TipoTransaccion tipoTransaccion = new TipoTransaccion();
    DetalleTransaccion detalleTransaccion = new DetalleTransaccion();

    public TransaccionControlador() {
    }

    @PostConstruct
    public void init() {
        nuevaTransaccion = new Transaccion();
        nuevaTransaccion.setDetalleTransaccionList(new ArrayList<>());
    }

    public DetalleTransaccion getNuevoDetalleTransaccion() {
        return nuevoDetalleTransaccion;
    }

    public Producto getP() {
        return p;
    }

    public void setP(Producto p) {
        this.p = p;
    }

    public DetalleTransaccion getDetalleTransaccion() {
        return detalleTransaccion;
    }

    public void setDetalleTransaccion(DetalleTransaccion detalleTransaccion) {
        this.detalleTransaccion = detalleTransaccion;
    }

    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public Transaccion getNuevaTransaccion() {
        return nuevaTransaccion;
    }

    public void setNuevaTransaccion(Transaccion nuevaTransaccion) {
        this.nuevaTransaccion = nuevaTransaccion;
    }

    public DetalleTransaccion getDetalleTransaccion(Producto p) {
        for (DetalleTransaccion dp : nuevaTransaccion.getDetalleTransaccionList()) {
            if (dp.getProducto().getIdProducto().equals(dp)) {
                return dp;
            }

        }
        return null;
    }

    public void seleccionarProducto(Producto p) {
        nuevoDetalleTransaccion = new DetalleTransaccion();
        nuevoDetalleTransaccion.setProducto(p);
        nuevoDetalleTransaccion.setTransaccion(nuevaTransaccion);
        nuevoDetalleTransaccion.setPrecioFinal(p.getPrecio());

    }

    public void addDetalleTransaccion() {

        DetalleTransaccion temp = getDetalleTransaccion(nuevoDetalleTransaccion.getProducto());
        if (temp != null) {
            temp.setCantidad(temp.getCantidad() + nuevoDetalleTransaccion.getCantidad());
        } else {
            nuevaTransaccion.getDetalleTransaccionList();
        }
        nuevaTransaccion.getDetalleTransaccionList().add(nuevoDetalleTransaccion);

    }

    public void realizarTransaccion() {
        nuevaTransaccion.setFecha(new Date());
        nuevaTransaccion.setCliente(sc.getUsuario());
        nuevaTransaccion.setTipoTransaccion(ttfl.find(1));
        tfl.create(nuevaTransaccion);
        System.out.println("Pedido solicitado correctamente");

        Mail.sendMail(sc.getEmail(), "Compra de Producto",
                "<h1> Has comprado un producto en SIMU, espero te haya gustado, muy pronto te lo haremos llegar </h1>");
    }

    public List<DetalleTransaccion> listarTransaccionesCliente() {
        return dtfl.listarDetalleTransaccionCliente(sc.getUsuario().getIdUsuario());
    }

}
