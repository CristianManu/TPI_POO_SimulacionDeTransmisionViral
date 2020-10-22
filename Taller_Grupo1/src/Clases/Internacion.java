/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Bautista
 */
public enum Internacion {
    /*
        Atributos constantes que corresponden al lugar de internacion
        que tenga una persona
    */

    /**
     * Constante DOM con leyenda Domicilio
     */

    DOM("Domicilio"),

    /**
     * Constante CM con leyenda Cuidados Moderados 
     */
    CM("Cuidados Moderados"),

    /**
     * Constante CTI con leyenda Cuidados Terapia Intensiva
     */
    CTI("Cuidados Terapia Intensiva");
    
    private final String descripcion;
    
    /****************        MÉTODOS DE ACCESO        *****************/
    
    /*
     *@param descripcion
    */
    private Internacion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    /**
     *
     * @return String
     */
    public String getDescripcion(){
        return descripcion; 
    }
}