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
public enum Estado {
    //Atributos que corresponden al estado de Persona
    Asintomatico("Asintomatico"),
    Leve("Leve"),
    Moderado("Moderado"),
    Grave("Grave");
    
    private final String descripcion;

    /**
     * 
     * @param descripcion 
     */
    private Estado(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getDescripcion(){
        return descripcion; 
    }
}
