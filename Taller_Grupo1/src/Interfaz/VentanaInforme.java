/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaz;
import Clases.Domicilio;
import Clases.Hospital;
import Clases.Informes;
import javax.swing.*;
import java.awt.*;

import javax.swing.BorderFactory;
import java.util.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.border.Border;

/**
 *
 * @author cristian
 */
public class VentanaInforme extends Container {
    public Hospital hosp;
    public Domicilio dom;
    public Informes info;
    private JPanel panelIzq, panelDer;
    private JLabel displayInfec, displaySano, displayAlto, displayMedio, displayBajo,
            displayIntDom, displayCuiMod, displayTerInt;
    
    private JLabel numSanos, numInfec, numAlto, numMedio, numBajo, numIntDom,
            numCuiMod, numTerInt;
    
    static final int separacion = 7;

    public VentanaInforme() {
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
        
        this.hosp = new Hospital();
        this.dom = new Domicilio();
        this.info = new Informes();
        crearLabels();
    }
    
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
    
    void actValores(){
        displaySano.setText("Sanos: "+ info.getPersonasSanas());
        displayInfec.setText("Infectados: "+ info.getPersonasContagiadas().size());
        displayAlto.setText("Cuidado Alto: "+ info.getPersonasCuidadoAlto().size());
        displayMedio.setText("Cuidado Medio: "+ info.getPersonasCuidadoMedio().size());
        displayBajo.setText("Cuidado Bajo: "+ info.getPersonasCuidadoBajo().size());
        displayIntDom.setText("Internados domicilio"+dom.mostrarPersonasCuarentena().size());
        displayCuiMod.setText("Cuidados Moderados: "+hosp.getnPacientesModerado());
        displayTerInt.setText("Terapia Intensiva: "+hosp.getnPacientesGraves());
       
    }
    
}
