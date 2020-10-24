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
 * @author Grupo1
 */
public class Escuela {
    //Atributos
    Vector posicion;
    Vector centro;
    
    private int tamaño = 80;
    
    /**Constructor por defecto*/
    public Escuela(){
        this.posicion = new Vector(200, 200);
        this.centro = new Vector(200+(tamaño/2), 200+(tamaño/2));
    }

    /*****************        MÉTODOS DE ACCESO        *****************/
    
    public Vector getCentro() {    
        return centro;
    }
    
    public void setCentro(Vector centro) {
        this.centro = centro;
    }
    
    public Vector getPosicion() {
        return posicion;
    }

    public void setPosicion(Vector posicion) {
        this.posicion = posicion;
    }
    
    
    /***********************               FUNCION               ***********************/
    
    /**
     * Método que crea la forma del establecimiento escolar a visualizarse en la pantalla
     *
     * @param g
     */
    public void draw(Graphics2D g){
        AffineTransform save = g.getTransform();
//        g.translate((int) this.posicion.getX(), (int) this.posicion.getY());
        g.setColor(Color.WHITE);
        g.drawRect((int)this.posicion.getX(), (int)this.posicion.getY(), tamaño, tamaño);
        g.drawRect((int)this.centro.getX(), (int)this.centro.getY(), 1, 1);
        g.drawString("      Escuela", ((int)this.posicion.getX()),(int)this.posicion.getY() - 7);
        g.setTransform(save);    
    }
    
      
}
