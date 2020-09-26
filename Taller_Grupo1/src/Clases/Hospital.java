package Clases;

import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Notebook HP
 */
public class Hospital {
    //Atributos
    private int nPacientesTotal;
    private int nPacientesModerado;
    private int nPacientesGraves;

    /*
        Metodos de acceso
        Getters y setters
    */
    public int getnPacientesTotal() {
        return nPacientesTotal;
    }

    /**
     * 
     * @param nPacientesTotal 
     */
    public void setnPacientesTotal(int nPacientesTotal) {
        this.nPacientesTotal = nPacientesTotal;
    }

    public int getnPacientesModerado() {
        return nPacientesModerado;
    }

    /**
     * 
     * @param nPacientesModerado 
     */
    public void setnPacientesModerado(int nPacientesModerado) {
        this.nPacientesModerado = nPacientesModerado;
    }

    public int getnPacientesGraves() {
        return nPacientesGraves;
    }

    /**
     * 
     * @param nPacientesGraves 
     */
    public void setnPacientesGraves(int nPacientesGraves) {
        this.nPacientesGraves = nPacientesGraves;
    }
    
    public List<Persona> mostrarInternados(){return null;}
}
