/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Interfaz.Simulacion;
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
        JFrame frame = new JFrame("Simulacion de Covid");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(0,0);
        frame.setPreferredSize(new Dimension(1024, 768));
        Simulacion sim = new Simulacion();
        frame.setResizable(false);
        frame.add(sim);
        frame.pack();
        frame.setVisible(true);
    }

}
