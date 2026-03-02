package ar.edu.unahur.obj2.parcial2;

public class AcelerarComando extends Comando {

    @Override
    public void doEjecutar(AutoInteligente unAuto) {
        unAuto.acelerar();
    }

}
