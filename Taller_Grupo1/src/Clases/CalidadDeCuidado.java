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
    Alto("Alto"),Medio("Medio"), Bajo("Bajo");
    
    private final String descripcion;
    
    /*
     *@param descripcion
    */
    private CalidadDeCuidado(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getDescripcion(){
        return descripcion; 
    }
}
