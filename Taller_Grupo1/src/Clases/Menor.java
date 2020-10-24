/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaz.Simulacion;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.awt.*;
import java.awt.geom.*;

/**
 *
 * @author Grupo1
 */
public class Menor extends Persona{
    
    private int tamaño = 2;
    /**
     * Construye un nuevo Path2Dobjeto vacío 
     * 
     */
    private Path2D forma = new Path2D.Double();
    
    /**
     *  CREACION DE TRIÁNGULO
     *  Primeramente crea un punto, luego dibuja una línea hacia ese punto y luego las dos restantes.
     * la última sentencia cierra la figura.
     */   

    {
        forma.moveTo(0, -tamaño*2);
        forma.lineTo(-tamaño, tamaño*2);
        forma.lineTo(tamaño, tamaño*2);
        forma.closePath();
    }
    private boolean asistirEscuela;
    private int tiempoEnEscuela;
    /**
     * Invoca el constructor por defecto de la clase Persona
     */
    public Menor(){
        super();
        this.asistirEscuela = false;
        this.tiempoEnEscuela = 0;
    }
    
    public Menor(String nombre, boolean sano, String apellido, int dni, boolean cuarentena, String cuidado) {
        super(nombre, sano, apellido, dni, cuarentena, cuidado);
    }
    
    
    public void irAEscuela(){
        this.asistirEscuela = true;
    }
    
    public void jugar(){}
    
    private Vector viajarEscuela(Escuela escu){
        Vector direccion = new Vector(escu.getPosicion().getX(),escu.getPosicion().getY());
            direccion.restar(this.posicion);
            direccion.setMagnitud(maxVelocidad);
            direccion.restar(this.velocidad);
            direccion.limit(maxFuerza);        
        return direccion;
    }

    @Override
    public void interaccion(ArrayList<Persona> personas, Escuela escu, Trabajo trab) {
        if (!this.asistirEscuela) {
            this.aceleracion.setValores(0, 0);
            Vector alineacion = this.alinear(personas);
            Vector cohesion = this.cohesion(personas);
            Vector separacion = this.separacion(personas);
            this.aceleracion.sumar(alineacion);
            this.aceleracion.sumar(separacion);
            this.aceleracion.sumar(cohesion); //To change body of generated methods, choose Tools | Templates.            
        } else{
            this.aceleracion.sumar(this.viajarEscuela(escu));
        }
    }

    @Override
    public void update() {
        super.update();
        if (tiempoEnEscuela < 500) {
            this.tiempoEnEscuela++;
        } else{
            this.asistirEscuela = false;
            this.tiempoEnEscuela = 0;
        }
    }

    

    
    
    
    /**
     * Metodo que crea la forma del menor a visualizarse en la pantalla
     * @param g 
     */
    @Override
    public void draw(Graphics2D g) {
        AffineTransform save = g.getTransform();
        g.translate((int)this.posicion.getX(), (int)this.posicion.getY());
        g.rotate(this.velocidad.dir() + Math.PI/2);
        if (this.isSano()) {
            if (this.isInmune()) {
                g.setColor(Color.BLUE);
            } else {g.setColor(Color.WHITE);}
        } else {
            g.setColor(Color.RED);
        }
        g.fill(forma);
        g.draw(forma);
        g.setTransform(save);
    }
    
}
