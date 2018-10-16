/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.controlador.usuario;

import edu.hypatia.simu.controlador.mail.Mail;
import edu.hypatia.simu.controlador.usuario.sesion.SesionControlador;
import edu.hypatia.simu.modelo.dao.RolFacadeLocal;
import edu.hypatia.simu.modelo.dao.UsuarioFacadeLocal;
import edu.hypatia.simu.modelo.entidades.Usuario;
import edu.hypatia.simu.util.FilesUtil;
import edu.hypatia.simu.util.PasswordUtil;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.http.Part;

/**
 *
 * @author APRENDIZ
 */
@Named(value = "usuarioControlador")
@SessionScoped
public class UsuarioControlador implements Serializable {

    @Inject
    private SesionControlador sc;

    @EJB
    private UsuarioFacadeLocal ufl;
    
    @EJB
    private RolFacadeLocal rfl;

    private Usuario usuario = new Usuario();
    
    
    private List<Usuario> mecanicos;
    private List<Usuario> clientes;

    private Part partFile;
    

    public Usuario getUsuario() {
        return usuario;
    }
    

    public void setUsuario(Usuario persona) {
        this.usuario = persona;
    }

    public Part getPartFile() {
        return partFile;
    }

    public void setPartFile(Part partFile) {
        this.partFile = partFile;
    }

    public UsuarioControlador() {
    }
    
        
    public List<Usuario> listarAdmin(){
        return ufl.todosLosAdmins();
    }

    public List<Usuario> getMecanicos() {
        return ufl.todosLosMecanicos();
    }

    public List<Usuario> getClientes() {
        return ufl.todosLosClientes();
    }

    public String registrarAdministrador() {

        Date fecha = new Date();

        usuario.setRol(rfl.find(3));
        usuario.setContrasena(PasswordUtil.getMD5("administrador"));
        usuario.setFechaRegistro(fecha);
        ufl.create(usuario);
        Mail.sendMail(usuario.getEmail(), "Administrador registrado", sc.getUsuario().getNombre()
                + "<h1>Registro de Administrador</h1>"
                + "<h3>Hola " + usuario.getNombre() + " " + usuario.getApellido() + "</h3>"
                + "Usted ha sido registrado por " + sc.getUsuario().getNombre() + sc.getUsuario().getApellido() + "como un nuevo administrador de SIMU."
                + "<hr>"
                + "<p><strong>Su correo electronico es : " + usuario.getEmail() + "</strong></p>"
                + "<p><strong>Su contraseña es: administrador</strong></p>"
                + "<p><strong>Porfavor, Ingresa a SIMU y actualiza tu contraseña.</strong></p>");

        usuario = new Usuario();
        return "index.xhtml?faces-redirect=true";
    }

    public String registrarMecanico() {
        System.out.println("vamos a ver si funciona");
        System.out.println("nombre" + usuario.getNombre());
        System.out.println("apellido: " + usuario.getApellido());
        System.out.println("correo: " + usuario.getEmail());
        System.out.println("telefono: " + usuario.getTelefono());
        Date fecha = new Date();
        System.out.println("fecha:" + fecha.toString());
        usuario.setContrasena(PasswordUtil.getMD5("mecanico"));
        System.out.println("contrsaeña: " + usuario.getContrasena());
        usuario.setFechaRegistro(fecha);
        usuario.setRol(rfl.find(2));
        System.out.println("Rol: " + usuario.getRol().getRol());
        ufl.create(usuario);
        System.out.println("Se regisgtró un nuevo mecánico");
        Mail.sendMail(usuario.getEmail(), "Mecánico registrado", sc.getUsuario().getNombre()
                + "<h1>Registro de Mecánico</h1>"
                + "<h3>Hola " + usuario.getNombre() + " " + usuario.getApellido() + "</h3>"
                + "Usted ha sido registrado por " + sc.getUsuario().getNombre() + sc.getUsuario().getApellido() + "como un nuevo administrador de SIMU."
                + "<hr>"
                + "<p><strong>Su correo electronico es : " + usuario.getEmail() + "</strong></p>"
                + "<p><strong>Su contraseña es: mecanico</strong></p>"
                + "<p><strong>Porfavor, Ingresa a SIMU y actualiza tu contraseña.</strong></p>");
        usuario = new Usuario();
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
