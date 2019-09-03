/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.votacionescandidato.modelo.controller;

import com.mycompany.votacionescandidato.pojo.Candidato;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author diego
 */
public class Controlador {

    public Controlador() {
    }

    public String votar(Candidato candidato, List<Candidato> candidatos) throws Exception {
        for (Candidato c : (ArrayList<Candidato>) candidatos) {
            if (c.equals(candidato)) {
                c.setVotos(c.getVotos() + 1);
                String msg = "#"+c.getVotos();
                return msg;
            }
        }
        return "";
    }
    
    

    public boolean agregarCandidato(Candidato candidato, List<Candidato> candidatos) throws Exception {
        for (Candidato c : (ArrayList<Candidato>) candidatos) {
            if (Objects.equals(c.getCedula(), candidato.getCedula())) {
                throw new Exception("El candidato que desea regiatrar ya existe");
                
            }
        }
        return true;
    }
}
