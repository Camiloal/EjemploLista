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
 *
 * @author diego
 */
@ManagedBean
@SessionScoped
public class Index implements Serializable {

    /**
     *
     */
    private Candidato candidato;

    /**
     *
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

    public void agregarCandidato() {
        Controlador controlador = new Controlador();

        try {
            if (file != null) {
            String imagen = img.save(getFile().getFileName(), getFile().getInputstream());
            candidato.setFoto(imagen);
            if (controlador.agregarCandidato(candidato, lista.getCandidatos())) {
                lista.getCandidatos().add(candidato);
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
    
    public void upload() throws IOException {
        if (file != null) {
            FacesMessage message = new FacesMessage("Succesful", getFile().getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
    
    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public GuardarImagen getImg() {
        return img;
    }

    public void setImg(GuardarImagen img) {
        this.img = img;
    }

}
