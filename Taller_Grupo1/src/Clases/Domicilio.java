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
public class Domicilio {
    //Atributo
    private int nPersonasCuarentena;
    
    public void agregarPersona(Persona persona){}

    /*
        Metodos de acceso
        Getter y setter
    */
    public int getnPersonasCuarentena() {
        return nPersonasCuarentena;
    }

    /**
     * 
     * @param nPersonasCuarentena 
     */
    public void setnPersonasCuarentena(int nPersonasCuarentena) {
        this.nPersonasCuarentena = nPersonasCuarentena;
    }
    
    public List<Persona> mostrarPersonasCuarentena(){return null;}
    
}
