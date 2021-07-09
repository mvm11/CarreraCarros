package com.carrera.principal;

import com.carrera.ids.IdJugador;
import com.carrera.ids.IdNombre;
import com.carrera.juego.Juego;
import com.mysql.conexion.Conexion;
import java.sql.Connection;
import java.util.Scanner;
import java.util.UUID;


public class Main {

    public static void main(String[] args) {
        
        
       
        UUID id;
        int cantidadJugadores;
        String nombreJugador;

        Juego nuevoJuego = new Juego();

        //Datos jugadores para iniciar el juego

        System.out.println("___..............._\n" +
"             __.. ' _'.\"\"\"\"\"\"\\\\\"\"\"\"\"\"\"\"- .`-._\n" +
" ______.-'         (_) |      \\\\           ` \\\\`-. _\n" +
"/_       --------------'-------\\\\---....______\\\\__`.`  -..___\n" +
"| T      _.----._           Xxx|x...           |          _.._`--. _\n" +
"| |    .' ..--.. `.         XXX|XXXXXXXXXxx==  |       .'.---..`.     -._\n" +
"\\_j   /  /  __  \\  \\        XXX|XXXXXXXXXXX==  |      / /  __  \\ \\        `-.\n" +
" _|  |  |  /  \\  |  |       XXX|\"\"'            |     / |  /  \\  | |          |\n" +
"|__\\_j  |  \\__/  |  L__________|_______________|_____j |  \\__/  | L__________J\n" +
"     `'\\ \\      / ./__________________________________\\ \\      / /___________\\\n" +
"        `.`----'.'   dp                                `.`----'.'\n" +
"          `\"\"\"\"'                                         `\"\"\"\"'");
        System.out.println("                                                             ");
        System.out.println("                                                             ");
        System.out.println("Bienvenido a la carrera de autos");
        System.out.println("                                                             ");

        //Consulta  cuántos jugadores se quieren crear y se crean dichos jugadores con nombres "jugador"+n
        Scanner in = new Scanner(System.in); 
        System.out.println("Para iniciar el juego ingrese la cantidad de jugadores");
         while(!in.hasNextInt()) in.next();         
        cantidadJugadores = in.nextInt();

        for (int i = 0; i < cantidadJugadores; i++) {
            id = UUID.randomUUID();
            IdJugador jugadorId = new IdJugador(id);
            nombreJugador = "jugador" + (i + 1);
            IdNombre nombre = new IdNombre(nombreJugador);
            nuevoJuego.crearJugador(jugadorId, nombre);
        }

        // Crear pistas
        nuevoJuego.crearPista();

        // Iniciar el Juego
        nuevoJuego.iniciarJuego(); 
    }

}
