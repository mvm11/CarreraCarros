
package com.carrera.posicion;


public class Posicion implements Posiciones{
    
    private Integer ubicacionActual;
    private Integer meta;

    @Override
    public Integer actual() {
        return ubicacionActual;
    }

    @Override
    public Integer meta() {
        return meta;
    }

    public void setActual(Integer actual) {
        this.ubicacionActual = actual;
    }

    public Posicion(Integer actual, Integer meta) {
        this.ubicacionActual = actual;
        this.meta = meta;
    }
}
