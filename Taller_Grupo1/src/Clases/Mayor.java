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
 * @author Notebook HP
 */
public class Mayor extends Persona{
    
    private int tamaño = 4;
    
    /**
     * Construye un nuevo Path2D objeto vacío de doble
     */
    private Path2D forma = new Path2D.Double();
    private int tiempopaseo;
    
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
     * Invoca al constructor por defecto de la superclase Persona.
     * 
     */
    
    public Mayor(){
        super();
        this.setEnCasa(true);
        this.tiempopaseo = 0;
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
    public Mayor(String nombre, boolean sano, String apellido, int dni, boolean cuarentena, String cuidado) {
        super(nombre, sano, apellido, dni, cuarentena, cuidado);
    }
    
    /****************        FUNCIONES        *****************/
    
    
    public void salirAPasear(){
        this.tiempopaseo = 0;
        this.setEnCasa(false);
    }

    /**
     * Actualiza
     * Llama al método update() de la superclase 
     * Si el tiempo del paseo es menor a 300 aumenta el tiempo de paseo 
     * sino si, no es inmune setea enCasa a verdadero
     */
    @Override
    public void update() {
        super.update();
        if (tiempopaseo < 300) {
            this.tiempopaseo++;
        } else if (!this.isInmune()) {
            this.setEnCasa(true);
        }
    }
    
    

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
