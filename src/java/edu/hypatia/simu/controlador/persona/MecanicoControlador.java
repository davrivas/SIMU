/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.controlador.persona;

import edu.hypatia.simu.modelo.dao.jpal.RolFacadeLocal;
import edu.hypatia.simu.modelo.dao.jpal.UsuarioFacadeLocal;
import edu.hypatia.simu.modelo.entidades.Rol;
import edu.hypatia.simu.modelo.entidades.Usuario;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author davrivas
 */
@Named(value = "mecanicoControlador")
@SessionScoped
public class MecanicoControlador implements Serializable {

    @EJB
    private UsuarioFacadeLocal ufl;
    private List<Usuario> mecanicos;
    @EJB
    private RolFacadeLocal rfl;

    private Usuario mecanico;

    /**
     * Creates a new instance of UsuarioControlador
     */
    public MecanicoControlador() {
    }

    @PostConstruct
    public void init() {
        mecanicos = ufl.findAllMechanic();
        mecanico = new Usuario();
    }

    public List<Usuario> getUsuarios() {
        return mecanicos;
    }

    public Usuario getUsuario() {
        return mecanico;
    }

    public void setUsuario(Usuario mecanico) {
        this.mecanico = mecanico;
    }

    public String insertar() {
        Date fecha = new Date();
        Rol rol = rfl.find(2);
        mecanico.setFechaRegistro(fecha);
        mecanico.setRol(rol);
        ufl.create(mecanico);
        return "index";
    }

}
