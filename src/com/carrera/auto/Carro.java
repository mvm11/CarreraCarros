
package com.carrera.auto;
import com.carrera.ids.IdCarro;
import com.carrera.ids.IdJuego;
import java.util.Map;
import java.util.HashMap;


public class Carro {
    
    
    // atributos de la clase carro
    protected Conductor conductor;
    protected Integer distancia;
    protected IdJuego juegoId;
    private final Map<IdCarro, Conductor> carros = new HashMap<>();
    
    
    // método constructor
    public Carro() {
    }

    // método constructor
    public Carro(Conductor conductor, Integer distancia, IdJuego juegoId) {
        this.conductor = conductor;
        this.distancia = distancia;
        this.juegoId = juegoId;
    }

    
   // método para asignar conductor
    public void asignarConductor(IdCarro carroId, Conductor conductor) {
        carros.put(carroId, conductor);

    }
    
    // mapa para almacenar el carro y el conductor
    public Map<IdCarro, Conductor> carros() {
        return carros;

    }
    
    
    // método para asignar la distancia
    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }
    
    
    // método para retornar el número de carros almacenados 
    public Integer numeroCarros() {
        return carros.size();
    }
    
    // getters 
    public Conductor conductor() {

        return conductor;

    }

    public Integer distancia() {

        return distancia;

    }

}
