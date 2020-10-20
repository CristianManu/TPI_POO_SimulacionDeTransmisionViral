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
     *
     * @param cui
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

    /**
     *
     * @return calidadCuidado
     */
    public CalidadDeCuidado getCalidadCuidado() {
        return calidadCuidado;
    }

    public int getPorcentaje() {
        return porcentaje;
    }
    
    
    
    
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
