/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.votacionescandidato.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 *
 * @author diego
 */
public class Candidato  implements Serializable {
    
    /**
     * 
     */
    @Min(7)
    private Integer cedula;
    
    /**
     * 
     */
    @Size(min=2,max=30)
    private String nombre;
    
    /**
     * 
     */
    @Size(min=2,max=30)
    private String apellido;
    
    private Date nacimiento;
    
    
    /**
     * 
     */
    private Integer votos;
    
    /**
     * 
     */
    private String foto;

    public Candidato() {
        this.votos = 0;
    }

    public Candidato(Integer cedula, String nombre, String apellido,Date nacimiento, String foto) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.foto = foto;
        this.nacimiento = nacimiento;
        this.votos = 0;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getVotos() {
        return votos;
    }

    public void setVotos(Integer votos) {
        this.votos = votos;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }
    
}
