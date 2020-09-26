/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author cristian - Bautista - Aldana
 */
public class Persona {
    
    private String nombre;
    private boolean sano;
    private String apellido;
    private int dni;
    private boolean cuarentena;
    private Comorbilidad comorbilidad;
    private Cuidado cuidado;
    private Estado estado;

    /**
     * 
     * @param nombre
     * @param sano
     * @param apellido
     * @param dni
     * @param cuarentena
     * @param comorbilidad
     * @param cuidado
     * @param estado 
     */
    public Persona(String nombre, boolean sano, String apellido, int dni, boolean cuarentena, Comorbilidad comorbilidad, Cuidado cuidado, Estado estado) {
        this.nombre = nombre;
        this.sano = sano;
        this.apellido = apellido;
        this.dni = dni;
        this.cuarentena = cuarentena;
        this.comorbilidad = comorbilidad;
        this.cuidado = cuidado;
        this.estado = estado;
    }
    
    
    
    public void toser(){}
    
    public void llamarAlMedico(){}
    
    public void caminar(){}
    
    public void irAlHospital(){}
    
    public void internacionDomicialiaria(){}
    
    
    /*Metodos de acceso
        Getters y setters
    */
    
    public String getNombre() {
        return nombre;
    }
    
    /**
     * 
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public boolean isSano() {
        return sano;
    }
    
    /**
     * 
     * @param sano 
     */
    public void setSano(boolean sano) {
        this.sano = sano;
    }

    public String getApellido() {
        return apellido;
    }
    
    /**
     * 
     * @param apellido 
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public int getDni() {
        return dni;
    }
    
    /**
     * 
     * @param dni 
     */
    public void setDni(int dni) {
        this.dni = dni;
    }
    
    public boolean isCuarentena() {
        return cuarentena;
    }

    /**
     * 
     * @param cuarentena 
     */
    public void setCuarentena(boolean cuarentena) {
        this.cuarentena = cuarentena;
    }
    
    
    public Cuidado getCuidado() {
        return cuidado;
    }
    
    /**
     * 
     * @param cuidado 
     */
    public void setCuidado(Cuidado cuidado) {
        this.cuidado = cuidado;
    }
            
   
    public Comorbilidad getComorbilidad(){
        return comorbilidad;
    }
    
    /**
     * 
     * @param array 
     */
    public void setComorbilidad(Comorbilidad []array){
        
    }
    /**
     * 
     */
    public void mostrarInformacion(){}
    
}
