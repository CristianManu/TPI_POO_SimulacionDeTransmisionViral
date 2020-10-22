/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Notebook HP
 */
public class Cuidado {
    //Atributos que corresponden al cuidado de Persona
    private CalidadDeCuidado calidadCuidado;
    private boolean barbijo;
    private boolean manos;
    private boolean distanciamiento;
    private int porcentaje;
    
    /**
     * CONSTRUCTOR
     * 
     * @param cui
     * 
     * Si el valor que devuelve  en minúsculas de la cadena cui es igual a "bajo"
     * asigna a calidadCuidado la calidadCuidado bajo y a porcentaje asigna el valor 70.
     * Sino Si el valor que devuelve  en minúsculas de la cadena cui es igual a "medio"
     * asigna a calidadCuidado la calidadCuidado medio y a porcentaje asigna el valor 25.
     * sino asigna a calidadCuidado la calidadCuidado alto y a porcentaje asigna el valor 5.
     * 
     * Luego realiza la llamada a metodo determinarCalidadCuidado()
     */
    public Cuidado(String cui){
        if(cui.toLowerCase() == "bajo"){
            this.calidadCuidado = this.calidadCuidado.Bajo;
            this.porcentaje = 70;
        } else if (cui.toLowerCase() == "medio") {
            this.calidadCuidado = this.calidadCuidado.Medio;
            this.porcentaje = 25;
        } else{
            this.calidadCuidado = this.calidadCuidado.Alto;
            this.porcentaje = 5;
        }
        
        determinarCalidadCuidado();
    }

    /****************        MÉTODOS DE ACCESO        ****************
     *     GETTER Y SETTER
    */
    
    /**
     *
     * @return calidadCuidado
     */
    public CalidadDeCuidado getCalidadCuidado() {
        return calidadCuidado;
    }
    
    /**
     * @return porcentaje
     */
    public int getPorcentaje() {
        return porcentaje;
    }
    
    
    /**
     *********************               FUNCION               *********************
     **/
    
    /**
     *
     * MÉTODO QUE DETERMINA LA CALIDAD DE CUIDADO DE UNA PERSONA
     * 
     * Si la calidad de cuidado es igual a bajo cambia el estado de manos a verdadero, de barbijo a falso 
     * y el distanciamiento en falso
     * Sino si calidad de cuidado es igual a medio cambia el estado de manos a verdadero, de barbijo a verdadero y
     * el distanciamiento en falso. 
     * sino cambia el estado de manos, barbijo y distanciamiento a verdadero
     */
    private void determinarCalidadCuidado(){
        if (calidadCuidado == CalidadDeCuidado.Bajo) {
            this.manos = true;
            this.barbijo = false;
            this.distanciamiento = false;
        } else if (calidadCuidado == CalidadDeCuidado.Medio) {
            this.manos = true;
            this.barbijo = true;
            this.distanciamiento = false;
        } else{
            this.manos = true;
            this.barbijo = true;
            this.distanciamiento = true;
        }
    }

}
