package ar.edu.unahur.obj2.parcial2;

public class CargarBateriaAlMaximoComando extends Comando {

    @Override
    public void doEjecutar(AutoInteligente unAuto) {
        unAuto.cargarBateriaAlMaximo();
    }

}
