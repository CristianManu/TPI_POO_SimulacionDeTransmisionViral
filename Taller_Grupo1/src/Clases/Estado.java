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
public enum Estado {
    //Atributos constantes que corresponden al estado de Persona

    /**
     * Constante Asintomático con leyenda Asintomático
     */
    Asintomatico("Asintomatico"),

    /**
     * Constante Leve con leyenda Leve
     */
    Leve("Leve"),

    /**
     * Constante Moderado con leyenda Moderado
     */
    Moderado("Moderado"),

    /**
     * Constante Grave con leyenda
     */
    Grave("Grave");
    
    private final String descripcion;

    /****************        MÉTODOS DE ACCESO        *****************/
        
    /**
     * 
     * @param descripcion 
     */
    private Estado(String descripcion) {
        this.descripcion = descripcion;
    }
    
    /**
     * Devuelve el estado de una persona en forma de una cadena de String
     * @return descripcion.
     */
    public String getDescripcion(){
        return descripcion; 
    }
}
