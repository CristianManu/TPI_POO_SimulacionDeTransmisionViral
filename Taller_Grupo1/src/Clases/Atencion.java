/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Grupo1
 */
public class Atencion {
    //Atributos de la clase asociacion Atencion
    private Persona persona;
    private Hospital hospital;
    

    /**
     * Constructor parametrizado
     * @param persona
     * @param hospital 
     */
    public Atencion(Persona persona, Hospital hospital) {
        this.persona = persona;
        this.hospital = hospital;
        
    }

    /**Devuelve al paciente actual de atención
     * @return persona*/
    public Persona getPersona() {
        return persona;
    }
    
    
  

    /**
     * Agrega una persona al Domicilio. Ademas se cambia la internacion a internacion domiciliaria.
     * Tambien setea a True el atributo Cuarentena de Persona.
     */

    public void enviarADomicilio(){
        persona.getDomicilio().agregarPersona(persona);
        persona.setInternacion(Internacion.DOM);
        persona.setCuarentena(true);
    }
    
     
    /**
    * Metodo que agrega la persona indicada por parámetro a la lista de cuidados Terapia Intensiva.
    * Si no se realizó la operación, agrega también la persona indicada por parámetro a la lista Cuidados Moderados.
    * De no realizarse ninguna de las anteriores, 
    * agregará la persona indicada por parámetro a la lista de personas en domicilio.
    * Ademas cambia la Internacion de la persona dependiendo del caso.
    * Tambien setea a True el atributo Cuarentena de Persona.
    */
    public void enviarATerapiaIntensiva(){
        persona.setCuarentena(true);
        if (!hospital.agregarPacienteGrave(persona)){
            if (!hospital.agregarPacienteModerado(persona)){
                this.enviarADomicilio();
            } else {
                persona.setInternacion(Internacion.CM);
            }
        } else {
            persona.setInternacion(Internacion.CTI);
        }
    }
    
     
    /**
    * Metodo que agrega la persona indicada por parámetro a la lista de cuidados moderados.Si no se realizó la operación, 
    * agregará la persona indicada por parámetro a la lista de personas en domicilio. Tambien cambia la internacion de la 
    * persona a cuidados moderados si se logra realizar la operacion.
    * Tambien setea a True el atributo Cuarentena de Persona.
    */
    public void enviarACuidadosModerados(){
        persona.setCuarentena(true);
        if (!hospital.agregarPacienteModerado(persona)){
            this.enviarADomicilio();
        } else {
            persona.setInternacion(Internacion.CM);
        }
    }
    
    

    /**
     * Si la persona no esta sana, dependiendo de su estado se la derivará a una de las dos salas o a su domicilio
     */

    public void atencionPorCovid(){
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
    
  

    /**
     *Implementacion postergada hasta consultar duda con profesor
     */

    public void atencionGeneral(){}
    
    /**
     *  Para dar de alta a un paciente, se verifica si el lugar donde se encuentra hospitalizado es igual a una
     * de la internacion enumerada procediendo a:
     * si el lugar de la persona es igual a domicilio, remueve a la persona de la lista correspondiente
     * a personas en domicilio.Sino, si el lugar de la persona es igual a Cuidados Moderados, remueve a la persona 
     * de la lista de pacientes de Cuidados Moderado.
     * De no ser ninguna de las dos anteriores, se procederá a remover al paciente de la lista de pacientes de 
     * Cuidados Terapia Intensiva.
     * @param persona 
     * @throws java.lang.Exception 
     */
    public void darDeAlta(Persona persona) throws Exception{
        if (persona.getInternacion().equals(Internacion.DOM)){
              persona.getDomicilio().darDeAltaPacienteDomicilio(persona);
        }else{
            if(persona.getInternacion().equals(Internacion.CM)){
                hospital.darDeAltaPacienteModerado(persona);
            } else{
                hospital.darDeAltaPacienteGrave(persona);
            }
        }
    }    
    
    
    
}
