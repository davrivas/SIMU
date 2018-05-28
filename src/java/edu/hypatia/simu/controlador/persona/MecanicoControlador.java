/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.controlador.persona;

import edu.hypatia.simu.modelo.dao.MecanicoFacadeLocal;
import edu.hypatia.simu.modelo.dao.RolFacadeLocal;
import edu.hypatia.simu.modelo.entidades.Mecanico;
import edu.hypatia.simu.modelo.entidades.Persona;
import edu.hypatia.simu.modelo.entidades.Rol;
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
    private MecanicoFacadeLocal mfl;
    private List<Mecanico> mecanicos;
    @EJB
    private RolFacadeLocal rfl;

    private Mecanico mecanico;

    /**
     * Creates a new instance of MecanicoControlador
     */
    public MecanicoControlador() {
    }

    @PostConstruct
    public void init() {
        mecanicos = mfl.findAll();
        mecanico = new Mecanico();
    }

    public List<Mecanico> getMecanicos() {
        return mecanicos;
    }

    public Mecanico getMecanico() {
        return mecanico;
    }

    public void setMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }

    public String insertar() {
        Date fecha = new Date();
        Rol rol = rfl.find(2);
        mecanico.getPersona().setFechaRegistro(fecha);
        mecanico.getPersona().setRol(rol);
        mfl.create(mecanico);
        return "index";
    }

}
