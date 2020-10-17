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
 * @author Notebook HP
 */
public class Informes {
    
    List<Persona> personasContagiadas = new ArrayList<>();
    List<Persona> personasSanas = new ArrayList<>();
    List<Persona> personasCuidadoAlto = new ArrayList<>();
    List<Persona> personasCuidadoMedio = new ArrayList<>();
    List<Persona> personasCuidadoBajo = new ArrayList<>();

    public void añadirPersonaContagiada(Persona p){
        personasContagiadas.add(p);
    }
    
    public void añadirPersonaSana(Persona p){
        personasSanas.add(p);
    }
    
    public void añadirPersonaCuidadoAlto(Persona p){
        personasCuidadoAlto.add(p);
    }
    
    public void añadirPersonaCuidadoMedio(Persona p){
        personasCuidadoMedio.add(p);
    }
    
    public void añadirPersonaCuidadoBajo(Persona p){
        personasCuidadoBajo.add(p);
    }
    
    public void quitarPersonaContagiada(Persona p){
        personasContagiadas.remove(p);
    }
    
    public void quitarPersonaSana(Persona p){
        personasSanas.remove(p);
    }
    
    public void quitarPersonaCuidadoAlto(Persona p){
        personasCuidadoAlto.remove(p);
    }
    
    public void quitarPersonaCuidadoMedio(Persona p){
        personasCuidadoMedio.remove(p);
    }
    
    public void quitarPersonaCuidadoBajo(Persona p){
        personasCuidadoBajo.remove(p);
    }
    public String mostrarInfoActual(){
        String titulo = "Informe de la situacion" + "\n";
        String nPerSanas = "Numero de personas Sanas: " + this.getPersonasSanas().size() + "\n";
        String nPerConta = "Numero de personas Contagiadas: " + this.getPersonasContagiadas().size() + "\n";
        String nPerCuiAlto = "Numero de personas con Cuidados Altos: " + this.getPersonasCuidadoAlto().size() + "\n";
        String nPerCuiMedio = "Numero de personas con Cuidados Medios: " + this.getPersonasCuidadoMedio().size() + "\n";
        String nPerCuiBajo = "Numero de personas con Cuidados Bajos: " + this.getPersonasCuidadoBajo().size() + "\n";
        return titulo + nPerSanas + nPerConta + nPerCuiAlto + nPerCuiMedio + nPerCuiBajo;
    }
    
    public List<Persona> getPersonasSanas(){
        return this.personasSanas;
    }
    
    public List<Persona> getPersonasContagiadas(){
        return this.personasContagiadas;
    }
    
    public List<Persona> getPersonasCuidadoAlto(){
        return this.personasCuidadoAlto;
    }
    
    public List<Persona> getPersonasCuidadoMedio(){
        return this.personasCuidadoMedio;
    }
    
    public List<Persona> getPersonasCuidadoBajo(){
        return this.personasCuidadoBajo;
    }
    
}
