/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 * @author Grupo1
 * @version 
 */
public class Adulto extends Persona {
    /**
     * Invoca al constructor por defecto de la clase Persona
     * 
     */
    public Adulto(){
        super();
    }
    
    /**
     * Invoca al constructor parametrizado de la clase Persona
     * @param nombre
     * @param sano
     * @param apellido
     * @param dni
     * @param cuarentena
     * @param cuidado
     */

    public Adulto(String nombre, boolean sano, String apellido, int dni, boolean cuarentena, String cuidado) {
        super(nombre, sano, apellido, dni, cuarentena, cuidado);
    }
    
    /***********************               FUNCIONES               ***********************/
    
    void irATrabajar(){}
    
    void irAEstudiar(){}
}
