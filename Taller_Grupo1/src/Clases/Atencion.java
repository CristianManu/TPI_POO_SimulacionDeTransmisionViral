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
    private Domicilio domicilio;

    /**
     * 
     * @param persona
     * @param hospital 
     */
    public Atencion(Persona persona, Hospital hospital, Domicilio domicilio) {
        this.persona = persona;
        this.hospital = hospital;
        this.domicilio = domicilio;
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
    
    /*Agrega una persona que fue derivada a Domicilio*/
    void enviarADomicilio(){
        domicilio.agregarPersona(persona);
    }
    
    /*Derivación, si no se puede enviar al paciente a Cuidados Terapia Intensiva, deriva a Cuidados Moderados
    de no ser asi, lo envia al Domicilio*/
    public void enviarATerapiaIntensiva(){     
        if (!hospital.agregarPacienteGrave(persona)){
            if (!hospital.agregarPacienteModerado(persona)){
                this.enviarADomicilio();
            }
        }
    }
    
    /*Derivacion, si no se puede enviar al paciente a Cuidados Moderados, se lo deriva al Domicilio*/
    void enviarACuidadosModerados(){
        if (!hospital.agregarPacienteModerado(persona)){
                this.enviarADomicilio();
            }
    }
    
    /*Si la persona no esta sana, dependiendo de su estado se la derivará a una de las dos salas o a su domicilio*/
    void atencionPorCovid(){
        if (persona.isSano() == false) {
            if(persona.getEstado() == "Asintomatico" || persona.getEstado() == "Leve"){
                this.enviarADomicilio();
            } else{
                if (persona.getEstado()== "Moderado") {
                    this.enviarACuidadosModerados();
                }
                if (persona.getEstado() == "Grave") {
                    this.enviarATerapiaIntensiva();
                }
            }
           
        }
    }
    
    /*Implementacion postergada hasta consultar duda con profesor*/
    void atencionGeneral(){}
    
    /**
     *  Para dar de alta a un paciente, se verifica si el lugar donde se encuentra hospitalizado es igual a una
     * de la internacion enumerada procede a, 
     * si el lugar de la persona es igual a domicilio, remueve a la persona de la lista correspondiente
     * a personas derivadas a sus domicilios.
     * Sino, si el lugar de la persona es igual a Cuidados Moderados, remueve a la persona de la lista de pacientes
     * de Cuidados Moderado.
     * De no ser ninguna de las dos anteriores, se procede a remover al paciente de la lista de pacientes de
     * Cuidados Terapia Intensiva.
     * @param persona 
     */
    void darDeAlta(Persona persona) throws Exception{
        if (persona.getInternacion().equals(Internacion.DOM)){
              domicilio.darDeAltaPacienteDomicilio(persona);
        }else{
            if(persona.getInternacion().equals(Internacion.CM)){
                hospital.darDeAltaPacienteModerado(persona);
            } else{
                hospital.darDeAltaPacienteGrave(persona);
            }
        }
    }    
    
    
    
}
