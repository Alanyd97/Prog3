import java.util.ArrayList;
import java.util.Arrays;

public class Dia {
    private ArrayList<Familia> familias;
    private final static int capacidad = 30;
    private int capacidadActual;
    private int id;

    public Dia(int a){
        familias = new ArrayList<>();
        id=a;
        capacidadActual = capacidad;
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
            setCapacidadActual(getCapacidadActual() - f.miembros());
            return true;
        }else{
            return false;
        }
    }

    public boolean capacidadActual(int cap){
        return capacidadActual >= cap;
    }
    @Override
    public String toString() {
        return "id = " + id +"  Capacidad " + capacidadActual + ", cant fam = " + familias.size();
    }
}

