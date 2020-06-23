import java.util.Arrays;
import java.util.Objects;

/* Una familia, con su cantidad de dias, y una arreglo con el top de 3 dias preferidos */
public class Familia implements Comparable<Familia> {

    private int id;
    private int miembros;
    private int[] diasPreferidos;
    private int indicePreferido;
    private int diaDesignado;
    private int bono;

    public int getIndicePreferido() {
        return indicePreferido;
    }

    public void setIndicePreferido(int indicePreferido) {
        this.indicePreferido = indicePreferido;
    }

    public Familia(int id, int miembros, int... diasPreferidos) {
        this.id = id;
        this.miembros = miembros;
        this.diasPreferidos = diasPreferidos;
        this.indicePreferido = 0;
        this.diaDesignado = -1;
        bono = 0;

    }

    /* Id de la familia */
    public int getId() {
        return id;
    }

    public int getDiaDesignado() {
        return diaDesignado;
    }

    public void setBono(int bonoF) {
        this.bono = bonoF;
    }

    /* Retorna la cantidad de miembros de la familia. */
    public int miembros() {
        return miembros;
    }


    /* Dado un indice entre 0 y 2, retorna el día preferido por la familia para ese indice. */
    public int preferenciaEn(int indice) {
        return diasPreferidos[indice];
    }

    /* Retorna el día preferido de la familia */
    public int diaPreferido() {
        return preferenciaEn(indicePreferido);
    }

    public int getBono(){return this.bono;}

    @Override
    public String toString() {
        return "Familia: id=" + id + ", miembros=" + miembros + ", preferencias=" + Arrays.toString(diasPreferidos)+" |";
    }

    @Override
    public int compareTo(Familia o) {
        //  o.miembros(),miembros
        return Integer.compare(this.preferenciaEn(0),o.preferenciaEn(0));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Familia)) return false;
        Familia familia = (Familia) o;
        return getId() == familia.getId();
    }

}