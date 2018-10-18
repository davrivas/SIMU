/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.util;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

/**
 *
 * @author NICOLAS
 */
public class FilesUtil {

    public static String folderPathFilesTemp = "/files/temps";

    public static String saveFileTemp(Part part, String fileName) throws Exception {

        System.out.println("**********************************");
        System.out.println(part.getContentType());
        System.out.println(part.getName());
        System.out.println(part.getSubmittedFileName());
        System.out.println(part.getSize());
        File folder = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("") + folderPathFilesTemp);
        System.out.println(folder.getAbsolutePath());
        if (!folder.exists()) {
            folder.mkdirs();
        }
        try (InputStream is = part.getInputStream()) {
            Files.copy(is, (new File(folder, fileName)).toPath(), StandardCopyOption.REPLACE_EXISTING);
            return folder.getAbsolutePath() + "/" + fileName;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            throw new Exception("Error al guardar el archivo: " + part.getSubmittedFileName(), e);
        }

    }

    public static void deleteFileTemp(Part part) throws Exception {
        System.out.println("**********************************");
        System.out.println(part.getContentType());
        System.out.println(part.getName());
        System.out.println(part.getSubmittedFileName());
        System.out.println(part.getSize());
        File file = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("") + folderPathFilesTemp + "/" + part.getSubmittedFileName());
        if (file.exists()) {
            file.deleteOnExit();
        }
    }
    
    public static void subirFoto(Part part, String path, String nameFile) throws Exception {
        File folder = new File(path);
        if (!folder.exists()) {
            folder.mkdirs();

        }
        try (InputStream is = part.getInputStream()) {
            Files.copy(is, (new File(folder, nameFile)).toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error al subir el archivo" + part.getSubmittedFileName(), e);
        }
    }

}
