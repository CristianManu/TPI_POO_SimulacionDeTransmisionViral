/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Notebook HP
 */
public enum CalidadDeCuidado {
    /*
        Atributos que corresponde a la calidad de cuidados
        que tenga una persona
    */

    /**
     * Calidad de cuidado alto
     */

    Alto("Alto"),

    /**
     * Calidad de cuidado medio
     */
    Medio("Medio"),

    /**
     *Calidad de cuidado bajo
     */
    Bajo("Bajo");
    
    private final String descripcion;
    
    /**
     * MÉTODOS DE ACCESO
     * GETTER Y SETTER
    */
    
    /*
     *@param descripcion
    */
    private CalidadDeCuidado(String descripcion) {
        this.descripcion = descripcion;
    }
    
    /**
     * Devuelve la calidad de cuidado
     * @return descripcion
     */
    public String getDescripcion(){
        return descripcion; 
    }
}
