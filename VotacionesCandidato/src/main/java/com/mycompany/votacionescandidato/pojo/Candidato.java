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
 *@autor Hernan Hernandez
 * @author Camilo Alvarez
 */
public class Candidato  implements Serializable {
    
    /**
     * Variable que guarda la cedula
     */
    @Min(7)
    private Integer cedula;
    
    /**
     * Variable que muestra el nimebre 
     */
    @Size(min=2,max=30)
    private String nombre;
    
    /**
     * Variable que guarda el apellido 
     */
    @Size(min=2,max=30)
    private String apellido;
   /**
    * variable que guarda la fecha de nacimiento 
    */
    private Date nacimiento;
    
    
    /**
     * variable que guarda los votos 
     */
    private Integer votos;
    
    /**
     * variiable donde se guarda la foto 
     */
    private String foto;
/**
 * constructor con votoso = 0
 */
    public Candidato() {
        this.votos = 0;
    }
/**
 * Contructor dode e inicializan las variabes 
 * @param cedula
 * @param nombre
 * @param apellido
 * @param nacimiento
 * @param foto 
 */
    public Candidato(Integer cedula, String nombre, String apellido,Date nacimiento, String foto) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.foto = foto;
        this.nacimiento = nacimiento;
        this.votos = 0;
    }
/**
 * Metodo que vuelve publica la variable
 */
    public String getFoto() {
        return foto;
    }
/**
 * Metodo que vuelve publica la variable
 */
    public void setFoto(String foto) {
        this.foto = foto;
    }

 /**
 * Metodo que vuelve publica la variable
 */
    public Integer getCedula() {
        return cedula;
    }
/**
 * Metodo que vuelve publica la variable
 */
    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }
/**
 * Metodo que vuelve publica la variable
 */
    public String getNombre() {
        return nombre;
    }
/**
 * Metodo que vuelve publica la variable
 */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
/**
 * Metodo que vuelve publica la variable
 */
    public String getApellido() {
        return apellido;
    }
/**
 * Metodo que vuelve publica la variable
 */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
/**
 * Metodo que vuelve publica la variable
 */
    public Integer getVotos() {
        return votos;
    }
/**
 * Metodo que vuelve publica la variable
 */
    public void setVotos(Integer votos) {
        this.votos = votos;
    }
/**
 * Metodo que vuelve publica la variable
 */
    public Date getNacimiento() {
        return nacimiento;
    }
/**
 * Metodo que vuelve publica la variable
 */
    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }
    
}
