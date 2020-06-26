import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Hashing {




    private int m;
    private int n;
    private int rs;
    private int rp;
    private int mTemporal;
    private int frontera;
    private HashMap<Integer, ArrayList<Integer>> hash;
    private double rhoDiseño;
    private ArrayList<Integer> datos;

    public Hashing (int m, int rs, int rp, double rhoDiseño, ArrayList<Integer> datos){
        this.m = m;
        this.rs = rs;
        this.rp = rp;
        this.n = 0;
        this.frontera = 0;
        this.rhoDiseño = rhoDiseño;
        this.mTemporal = this.m;
        this.datos = datos;
        this.hash = new HashMap<>();
        incializarHash();
    }

    public void incializarHash(){
        for (int i = 0; i < this.m ; i++) {
            this.hash.put(i, new ArrayList<Integer>());
        }
    }

    public int h (int dato){
        return dato % this.m;
    }

    public int hPrima(int dato){
        return dato % (2 * this.m);
    }

    //agrega un dato y devuelve el rho temporal
    public double addDato(Integer dato, Integer balde){
        this.hash.get(balde).add(dato);
        this.n = this.n+1;
        return n / (this.mTemporal * this.rp);
    }

    public boolean esMayor(double rhoTemporal){
        return rhoTemporal > this.rhoDiseño;
    }

    public void hashing(ArrayList<Integer> array) {
        Iterator<Integer> iteradorDatos = array.iterator();
        while (iteradorDatos.hasNext() && this.frontera < this.m){
            Integer dato = iteradorDatos.next();
            Integer balde = this.h(dato);
            if (this.frontera > balde){
                System.out.println("entre");
                balde = this.hPrima(dato);
            }
            System.out.println(hash);
            if (esMayor(this.addDato(dato, balde))){
                this.frontera = this.frontera +1;
                this.hash.put(this.mTemporal, new ArrayList<Integer>());
                this.mTemporal++;

                ArrayList<Integer> aux = new ArrayList<>();
                aux.addAll(this.hash.get(frontera-1));
                System.out.println(aux);
                aux.clear();
                hashing(aux);
             }
        }
        if (this.frontera>= this.m){
            this.frontera = 0;
            this.m = this.m*2;
            ArrayList<Integer> aux = new ArrayList<>();
            while (iteradorDatos.hasNext()){
                aux.add(iteradorDatos.next());
            }
            hashing(aux);
        }
    }

    public void printMap(){
        System.out.println(this.hash);
    }

}
