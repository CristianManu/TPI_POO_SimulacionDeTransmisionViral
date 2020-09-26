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
public class CuidadosTerapiaIntesiva {
    //Atributo
    private int numeroDeCamas;

    /*
        Metodos de acceso
        Getters y setters
    */
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
    
    public void agregarPersona(Persona persona){}
    
    public List<Persona> mostrarPacientes(){return null;}
}
