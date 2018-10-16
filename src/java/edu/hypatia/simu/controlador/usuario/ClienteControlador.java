/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.controlador.usuario;

import edu.hypatia.simu.controlador.usuario.sesion.SesionControlador;
import edu.hypatia.simu.modelo.dao.CiudadFacadeLocal;
import edu.hypatia.simu.modelo.dao.UsuarioFacadeLocal;
import edu.hypatia.simu.modelo.dao.DepartamentoFacadeLocal;
import edu.hypatia.simu.modelo.dao.RolFacadeLocal;
import edu.hypatia.simu.modelo.dao.TipoDocumentoFacadeLocal;
import edu.hypatia.simu.modelo.entidades.Ciudad;
import edu.hypatia.simu.modelo.entidades.Usuario;
import edu.hypatia.simu.modelo.entidades.Departamento;
import edu.hypatia.simu.modelo.entidades.TipoDocumento;
import edu.hypatia.simu.util.PasswordUtil;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author APRENDIZ
 */
@Named(value = "clienteControlador")
@SessionScoped
public class ClienteControlador implements Serializable {

    @Inject
    private SesionControlador sc;
    @EJB
    private UsuarioFacadeLocal ufl;

    @EJB
    private TipoDocumentoFacadeLocal tdfl;

    @EJB
    private CiudadFacadeLocal ciudadfl;

    @EJB
    private DepartamentoFacadeLocal dfl;

    @EJB
    private RolFacadeLocal rfl;

    private Usuario clienteSeleccionado;
    private List<Usuario> clientes;

    private Usuario cliente = new Usuario();
    private Departamento departamento = new Departamento();
    private String confirmacion;

    /*LISTAR*/
    public List<Usuario> getClientes() {
        return ufl.todosLosClientes();
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Usuario getClienteSeleccionado() {
        return clienteSeleccionado;
    }

    public String getConfirmacion() {
        return confirmacion;
    }

    public void setConfirmacion(String confirmacion) {
        this.confirmacion = confirmacion;
    }

    public ClienteControlador() {
    }

    public List<TipoDocumento> listarTipoDocumento() {
        return tdfl.findAll();
    }

    public List<Departamento> listarDepartamento() {
        return dfl.findAll();
    }

    public List<Ciudad> listarCiudad() {
        return ciudadfl.findAll();
    }

    /*ELIMINAR*/
    public void seleccionarCliente(Usuario c) {
        System.out.println("Id:" + c.getIdUsuario());
        cliente = c;
        clienteSeleccionado = c;
    }

    public String eliminar() {
        try {
            System.out.println("Vamos a eliminar el cliente");
            System.out.println("Id:" + clienteSeleccionado.getIdUsuario());
            ufl.remove(clienteSeleccionado);
            clientes = null;
        } catch (Exception e) {
        }
        clienteSeleccionado = null;
        return "listarClientes.xhtml?faces-redirect=true";
    }

    /*ACTUALIZAR*/
    public String editar() {
        try {
            System.out.println("Vamos a editar el cliente:");
            System.out.println("Id:" + clienteSeleccionado.getIdUsuario());
            ufl.edit(clienteSeleccionado);
            clientes = null;
        } catch (Exception e) {
        }
        return "listarClientes.xhtml?faces-redirect=true";
    }

    /*REGISTRAR*/
    public String registrarCliente() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        try {
            if (ufl.findByEmail(cliente.getEmail()) == null) {
                if (cliente.getContrasena().equals(confirmacion)) {
                    String contrasenaSinMD5 = cliente.getContrasena(),
                            contrasenaConMD5 = PasswordUtil.getMD5(contrasenaSinMD5);
//                System.out.println("Contraseña sin MD5: " + contrasenaSinMD5);
                    cliente.setContrasena(contrasenaConMD5);
//                System.out.println("Contraseña con MD5: " + contrasenaConMD5);
                    cliente.setFechaRegistro(new Date());
                    cliente.setRol(rfl.find(1));
                    ufl.create(cliente);
                    sc.setEmail(cliente.getEmail());
                    sc.setContrasena(contrasenaSinMD5);
                    sc.iniciarSesion();
                } else {
                    fc.addMessage("form-register", new FacesMessage(
                            FacesMessage.SEVERITY_INFO, "Las contraseñas no coinciden:",
                            "verifique que las contraseñas coincidan"));
                }
            } else {
                fc.addMessage("form-register", new FacesMessage(
                        FacesMessage.SEVERITY_INFO, "El correo electrónico " + cliente.getEmail()
                        + " ya existe en nuestra base de datos", ""));
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
            fc.addMessage("form-register", new FacesMessage(
                    FacesMessage.SEVERITY_INFO, "No se pudo realizar el registro de usuario", ""));
        }

        return "";
    }

    public String registrarNuevoCliente() {
        try {
            String contrasenaSinMD5 = cliente.getContrasena(),
                    contrasenaConMD5 = PasswordUtil.getMD5(contrasenaSinMD5);
            cliente.setContrasena(contrasenaConMD5);
            cliente.setFechaRegistro(new Date());
            cliente.setRol(rfl.find(1));
            ufl.create(cliente);
            cliente = new Usuario();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

        return "listarClientes.xhtml?faces-redirect=true";
    }

}
