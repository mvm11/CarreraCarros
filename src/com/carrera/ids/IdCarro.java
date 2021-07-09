
package com.carrera.ids;

import java.util.UUID;


public class IdCarro {
    
    // atributos de la clase CarroID
    private UUID id;

    // método constructor
    public IdCarro(UUID id) {
        this.id = id;
    }
    
    // método getter
    public String getId() {
        return id.toString();
    }

    
    
}
