/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaz;
import Clases.Hospital;
import Clases.Informes;
import Clases.Internacion;
import Clases.Persona;
import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 *
 * @author Grupo1
 */
public class VentanaInforme extends Container implements Runnable {

    /**
     *
     */
    public Informes info;

    /**
     * 
     */
    public Hospital hosp;
    private JPanel panelIzq, panelDer;
    private JLabel displayInfec, displaySano, displayAlto, displayMedio, displayBajo,
            displayIntDom, displayCuiMod, displayTerInt;
    
    private JLabel numSanos, numInfec, numAlto, numMedio, numBajo, numIntDom,
            numCuiMod, numTerInt;
    
    static final int separacion = 7;

    /**
     * Constructor parametrizado
     * @param info
     * @param hosp
     */
    public VentanaInforme(Informes info, Hospital hosp) {
        panelIzq = new JPanel();
        panelDer = new JPanel();
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        panelIzq.setLayout(new BoxLayout(panelIzq, BoxLayout.Y_AXIS));
        panelDer.setLayout(new BoxLayout(panelDer, BoxLayout.Y_AXIS));
        this.add(Box.createRigidArea(new Dimension(12, 0)));
        this.add(panelIzq);
        this.add(Box.createHorizontalGlue());
        this.add(panelDer);
        this.add(Box.createRigidArea(new Dimension(12, 0)));
        this.setBackground(Color.LIGHT_GRAY);
        this.setPreferredSize(new Dimension(400, 300));
        this.setFocusable(true);
        
        this.info = info;
        this.hosp = hosp;
        crearLabels();
    }
    
    
    /***********************               FUNCIONES               ***********************/
    
    
    /**
     * Funcion que crea las labels que muestran la informacion de la epidemia.
     */
    private void crearLabels(){
        displaySano = new JLabel("Cantidad de personas sanas");
        this.setLayout(new FlowLayout());
        panelIzq.add(displaySano);
        panelIzq.add(Box.createRigidArea(new Dimension(0, separacion)));
        
        /*Label de personas infectadas
        
        */
        displayInfec = new JLabel("Cantidad de personas infectadas");
//        this.setLayout(new FlowLayout());
        panelIzq.add(displayInfec);
        panelIzq.add(Box.createRigidArea(new Dimension(0, separacion)));        
        
        /*Label de personas con cuidados Altos
        
        */
        displayAlto = new JLabel("Cantidad de personas con cuidado bajo");
//        this.setLayout(new FlowLayout());
        panelIzq.add(displayAlto);
        panelIzq.add(Box.createRigidArea(new Dimension(0, separacion)));        
        
        /*Label de personas con cuidados Medios
        
        */
        displayMedio = new JLabel("Cantidad de personas con cuidado medio");
//        this.setLayout(new FlowLayout());
        panelIzq.add(displayMedio);
        panelIzq.add(Box.createRigidArea(new Dimension(0, separacion)));
        
        /*Label de personas con cuidados Bajos
        
        */
        displayBajo = new JLabel("Cantidad de personas con cuidado alto");
//        this.setLayout(new FlowLayout());
        panelIzq.add(displayBajo);
        panelIzq.add(Box.createRigidArea(new Dimension(0, separacion)));
        
        displayIntDom = new JLabel("Cantidad de personas con internacion domiciliaria");
//        this.setLayout(new FlowLayout());
        panelIzq.add(displayIntDom);
        panelIzq.add(Box.createRigidArea(new Dimension(0, separacion)));
        
        displayCuiMod = new JLabel("Cantidad de personas en Cuidados Moderados");
//        this.setLayout(new FlowLayout());
        panelIzq.add(displayCuiMod);
        panelIzq.add(Box.createRigidArea(new Dimension(0, separacion)));
        
        displayTerInt = new JLabel("Cantidad de personas en Terapia intensiva");
//        this.setLayout(new FlowLayout());
        panelIzq.add(displayTerInt);
        panelIzq.add(Box.createRigidArea(new Dimension(0, separacion)));
        
        Border borde = BorderFactory.createLineBorder(Color.BLACK, 1);
        
        numSanos = new JLabel(" 0 ");
        numSanos.setBorder(borde);
        panelDer.add(numSanos);
        panelDer.add(Box.createRigidArea(new Dimension(0, separacion-2)));
        
        numInfec = new JLabel(" 0 ");
        numInfec.setBorder(borde);
        panelDer.add(numInfec);
        panelDer.add(Box.createRigidArea(new Dimension(0, separacion-2)));
        
        numAlto = new JLabel(" 0 ");
        numAlto.setBorder(borde);
        panelDer.add(numAlto);
        panelDer.add(Box.createRigidArea(new Dimension(0, separacion-2)));
        
        numMedio = new JLabel(" 0 ");
        numMedio.setBorder(borde);
        panelDer.add(numMedio);
        panelDer.add(Box.createRigidArea(new Dimension(0, separacion-2)));
        
        numBajo = new JLabel(" 0 ");
        numBajo.setBorder(borde);
        panelDer.add(numBajo);
        panelDer.add(Box.createRigidArea(new Dimension(0, separacion-2)));
        
        numIntDom = new JLabel(" 0 ");
        numIntDom.setBorder(borde);
        panelDer.add(numIntDom);
        panelDer.add(Box.createRigidArea(new Dimension(0, separacion-2)));
        
        numCuiMod = new JLabel(" 0 ");
        numCuiMod.setBorder(borde);
        panelDer.add(numCuiMod);
        panelDer.add(Box.createRigidArea(new Dimension(0, separacion-2)));
        
        numTerInt = new JLabel(" 0 ");
        numTerInt.setBorder(borde);
        panelDer.add(numTerInt);
        panelDer.add(Box.createRigidArea(new Dimension(0, separacion-2)));
        
    }
    
    @Override
    public void run(){
        while (true) {
            System.out.println("Ventana informe funcionando");
            actValores();
            this.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
            }            
        }
    }
    
    void actValores(){
        numSanos.setText(" " + info.getPersonasSanas().size()  + " ");
        numInfec.setText(" " + info.getPersonasContagiadas().size()  + " ");
        numAlto.setText(" " + info.getPersonasCuidadoAlto().size()  + " ");
        numMedio.setText(" " + info.getPersonasCuidadoMedio().size()  + " ");
        numBajo.setText(" " + info.getPersonasCuidadoBajo().size()  + " ");
        
        //Mostrar personas en internacion domiciliaria
        int contdom = 0;
        Iterator<Persona> recorrerPC = info.getPersonasContagiadas().iterator();
        while (recorrerPC.hasNext()) {
            Persona next = recorrerPC.next();
            if (next.getInternacion() == Internacion.DOM) {
                contdom++;
            }
        }
//        //Mostrar personas en internacion domiciliaria
//        int contdom = 0;
//        for (Persona p : info.getPersonasContagiadas()) {
//            if (p.getInternacion() == Internacion.DOM) {
//                contdom++;
//            }
//        }
        numIntDom.setText(" " + contdom + " ");
        
        numCuiMod.setText(" " + hosp.getnPacientesModerado() + " ");
        numTerInt.setText(" " + hosp.getnPacientesGraves()  + " ");
       
    }
    
}
