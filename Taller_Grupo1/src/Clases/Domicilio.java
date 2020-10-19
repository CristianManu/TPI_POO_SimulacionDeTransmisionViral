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
    
    /**Constructor por defecto
     * Inicializa contador en 0, y crea la lista de personas
     * */
    public Domicilio() {
        nPersonasCuarentena = 0;
        personaDom = new ArrayList();
    }
    
     
    /**
    * Aumenta la cantidad de pacientes en domicilio y la cantidad total de pacientes en cuarentena.
    * También agrega la persona indicada por parámetro a la lista.
    * 
    * @param persona
    */
    public void agregarPersona(Persona persona){
        personaDom.add(persona);
        nPersonasCuarentena++;
        persona.setInternacion(Internacion.DOM);
    }
    
    /**
     * 
    * Da de alta al paciente eliminandolo al mismo de la lista indicada por parámetro.
    * @param persona 
     * @throws java.lang.Exception lanza una excepción si no hay pacientes que dar de alta.
    */
    public void darDeAltaPacienteDomicilio(Persona persona) throws Exception{
         if (nPersonasCuarentena >= 0){
            personaDom.remove(persona);
            nPersonasCuarentena--;
        } else {
            throw new Exception("No hay pacientes que dar de alta");
        }
    }
    /*
        Metodos de acceso
        Getter
    */
    
    /**
     * Devuelve la cantidad de pacientes actualmente en cuarentena
     * @return nPersonasCuarentena
    */
    public int getnPersonasCuarentena() {
        return nPersonasCuarentena;
    }

    
    /**
     * Muestra una lista actual de personas en cuarentena
     * @return Lista de personas
     */
    public List<Persona> mostrarPersonasCuarentena(){
        return personaDom;
    }
    
}
