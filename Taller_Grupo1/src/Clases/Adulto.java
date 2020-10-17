/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Grupo1
 * @version 
 */
public class Adulto extends Persona {
    /**
     * 
     * @param nombre
     * @param sano
     * @param apellido
     * @param dni
     * @param cuarentena
     * @param cuidado
     * @param estado 
     */
    public Adulto(String nombre, boolean sano, String apellido, int dni, boolean cuarentena, String cuidado, Estado estado) {
        super(nombre, sano, apellido, dni, cuarentena, cuidado, estado);
    }
    
    void irATrabajar(){}
    
    void irAEstudiar(){}
}
