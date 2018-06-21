/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.controlador.reparacion;

import edu.hypatia.simu.controlador.mail.Mail;
import edu.hypatia.simu.controlador.persona.sesion.SesionControlador;
import edu.hypatia.simu.modelo.dao.ReparacionFacadeLocal;
import edu.hypatia.simu.modelo.entidades.Mecanico;
import edu.hypatia.simu.modelo.entidades.Reparacion;
import java.io.Serializable;
import java.util.ArrayList;
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
        reparacionesSinRevisar = new ArrayList<>();
        
        for (Reparacion r : rfl.reparacionesDelMecanico(sc.getPersona().getMecanico())) {
            if (r.getDescripcion() == null) {
                reparacionesSinRevisar.add(r);
            }
        }
        
        return reparacionesSinRevisar;
    }

    public List<Reparacion> getReparacionesRevisadas() {
        reparacionesRevisadas = new ArrayList<>();
        
        for (Reparacion r : rfl.reparacionesDelMecanico(sc.getPersona().getMecanico())) {
            if (r.getDescripcion() != null) {
                reparacionesRevisadas.add(r);
            }
        }
        
        return reparacionesRevisadas;
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
        rfl.edit(reparacionSeleccionada);
        
        String nombreCliente = reparacionSeleccionada.getMoto().getCliente().getPersona().getNombre() + " " + reparacionSeleccionada.getMoto().getCliente().getPersona().getApellido();
        String placaMoto = reparacionSeleccionada.getMoto().getPlaca();
        String nombreMecanico = reparacionSeleccionada.getMecanico().getPersona().getNombre() + " " + reparacionSeleccionada.getMecanico().getPersona().getApellido();
        
        String destinatario = reparacionSeleccionada.getMoto().getCliente().getPersona().getEmail();
        String asunto = "Reparación revisada";
        String cuerpoHTML = "<h1>Hola " + nombreCliente + "</h1>"
                + "El mecánico " + nombreMecanico + " ha revisado la reparacion para tu moto con placa " + placaMoto + "<br>"
                + "Este fue el comentario"
                + "<q>" + reparacionSeleccionada.getDescripcion() +"</q>";
        Mail.sendMail(destinatario, asunto, cuerpoHTML);
        
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
