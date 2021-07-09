
package com.carrera.auto;


public class Conductor {
    
    // atributos de la clase conductor
    private String nombre;
    
    // método constructor
    public Conductor() {
    }
    
    // método constructor 
    public Conductor(String nombre) {
        this.nombre = nombre;
    }

    public String nombre() {
        return nombre;

    }
    
    // método para lanzar el dado y avanzar en la pista 
    public Integer lanzarDado() {
        int dadoAleatorio = (int) (Math.random() * 6);
        return dadoAleatorio;
    }

}

