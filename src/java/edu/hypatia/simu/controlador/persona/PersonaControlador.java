/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.controlador.persona;

import edu.hypatia.simu.controlador.mail.Mail;
import edu.hypatia.simu.controlador.persona.sesion.SesionControlador;
import edu.hypatia.simu.modelo.dao.MecanicoFacadeLocal;
import edu.hypatia.simu.modelo.dao.PersonaFacadeLocal;
import edu.hypatia.simu.modelo.dao.RolFacadeLocal;
import edu.hypatia.simu.modelo.entidades.Mecanico;
import edu.hypatia.simu.modelo.entidades.Persona;
import edu.hypatia.simu.util.FilesUtil;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.http.Part;

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
    
    private Part partFile;
    
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Part getPartFile() {
        return partFile;
    }

    public void setPartFile(Part partFile) {
        this.partFile = partFile;
    }
    

    public PersonaControlador() {
    }

    public String registrarAdministrador() {

        Date fecha = new Date();

        persona.setRol(rfl.find(3));
        persona.setContrasena("administrador");
        persona.setFechaRegistro(fecha);
        pfl.create(persona);
        Mail.sendMail(persona.getEmail(), "Administrador registrado", sc.getPersona().getNombre() + 
                       "<h1>Registro de Administrador</h1>" + 
                       "<h3>Hola " + persona.getNombre() + " " + persona.getApellido() + "</h3>" +
                       "Usted ha sido registrado por " + sc.getPersona().getNombre() + sc.getPersona().getApellido() + "como un nuevo administrador de SIMU." + 
                       "<hr>" +
                       "<p><strong>Su correo electronico es : " + persona.getEmail() + "</strong></p>" +
                       "<p><strong>Su contraseña es: " + persona.getContrasena() + "</strong></p>" +
                       "<p><strong>Porfavor, Ingresa a SIMU y actualiza tu contraseña.</strong></p>");

        persona = null;
        return "index.xhtml?faces-redirect=true";
    }
    
    public String registrarMecanico() {

        Date fecha = new Date();
        persona.setContrasena("mecanico");
        persona.setFechaRegistro(fecha);
        persona.setRol(rfl.find(2));
        pfl.create(persona);
       
        return "index.xhtml?faces-redirect=true";
    }
    
    public void loadPersonas(){
        try {
            String path = FilesUtil.saveFileTemp(partFile, "loadPersona.csv");
            int rows = pfl.loadUsers(path);
            System.out.println("####################################");
            System.out.println("Se agregaron " + rows + "personas.");
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            
        }
    }

}
