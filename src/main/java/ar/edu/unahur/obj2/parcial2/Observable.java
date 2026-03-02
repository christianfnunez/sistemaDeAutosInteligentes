package ar.edu.unahur.obj2.parcial2;

public interface Observable {
    void agregarObservador(Observador auto);
    void quitarObservador(Observador auto);
    void notificar(String patente, String aviso);
}
