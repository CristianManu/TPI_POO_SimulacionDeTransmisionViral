/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;

/**
 * @author Grupo1
 * @version 
 */
public class Adulto extends Persona {
    /**
     * Invoca al constructor por defecto de la superclase Persona
     * 
     */
    
    private boolean asistirTrabajo;
    private int tiempoTrabajo;
    
    public Adulto(){
        super();
        this.asistirTrabajo = false;
        this.tiempoTrabajo = 0;
    }
    
    /**
     * Invoca al constructor parametrizado de la superclase Persona
     * @param nombre
     * @param sano
     * @param apellido
     * @param dni
     * @param cuarentena
     * @param cuidado
     */

    public Adulto(String nombre, boolean sano, String apellido, int dni, boolean cuarentena, String cuidado) {
        super(nombre, sano, apellido, dni, cuarentena, cuidado);
    }
    
    /***********************               FUNCIONES               ************************/
    
    public void irATrabajar(){
        this.asistirTrabajo = true;
    }
    
    private Vector viajarTrabajo(Trabajo trab){
        Vector direccion = new Vector(trab.getCentro().getX(),trab.getCentro().getY());
            direccion.restar(this.posicion);
            direccion.setMagnitud(maxVelocidad);
            direccion.restar(this.velocidad);
            direccion.limit(maxFuerza);        
        return direccion;
    }

    @Override
    public void update() {
        super.update(); //To change body of generated methods, choose Tools | Templates.
        if (tiempoTrabajo < 500) {
            this.tiempoTrabajo++;
        } else{
            this.asistirTrabajo = false;
            this.tiempoTrabajo = 0;
        }        
    }

    @Override
    public void interaccion(ArrayList<Persona> personas, Escuela escu, Trabajo trab) {
        if (!this.asistirTrabajo) {
            this.aceleracion.setValores(0, 0);
            Vector alineacion = this.alinear(personas);
            Vector cohesion = this.cohesion(personas);
            Vector separacion = this.separacion(personas);
            this.aceleracion.sumar(alineacion);
            this.aceleracion.sumar(separacion);
            this.aceleracion.sumar(cohesion); //To change body of generated methods, choose Tools | Templates.            
        } else{
            this.aceleracion.sumar(this.viajarTrabajo(trab));
        }
    }
    }
