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
    private List<Persona> personaDom;
    
    /**Constructor por defecto
     * Inicializa contador en 0, y crea la lista de personas
     * */
    public Domicilio() {
        personaDom = new ArrayList();
    }
    
     
    /**
    * Aumenta la cantidad de pacientes en domicilio.
    * También añade la persona indicada por parámetro a la lista.
    * 
    * @param persona
    */
    public void agregarPersona(Persona persona){
        personaDom.add(persona);
        persona.setInternacion(Internacion.DOM);
    }
    
    /**
     * 
    * Da de alta al paciente cambiando la inmunidad de la persona a verdadero. 
    * Como así también sano a verdadero y elimina al mismo de la lista indicada por parámetro.
    * 
    * @param persona 
     * @throws java.lang.Exception lanza una excepción si no hay pacientes que dar de alta.
    */
    public void darDeAltaPacienteDomicilio(Persona persona) throws Exception{
         if (personaDom.size() >= 0){
            persona.setInmune(true);
            persona.setSano(true);
            personaDom.remove(persona);
            
            
        } else {
            throw new Exception("No hay pacientes que dar de alta");
        }
    }
    
    
    /*
        Metodos de acceso
        Getter
    */
    
    
    /**
     * Muestra una lista actual de personas en cuarentena
     * @return Lista de personas
     */
    public List<Persona> mostrarPersonasCuarentena(){
        return personaDom;
    }
    
}
