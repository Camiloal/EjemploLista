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

/**
 *
 * @author diego
 */
@ManagedBean
@ApplicationScoped
public class Lista implements Serializable {

    private List<Candidato> candidatos;

    /**
     * Creates a new instance of Lista
     */
    public Lista() {
        candidatos = new ArrayList<>();
    }

    public List getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(List candidatos) {
        this.candidatos = candidatos;
    }
    
}
