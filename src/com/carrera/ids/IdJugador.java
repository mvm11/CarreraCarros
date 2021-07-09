
package com.carrera.ids;

import java.util.UUID;



public class IdJugador {
    
    // atributos de la clase IdJugador
    private UUID id;

    // método constructor 
    public IdJugador(UUID id) {
        this.id = id;
    }
    
    // método getter 
    public String getId() {
        return id.toString();
    }
}
