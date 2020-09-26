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
public class Menor extends Persona{
    /**
     * 
     * @param nombre
     * @param sano
     * @param apellido
     * @param dni
     * @param cuarentena
     * @param comorbilidad
     * @param cuidado
     * @param estado 
     */
    public Menor(String nombre, boolean sano, String apellido, int dni, boolean cuarentena, Comorbilidad comorbilidad, Cuidado cuidado, Estado estado) {
        super(nombre, sano, apellido, dni, cuarentena, comorbilidad, cuidado, estado);
    }
    
    
    public void irAEscuela(){}
    public void jugar(){}
    
    
}
