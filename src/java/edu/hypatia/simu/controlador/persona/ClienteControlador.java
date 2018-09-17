/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.controlador.persona;

import edu.hypatia.simu.modelo.dao.CiudadFacadeLocal;
import edu.hypatia.simu.modelo.dao.UsuarioFacadeLocal;
import edu.hypatia.simu.modelo.dao.DepartamentoFacadeLocal;
import edu.hypatia.simu.modelo.dao.RolFacadeLocal;
import edu.hypatia.simu.modelo.dao.TipoDocumentoFacadeLocal;
import edu.hypatia.simu.modelo.entidades.Ciudad;
import edu.hypatia.simu.modelo.entidades.Usuario;
import edu.hypatia.simu.modelo.entidades.Departamento;
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

    private Usuario clienteSeleccionado;
    private List<Usuario> clientes;

    private Usuario persona = new Usuario();
    private Usuario cliente = new Usuario();
    private Departamento departamento = new Departamento();

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

    public Usuario getPersona() {
        return persona;
    }

    public void setPersona(Usuario persona) {
        this.persona = persona;
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

        Date fecha = new Date();
        Rol rol = rfl.find(1);
        persona.setFechaRegistro(fecha);
        persona.setRol(rol);
        ufl.create(persona);

        cliente.setIdUsuario(getPersona().getIdUsuario());
        ufl.create(cliente);

        return "index.xhtml?faces-redirect=true";
    }

}
