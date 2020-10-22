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
 * @author Notebook HP
 */
public class Menor extends Persona{
    
    private int tamaño = 2;
    private Path2D forma = new Path2D.Double();
    
    {
        forma.moveTo(0, -tamaño*2);
        forma.lineTo(-tamaño, tamaño*2);
        forma.lineTo(tamaño, tamaño*2);
        forma.closePath();
    }
    /**
     * 
     * @param nombre
     * @param sano
     * @param apellido
     * @param dni
     * @param cuarentena
     * @param cuidado
     */
    
    public Menor(){
        super();
    }
    
    public Menor(String nombre, boolean sano, String apellido, int dni, boolean cuarentena, String cuidado) {
        super(nombre, sano, apellido, dni, cuarentena, cuidado);
    }
    
    
    public void irAEscuela(){}
    public void jugar(){}

    @Override
    public void draw(Graphics2D g) {
        AffineTransform save = g.getTransform();
        g.translate((int)this.posicion.getX(), (int)this.posicion.getY());
        g.rotate(this.velocidad.dir() + Math.PI/2);
        if (this.isSano()) {
        g.setColor(Color.WHITE);            
        }else{g.setColor(Color.RED);}
        g.fill(forma);
        g.draw(forma);
        g.setTransform(save);
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
