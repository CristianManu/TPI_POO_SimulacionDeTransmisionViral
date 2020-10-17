/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Grupo1
 */
public class Domicilio {
    //Atributo
    private int nPersonasCuarentena;
    private List<Persona> personaDom;
    
    /*Constructor por defecto*/
    public Domicilio() {
        nPersonasCuarentena = 0;
        personaDom = new ArrayList();
    }
    
     /**Añade una persona a la lista de personas en domicilio
     * @param persona
     */
    public void agregarPersona(Persona persona){
        personaDom.add(persona);
        nPersonasCuarentena++;
        persona.setInternacion(Internacion.DOM);
    }
    
    /**
     * Se elimina a la persona de la lista, dandola de alta
     * @param persona
     */
    public void darDeAltaPacienteDomicilio(Persona persona){
        personaDom.remove(persona);
        nPersonasCuarentena--;
    }
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
    
    //Muestra una lista actual de personas en cuarentena
    public List<Persona> mostrarPersonasCuarentena(){return personaDom;}
    
}
