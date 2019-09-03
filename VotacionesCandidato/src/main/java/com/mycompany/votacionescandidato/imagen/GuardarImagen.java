/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.votacionescandidato.imagen;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

/**
 *
 * @author CamiloAlvarez
 */
public class GuardarImagen {
    
    private String path = "E:\\linea 3\\Votaciones\\VotacionesCandidato\\src\\main\\webapp\\resources\\imagenes\\";

    /**
     * cosntructor
     */
    public GuardarImagen() {
    }
    
    /**
     * metodo encargado de guardar la imagen
     * @param fileName
     * @param in
     * @return 
     */
    public String save(String fileName, InputStream in) {
        try {
 
            
            Date now= new Date();
            String nameFile = String.valueOf(now.getTime())+fileName;
            OutputStream out = new FileOutputStream(new File(path+nameFile));
 
            int read = 0;
            byte[] bytes = new byte[1024];
 
            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
 
            in.close();
            out.flush();
            out.close();
 
            return nameFile;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return "error";
    }
}
