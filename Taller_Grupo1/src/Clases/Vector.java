/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Grupo1
 */
public class Vector {
    public double x,y;
    
    //constructor por defecto, adopta valores aleatorios
    public Vector(){
        this.x = Math.random() -0.5;
        this.y = Math.random() -0.5;
    }
    //constructor parametrizado donde se le pasan los valores
    public Vector(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    /***********************          MÉTODOS DE ACCESO              ***********************/

    public double getX() {return x;}

    public void setX(double x) {this.x = x;}

    public double getY() {return y;}

    public void setY(double y) {this.y = y;}
    
    public void setValores(double x, double y) {
        this.x = x;
        this.y = y;
    }

    
    /************************               FUNCIONES               ***********************/
    
    /**
     * @return  
     */
    public double magnitud(){
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }
    
    /**
     * @param maxF*/
    public void limit(double maxF) {
        double magnitud = magnitud();
        double producto;
        if(magnitud > maxF) 
            producto = maxF / magnitud;
        else
            producto = 1.0;
        
        this.x *= producto;
        this.y *= producto;
    }

    /**
     * @param nMagnitud
     * @return */
    public Vector setMagnitud(double nMagnitud) {
        double aMagnitud = magnitud();
        this.x *= (nMagnitud/aMagnitud);
        this.y *= (nMagnitud/aMagnitud);
        return this;
    }
    /**
     * @param padre
     */
    public void sumar(Vector padre) {
        this.x += padre.getX();
        this.y += padre.getY();
    }

    /**
     *
     * @param padre
     */
    public void restar(Vector padre) {
        this.x -= padre.getX();
        this.y -= padre.getY();
    }

    /**
     *
     * @param producto
     */
    public void multiplicar(double producto) {
        this.x *= producto;
        this.y *= producto;
    }

    /**
     *
     * @param denominador
     */
    public void dividir(double denominador) {
        this.x /= denominador;
        this.y /= denominador;
    }

    /**
     * @return  la arcotangente del cociente entre x e y
     */
    public double dir() {
        return Math.atan2(this.y, this.x);
    }

    /**
     * @return Resultado de producto entre x e y
     */
    public double movimiento() {
        return this.x+this.y;
    }
    
}
