import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Dia implements Comparable<Dia>{
    private ArrayList<Familia> familias;
    private final static int capacidad = 30;
    private int capacidadActual;
    private int id;
    private int bono;

    public int getBono() {
        return bono;
    }

    public Dia(int a){
        familias = new ArrayList<>();
        id=a;
        capacidadActual = capacidad;
        bono = 0;
    }

    public int getId(){return this.id;}

    public int getCapacidadActual() {
        return capacidadActual;
    }

    public void setCapacidadActual(int capacidadActual) {
        this.capacidadActual = capacidadActual;
    }

    public boolean addFamilia(Familia f){
        if (capacidadActual(f.miembros())){
            familias.add(f);
            f.setDiaDesignado(this.getId());
            setCapacidadActual(getCapacidadActual() - f.miembros());
            if (f.getDiaDesignado() > 0){
                bono = bono + (25 + (10 * f.miembros()) + (5 * f.getIndicePreferido()));
            }
            return true;
        }else{
            return false;
        }
    }

    public void remove (int id){
        Familia aux = new Familia(id, 0, new int[3]);
        if (familias.contains(aux)){
            aux = familias.get(familias.indexOf(aux));
            familias.remove(aux);
            bono = bono - (25 + (10 * aux.miembros()) + (5 * aux.getIndicePreferido()));
            this.setCapacidadActual(capacidadActual+aux.miembros());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dia dia = (Dia) o;
        return id == dia.id;
    }

    @Override
    public int compareTo(Dia o) {
        return Integer.compare(id,o.getId());
    }

    public boolean capacidadActual(int cap){
        return capacidadActual >= cap;
    }
    @Override
    public String toString() {
        return "id = " + id +"  Capacidad " + capacidadActual + ", cant fam = " + familias.size();
    }
}

