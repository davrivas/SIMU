/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.controlador.persona;

import edu.hypatia.simu.controlador.mail.Mail;
import edu.hypatia.simu.controlador.persona.sesion.SesionControlador;
import edu.hypatia.simu.modelo.dao.PersonaFacadeLocal;
import edu.hypatia.simu.modelo.dao.RolFacadeLocal;
import edu.hypatia.simu.modelo.entidades.Persona;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Inject;

/**
 *
 * @author APRENDIZ
 */
@Named(value = "personaControlador")
@SessionScoped
public class PersonaControlador implements Serializable {

    @Inject
    private SesionControlador sc;

    @EJB
    private PersonaFacadeLocal pfl;

    @EJB
    private RolFacadeLocal rfl;

    private Persona persona = new Persona();

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public PersonaControlador() {
    }

    public String registrarAdministrador() {

        Date fecha = new Date();

        persona.setRol(rfl.find(3));
        persona.setContrasena("administrador");
        persona.setFechaRegistro(fecha);
        pfl.create(persona);
        Mail.sendMail("simucolombia@gmail.com", "Administrador registrado", sc.getPersona().getNombre() + "ha registrado un nuevo administrador");

        persona = null;
        return "index.xhtml?faces-redirect=true";
    }

}
