
package com.carrera.ids;

import java.util.UUID;


public class IdJuego {
    
    // Atributos de la clase IDjuego
    private UUID id;

    // método constructor
    public IdJuego(UUID id) {
        this.id = id;
    }
    
    // método getter 
    public String getId() {
        return id.toString();
    }
 
}
