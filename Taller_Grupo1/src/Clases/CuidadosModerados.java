/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.List;

/**
 *
 * @author Notebook HP
 */
public class CuidadosModerados {
    //Atributo
    private int numeroDeCamas;
    
    
    public int getNumeroDeCamas() {
        return numeroDeCamas;
    }
    /**
     * 
     * @param numeroDeCamas 
     */
    public void setNumeroDeCamas(int numeroDeCamas) {
        this.numeroDeCamas = numeroDeCamas;
    }
    
    /**
     * 
     * @param persona 
     */
    public void agregarPersona(Persona persona){}
    
    
    public List<Persona> mostrarPacientes(){return null;}
}
