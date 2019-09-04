/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.votacionescandidato.beans;

import com.mycompany.votacionescandidato.imagen.GuardarImagen;
import com.mycompany.votacionescandidato.modelo.controller.Controlador;
import com.mycompany.votacionescandidato.pojo.Candidato;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *@Hernan Hernandez
 * @author Camilo Alvarez
 */
@ManagedBean
@RequestScoped
public class Index implements Serializable {

    /**
     *Se instanic candidato
     */
    private Candidato candidato;

    /**
     *Etiqueta que isrve para traer los datos de otros bean 
     */
    @ManagedProperty("#{lista}")
    private Lista lista;

    /**
     *
     */
    private UploadedFile file;
    private GuardarImagen img;

    /**
     * Creates a new instance of Index
     */
    public Index() {
        System.out.println("Constructor!!!");
        candidato = new Candidato();
        img = new GuardarImagen();
        
    }
    /**
     * metodo que sirve para guardar en la lista los candidatos
     */
    public void agregarCandidato() {
        Controlador controlador = new Controlador();
        try {
            if (file != null) {
                System.err.println("qwew");
            String imagen = img.save(getFile().getFileName(), getFile().getInputstream());
            candidato.setFoto(imagen);
            if (controlador.agregarCandidato(candidato, lista.getCandidatos())) {
                
                lista.agregarCandidato(candidato);
                System.out.println(candidato.getFoto());
                
                FacesMessage msg = new FacesMessage("Aviso", "Candidato Agregado!!");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
            }
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Aviso", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }   
  
    
    /**
     * metodo que hace la variable publica 
     */
    public UploadedFile getFile() {
        return file;
    }
    /**
     * metodo que hace la variable publica 
     */
    public void setFile(UploadedFile file) {
        this.file = file;
    }
    
     /**
     * metodo que hace la variable publica 
     */
    public Lista getLista() {
        return lista;
    }
    /**
     * metodo que hace la variable publica 
     */
    public void setLista(Lista lista) {
        this.lista = lista;
    }
    
     /**
     * metodo que hace la variable publica 
     */
    public Candidato getCandidato() {
        return candidato;
    }
     /**
     * metodo que hace la variable publica 
     */
    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }
     /**
     * metodo que hace la variable publica 
     */
    public GuardarImagen getImg() {
        return img;
    }
        /**
     * metodo que hace la variable publica 
     */
    public void setImg(GuardarImagen img) {
        this.img = img;
    }

}
