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
public class Informes {
    //Listas de tipo persona 
    List<Persona> personasContagiadas = new ArrayList<>();
    List<Persona> personasSanas = new ArrayList<>();
    List<Persona> personasCuidadoAlto = new ArrayList<>();
    List<Persona> personasCuidadoMedio = new ArrayList<>();
    List<Persona> personasCuidadoBajo = new ArrayList<>();

    /**
     *Añade la persona indicada por parámetro a la lista de personas contagiadas.
     * @param p un objeto Persona
     */
    public void añadirPersonaContagiada(Persona p){
        personasContagiadas.add(p);
    }
    
    /**
     *Añade la persona indicada por parámetro a la lista de personas sanas
     * @param p
     */
    public void añadirPersonaSana(Persona p){
        personasSanas.add(p);
    }
    
    /**
     *Añade la persona indicada por parámetro a la lista de personas con Cuidado Alto
     * @param p
     */
    public void añadirPersonaCuidadoAlto(Persona p){
        personasCuidadoAlto.add(p);
    }
    
    /**
     *Añade la persona indicada por parámetro a la lista de personas con cuidado Medio
     * @param p
     */
    public void añadirPersonaCuidadoMedio(Persona p){
        personasCuidadoMedio.add(p);
    }
    
    /**
     *  Añade la persona indicada por parámetro a la lista de personas con cuidado Bajo
     * @param p
     */
    public void añadirPersonaCuidadoBajo(Persona p){
        personasCuidadoBajo.add(p);
    }
    
    /**
     *  Elimina de la lista personas contagiadas al paciente indicado por parámetro
     * @param p
     */
    public void quitarPersonaContagiada(Persona p){
        personasContagiadas.remove(p);
    }
    
    /**
     *  Elimina de la lista personas sanas al paciente indicado por parámetro
     * @param p
     */
    public void quitarPersonaSana(Persona p){
        personasSanas.remove(p);
    }
    
    /**
     * Elimina de la lista personas con cuidado alto al paciente indicado por parámetro
     * @param p
     */
    public void quitarPersonaCuidadoAlto(Persona p){
        personasCuidadoAlto.remove(p);
    }
    
    /**
     * Elimina de la lista personas con cuidado medio al paciente indicado por parámetro
     * @param p
     */
    public void quitarPersonaCuidadoMedio(Persona p){
        personasCuidadoMedio.remove(p);
    }
    
    /**
     * Elimina de la lista personas con cuidado bajo al paciente indicado por parámetro
     * @param p
     */
    public void quitarPersonaCuidadoBajo(Persona p){
        personasCuidadoBajo.remove(p);
    }

    /**
     *  Muestra la información actual
     * @return String  
     */
    public String mostrarInfoActual(){
        String titulo = "Informe de la situacion" + "\n";
        String nPerSanas = "Numero de personas Sanas: " + this.getPersonasSanas().size() + "\n";
        String nPerConta = "Numero de personas Contagiadas: " + this.getPersonasContagiadas().size() + "\n";
        String nPerCuiAlto = "Numero de personas con Cuidados Altos: " + this.getPersonasCuidadoAlto().size() + "\n";
        String nPerCuiMedio = "Numero de personas con Cuidados Medios: " + this.getPersonasCuidadoMedio().size() + "\n";
        String nPerCuiBajo = "Numero de personas con Cuidados Bajos: " + this.getPersonasCuidadoBajo().size() + "\n";
        return titulo + nPerSanas + nPerConta + nPerCuiAlto + nPerCuiMedio + nPerCuiBajo;
    }
    
    /**
     *
     * @return una lista de personas sanas
     */
    public List<Persona> getPersonasSanas(){
        return this.personasSanas;
    }
    
    /**
     * 
     * @return una lista de personas contagiadas
     */
    public List<Persona> getPersonasContagiadas(){
        return this.personasContagiadas;
    }
    
    /**
     *
     * @return una lista de personas con cuidado alto
     */
    public List<Persona> getPersonasCuidadoAlto(){
        return this.personasCuidadoAlto;
    }
    
    /**
     *
     * @return una lista de personas con cuidado medio
     */
    public List<Persona> getPersonasCuidadoMedio(){
        return this.personasCuidadoMedio;
    }
    
    /**
     *
     * @return una lista de personas con cuidado bajo
     */
    public List<Persona> getPersonasCuidadoBajo(){
        return this.personasCuidadoBajo;
    }
    
}
