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
    
    
    
    public Hospital (){
        nPacientesTotal = 0;
        nPacientesModerados = 0;
        nPacientesGraves = 0;
        personasInternadas = new ArrayList();
    }

    /*
        Metodos de acceso
        Getters y setters
    */
    
    /**
     * Devuelve la cantidad de pacientes actual del hospital
     * @return 
    */
    public int getnPacientesTotal() {
        return nPacientesTotal;
    }
   
    /**
    * Aumenta la cantidad de pacientes moderados y la cantidad total de pacientes.
    * Tambien agrega la persona indicada por parametro a la lista.
    * @param p
    */
    public void agregarPacienteModerado(Persona p){
        nPacientesModerados++;
        nPacientesTotal++;
        personasInternadas.add(p);
    }
    
    /**
    * Disminuye la cantidad de pacientes moderados y la cantidad total de pacientes.
    * Se elimina a la persona de la lista indicada por parametro.
    * @param p 
    */
    public void darDeAltaPacienteModerado(Persona p){
        nPacientesModerados--;
        nPacientesTotal--;
        personasInternadas.remove(p);
        cuidadosModerados.agregarPaciente(p);
    }
    
    /**
    * Disminuye la cantidad de pacientes graves y la cantidad total de pacientes.
    * Se elimina a la persona de la lista indicada por parametro.
    * @param p 
    */
    public void darDeAltaPacienteGrave(Persona p){
        nPacientesGraves--;
        nPacientesTotal--;
        personasInternadas.remove(p);
    }
    
    /**
    * Aumenta la cantidad de pacientes graves y la cantidad total de pacientes.
    * Tambien agrega la persona indicada por parametro a la lista.
    * Si esta no se pudo agregar debido al cupo de camas, se agrega a cuidados moderados.
    */
    public void agregarPacienteGrave(Persona p){
        nPacientesGraves++;
        nPacientesTotal++;
        personasInternadas.add(p);
        if (!cuidadosTerapiaIntensiva.agregarPaciente(p)){
            this.agregarPacienteModerado(p);
        }
    }
    
    /**
    * Devuelve la cantidad de pacientes moderados actual del hospital
    * @return 
    */
    public int getnPacientesModerado() {
        return nPacientesModerados;
    }
    
    /**
     * Devuelve la cantidad de pacientes graves actual del hospital
     * @return 
    */
    public int getnPacientesGraves() {
        return nPacientesGraves;
    }


    
    public List<Persona> mostrarInternados(){
        return personasInternadas;
    }
}
