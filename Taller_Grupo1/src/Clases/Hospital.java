package Clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

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
    
    
    /****************        MÉTODOS DE ACCESO        *****************/

    /**
     * Devuelve la cantidad de pacientes actual de Cuidados Moderados
     * @return cuidadosModerados
     */
    public CuidadosModerados getCuidadosModerados() {
        return cuidadosModerados;
    }
    
    /*
    *@param cuidadosModerados
    */
    public void setCuidadosModerados(CuidadosModerados cuidadosModerados) {
        this.cuidadosModerados = cuidadosModerados;
    }

    /** Devuelve la cantidad de pacientes actual de Cuidados Terapia Intensiva
     * @return cuidadosTerapiaIntensiva
     */
    public CuidadosTerapiaIntensiva getCuidadosTerapiaIntensiva() {
        return cuidadosTerapiaIntensiva;
    }

    /**
     * @param cuidadosTerapiaIntensiva
     */
    public void setCuidadosTerapiaIntensiva(CuidadosTerapiaIntensiva cuidadosTerapiaIntensiva) {
        this.cuidadosTerapiaIntensiva = cuidadosTerapiaIntensiva;
    }
    
    /**
     * Devuelve la cantidad de pacientes actual del hospital
     * @return numero de pacientes en el hospital 
    */
    public int getnPacientesTotal() {
        return nPacientesTotal;
    }
    
    /**
    * Devuelve la cantidad de pacientes moderados actual del hospital
    * @return cantidad de pacientes moderados
    */
    public int getnPacientesModerado() {
        return this.getCuidadosModerados().mostrarPacientes().size();
    }
    
    /**
     * Devuelve la cantidad de pacientes graves actual del hospital
     * @return  cantidad de pacientes graves
    */
    public int getnPacientesGraves() {
        return this.getCuidadosTerapiaIntensiva().mostrarPacientes().size();
    }


    /**
     * Devuelve una lista con todas las personas internadas en el hospital
     * @return Una lista de personas internadas en el hospital
     */
    public List<Persona> mostrarInternados(){
        return personasInternadas;
    }
   
    
    /***********************               FUNCIONES               ***********************/
    
    
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
    * Disminuye la cantidad de pacientes moderados y la cantidad total de pacientes.
    * Se elimina a la persona de la lista indicada por parametro.
    * Seteando la inmunidad de la persona a verdadero;
    * @param p un objeto persona
     * @throws java.lang.Exception lanza excepcion si no hay personas que remover.
    */
    public void darDeAltaPacienteModerado(Persona p) throws Exception{
        cuidadosModerados.darDeAlta(p);
        personasInternadas.remove(p); 
        nPacientesModerados--;
        nPacientesTotal--;        
    }
    
    /**
    * Disminuye la cantidad de pacientes graves y la cantidad total de pacientes.
    * Cambia la inmunidad de la persona a verdadero. Como así también sano a verdadero 
    * y elimina al mismo de la lista indicada por parámetro.
    * 
    * @param p un objeto persona
    * @throws java.lang.Exception lanza excepcion so no hay personas que remover
    */
    public void darDeAltaPacienteGrave(Persona p) throws Exception{
        cuidadosTerapiaIntensiva.darDeAlta(p);
        personasInternadas.remove(p);
        nPacientesGraves--;
        nPacientesTotal--;        
        
    }
    
    //actualiza el estado de sus pacientes, Si los tiene
    public void update(){
        Iterator<Persona> recorrerCuiMod = this.cuidadosModerados.mostrarPacientes().iterator();
        Iterator<Persona> recorrerTerInt = this.cuidadosTerapiaIntensiva.mostrarPacientes().iterator();
        //reviso Cuidados Moderados
        while (recorrerCuiMod.hasNext()) {
            Persona next = recorrerCuiMod.next();
            if (next.getTiempoInfec() > 2000) {
                recorrerCuiMod.remove();
            }
        }
        
        //reviso Cuidados Terapia intensiva
        while (recorrerTerInt.hasNext()) {
            Persona next = recorrerTerInt.next();
            if (next.getTiempoInfec() > 3000) {
                recorrerTerInt.remove();
            }
        }
        
        
        //No funciona
//        //reviso Cuidados Moderados
//        if (!this.cuidadosModerados.mostrarPacientes().isEmpty()) {
//            for (Persona p : this.cuidadosModerados.mostrarPacientes()) {
//                if (p.getTiempoInfec() > 2000) {
//                    this.darDeAltaPacienteModerado(p);
//                }
//            }
//        }
//        
//        //reviso Cuidados Terapia Intensiva
//        if (!this.cuidadosTerapiaIntensiva.mostrarPacientes().isEmpty()) {
//            for (Persona p : this.cuidadosTerapiaIntensiva.mostrarPacientes()) {
//                if (p.getTiempoInfec() > 2000) {
//                    this.darDeAltaPacienteGrave(p);
//                }
//            }
//        }        
    }
    
}
