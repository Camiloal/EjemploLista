/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.votacionescandidato.beans;

import com.mycompany.votacionescandidato.modelo.controller.Controlador;
import com.mycompany.votacionescandidato.pojo.Candidato;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author diego
 */
@ManagedBean
@SessionScoped
public class Votaciones implements Serializable {

    /**
     *
     */
    @ManagedProperty(value = "#{lista}")
    private Lista lista;

    /**
     *
     */
    private Candidato candidato;

    /**
     * Creates a new instance of Votaciones
     */
    public Votaciones() {
        System.out.print(candidato);
    }

    public Lista getLista() {
         //System.out.print(candidato);
        return lista;
    }

    public void setLista(Lista lista) {
        // System.out.print(candidato);
        this.lista = lista;
    }

    public Candidato getCandidato() {
         System.out.print(candidato);
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
       //  System.out.print(candidato);
        this.candidato = candidato;
    }

   public void sumarVoto(){
       candidato.setVotos(candidato.getVotos()+1) ;
       FacesMessage msg = new FacesMessage("Aviso", "listo mejo");
            FacesContext.getCurrentInstance().addMessage(null, msg);

    }

    
}
