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
public class Mayor extends Persona{
    
    private int tamaño = 4;
    
    /**
     * Construye un nuevo Path2D objeto vacío de doble
     */
    private Path2D forma = new Path2D.Double();
    
    /**
     * Creación de un triángulo
     *  Primeramente crea un punto, luego dibuja una línea hacia ese punto y luego las dos restantes.
     * la última sentencia cierra la figura.
     */
    {
        forma.moveTo(0, -tamaño*2);
        forma.lineTo(-tamaño, tamaño*2);
        forma.lineTo(tamaño, tamaño*2);
        forma.closePath();
    }
    
   
    /**
     * Invoca al constructor por defecto de la clase Persona.
     * 
     */
    public Mayor(){
        super();
    }
    
    
     /**
     *  Invoca el constructor parametrizado de la clase Persona.
     * @param nombre
     * @param sano
     * @param apellido
     * @param dni
     * @param cuarentena
     * @param cuidado
     */
    
    public Mayor(String nombre, boolean sano, String apellido, int dni, boolean cuarentena, String cuidado) {
        super(nombre, sano, apellido, dni, cuarentena, cuidado);
    }
    
    /***********************               FUNCIONES               ***********************/
    
    void salirAPasear(){}

    /**
     * Método que crea la forma del Mayor a visualizarse en la pantalla
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
