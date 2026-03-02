package ar.edu.unahur.obj2.parcial2;

public abstract class Comando implements Mision {
    AutoInteligente autoPrevio;

    @Override
    public void ejecutar(AutoInteligente unAuto) {
        unAuto.consumirBateria();
        autoPrevio = unAuto.copiar();
        doEjecutar(unAuto);
        unAuto.agregarMisionEjecutada(this);
    }

    @Override
    public void deshacer(AutoInteligente unAuto) {
        unAuto.copiarDesde(autoPrevio);
    }

    public abstract void doEjecutar(AutoInteligente unAuto);

}
