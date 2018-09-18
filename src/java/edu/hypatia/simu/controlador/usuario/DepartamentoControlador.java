/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.controlador.usuario;

import edu.hypatia.simu.modelo.dao.DepartamentoFacadeLocal;
import edu.hypatia.simu.modelo.entidades.Departamento;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author APRENDIZ
 */
@Named(value = "departamentoControlador")
@ViewScoped
public class DepartamentoControlador implements Serializable {

    @EJB
    private DepartamentoFacadeLocal dfl;

    private Departamento departamento = new Departamento();

    private List<Departamento> departamentos;

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public DepartamentoControlador() {
    }

    public List<Departamento> getDepartamentos() {
        return dfl.findAll();
    }

}
