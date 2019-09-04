/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.votacionescandidato.beans;

import com.mycompany.votacionescandidato.modelo.controller.Controlador;
import com.mycompany.votacionescandidato.pojo.Candidato;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author diego
 */
@ManagedBean
@ViewScoped
public class Votaciones implements Serializable {

    
    /**
     *
     */
    @ManagedProperty("#{lista}")
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

    public Candidato getCandidato() {
        System.out.print(candidato);
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        //  System.out.print(candidato);
        this.candidato = candidato;
    }


    public void sumarVoto() {
        candidato.setVotos(candidato.getVotos() + 1);
      
        lista.iniciarGrafica();
        FacesMessage mensa = new FacesMessage("Candidato: " + candidato.getNombre(), "Numero de votos: " + candidato.getVotos());
        FacesContext.getCurrentInstance().addMessage(null, mensa);

    }
    
    public void ganador(){
        int cont=0;
        Candidato c = new Candidato();
        for (Candidato can : lista.getCandidatos()) {
            if(cont<can.getVotos()){
                cont = can.getVotos();
                c= can;
            }
                
        }
         FacesMessage mensa = new FacesMessage("El Candidato: " + c.getNombre(), "Gano con " + c.getVotos()+" votos");
        FacesContext.getCurrentInstance().addMessage(null, mensa);
    }

    /**
     * @return the lista
     */
    public Lista getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(Lista lista) {
        this.lista = lista;
    }

    
    

}
