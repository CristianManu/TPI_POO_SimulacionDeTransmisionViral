/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Clases.Persona;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
/**
 *
 * @author cristian
 */
public class Simulacion extends JPanel implements KeyListener, MouseListener, MouseMotionListener{
    private static final int poblacion = 100;  //Poblacion de la ciudad.
    
    //Dimension de la ventana
    public static final int ancho = 768;
    public static final int alto = 1024;
    
    //Texto a mostrarte en ventana
    static int infectados = 1, sanos = 0, cuidadoAlto = 0, cuidadoMedio = 0, cuidadoBajo = 0;
    
    //Lista de personas que forman parte de la simulacion.
    static ArrayList<Persona> personas = new ArrayList<Persona>();
    
    static JLabel displayInfec, displaySano, displayAlto, displayMedio, displayBajo;
    
    
    public Simulacion(){
        //Configuracion JPanel
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setFocusable(true);
        
        //Interaccion con la interfaz, revisar.
        this.addKeyListener(this);
        this.addMouseListener(this);
        
        crearLabels();
        
        for (int i = 0; i < poblacion; i++) {
            //por motivos de prueba de simulacion, se usará constructor por defecto.
            personas.add(new Persona());
        }
    }
    
    /**
     * Funcion que crea las labels que muestran la informacion de la epidemia.
     */
    private void crearLabels(){
        /*Label de personas sanas
        
        */
        displaySano = new JLabel("Sanos: " + sanos);
        this.setLayout(new FlowLayout());
        this.add(displaySano);
        
        /*Label de personas infectadas
        
        */
        displayInfec = new JLabel("Infectados: " + infectados);
        this.setLayout(new FlowLayout());
        this.add(displayInfec);
        
        /*Label de personas con cuidados Altos
        
        */
        displayAlto = new JLabel("Cuidados Altos: " + cuidadoBajo);
        this.setLayout(new FlowLayout());
        this.add(displayAlto);
        
        /*Label de personas con cuidados Medios
        
        */
        displayMedio = new JLabel("Cuidados Medios: " + cuidadoMedio);
        this.setLayout(new FlowLayout());
        this.add(displayMedio);
        
        /*Label de personas con cuidados Bajos
        
        */
        displayBajo = new JLabel("Cuidados Bajos " + cuidadoBajo);
        this.setLayout(new FlowLayout());
        this.add(displayBajo);
    }
    
    /**
     * Este metodo crea una figura para cada persona
     * Tambien ajusta las especificaciones graficas de la figura
     * @param pag 
     */
    public void paintComponent(Graphics pag){
        super.paintComponent(pag);
        Graphics2D g = (Graphics2D) pag;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (Persona p: personas) {
            p.draw(g);
        }
    }
    
    public void run(){
        
    }
    
    //Implementacion de metodos abstractos
    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
