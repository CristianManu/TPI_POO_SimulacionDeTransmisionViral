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
        Atributos que corresponde a la calidad de cuidados
        que tenga una persona
    */
    DOM("Domicilio"),CM("Cuidados Moderados"), CTI("Cuidados Terapia Intensiva");
    
    private final String descripcion;
    
    /*
     *@param descripcion
    */
    private Internacion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getDescripcion(){
        return descripcion; 
    }
}