/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.awt.*;
import java.awt.geom.*;
/**
 *
 * @author cristian
 */
public class Trabajo {

    Vector posicion;

    private int tamaño = 80;
    
    public Trabajo(){
        this.posicion = new Vector(700,200);
    }
    
    public Vector getPosicion() {
        return posicion;
    }

    public void setPosicion(Vector posicion) {
        this.posicion = posicion;
    }
    
    
    
    public void draw(Graphics2D g){
        AffineTransform save = g.getTransform();
//        g.translate((int) this.posicion.getX(), (int) this.posicion.getY());
        g.setColor(Color.WHITE);
        g.drawRect((int)this.posicion.getX(), (int)this.posicion.getY(), tamaño, tamaño);
        g.drawRect((int)this.posicion.getX(), (int)this.posicion.getY(), 1, 1);
        g.drawString("      Trabajo", (int)this.posicion.getX(), (int)this.posicion.getY() - 7);
        g.setTransform(save);    
    }
    
    private int centrar(int xoy){
        return (xoy-tamaño)/2;
    }    
    
}
