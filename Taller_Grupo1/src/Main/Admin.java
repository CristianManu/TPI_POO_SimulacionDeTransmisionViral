/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import Clases.*;

/**
 *
 * @author cristian
 */
public class Admin {
    
    public static void main(String[] args) {
    Comorbilidad com1 = new Comorbilidad("Lisiado");
    Persona p1 = new Persona("Cristian Manuel", true, "Lopez", 15487564, true, "alto");
    p1.añadirComorbilidad(com1);
    
        System.out.println(p1.mostrarInformacion());
    }

}
