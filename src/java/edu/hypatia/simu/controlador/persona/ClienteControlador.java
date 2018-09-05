/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.controlador.persona;

import edu.hypatia.simu.modelo.dao.jpal.CiudadFacadeLocal;
import edu.hypatia.simu.modelo.dao.jpal.DepartamentoFacadeLocal;
import edu.hypatia.simu.modelo.dao.jpal.RolFacadeLocal;
import edu.hypatia.simu.modelo.dao.jpal.TipoDocumentoFacadeLocal;
import edu.hypatia.simu.modelo.dao.jpal.UsuarioFacadeLocal;
import edu.hypatia.simu.modelo.entidades.Ciudad;
import edu.hypatia.simu.modelo.entidades.Departamento;
import edu.hypatia.simu.modelo.entidades.Usuario;
import edu.hypatia.simu.modelo.entidades.Rol;
import edu.hypatia.simu.modelo.entidades.TipoDocumento;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author APRENDIZ
 */
@Named(value = "clienteControlador")
@SessionScoped
public class ClienteControlador implements Serializable {

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

    private Usuario usuarioSeleccionado;
    private List<Usuario> clientes;

    private Usuario usuario = new Usuario();
    private Departamento departamento = new Departamento();

    /*LISTAR*/
    public List<Usuario> getUsuarios() {
        return ufl.findAll();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Usuario getUsuarioSeleccionado() {
        return usuarioSeleccionado;
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
    public void seleccionarUsuario(Usuario u) {
        System.out.println("Id:" + u.getIdUsuario());
        usuario = u;
        usuarioSeleccionado = u;
    }

    public String eliminar() {
        try {
            System.out.println("Vamos a eliminar el cliente");
            System.out.println("Id:" + usuarioSeleccionado.getIdUsuario());
            ufl.remove(usuarioSeleccionado);
            clientes = null;
        } catch (Exception e) {
        }
        usuarioSeleccionado = null;
        return "listarUsuarios.xhtml?faces-redirect=true";
    }

    /*ACTUALIZAR*/
    public String editar() {
        try {
            System.out.println("Vamos a editar el cliente:");
            System.out.println("Id:" + usuarioSeleccionado.getIdUsuario());
            ufl.edit(usuarioSeleccionado);
            clientes = null;
        } catch (Exception e) {
        }
        return "listarUsuarios.xhtml?faces-redirect=true";
    }

    /*REGISTRAR*/
    public String registrarUsuario() {

        Date fecha = new Date();
        Rol rol = rfl.find(1);
        usuario.setFechaRegistro(fecha);
        usuario.setRol(rol);
        ufl.create(usuario);

        return "index.xhtml?faces-redirect=true";
    }

}
