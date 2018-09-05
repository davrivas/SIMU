/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.controlador.persona;

import edu.hypatia.simu.controlador.mail.Mail;
import edu.hypatia.simu.controlador.persona.sesion.SesionControlador;
import edu.hypatia.simu.modelo.dao.jpal.RolFacadeLocal;
import edu.hypatia.simu.modelo.dao.jpal.UsuarioFacadeLocal;
import edu.hypatia.simu.modelo.entidades.Usuario;
import edu.hypatia.simu.util.FilesUtil;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
    private UsuarioFacadeLocal ufl;
    
    @EJB
    private RolFacadeLocal rfl;

    private Usuario usuario = new Usuario();
    
    
    private List<Usuario> personasAd;

    private Part partFile;
    

    public Usuario getUsuario() {
        return usuario;
    }
    

    public void setPersona(Usuario usuario) {
        this.usuario = usuario;
    }

    public Part getPartFile() {
        return partFile;
    }

    public void setPartFile(Part partFile) {
        this.partFile = partFile;
    }

    public PersonaControlador() {
    }
    
        
    public List<Usuario> listarAdmin(){
        return ufl.findAllAdmin();
    }

    public String registrarAdministrador() {

        Date fecha = new Date();

        usuario.setRol(rfl.find(3));
        usuario.setContrasena("administrador");
        usuario.setFechaRegistro(fecha);
        ufl.create(usuario);
        Mail.sendMail(usuario.getEmail(), "Administrador registrado", sc.getUsuario().getNombre()
                + "<h1>Registro de Administrador</h1>"
                + "<h3>Hola " + usuario.getNombre() + " " + usuario.getApellido() + "</h3>"
                + "Usted ha sido registrado por " + sc.getUsuario().getNombre() + sc.getUsuario().getApellido() + "como un nuevo administrador de SIMU."
                + "<hr>"
                + "<p><strong>Su correo electronico es : " + usuario.getEmail() + "</strong></p>"
                + "<p><strong>Su contraseña es: " + usuario.getContrasena() + "</strong></p>"
                + "<p><strong>Porfavor, Ingresa a SIMU y actualiza tu contraseña.</strong></p>");

        usuario = null;
        return "index.xhtml?faces-redirect=true";
    }

    public String registrarMecanico() {

        Date fecha = new Date();
        usuario.setContrasena("mecanico");
        usuario.setFechaRegistro(fecha);
        usuario.setRol(rfl.find(2));
        ufl.create(usuario);
        return "index.xhtml?faces-redirect=true";
    }

    public void loadPersonas() {
        try {
            String path = FilesUtil.saveFileTemp(partFile, "datosPersona.csv");
            int rows = ufl.loadUsers(path);
            System.out.println("####################################");
            System.out.println("Se agregaron " + rows + " personas.");
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

}
