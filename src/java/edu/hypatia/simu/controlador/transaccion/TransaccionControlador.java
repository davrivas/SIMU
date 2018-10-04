/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.controlador.transaccion;

import edu.hypatia.simu.controlador.usuario.sesion.SesionControlador;
import edu.hypatia.simu.modelo.dao.AccesorioFacadeLocal;
import edu.hypatia.simu.modelo.dao.ProductoFacadeLocal;
import edu.hypatia.simu.modelo.dao.TransaccionFacadeLocal;
import edu.hypatia.simu.modelo.dao.jpa.AccesorioFacade;
import edu.hypatia.simu.modelo.entidades.Accesorio;
import edu.hypatia.simu.modelo.entidades.DetalleTransaccion;
import edu.hypatia.simu.modelo.entidades.Moto;
import edu.hypatia.simu.modelo.entidades.Producto;
import edu.hypatia.simu.modelo.entidades.Transaccion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Inject;
import net.sf.jasperreports.engine.util.MessageUtil;

/**
 *
 * @author asus
 */
@Named(value = "transaccionControlador")
@SessionScoped
public class TransaccionControlador implements Serializable {

    private Transaccion nuevaTransaccion;

    private DetalleTransaccion nuevoDetalleTransaccion;

    public DetalleTransaccion getNuevoDetalleTransaccion() {
        return nuevoDetalleTransaccion;
    }

    @EJB
    private ProductoFacadeLocal pfl;

    @Inject
    private SesionControlador sc;

    @EJB
    private TransaccionFacadeLocal tfl;

    public Producto getP() {
        return p;
    }

    public void setP(Producto p) {
        this.p = p;
    }

    private Producto p;

    @PostConstruct
    public void init() {
        nuevaTransaccion = new Transaccion();
        nuevaTransaccion.setDetalleTransaccionList(new ArrayList<>());
    }

    public TransaccionControlador() {
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
        if (nuevoDetalleTransaccion.getCantidad() > 0) {
            DetalleTransaccion temp = getDetalleTransaccion(nuevoDetalleTransaccion.getProducto());
            if (temp != null) {
                temp.setCantidad(temp.getCantidad() + nuevoDetalleTransaccion.getCantidad());
            } else {
                nuevaTransaccion.getDetalleTransaccionList();
            }
            nuevaTransaccion.getDetalleTransaccionList().add(nuevoDetalleTransaccion);

        }
    }

    public void solicitar() {
        nuevaTransaccion.setFecha(new Date());
//        nuevaTransaccion.setCliente(sc.getUsuario());
        tfl.create(nuevaTransaccion);
        System.out.println("Pedido solicitado correctamente");
    }

}
