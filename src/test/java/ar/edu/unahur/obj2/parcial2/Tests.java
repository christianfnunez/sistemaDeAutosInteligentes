package ar.edu.unahur.obj2.parcial2;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class Tests {
    private AutoInteligente a1 = new AutoInteligente("123", 100);
    private Aplicacion app = new Aplicacion();
    private EstacionDeControl est = new EstacionDeControl();

    @Test
    void agregarMisionesDesdeAppYEjecutar_BateriaAl100YVelocidad5(){
        app.agregarMision(new AcelerarComando());
        app.agregarMision(new AcelerarComando());
        app.agregarMision(new DesacelerarComando());
        app.agregarMision(new FrenarComando());
        app.agregarMision(new RetrocederComando());
        app.agregarMision(new CargarBateriaAlMaximoComando());

        app.ejecutar(a1);

        assertEquals(100, a1.getCantidadDeBateria());
        assertEquals(5, a1.getVelocidadActual());
    }

    @Test
    void notificarEstacionLuegoDeLlegarA120kmPorHora(){
        a1.agregarObservador(est);

        app.agregarMision(new AcelerarComando());
        app.agregarMision(new AcelerarComando());
        app.agregarMision(new AcelerarComando());
        app.agregarMision(new AcelerarComando());
        app.agregarMision(new AcelerarComando());
        app.agregarMision(new AcelerarComando());
        app.agregarMision(new AcelerarComando());
        app.agregarMision(new AcelerarComando());
        app.agregarMision(new AcelerarComando());
        app.agregarMision(new AcelerarComando());
        app.agregarMision(new AcelerarComando());
        app.agregarMision(new AcelerarComando());

        app.ejecutar(a1);

        assertEquals(1, est.getHistorialDeAvisos().size());
    }

    @Test
    void Excepción() {
        DominioException exception = assertThrows(DominioException.class, () -> {new AutoInteligente("100", 0);});

        assertEquals("Un auto no puede existir si su bateria inicial es negativa.", exception.getMessage());
    }


}
