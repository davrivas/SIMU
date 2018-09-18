/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.controlador.reparacion;

import edu.hypatia.simu.controlador.mail.Mail;
import edu.hypatia.simu.controlador.usuario.sesion.SesionControlador;
import edu.hypatia.simu.modelo.dao.ReparacionFacadeLocal;
import edu.hypatia.simu.modelo.entidades.Reparacion;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author davrivas
 */
@Named(value = "reparacionControlador")
@ViewScoped
public class ReparacionControlador implements Serializable {

    @EJB
    private ReparacionFacadeLocal rfl;
    @Inject
    private SesionControlador sc;
    private List<Reparacion> reparacionesSinRevisar;
    private List<Reparacion> reparacionesRevisadas;
    private Reparacion reparacionSeleccionada = new Reparacion();

    /**
     * Creates a new instance of ReparacionControlador
     */
    public ReparacionControlador() {
    }

    public List<Reparacion> getReparacionesSinRevisar() {        
        return rfl.reparacionesSinRevisar(sc.getUsuario());
    }

    public List<Reparacion> getReparacionesRevisadas() {
        return rfl.reparacionesRevisadas(sc.getUsuario());
    }

    public Reparacion getReparacionSeleccionada() {
        return reparacionSeleccionada;
    }

    public void setReparacionSeleccionada(Reparacion reparacionSeleccionada) {
        this.reparacionSeleccionada = reparacionSeleccionada;
    }

    public void seleccionarReparacion(Reparacion r) {
        reparacionSeleccionada = r;
    }

    public String revisarReparacion() {
        String nombreCliente = reparacionSeleccionada.getMoto().getCliente().getNombre() + " " + reparacionSeleccionada.getMoto().getCliente().getApellido();
        String placaMoto = reparacionSeleccionada.getMoto().getPlaca();
        String nombreMecanico = reparacionSeleccionada.getMecanico().getNombre() + " " + reparacionSeleccionada.getMecanico().getApellido();
        
        String destinatario = reparacionSeleccionada.getMoto().getCliente().getEmail();
        String asunto = "Reparación revisada";
        String cuerpoHTML = "<h1>Hola " + nombreCliente + "</h1>"
                + "El mecánico " + nombreMecanico + " ha revisado la reparacion para tu moto con placa " + placaMoto + "<br>"
                + "Este fue el comentario: <q>" + reparacionSeleccionada.getDescripcion() +"</q>";
        Mail.sendMail(destinatario, asunto, cuerpoHTML);
        
        rfl.edit(reparacionSeleccionada);
        reparacionSeleccionada = new Reparacion();
        return "index.xhtml?faces-redirect=true";
    }

    public String getCalificacionReparacion(Reparacion r) {
        if (r.getCalificacion() == null) {
            return "<em>El cliente no ha calificado la reparación</em>";
        }
        String rta = "";
        for (int i = 0; i < r.getCalificacion(); i++) {
            rta += "<span class='fa fa-star' style='color:orange;'></span>";
        }

        return rta;
    }

}
