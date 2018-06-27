/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.controlador.persona;

import edu.hypatia.simu.modelo.dao.CiudadFacadeLocal;
import edu.hypatia.simu.modelo.dao.ClienteFacadeLocal;
import edu.hypatia.simu.modelo.dao.DepartamentoFacadeLocal;
import edu.hypatia.simu.modelo.dao.PersonaFacadeLocal;
import edu.hypatia.simu.modelo.dao.RolFacadeLocal;
import edu.hypatia.simu.modelo.dao.TipoDocumentoFacadeLocal;
import edu.hypatia.simu.modelo.entidades.Ciudad;
import edu.hypatia.simu.modelo.entidades.Cliente;
import edu.hypatia.simu.modelo.entidades.Departamento;
import edu.hypatia.simu.modelo.entidades.Persona;
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
    private ClienteFacadeLocal cfl;

    @EJB
    private PersonaFacadeLocal pfl;

    @EJB
    private TipoDocumentoFacadeLocal tdfl;

    @EJB
    private CiudadFacadeLocal ciudadfl;

    @EJB
    private DepartamentoFacadeLocal dfl;

    @EJB
    private RolFacadeLocal rfl;

    private Cliente clienteSeleccionado;
    private List<Cliente> clientes;

    private Persona persona = new Persona();
    private Cliente cliente = new Cliente();
    private Departamento departamento = new Departamento();

    /*LISTAR*/
    public List<Cliente> getClientes() {
        return cfl.findAll();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Cliente getClienteSeleccionado() {
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
    public void seleccionarCliente(Cliente c) {
        System.out.println("Id:" + c.getIdCliente());
        cliente = c;
        clienteSeleccionado = c;
    }

    public String eliminar() {
        try {
            System.out.println("Vamos a eliminar el cliente");
            System.out.println("Id:" + clienteSeleccionado.getIdCliente());
            cfl.remove(clienteSeleccionado);
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
            System.out.println("Id:" + clienteSeleccionado.getIdCliente());
            cfl.edit(clienteSeleccionado);
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
        pfl.create(persona);

        cliente.setIdCliente(getPersona().getIdPersona());
        cfl.create(cliente);

        return "index.xhtml?faces-redirect=true";
    }

}
