/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.votacionescandidato.beans;

import com.mycompany.votacionescandidato.pojo.Candidato;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author diego
 */
@ManagedBean
@ApplicationScoped
public class Lista implements Serializable {

    private List<Candidato> candidatos;
    private PieChartModel livePieModel;

    /**
     * Creates a new instance of Lista
     */
    public Lista() {
        candidatos = new ArrayList<>();
        livePieModel = new PieChartModel();
    }
    
    public void agregarCandidato(Candidato can){
         getCandidatos().add(can);
         iniciarGrafica();
    }

    /**
     * @return the candidatos
     */
    public List<Candidato> getCandidatos() {
        return candidatos;
    }

    /**
     * @param candidatos the candidatos to set
     */
    public void setCandidatos(List<Candidato> candidatos) {
        this.candidatos = candidatos;
    }
    
    public void iniciarGrafica() {
        setLivePieModel(new PieChartModel());
        for (Candidato col : getCandidatos()) {
            
            System.out.println(col.getNombre());
            System.out.println(col.getVotos());
            getLivePieModel().getData().put(col.getNombre(), col.getVotos());
        }
        getLivePieModel().setTitle("Candidatos");
        getLivePieModel().setLegendPosition("w");
        getLivePieModel().setShadow(false);
    }

    /**
     * @return the livePieModel
     */
    public PieChartModel getLivePieModel() {
        return livePieModel;
    }

    /**
     * @param livePieModel the livePieModel to set
     */
    public void setLivePieModel(PieChartModel livePieModel) {
        this.livePieModel = livePieModel;
    }
    
}
