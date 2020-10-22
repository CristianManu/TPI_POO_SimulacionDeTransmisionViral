/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Grupo1
 */
public class Comorbilidad {
    /*Atributo nombre de dos o
    más trastornos o enfermedades que sufre una persona*/
    
    
    private String nombre;
    
    
    
    /****************        MÉTODOS DE ACCESO        ****************
     * GETTER Y SETTER
    */
    
    /**
     * Devuelve el nombre de la comorbilidad
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * 
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     *
     * @param comor
     */
    public Comorbilidad (String comor){
        this.nombre = comor;
    }
    
    
}
