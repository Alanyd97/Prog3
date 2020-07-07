import java.util.ArrayList;
import java.util.Arrays;

public class Dia {
    private ArrayList<Familia> familias;
    private final static int capacidad = 340;
    private int capacidadActual;
    private int cantFamilias;
    private int bono;
    private int cantMiembros;
    private int id;

    public Dia(int id){
        familias = new ArrayList<>();
        bono=0;
        capacidadActual = capacidad;
        cantFamilias = 0;
        cantMiembros = 0;
        this.id = id;
    }

    public int getCapacidadActual() {
        return capacidadActual;
    }

    public int getId(){return this.id;}

    public void setCapacidadActual(int capacidadActual) {
        this.capacidadActual = capacidadActual;
    }

    public boolean addFamilia(Familia f, int indice){
        if (capacidadActual(f.miembros())){
            cantMiembros = cantMiembros + f.miembros();
            cantFamilias++;
            familias.add(f);
            f.setDesignado(this.id);
            if (indice > 0){
                bono = this.getBono() + 25 +(10 * f.miembros()) + (5 * indice );
            }
            setCapacidadActual(getCapacidadActual() - f.miembros());
            return true;
        }else{
            return false;
        }
    }

    public int getBono() {return this.bono;}

    public int getCantFamilias(){return cantFamilias;}

    public boolean capacidadActual(int cap){
        return capacidadActual >= cap;
    }
    @Override
    public String toString() {
        return "Capacidad=" + capacidadActual + ", cant fam=" + this.cantMiembros;
    }
}