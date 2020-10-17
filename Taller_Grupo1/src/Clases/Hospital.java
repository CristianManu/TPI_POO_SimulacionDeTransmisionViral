package Clases;

import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Grupo1
 */
public class Hospital {
    //Atributos
    private int nPacientesTotal;
    private int nPacientesModerados;
    private int nPacientesGraves;
    private CuidadosModerados cuidadosModerados;
    private CuidadosTerapiaIntensiva cuidadosTerapiaIntensiva;
    private List<Persona> personasInternadas;
    
    
    /**
     * Constructor de Hospital inincializa contadores en 0, crea la lista de personas
     * y las salas de cuidados intensivos y moderados.
     */
    public Hospital (){
        nPacientesTotal = 0;
        nPacientesModerados = 0;
        nPacientesGraves = 0;
        personasInternadas = new ArrayList();
        cuidadosModerados = new CuidadosModerados();
        cuidadosTerapiaIntensiva = new CuidadosTerapiaIntensiva();
    }

    
    /**
     * Devuelve la cantidad de pacientes actual del hospital
     * @return numero de pacientes en el hospital 
    */
    public int getnPacientesTotal() {
        return nPacientesTotal;
    }
   
    /**
    * Aumenta la cantidad de pacientes moderados y la cantidad total de pacientes.
    * Tambien agrega la persona indicada por parametro a la lista.
    * @param p un objeto persona
    * @return devuelve verdadero si se realizo la operacion y falso sino se pudo.
    */
    public boolean agregarPacienteModerado(Persona p){
        if(!cuidadosModerados.agregarPaciente(p)){
           return false;
       } else {
        nPacientesModerados++;
        nPacientesTotal++;
        personasInternadas.add(p);
        return true;
        } 
    }
    
    /**
    * Disminuye la cantidad de pacientes moderados y la cantidad total de pacientes.Se elimina a la persona de la lista indicada por parametro.
    * @param p un objeto persona
     * @throws java.lang.Exception lanza excepcion si no hay personas que remover.
    */
    public void darDeAltaPacienteModerado(Persona p) throws Exception{
        cuidadosModerados.darDeAlta(p);
        nPacientesModerados--;
        nPacientesTotal--;
        personasInternadas.remove(p);    
    }
    
    /**
    * Disminuye la cantidad de pacientes graves y la cantidad total de pacientes.Se elimina a la persona de la lista indicada por parametro.
    * @param p un objeto persona
    * @throws java.lang.Exception lanza excepcion so no hay personas que remover
    */
    public void darDeAltaPacienteGrave(Persona p) throws Exception{
        cuidadosTerapiaIntensiva.darDeAlta(p);
        nPacientesGraves--;
        nPacientesTotal--;
        personasInternadas.remove(p);
    }
    
    /**
    * Aumenta la cantidad de pacientes graves y la cantidad total de pacientes.
    * Tambien agrega la persona indicada por parametro a la lista.
    * @param p un objeto persona
    * @return  devuelve verdader si se realizo la operacion y falso en caso contrario
    */
    public boolean agregarPacienteGrave(Persona p){
        
        if (!cuidadosTerapiaIntensiva.agregarPaciente(p)){
            return false;
        } else {
            nPacientesGraves++;
            nPacientesTotal++;
            personasInternadas.add(p);
            return true;
        }
    }
    
    /**
    * Devuelve la cantidad de pacientes moderados actual del hospital
    * @return cantidad de pacientes moderados
    */
    public int getnPacientesModerado() {
        return nPacientesModerados;
    }
    
    /**
     * Devuelve la cantidad de pacientes graves actual del hospital
     * @return  cantidad de pacientes graves
    */
    public int getnPacientesGraves() {
        return nPacientesGraves;
    }


    /**
     * Devuelve una lista con todas las personas internadas en el hospital
     * @return Una lista de personas internadas en el hospital
     */
    public List<Persona> mostrarInternados(){
        return personasInternadas;
    }
}
