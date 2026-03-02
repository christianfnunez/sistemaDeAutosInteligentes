package ar.edu.unahur.obj2.parcial2;

import java.util.ArrayList;
import java.util.List;

public class EstacionDeControl implements Observador {
    List<String> historialDeAvisos = new ArrayList<>();

    @Override
    public void actualizar(String patente, String aviso) {
        historialDeAvisos.add("El auto con patente " + patente + aviso);
    }

    public List<String> getHistorialDeAvisos() {
        return historialDeAvisos;
    }

}
