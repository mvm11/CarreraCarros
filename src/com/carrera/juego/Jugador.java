/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carrera.juego;

import com.carrera.ids.IdNombre;


/**
 *
 * @author Mateo
 */
    
   public class Jugador {

    private IdNombre nombre;
    private Integer puntos;

    public Jugador(IdNombre nombre, Integer puntos) {
        this.nombre = nombre;
        this.puntos = puntos;
    }

    public IdNombre nombre() {
        return nombre;
    }


    public void asignarPuntos(Integer puntos) {
        puntos = puntos;
    }
}
