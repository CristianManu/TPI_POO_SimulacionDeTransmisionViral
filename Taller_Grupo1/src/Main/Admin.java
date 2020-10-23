/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Interfaz.Simulacion;
import Interfaz.VentanaInforme;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Grupo1
 */
public class Admin {
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        
        JFrame frame1 = new JFrame("Simulacion de Covid");
        JFrame frame2 = new JFrame("Informes");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLocation(0,0);
        frame2.setLocation(1024,0);
        frame1.setPreferredSize(new Dimension(1024, 768));
        frame2.setPreferredSize(new Dimension(400,300));
        //Seteado de la simulacion
        Simulacion.setearDiaLimite(50);
        Simulacion.setearPeriodoDeChequeo(1000);
        Simulacion.setearPeriodoDeChequeoHospital(100);
        Simulacion.setearControlPaseoMayores(750);
        //Creacion de una Simulacion
        Simulacion sim = new Simulacion();
        VentanaInforme vi = new VentanaInforme(sim.informe, sim.hosp);
        Thread hilosim = new Thread(sim);
        Thread hilovi = new Thread(vi);
        frame1.setResizable(false);
        frame2.setResizable(false);
        frame1.add(sim);
        frame2.add(vi);
        frame1.pack();
        frame2.pack();
        frame1.setVisible(true);
        frame2.setVisible(true);
        hilosim.start();
        hilovi.start();
    }

}
