/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author Notebook HP
 */
public class Menor extends Persona{
    /**
     * 
     * @param nombre
     * @param sano
     * @param apellido
     * @param dni
     * @param cuarentena
     * @param cuidado
     */
    public Menor(String nombre, boolean sano, String apellido, int dni, boolean cuarentena, String cuidado) {
        super(nombre, sano, apellido, dni, cuarentena, cuidado);
    }
    
    
    public void irAEscuela(){}
    public void jugar(){}

    @Override
    public void draw(Graphics2D g) {
        super.draw(g); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() {
        super.update(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void interaccion(ArrayList<Persona> personas) {
        super.interaccion(personas); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vector separacion(ArrayList<Persona> personas) {
        return super.separacion(personas); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vector cohesion(ArrayList<Persona> personas) {
        return super.cohesion(personas); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vector alinear(ArrayList<Persona> personas) {
        return super.alinear(personas); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
