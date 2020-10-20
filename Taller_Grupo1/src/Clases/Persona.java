/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import Interfaz.Simulacion;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.awt.*;
import java.awt.geom.*;

/**
 *
 * @author cristian - Bautista - Aldana
 */
public class Persona {
    //Atributos Interfaz
    Vector posicion;
    Vector velocidad;
    Vector aceleracion;
    
    static int rangoVision = 120;
    static int tamaño = 3;
    static Path2D forma = new Path2D.Double();
    
    static{
        forma.moveTo(0, -tamaño*2);
        forma.lineTo(-tamaño, tamaño*2);
        forma.lineTo(tamaño, tamaño*2);
        forma.closePath();
    }
    
    //Atributos UML
    private String nombre;
    private boolean sano;
    private String apellido;
    private int dni;
    private boolean cuarentena;
    private List<Comorbilidad> comorlist;
    private Cuidado cuidado;
    private Estado estado;
    private Internacion internacion;


    
    public Persona(){
        //Inicializacion de atributos Interfaz
        this.posicion = new Vector((double)(Math.random()*Simulacion.ancho), (double)(Math.random()*Simulacion.alto));
        double angulo = Math.random()*360;
        double radio = Math.random()*2+2; //2-4
        this.velocidad = new Vector(radio * Math.cos(angulo), radio * Math.sin(angulo));
        this.aceleracion = new Vector(0, 0);
        
        //Inicializacion de atributos UML
        this.nombre = "";
        this.sano = true;
        this.apellido = "";
        this.dni = 0;
        this.cuarentena = false;
        this.comorlist = new ArrayList<>();
        this.cuidado = null;
        this.estado = null;
        this.internacion = null;        
    }
    
