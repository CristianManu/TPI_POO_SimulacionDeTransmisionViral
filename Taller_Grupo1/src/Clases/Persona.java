/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
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
    private List<Comorbilidad> comorlist;
    private Cuidado cuidado;
    private Estado estado;
    private Internacion internacion;

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
    public Persona(String nombre, boolean sano, String apellido, int dni, boolean cuarentena, String cuidado) {
        this.nombre = nombre;
        this.sano = sano;
        this.apellido = apellido;
        this.dni = dni;
        this.cuarentena = cuarentena;
        this.comorlist = new ArrayList<>();
        this.cuidado = new Cuidado(cuidado);
        this.estado = null;
        this.internacion = null;
    }
    
    public String getEstado(){
        return this.estado.getDescripcion();
    }
    /**
     * Funcion que asigna un estado aleatorio a una Persona cuando esta se contagia.
     */
    public void setEstado(){
        Random r1 = new Random();
        int ran = r1.nextInt(3);
        switch(ran){
            case 0: this.estado = Estado.Asintomatico;
            break;
            case 1: this.estado = Estado.Leve;
            break;
            case 2: this.estado = Estado.Moderado;
            break;
            case 3: this.estado = Estado.Grave;
            break;
        }
    }

    public Internacion getInternacion() {
        return internacion;
    }

    public void setInternacion(Internacion internacion) {
        this.internacion = internacion;
    }
 
    public void toser(){}
    
    public void llamarAlMedico(){}
    
    public void caminar(){}
    
    public void irAlHospital(){}
    
    public void internacionDomicialiaria(){}
    
    /**
     * Funcion que añade una comorbilidad a la lista de comorbilidades
     * de la persona
     * @param com 
     */
    public void añadirComorbilidad(Comorbilidad com){
        this.comorlist.add(com);
    }
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
            
   /**
    * La funcion get de comorbilidad retorna una lista de comorbilidades
    * @return List<Comorbilidad>
    */
    public List<Comorbilidad> getComorbilidad(){
        return comorlist;
    }
    
    /**
     * Muestra la informacion de la persona.
     * @return String
     */
    public String mostrarInformacion(){
        String estado;
        String comorbolidades = "";
        
        if (this.comorlist.isEmpty()) {
            comorbolidades = "Ninguna";
        } else{
            for (int i = 0; i < this.comorlist.size(); i++) {
                comorbolidades += this.comorlist.get(i).getNombre() + "\n";
            }
        }
        
        if (this.isSano()) {
            estado = "Sano";
        }else{
            estado = "Infectado " + "\n" + "Gravedad: " + this.getEstado();
        }
        
        return "Nombre: " + this.getNombre() + " " + this.getApellido() + "\n" +
                "DNI: " + this.getDni() + "\n" + "Estado: " + estado + "\n" + 
                "Cuidados: " + this.cuidado.getCalidadCuidado() + "\n" + 
                "Comorbolidad: " + comorbolidades;
    }
    
}
