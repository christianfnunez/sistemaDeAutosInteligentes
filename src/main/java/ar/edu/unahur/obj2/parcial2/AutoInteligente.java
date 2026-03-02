package ar.edu.unahur.obj2.parcial2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AutoInteligente implements Observable {
    private String patente;
    private Integer cantidadDeBateria;
    private Integer velocidadActual;
    private List<Mision> misionesEjecutadas = new ArrayList<>();
    Set<Observador> estaciones = new HashSet<>();

    public AutoInteligente(String patente, Integer cantidadDeBateria) {
        estaEnRango(cantidadDeBateria);
        this.patente = patente;
        this.cantidadDeBateria = cantidadDeBateria;
        this.velocidadActual = 0;
    }

    public Integer getCantidadDeBateria() {
        return cantidadDeBateria;
    }

    public Integer getVelocidadActual() {
        return velocidadActual;
    }

    public void estaEnRango(Integer cantidadDeBateria) {
        if (cantidadDeBateria < 1) {
            throw new DominioException("Un auto no puede existir si su bateria inicial es negativa.");
        }
    }

    public void hayBateria() {
        if (this.cantidadDeBateria < 1) {
            throw new DominioException("No hay suficiente batería.");
        };
    }

    public void consumirBateria() {
        hayBateria();
        cantidadDeBateria -= 1;
    }

    public AutoInteligente copiar() {
        AutoInteligente nuevo = new AutoInteligente(this.patente, this.cantidadDeBateria);
        nuevo.velocidadActual = this.velocidadActual;
        nuevo.misionesEjecutadas = this.misionesEjecutadas;
        return nuevo;
    }

    public void copiarDesde(AutoInteligente autoPrevio) {
        patente = autoPrevio.patente;
        cantidadDeBateria = autoPrevio.cantidadDeBateria;
        velocidadActual = autoPrevio.velocidadActual;
        misionesEjecutadas = autoPrevio.misionesEjecutadas;
    }

    public void acelerar() {
        velocidadActual += 10;
        if (this.velocidadActual >= 119) {
            notificar(patente, "superó los 120 km/h");
        }
    }

    public void desacelerar() {
        velocidadActual = Integer.max(0, velocidadActual - 10);
    }

    public void frenar() {
        velocidadActual = 0;
    }

    public void retroceder() {
        if (velocidadActual == 0) {
            velocidadActual += 5;
        }        
    }

    public void cargarBateriaAlMaximo() {
        cantidadDeBateria = 100;
    }

    public void agregarMisionEjecutada(Mision nuevaMision) {
        misionesEjecutadas.add(nuevaMision);
    }

    public void ejecutar(List<Mision> misiones) {
        misiones.forEach(m -> m.ejecutar(this));
    }

    @Override
    public void agregarObservador(Observador estacion) {
        estaciones.add(estacion);
    }

    @Override
    public void quitarObservador(Observador estacion) {
        estaciones.remove(estacion);
    }

    @Override
    public void notificar(String patente, String aviso) {
        estaciones.forEach(e -> e.actualizar(patente, aviso));
    }



    





}
