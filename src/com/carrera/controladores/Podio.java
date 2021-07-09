/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carrera.controladores;

import com.carrera.juego.Jugador;

/**
 *
 * @author Mateo
 */
public class Podio implements Lugares{
    
    // Atributos de la clase Podio
    private Jugador primerLugar;
    private Jugador segundoLugar;
    private Jugador tercerLugar;
    // Método constructor
    public Podio() {
    }
    // Asignar lugares
    public void asignarPrimerLugar(Jugador jugador) {
        primerLugar = jugador;
    }

    public void asignarSegundoLugar(Jugador jugador) {
        segundoLugar = jugador;
    }

    public void asignarTercerLugar(Jugador jugador) {
        tercerLugar = jugador;
    }
    
    @Override
    public Jugador primerLugar() {
        return primerLugar;
    }

    @Override
    public Jugador segundoLugar() {
        return segundoLugar;
    }

    @Override
    public Jugador tercerLugar() {
        return tercerLugar;
    }

    @Override
    public Boolean estaLleno() {
        Boolean lleno = false;
        if (primerLugar != null && segundoLugar != null && tercerLugar != null) {
            lleno = true;
        }
        return lleno;
    }
    
}
