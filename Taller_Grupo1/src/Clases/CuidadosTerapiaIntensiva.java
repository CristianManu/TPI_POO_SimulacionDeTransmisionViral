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
public class CuidadosTerapiaIntensiva {
    //Atributo
    private static final int  NUMEROCAMAS = 2;
    private List<Persona> pacientes;
    private int nPacientes;
    
    public CuidadosTerapiaIntensiva(){
        pacientes = new ArrayList();
        nPacientes = 0;
    }
   
    /**
     * 
     * @return 
     */
    public int getNumeroDeCamas() {
        return NUMEROCAMAS;
    }
    /**
     * Agrega un Paciente a la sala, si la sala esta llena devuelve false y no lo agrega.De lo contrario devuelve true.
     * @param p
     * @return 
     */
    public boolean agregarPaciente(Persona p){
        if (nPacientes < NUMEROCAMAS){
            pacientes.add(p);
            nPacientes++;
            return true;
        }
        return false;
    }
    
    /**
     * Da de alta un paciente eliminandolo de la lista.Si no hay pacientes que eliminar lanza una excepcion.
     * @param p
     * @throws java.lang.Exception
     */
    public void darDeAlta(Persona p) throws Exception{
        if (nPacientes >= 0){
            pacientes.remove(p);
            nPacientes--;
        } else {
            throw new Exception("No hay pacientes que dar de alta");
        }
    }
    
    /**
     * Devuelve la lista con los pacientes en la sala.
     * @return 
     */
    public List<Persona> mostrarPacientes(){
        return pacientes;
    }
}
