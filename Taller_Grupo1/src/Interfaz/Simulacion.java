/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Clases.Adulto;
import Clases.CalidadDeCuidado;
import Clases.Hospital;
import Clases.Informes;
import Clases.Internacion;
import Clases.Mayor;
import Clases.Menor;
import Clases.Persona;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Grupo1
 */
public class Simulacion extends JPanel implements Runnable{
    private static final long serialVersionUID = -8716187417647724411L;    
    private static final int poblacion = 100;  //Poblacion de la ciudad.
    private static int contador = 0;
    private static int tiempo = 0;
    
    /**
     *
     */
    public static final int ancho = 1024;

    /**
     *
     */
    public static final int alto = 768;
        
    //Lista de personas que forman parte de la simulacion.
    static ArrayList<Persona> personas = new ArrayList<Persona>();
    public boolean personaAñadida = false;
    
    //Hospital
    public Hospital hosp;
    
    //Informes
    public Informes informe;
    
   
    
    /** Constructor por defecto
     * Se realiza la configuración JPanel
     * Se añade personas a la lista personas.
     */
    public Simulacion(){
        //Configuracion JPanel
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(ancho, alto));
        this.setFocusable(true);
        
        
        for (int i = 0; i < poblacion; i++) {
            
            personas.add(new Adulto());
        }
        
        this.hosp = new Hospital();
        this.informe  = new Informes();
        
        /**       En el bucle recorre la lista, 
         *  Si la persona que se encuentra en la posicion indicado por el índice esta sano, de ser asi lo añade 
         * a la lista de personas sanas de tipo Informe. De caso contrario,
         * lo añadirá a la lista de personas contagiadas.
         *  Si la persona que se encuentra en la posicion indicado por el indice tiene calidad de cuidado igual bajo 
         * lo añade a personasCuidadoBajo de informes, sino si es igual a medio lo añade a la lista de personaCuidadoMedio
         * de no ser ninguna de las anteriores, lo añadirá a la lista personCuidadoAlto 
         *
         */
        for (int i = 0; i < poblacion; i++) {
            if (personas.get(i).isSano()) {
                informe.añadirPersonaSana(personas.get(i));
            }
            if (!(personas.get(i).isSano())) {
                informe.añadirPersonaContagiada(personas.get(i));
//                informe.quitarPersonaSana(personas.remove(i));
            }
            if (personas.get(i).getCuidado().getCalidadCuidado() == CalidadDeCuidado.Bajo) {
                informe.añadirPersonaCuidadoBajo(personas.get(i));
            } else if (personas.get(i).getCuidado().getCalidadCuidado() == CalidadDeCuidado.Medio) {
                informe.añadirPersonaCuidadoMedio(personas.get(i));
            } else{
                informe.añadirPersonaCuidadoAlto(personas.get(i));
            }
        }
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
        //Aqui se dibuja
        for (Persona p: personas) {
            p.draw(g);
            p.drawCircle(g);
            if (p.isCuarentena()) {
            p.drawRectangle(g);                
            }
        }
    }
    /**
     * Método que actualiza valores
     * Recorre la lista, si la persona esta sana, y si no se encuentra en la lista Informe los añade a
     * la lista de personas sanas.
     * En caso contrario, si la persona no esta sana, y si  no se encuentra en la lista informe, los añade
     * a la lista de persona contagiadas y las quita de la lista de personas sanas
     */
    void actValores(){
        for (int i = 0; i < 100; i++) {
            if (personas.get(i).isSano()) {
                if (!informe.getPersonasSanas().contains(personas.get(i))) {
                    informe.añadirPersonaSana(personas.get(i));
                    informe.quitarPersonaContagiada(personas.get(i));
                }
            }
            if (!personas.get(i).isSano()) {
                if (!informe.getPersonasContagiadas().contains(personas.get(i))) {
                    informe.añadirPersonaContagiada(personas.get(i));
                    informe.quitarPersonaSana(personas.get(i));
                }
            }
        }
    }
    
    @Override
    public void run(){
        while (tiempo < 10000) {
            System.out.println("Funcionando");
            System.out.println("Persona posicion " + personas.get(0).getPosicion().getX() + " - " +  personas.get(0).getPosicion().getY());
            System.out.println("Contador: " + contador);
            System.out.println("Tiempo:" + tiempo);
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
            tiempo++;
        }
    }
    
    //Funciones para run()
    
    /**
     * Metodo que realiza tareas tras alcanzar determinado valor de contadores de tiempo.
     */
    private void controlTiempo(){
        //Este if controla la periodicidad del chequeo de personas, el cual es aleatorio
        if (contador > 1000) {
            for (int i = 0; i < personas.size(); i++) {
                switch((int)(Math.round(Math.random()))){
                    case 0: break;
                    case 1: personas.get(i).irAlHospital(hosp);
                }                    
            }
                contador = 0;
        }
        //Este if controla la periodicidad en el que el hospital revisa a sus pacientes.
        if (tiempo % 100 == 0) {
            hosp.update();
        }
        
        //Esta sentencia da error java.util.ConcurrentModificationException
//        if (tiempo > 2100) {
//            for (Persona p : hosp.mostrarInternados()) {
//                if (p.getTiempoInfec() > 2000) {
//                    if (p.getInternacion() == Internacion.CM) {
//                        try {
//                            hosp.darDeAltaPacienteModerado(p);
//                        } catch (Exception ex) {
//                            Logger.getLogger(Simulacion.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                    } else if (p.getInternacion() == Internacion.CTI) {
//                        try {
//                            hosp.darDeAltaPacienteGrave(p);
//                        } catch (Exception ex) {
//                            Logger.getLogger(Simulacion.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                    }
//                }
//            }
//        }
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
