package ar.edu.unahur.obj2.parcial2;

import java.util.ArrayList;
import java.util.List;

public class Aplicacion {
    List<Mision> misiones = new ArrayList<>();

    public void agregarMision(Mision nuevaMision) {
        misiones.add(nuevaMision);
    }

    public void ejecutar(AutoInteligente unAuto) {      
        unAuto.ejecutar(misiones);
    }

    public void borrarUltimaMision() {
        misiones.removeLast();
    }
}
