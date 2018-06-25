/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.controlador.graficos;

import com.google.gson.Gson;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author NICOLAS
 */
@Named(value = "graficoControlador")
@SessionScoped
public class GraficoControlador implements Serializable {

    private List<DatoGrafico> datos;

    public GraficoControlador() {
    }

    @PostConstruct
    public void init() {
    }

    public List<DatoGrafico> getDatos() {
        if (datos == null || datos.isEmpty()) {
            datos = new ArrayList<>();

            datos.add(new DatoGrafico(1, new Random().nextDouble(), "Manzanas"));
            datos.add(new DatoGrafico(2, new Random().nextDouble(), "Naranja"));
            datos.add(new DatoGrafico(3, new Random().nextDouble(), "Peras"));
            datos.add(new DatoGrafico(4, new Random().nextDouble(), "Uvas"));

        }
        return datos;
    }

    public String getDatosJson() {
        Gson gson = new Gson();
        return gson.toJson(getDatos());
    }

    public void nuevosDatos() {
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.getPartialViewContext().getEvalScripts().add("updateDatos(" + getDatosJson() + ")");
        datos = null;
    }

    public void actualizarDatos() {
        datos = null;
    }

}
