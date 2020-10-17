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
public class Atencion {
    //Atributos de la clase asociacion Atencion
    private Persona persona;
    private Hospital hospital;

    /**
     * 
     * @param persona
     * @param hospital 
     */
    public Atencion(Persona persona, Hospital hospital) {
        this.persona = persona;
        this.hospital = hospital;
    }

    
    public Persona getPersona() {
        return persona;
    }
    
    /**
     * 
     * @param persona 
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Hospital getHospital() {
        return hospital;
    }

    /**
     * 
     * @param hospital 
     */
    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
    
    void enviarADomicilio(){}
    
    public void enviarATerapiaIntensiva(){     
        if (!hospital.agregarPacienteGrave(persona)){
            if (!hospital.agregarPacienteModerado(persona)){
                this.enviarADomicilio();
            }
        }
    }
    void enviarACuidadosModerados(){}
    void atencionPorCovid(){}
    void atencionGeneral(){}
    /**
     * 
     * @param persona 
     */
    void darDeAlta(Persona persona){
        if (persona.getInternacion().equals(Internacion.DOM)){
        
        }
    }
    
    
    
}
