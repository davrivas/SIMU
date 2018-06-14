/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.controlador.reparacion;

import edu.hypatia.simu.controlador.persona.SesionControlador;
import edu.hypatia.simu.modelo.dao.ReparacionFacadeLocal;
import edu.hypatia.simu.modelo.entidades.Moto;
import edu.hypatia.simu.modelo.entidades.Reparacion;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
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
    @Inject
    private SesionControlador sc;
    private List<Reparacion> reparaciones;
    private Moto historialMoto = new Moto();
    private Reparacion reparacionNueva = new Reparacion();
    private Reparacion reparacionSeleccionada = new Reparacion();
    private Reparacion reparacionAgendada = new Reparacion();

    /**
     * Creates a new instance of ReparacionControlador
     */
    public ReparacionControlador() {
    }

    public List<Reparacion> getReparaciones() {
        return rfl.findAll();
    }

    public Moto getHistorialMoto() {
        return historialMoto;
    }

    public void setHistorialMoto(Moto historialMoto) {
        this.historialMoto = historialMoto;
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

    public Reparacion getReparacionAgendada() {
        return reparacionAgendada;
    }

    public void setReparacionAgendada(Reparacion reparacionAgendada) {
        this.reparacionAgendada = reparacionAgendada;
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
            rta += "<span class='fa fa-star' style='color:orange;'></span>";
        }

        return rta;
    }

    public void seleccionarMotoParaHistorial(Moto m) {
        historialMoto = m;
    }

    public String agendarCita() {
        return ""; // a la misma pagina
    }
}
