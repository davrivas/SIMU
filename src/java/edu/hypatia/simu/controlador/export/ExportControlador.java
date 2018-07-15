/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.controlador.export;

import com.mysql.jdbc.Connection;
import java.io.File;
import java.io.OutputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author APRENDIZ
 */
@Named(value = "exportControlador")
@SessionScoped
public class ExportControlador implements Serializable {

    FacesContext fc = FacesContext.getCurrentInstance();
    ExternalContext ec = fc.getExternalContext();

    public void motosPDF() throws Exception {

        Connection conexion;
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_simu", "root", "");

        try {

            File jasper = new File(ec.getRealPath("/WEB-INF/classes/edu/hypatia/simu/reportes/moto.jasper"));
            Map<String, Object> params = new HashMap<>();

            JasperPrint jp = JasperFillManager.fillReport(jasper.getPath(), params, conexion);
            HttpServletResponse hsr = (HttpServletResponse) ec.getResponse();
            hsr.addHeader("Content-disposition", "attachment; filename=Reporte de Motos.pdf");
            OutputStream os = hsr.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jp, os);
            os.flush();
            os.close();
            fc.responseComplete();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void accesoriosPDF() throws Exception {

        Connection conexion;
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_simu", "root", "");

        try {
            File jasper = new File(ec.getRealPath("/WEB-INF/classes/edu/hypatia/simu/reportes/accesorio.jasper"));
            Map<String, Object> params = new HashMap<>();

            JasperPrint jp = JasperFillManager.fillReport(jasper.getPath(), params, conexion);
            HttpServletResponse hsr = (HttpServletResponse) ec.getResponse();
            hsr.addHeader("Content-disposition", "attachment; filename=Reporte de accesorios.pdf");
            OutputStream os = hsr.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jp, os);
            os.flush();
            os.close();
            fc.responseComplete();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void clientesPDF() throws Exception {

        Connection conexion;
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_simu", "root", "");

        try {
            File jasper = new File(ec.getRealPath("/WEB-INF/classes/edu/hypatia/simu/reportes/cliente.jasper"));
            Map<String, Object> params = new HashMap<>();

            JasperPrint jp = JasperFillManager.fillReport(jasper.getPath(), params, conexion);
            HttpServletResponse hsr = (HttpServletResponse) ec.getResponse();
            hsr.addHeader("Content-disposition", "attachment; filename=Reporte clientes.pdf");
            OutputStream os = hsr.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jp, os);
            os.flush();
            os.close();
            fc.responseComplete();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
