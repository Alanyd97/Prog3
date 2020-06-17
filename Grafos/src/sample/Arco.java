package sample;

import java.util.Objects;

public class Arco {

    private int verticeOrigen;
    private int verticeDestino;
    private int etiqueta;

    public Arco(int verticeOrigen, int verticeDestino, int etiqueta) {
        this.verticeOrigen = verticeOrigen;
        this.verticeDestino = verticeDestino;
        this.etiqueta = etiqueta;
    }

    public int getVerticeOrigen() {
        return verticeOrigen;
    }

    public int getVerticeDestino() {
        return verticeDestino;
    }

    public int getEtiqueta() {
        return etiqueta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Arco)) return false;
        Arco arco = (Arco) o;
        return getVerticeOrigen() == arco.getVerticeOrigen() &&
                getVerticeDestino() == arco.getVerticeDestino();
    }

}
