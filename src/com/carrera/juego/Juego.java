
package com.carrera.juego;

import com.carrera.auto.Carro;
import com.carrera.auto.Conductor;
import com.carrera.carril.Carril;
import com.carrera.posicion.Posicion;
import com.carrera.ids.IdCarro;
import com.carrera.ids.IdJuego;
import com.carrera.ids.IdJugador;
import com.carrera.ids.IdNombre;
import com.carrera.controladores.Pista;
import com.carrera.controladores.Podio;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class Juego {
    
    
    protected Map<IdJugador, Jugador> jugadores = new HashMap<>();
    protected Pista pista;
    protected Boolean estadoJuego;
    protected Podio podio = new Podio();
    protected ArrayList<Pista> pistas = new ArrayList<>();
    protected ArrayList<Carro> carrosEnJuego = new ArrayList<>();
    protected ArrayList<Carril> carrilesEnJuego = new ArrayList<>();
    private final Carro carro = new Carro();

    
    // Crear jugador y la lista de jugadores con sus respectivos id
    public void crearJugador(IdJugador jugadorId, IdNombre nombre) {
        Jugador jugador = new Jugador(nombre, 0);
        jugadores.put(jugadorId, jugador);
        crearConductor(nombre);
    }
    
   // Crear el conductor y asignarle un carro.
    public void crearConductor(IdNombre nombre) {
        UUID id;            
        Conductor conductor = new Conductor(nombre.getNombre());
        id = UUID.randomUUID();
        IdCarro carroId =  new IdCarro(id);
        carro.asignarConductor(carroId, conductor);
    }
    
 
    public void crearPista() {
        int kilometrosPista = 10;
        int numeroCarriles = carro.numeroCarros();
        for (int i = 0; i < carro.numeroCarros(); i++) {
            Pista pista = new Pista(kilometrosPista, numeroCarriles);
            pistas.add(pista);
        }
    }
    
    // Asignar posiciones 
    
      public void asignarPrimerLugar(IdJugador jugadorId) {
        podio.asignarPrimerLugar(jugadores.get(jugadorId));
        System.out.println("----------" + jugadores.get(jugadorId).nombre().getNombre() + ": Primer Lugar" + "----------");

    }

    public void asignarSegundoLugar(IdJugador jugadorId) {
        podio.asignarSegundoLugar(jugadores.get(jugadorId));
        System.out.println("----------" + jugadores.get(jugadorId).nombre().getNombre() + ": Segundo Lugar" + "----------");
    }

    public void asignarTercerLugar(IdJugador jugadorId) {
        podio.asignarTercerLugar(jugadores.get(jugadorId));
        System.out.println("----------" + jugadores.get(jugadorId).nombre().getNombre() + ": Tercer Lugar" + "----------");

    }
    
    public void iniciarJuego() {
        //Identificado para iniciar el juego
        UUID id;
        id = UUID.randomUUID();
        IdJuego juegoId = new IdJuego(id);
        int Pista = 0;

        // Crear lista de carros en juego
            carro.carros().forEach((key, value) -> {
            Carro carrosJuego = new Carro(value, 0, juegoId);
            carrosEnJuego.add(carrosJuego);

            //añadir carros a los Carriles para jugar
            int kilometrosAMetros = pistas.get(Pista).kilometros() * 1000;
            Posicion posicion = new Posicion(0, kilometrosAMetros);
            Carril carriles = new Carril(key, juegoId, posicion, kilometrosAMetros, false);
            carrilesEnJuego.add(carriles);
        });

        //Iniciar JUEGO
        estadoJuego = true;
        Conductor conductor = new Conductor();
        System.out.println("----------Inicia la carrera--------");

        //Mientras no hayan 3 ganadores el juego continua
        while (estadoJuego) {
            int contador = 0;
            System.out.println("--------Avance----- " + "--------- Meta: " + carrilesEnJuego.get(contador).metros() + " metros");
            for (Carro carros : carrosEnJuego) {

                //Si el carro no ha ganado sigue jugando
                if (!yaGanoCarro(carros.conductor().nombre())) {
                    int mover = conductor.lanzarDado() * 100;
                    carros.setDistancia(carros.distancia() + mover);
                    carrilesEnJuego.get(contador).moverCarro(carrilesEnJuego.get(contador).posicion(), mover);
                    System.out.println(carros.conductor().nombre() + ":" + " mueve: " + mover + " Nueva posición: " + carros.distancia());

                    //Si el jugador llego a la final, asignarle la posición y el podio
                    if (carrilesEnJuego.get(contador).desplazamientoFinal()) {
                        if (podio.primerLugar() == null) {
                            asignarPrimerLugar(jugadorID(carros.conductor().nombre()));
                        } else if (podio.segundoLugar() == null) {
                            asignarSegundoLugar(jugadorID(carros.conductor().nombre()));
                        } else if (podio.tercerLugar() == null) {
                            asignarTercerLugar(jugadorID(carros.conductor().nombre()));
                        }
                    }
                }
                contador++;
            }
            if (podio.estaLleno()) {
                break;
            }
        }

        mostrarPodio();
        repetirJuego();
    }

    public Map<IdJugador, Jugador> jugadores() {

        return jugadores;

    }

    public Boolean jugando() {

        return estadoJuego;

    }

       // Retorna el id del jugador dando el nombre del jugador
    public IdJugador jugadorID(String nombre) {
        IdJugador lookId = null;
        for (IdJugador keys : jugadores.keySet()) {
            if (jugadores.get(keys).nombre().getNombre().equals(nombre)) {
                lookId = keys;
            }
        }
        return lookId;
    }

    //Retorna True  si el carro en la carrera ya ganó
    public Boolean yaGanoCarro(String nombre) {
        boolean yaGano = false;
        if (podio.tercerLugar() == jugadores.get(jugadorID(nombre))
                || podio.primerLugar() == jugadores.get(jugadorID(nombre))
                || podio.segundoLugar() == jugadores.get(jugadorID(nombre))) {
            yaGano = true;
        }
        return yaGano;
    }

    
    // Método para saber si repetir el juego y limpiar listas de juego anterior
    public void repetirJuego() {
        Scanner in = new Scanner(System.in);
        System.out.println("Desea jugar otra carrera?  Y/N");
        while (!in.hasNext("[yYnN]")) {
            System.out.println("Solo se reciben como respuesta Y/N ó y/n");
            in.next();
        }
        String jugarOtro = in.next();
        if (jugarOtro.equals("Y") || jugarOtro.equals("y")) {
            carrosEnJuego.clear();
            carrilesEnJuego.clear();
            Podio podioNuevo = new Podio();
            podio = podioNuevo;
            iniciarJuego();

        }

    }

    //Método para mostrar los conductores que quedaron en el podio 
    public void mostrarPodio() {
        System.out.println("--------Podio--------");
        System.out.println("Primer Lugar:  " + podio.primerLugar().nombre().getNombre());
        System.out.println("Segundo Lugar:  " + podio.segundoLugar().nombre().getNombre());
        System.out.println("Tercer Lugar:  " + podio.tercerLugar().nombre().getNombre());
        System.out.println("----------------------");

    }


    
    
}
