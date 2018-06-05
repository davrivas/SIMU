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
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author davrivas
 */
@Named(value = "reparacionControlador")
@ViewScoped
public class ReparacionControlador implements Serializable {

    @EJB
    private ReparacionFacadeLocal rfl;

    private List<Reparacion> reparaciones;
//    private List<Reparacion> historial; Para el historial se puede hacer un request con la placa
    private Reparacion reparacionNueva = new Reparacion();
    private Reparacion reparacionSeleccionada = new Reparacion();
    private Reparacion reparacionEliminada;
    private String placa;

    /**
     * Creates a new instance of ReparacionControlador
     */
    public ReparacionControlador() {
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

    public Reparacion getReparacionSeleccionada() {
        return reparacionSeleccionada;
    }

    public void setReparacionSeleccionada(Reparacion reparacionSeleccionada) {
        this.reparacionSeleccionada = reparacionSeleccionada;
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

    public void seleccionarReparacion(Reparacion r) {
        reparacionSeleccionada = r;
    }

    public String editar() {
        rfl.edit(reparacionSeleccionada);
        return "index.xhtml?faces-redirect=true";
    }

    public String eliminar() {
        rfl.remove(reparacionSeleccionada);
        return "index.xhtml?faces-redirect=true";
    }

    public String getCalificacionReparacion(Reparacion r) {
        if (r.getCalificacion() == null) {
            return "<em>Pendiente por calificar</em>";
        }
        String rta = "";
        for (int i = 0; i < r.getCalificacion(); i++) {
            rta += "<span class='fa fa-star' style='color:#f5f516;'></span>";
        }

        return rta;
    }
}
