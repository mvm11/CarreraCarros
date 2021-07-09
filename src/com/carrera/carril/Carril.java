
package com.carrera.carril;

import com.carrera.posicion.Posicion;
import com.carrera.ids.IdCarro;
import com.carrera.ids.IdJuego;


public class Carril {
    
    
   // Atributos de la clase Carril
    
    protected IdCarro carroId;
    protected IdJuego juegoId;
    protected Posicion posicion;
    protected Integer metros;
    protected Boolean desplazamientoFinal;
    
    // Método constructor 

    public Carril(IdCarro carroId, IdJuego juegoId, Posicion posicion, Integer metros, Boolean desplazamientoFinal) {
        this.carroId = carroId;
        this.juegoId = juegoId;
        this.posicion = posicion;
        this.metros = metros;
        this.desplazamientoFinal = desplazamientoFinal;
    }
    
     public void alcanzarLaMeta() {
        if (posicionActual() >= posicionDeseada()) {
            desplazamientoFinal = true;
        }

    }

    public void moverCarro(Posicion posicion, Integer cantidad) {
        this.posicion = posicion;
        posicion.setActual(posicion.actual() + cantidad);
        alcanzarLaMeta();
    }

    public Integer metros() {

        return metros;

    }

    public Posicion posicion() {

        return posicion;

    }

    public Integer posicionActual() {

        return posicion.actual();

    }

    public Integer posicionDeseada() {
        return posicion.meta();
    }

    public Boolean desplazamientoFinal() {

        return desplazamientoFinal;

    }
    
    
}
