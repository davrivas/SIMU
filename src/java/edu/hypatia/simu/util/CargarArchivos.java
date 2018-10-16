/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.util;

import edu.hypatia.simu.modelo.entidades.Producto;
import java.io.File;
import java.io.IOException;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

/**
 *
 * @author asus
 */
public class CargarArchivos {

    Producto producto = new Producto();

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    private Part file1;
    private Part file2;
    private Part file3;

    public Part getFile1() {
        return file1;
    }

    public void setFile1(Part file1) {
        this.file1 = file1;
    }

    public Part getFile2() {
        return file2;
    }

    public void setFile2(Part file2) {
        this.file2 = file2;
    }

    public Part getFile3() {
        return file3;
    }

    public void setFile3(Part file3) {
        this.file3 = file3;
    }
    

    public void cargarImagen(Part p, Integer id) {
        try {
            String pathFolder = FacesContext.getCurrentInstance().getExternalContext()
                    .getRealPath("resources").concat("\\img\\productos\\Producto(" + producto.getIdProducto() + ")").replace("\\build", "");
            System.out.println("------------------------------------------------------");
            System.out.println(pathFolder);
            System.out.println("------------------------------------------------------");
            File folder = new File(pathFolder);
            if (!folder.exists()) {
                folder.mkdir();
            }
            String nombre = p.getSubmittedFileName();
            FilesUtil2.copiarArchivo(p.getInputStream(), pathFolder.concat("\\" + nombre));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }

    public String[] getFotos(int idProducto) {
        String context = FacesContext.getCurrentInstance().getExternalContext().getRealPath("resources/img/productos/Producto(" + idProducto + ")");
        File file = new File(context);
        for (String foto : file.list()) {
            System.out.println(foto);
        }
        return file.list();
    }
    //metodo para cargar las fotos 

    public String cargarImagen1(Part p, Integer id) {
        try {
//            String pathFolder = FacesContext.getCurrentInstance().getExternalContext()
//                    .getRealPath("resources").concat("\\img\\solicitudes\\Solicitud(" + id + ")").replace("\\build", "");
            String pathFolderBuild = FacesContext.getCurrentInstance().getExternalContext()
                    .getRealPath("resources").concat("\\img\\productos\\Producto()(" + id + ")");

            File folderBuild = new File(pathFolderBuild);
            File folder = new File(pathFolderBuild.replace("\\build", ""));

            folderBuild.mkdir();
            folder.mkdir();

            String pathFolder = folder.getPath() + "\\" + p.getSubmittedFileName();
            pathFolderBuild += "\\" + p.getSubmittedFileName();

            FilesUtil2.copiarArchivo(p.getInputStream(), pathFolder);
            FilesUtil2.copiarArchivo(p.getInputStream(), pathFolderBuild);

            pathFolder = pathFolder.substring(pathFolder.lastIndexOf("resources"));

            return pathFolder;
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return "";
    }

    public String upload() {
        

        int idProducto = producto.getIdProducto();
        String pathBuild = FacesContext.getCurrentInstance().getExternalContext()
                .getRealPath("resources\\img\\productos");
        String path = pathBuild.replace("\\build", "");

        FilesUtil2.crearCarpeta(pathBuild, "Producto(" + idProducto + ")");
        FilesUtil2.crearCarpeta(path, "Producto(" + idProducto + ")");

        pathBuild += "\\Producto(" + idProducto + ")\\";
        path += "\\Producto(" + idProducto + ")\\";

        copiarFoto(file1, pathBuild, path);
        copiarFoto(file2, pathBuild, path);
        copiarFoto(file3, pathBuild, path);

        return " ";
    }

    private void copiarFoto(Part file, String pathBuild, String path) {
        try {
            if (file != null) {
                FilesUtil2.copiarArchivo(file.getInputStream(), pathBuild
                        .concat(file.getSubmittedFileName()));
                FilesUtil2.copiarArchivo(file.getInputStream(), path
                        .concat(file.getSubmittedFileName()));
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
