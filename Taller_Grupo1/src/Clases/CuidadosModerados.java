/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Grupo1
 */
public class CuidadosModerados {
    //Atributos 
    private static final int  NUMEROCAMAS = 5;
    private List<Persona> pacientes;
    private int nPacientes;
    
    /**
     * Constructor que Inicializa la cant de pacientes y crea el arrayList
     */
    public CuidadosModerados(){
        pacientes = new ArrayList();
        nPacientes = 0;
    }
    
    /****************        MÉTODOS DE ACCESO        ****************
     *     GETTER 
    */
    
    /**
     * 
     * @return cantidad de camas 
     */
    public int getNumeroDeCamas() {
        return NUMEROCAMAS;
    }
    
    /**
     * Devuelve la lista con los pacientes en la sala.
     * @return Lista de pacientes
     */
    public List<Persona> mostrarPacientes(){
        return pacientes;
    }
  
    /**
     *********************               FUNCIONES               *********************
     **/
    
    /**
     * Agrega un Paciente a la sala, si la sala esta llena devuelve false y no lo agrega.De lo contrario devuelve true.
     * @param p un objeto Persona
     * @return Retorna false en caso de no poder realizar la operacion y true en caso contrario
     */
    public boolean agregarPaciente(Persona p){
        if (nPacientes < NUMEROCAMAS){
            pacientes.add(p);
            nPacientes++;
            p.setInternacion(Internacion.CM);
            return true;
        }
        return false;
    }
    
    /**
     * Da de alta un paciente eliminandolo de la lista.Si no hay pacientes que eliminar lanza una excepcion.
     * @param p un objeto Persona
     */
    public void darDeAlta(Persona p){
        if (nPacientes >= 0){
            pacientes.remove(p);
            nPacientes--;
        }
    }
    
}
