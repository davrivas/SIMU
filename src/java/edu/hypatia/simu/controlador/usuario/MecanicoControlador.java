/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.controlador.usuario;

import edu.hypatia.simu.modelo.dao.RolFacadeLocal;
import edu.hypatia.simu.modelo.dao.UsuarioFacadeLocal;
import edu.hypatia.simu.modelo.entidades.Rol;
import edu.hypatia.simu.modelo.entidades.Usuario;
import edu.hypatia.simu.util.PasswordUtil;
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
    private UsuarioFacadeLocal mfl;
    private List<Usuario> mecanicos;
    @EJB
    private RolFacadeLocal rfl;

    private Usuario mecanico;

    /**
     * Creates a new instance of MecanicoControlador
     */
    public MecanicoControlador() {
    }

    @PostConstruct
    public void init() {
        mecanico = new Usuario();
    }

    public List<Usuario> getMecanicos() {
        return mfl.todosLosMecanicos();
    }

    public Usuario getMecanico() {
        return mecanico;
    }

    public void setMecanico(Usuario mecanico) {
        this.mecanico = mecanico;
    }

    public String insertar() {
        mecanico.setContrasena(PasswordUtil.getMD5("mecanico"));
        mecanico.setFechaRegistro(new Date());
        mecanico.setRol(rfl.find(2));
        mfl.create(mecanico);
        return "index";
    }

}
