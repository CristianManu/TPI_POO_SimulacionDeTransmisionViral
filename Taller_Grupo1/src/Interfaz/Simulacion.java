/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Clases.Hospital;
import Clases.Persona;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.util.Random;
/**
 *
 * @author Grupo1
 */
public class Simulacion extends JPanel{
    private static final long serialVersionUID = -8716187417647724411L;    
    private static final int poblacion = 100;  //Poblacion de la ciudad.
    private static int contador = 0;
    
    /**
     *
     */
    public static final int ancho = 1024;

    /**
     *
     */
    public static final int alto = 768;
    
    //Texto a mostrarte en ventana
    static int infectados = 1, sanos = 0, cuidadoAlto = 0, cuidadoMedio = 0, cuidadoBajo = 0;
    
    //Lista de personas que forman parte de la simulacion.
    static ArrayList<Persona> personas = new ArrayList<Persona>();
    public boolean personaAñadida = false;
    
    //Hospital
    public Hospital hosp;
    
    static JLabel displayInfec, displaySano, displayAlto, displayMedio, displayBajo;
    
    /**
     *
     */
    public Simulacion(){
        //Configuracion JPanel
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(ancho, alto));
        this.setFocusable(true);
        
        crearLabels();
        
        for (int i = 0; i < poblacion; i++) {
            //por motivos de prueba de simulacion, se usará constructor por defecto.
            personas.add(new Persona());
        }
        
        this.hosp = new Hospital();
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
    
    @Override
    public void paintComponent(Graphics pag){
        super.paintComponent(pag);
        Graphics2D g = (Graphics2D)pag;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (Persona p: personas) {
            p.draw(g);
            if (p.isCuarentena()) {
            p.drawRectangle(g);                
            }
        }
    }
    
    static void actValores(){
        displaySano.setText("Sanos: " + sanos);
        displayInfec.setText("Infectados: " + infectados);
    }
    
    public void run(){
        while (true) {
            sanos = 0;
            infectados = 0;
            System.out.println("Funcionando");
            System.out.println("Persona posicion " + personas.get(0).getPosicion().getX() + " - " +  personas.get(0).getPosicion().getY());
            System.out.println("Contador: " + contador);
            personasGrafica();
            actValores();
            controlTiempo();            
            this.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
            }
            //probando control de tiempo
            contador++;
        }
    }
    
    //Funciones para run()
    
    /**
     * Metodo que realiza tareas tras alcanzar determinado valor de contador.
     */
    private void controlTiempo(){
            if (contador > 1000) {
                for (int i = 0; i < personas.size(); i++) {
                switch((int)(Math.round(Math.random()))){
                    case 0: break;
                    case 1: personas.get(i).irAlHospital(hosp);
                }                    
                }
//                personas.get(0).irAlHospital(hosp);
//              personas.get((int)(Math.random()*100)).setCuarentena(true);
                contador = 0;
            }        
    }
    
    
    /**
     * Metodo que dibuja y controla el movimiento de las personas
     */
    private void personasGrafica() {
        for (int i = 0; i < personas.size(); i++) {
            personas.get(i).bordes();
            personas.get(i).interaccion(personas);
            personas.get(i).update();
            if (!(personas.get(i).isSano())) {
                personas.get(i).contagiar(personas);
                infectados++;
            }
            if (personas.get(i).isSano()) {
                sanos++;
            }
            if (personas.get(i).isCuarentena()) {
                personas.get(i).contColorTiempo++;
                if (personas.get(i).contColorTiempo % 4 == 0) {
                    personas.get(i).contColor++;
                    switch (personas.get(i).contColor) {
                        case 1:
                            personas.get(i).colRectan = Color.BLUE;
                            break;
                        case 2:
                            personas.get(i).colRectan = Color.WHITE;
                            break;
                        case 3:
                            personas.get(i).colRectan = Color.RED;
                            personas.get(i).contColor = 0;
                            break;
                    }
                }

            }
        }
    }
}