    /**
     * 
     * @param nombre
     * @param sano
     * @param apellido
     * @param dni
     * @param cuarentena
     * @param cuidado
     */    
    public Persona(String nombre, boolean sano, String apellido, int dni, boolean cuarentena, String cuidado) {
        //Inicializacion de atributos Interfaz
        this.posicion = new Vector((double)(Math.random()*Simulacion.ancho), (double)(Math.random()*Simulacion.alto));
        double angulo = Math.random()*360;
        double radio = Math.random()*2+2; //2-4
        this.velocidad = new Vector(radio * Math.cos(angulo), radio * Math.sin(angulo));
        this.aceleracion = new Vector(0, 0);
        
        //Inicializacion de atributos UML
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
    
    /**
     *
     * @return 
     */
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

    /**
     * Devuelve el lugar de internación actual de una persona
     * @return
     */
    public Internacion getInternacion() {
        return internacion;
    }

    /**
     *
     * @param internacion
     */
    public void setInternacion(Internacion internacion) {
        this.internacion = internacion;
    }
 
    /**
     *
     */
    public void toser(){}
    
    /**
     *
     */
    public void llamarAlMedico(){}
    
    /**
     *
     */
    public void caminar(){}
    
    /**
     *
     */
    public void irAlHospital(){}
    
    /**
     *
     */
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

    public Vector getPosicion() {
        return posicion;
    }

    public void setPosicion(Vector posicion) {
        this.posicion = posicion;
    }
    
    
    
    /**
     *  Devuelve el nombre de la persona actual
     * @return nombre
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

    /**
     * 
     * @return si la persona esta sana o no
     */
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

    /**
     * Devuelve el apellido de la persona actual
     * @return apellido
     */
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
    
    /**
     *  Devuelve el dni de la persona actual
     * @return dni
     */
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
    
    /**
     * Devuelve si la persona esta en cuarentena o no
     * @return cuarentena
     */
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
    
    /**
     *  Devuelve el cuidado de la persona actual
     * @return cuidado
     */
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
    
    /** FUNCIONES DE LA INTERFAZ
     *  Estas funciones seran utilizadas exclusivamente 
     * para la interaccion de los objetos con la interfaz
     *  Tambien contiene atributos estaticos que interactuaran con la misma
     */
    static double maxFuerza = 0.2;
    static double maxVelocidad = 2;

    static final double forzarCambioFuerza = 1;

    static double alinePercRadio = 50;
    static double cohesiPercRadio = 100;
    static double separPercRadio = 100;
    static double separMaxVelocidad = maxVelocidad;
    static double separMaxFuerza = maxFuerza;
    
    static void aumentarSeparacionMaxFuerza() { Persona.separMaxFuerza += forzarCambioFuerza; }
    static void disminuirSeparacionMaxFuerza() { Persona.separMaxFuerza -= forzarCambioFuerza; }
    public static void pause(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {}
    }
    
    
    public Vector alinear(ArrayList<Persona> personas){
        int radiopercep = (int)(alinePercRadio);
        int total = 0;
        Vector direccion = new Vector(0,0);
        //distancia entre personas
        for (int i = 0; i < personas.size(); i++) {
            double dist = distancia(this.posicion.getX(), this.posicion.getY(), personas.get(i).posicion.getX(), personas.get(i).posicion.getY());
            if (personas.get(i) != this && dist < radiopercep) {
                direccion.sumar(personas.get(i).velocidad);
                total++;
            }
        }
        
        if (total > 0) {
            direccion.dividir((double)total);
            direccion.setMagnitud(maxVelocidad);
            direccion.restar(this.velocidad);
            direccion.limit(maxFuerza);
        }
        return direccion;
    }
    
    public Vector cohesion(ArrayList<Persona> personas){
        int radiopercep = (int)(cohesiPercRadio);
        int total = 0;
        Vector direccion = new Vector(0,0);
        for (int i = 0; i < personas.size(); i++) {
            double dist = distancia(this.posicion.getX(), this.posicion.getY(), personas.get(i).posicion.getX(), personas.get(i).posicion.getY());
            if (personas.get(i) != this && dist < radiopercep) {
                direccion.sumar(personas.get(i).posicion);
                total++;
            }
        }
        if (total > 0) {
            direccion.dividir((double)total);
            direccion.restar(this.posicion);
            direccion.setMagnitud(maxVelocidad);
            direccion.restar(this.velocidad);
            direccion.limit(maxFuerza);
        }
        return direccion;
    }
    
    public Vector separacion(ArrayList<Persona> personas){
        int radiopercep = (int)separPercRadio;
        int total = 0;
        Vector direccion = new Vector(0, 0);
        for (int i = 0; i < personas.size(); i++) {
            double dist = distancia(this.posicion.getX(), this.posicion.getY(), personas.get(i).posicion.getX(), personas.get(i).posicion.getY());
            if (personas.get(i) != this && dist < radiopercep) {
                Vector diferencia = new Vector(this.posicion.getX(),this.posicion.getY());
                diferencia.restar(personas.get(i).posicion);
                if(dist == 0.0) dist += 0.001;
                diferencia.dividir(dist*dist);
                direccion.sumar(diferencia);
                total++;
            }
        }
        if (total > 0) {
            direccion.dividir((double)total);
            double sepfinal;
            double fuefinal;
            if (total > 40) {
                sepfinal = separMaxVelocidad * 2;
                fuefinal = separMaxFuerza * 2;
            }else{
                sepfinal = separMaxVelocidad;
                fuefinal = separMaxFuerza;
            }
            direccion.setMagnitud(sepfinal);
            direccion.restar(this.velocidad);
            direccion.limit(fuefinal);
        }
        return direccion;
    }
    
    public void interaccion(ArrayList<Persona> personas){
        this.aceleracion.setValores(0, 0);
        Vector alineacion = this.alinear(personas);
        Vector cohesion = this.cohesion(personas);
        Vector separacion = this.separacion(personas);
        this.aceleracion.sumar(alineacion);
        this.aceleracion.sumar(separacion);
        this.aceleracion.sumar(cohesion);
    }
    
    
    private double distancia(double x1, double y1, double x2, double y2){
        //Formula de distancia 
        return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
    }
    /**
     * Metodo encargado de "mover" a la persona
     */
    public void update(){
        this.velocidad.sumar(this.aceleracion);
        this.velocidad.limit(maxVelocidad);
        this.posicion.sumar(this.velocidad);
        this.velocidad.sumar(this.aceleracion);
        this.velocidad.limit(maxVelocidad);
    }
    
    /**
     * Metodo que crea la forma de la persona a visualizarse en la pantalla
     * @param g 
     */
    public void draw(Graphics2D g){
        AffineTransform save = g.getTransform();
        g.translate((int)this.posicion.getX(), (int)this.posicion.getY());
        g.setColor(Color.WHITE); //mas tarde agregar color segun estado
        g.fill(forma);
        g.draw(forma);
        g.setTransform(save);
    }
    
    /**
     * Metodo que evita que la figura se salga de los bordes del Frame
     */
    public void bordes(){
        if (this.posicion.getX() > Simulacion.ancho) {
            this.posicion.x = 0;
        }else if (this.posicion.getX() < 0) {
            this.posicion.x = Simulacion.ancho;
        }
        
        if (this.posicion.getY() > Simulacion.alto) {
            this.posicion.y = 0;
        }else if (this.posicion.getY() < 0){
            this.posicion.y = Simulacion.alto;
        }
    }
    
}
