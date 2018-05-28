/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.controlador.reparacion;

import edu.hypatia.simu.modelo.dao.ReparacionFacadeLocal;
import edu.hypatia.simu.modelo.entidades.Reparacion;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author davrivas
 */
@Named(value = "reparacionControlador")
@SessionScoped
public class ReparacionControlador implements Serializable {

    @EJB
    private ReparacionFacadeLocal rfl;

    private List<Reparacion> reparaciones;
//    private List<Reparacion> historial; Para el historial se puede hacer un request con la placa
    private Reparacion reparacionNueva;
    private Reparacion reparacionModificada;
    private Reparacion reparacionEliminada;
    private String placa;

    /**
     * Creates a new instance of ReparacionControlador
     */
    public ReparacionControlador() {
    }

    @PostConstruct
    public void init() {
        reparacionNueva = new Reparacion();
        reparacionEliminada = new Reparacion();
        reparacionModificada = new Reparacion();
    }

    public List<Reparacion> getReparaciones() {
        return rfl.findAll();
    }

    public Reparacion getReparacionNueva() {
        return reparacionNueva;
    }

    public void setReparacionNueva(Reparacion reparacionNueva) {
        this.reparacionNueva = reparacionNueva;
    }

    public Reparacion getReparacionModificada() {
        return reparacionModificada;
    }

    public void setReparacionModificada(Reparacion reparacionModificada) {
        this.reparacionModificada = reparacionModificada;
    }

    public Reparacion getReparacionEliminada() {
        return reparacionEliminada;
    }

    public void setReparacionEliminada(Reparacion reparacionEliminada) {
        this.reparacionEliminada = reparacionEliminada;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String consultarHistorial() {
//       historial = rfl.consultarHistorial(placa);
        return "historial?faces-redirect=true";
    }

    public String insertar() {
        rfl.create(reparacionNueva);
        reparacionNueva = new Reparacion();
        return "index.xhtml?faces-redirect=true";
    }

    public String preEditar(Reparacion r) {
        reparacionModificada = r;
        return "editar.xhtml?faces-redirect=true";
    }

    public String preEliminar(Reparacion r) {
        reparacionEliminada = r;
        return "eliminar.xhtml?faces-redirect=true";
    }

    public String editar() {
        rfl.edit(reparacionModificada);
        reparacionNueva = new Reparacion();
        return "index.xhtml?faces-redirect=true";
    }

    public String eliminar() {
        rfl.remove(reparacionEliminada);
        reparacionNueva = new Reparacion();
        return "index.xhtml?faces-redirect=true";
    }

    public String getCalificacionMant(Reparacion r) {
        if (r.getCalificacion() == null) {
            return "<em>Pendiente por calificar</em>";
        }
        String rta = "";
        for (int i = 0; i < r.getCalificacion(); i++) {
            rta += "<span class='fa fa-star'></span>";
        }

        return rta;
    }
}
