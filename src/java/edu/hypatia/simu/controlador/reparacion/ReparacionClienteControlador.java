/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.controlador.reparacion;

import edu.hypatia.simu.controlador.mail.Mail;
import edu.hypatia.simu.controlador.persona.sesion.SesionControlador;
import edu.hypatia.simu.modelo.dao.ReparacionFacadeLocal;
import edu.hypatia.simu.modelo.entidades.Moto;
import edu.hypatia.simu.modelo.entidades.Reparacion;
import edu.hypatia.simu.modelo.entidades.TipoServicioReparacion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.ejb.EJB;
import javax.inject.Inject;

/**
 *
 * @author davrivas
 */
@Named(value = "reparacionClienteControlador")
@SessionScoped
public class ReparacionClienteControlador implements Serializable {
    
    @EJB
    private ReparacionFacadeLocal rfl;
    @Inject
    private SesionControlador sc; 
    private Moto historialMoto = new Moto();
    private Reparacion reparacionAgendada = new Reparacion();

    /**
     * Creates a new instance of ReparacionCliente
     */
    public ReparacionClienteControlador() {
    }

    public Moto getHistorialMoto() {
        return historialMoto;
    }

    public void setHistorialMoto(Moto historialMoto) {
        this.historialMoto = historialMoto;
    }

    public Reparacion getReparacionAgendada() {
        return reparacionAgendada;
    }

    public void setReparacionAgendada(Reparacion reparacionAgendada) {
        this.reparacionAgendada = reparacionAgendada;
    }
    
    public void mostrarHistorial(Moto m) {
        historialMoto = m;
        System.out.println(historialMoto.getColor());
        System.out.println(historialMoto.getPlaca());
        System.out.println(historialMoto.getCilindraje());
    }

    public String agendarCita() {
        rfl.create(reparacionAgendada);

        // Enviar mail
        DateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");
        String fecha = formatoFecha.format(reparacionAgendada.getFecha());
        DateFormat formatoHora = new SimpleDateFormat("HH:mm");
        String hora = formatoHora.format(reparacionAgendada.getHora());
        String nombreCliente = sc.getPersona().getNombre() + " " + sc.getPersona().getApellido();
        String placaMoto = reparacionAgendada.getMoto().getPlaca();
        String nombreMecanico = reparacionAgendada.getMecanico().getPersona().getNombre() + " " + reparacionAgendada.getMecanico().getPersona().getApellido();
        String tiposDeServicio = "Los tipos de servicio son<br>";
        for (TipoServicioReparacion s : reparacionAgendada.getTipoServicioReparacionList()) {
            tiposDeServicio += "<li>" + s.getServicio() + "</li>";
        }
        String cuerpoHTML;

        // Para el cliente
        String destinatario = sc.getPersona().getEmail();
        String asunto = "Reparación programada";
        cuerpoHTML = "<h1>Hola " + nombreCliente + "</h1>"
                + "Has programado una reparacion para tu moto con placa " + placaMoto + "<br>"
                + "Para el día " + fecha + " a las " + hora + "<br>"
                + "<br>" + tiposDeServicio + "<br>"
                + "Te atenderá " + nombreMecanico;
        Mail.sendMail(destinatario, asunto, cuerpoHTML);

        // Para el mecánico
        destinatario = reparacionAgendada.getMecanico().getPersona().getEmail();
        asunto = "Reparación programada";
        cuerpoHTML = "<h1>Hola " + nombreMecanico + "</h1>"
                + "El cliente " + nombreCliente + " ha programado una reparacion "
                + "para la moto con placa " + placaMoto + "<br>"
                + "Para el día " + fecha + " a las " + hora + "<br>"
                + "<br>" + tiposDeServicio;
        Mail.sendMail(destinatario, asunto, cuerpoHTML);

        reparacionAgendada = new Reparacion();

        return "";
    }
}
