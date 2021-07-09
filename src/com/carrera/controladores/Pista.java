
package com.carrera.controladores;


public class Pista implements Carriles{
    
     public Pista(Integer kilometros, Integer numeroDeCarriles) {
        this.kilometros = kilometros;
        this.numeroDeCarriles = numeroDeCarriles;
    }

    private final Integer kilometros;
    private final Integer numeroDeCarriles;

    @Override
    public Integer kilometros() {
        return kilometros;
    }

    @Override
    public Integer numeroDeCarriles() {
        return numeroDeCarriles;
    }

    
}
