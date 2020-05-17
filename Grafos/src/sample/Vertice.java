package sample;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class Vertice<T> {
    private ArrayList<Arco<T>> arcos;
    private int valor;
    private int color;
    public int id;
    private int d;
    private int f;

    public Vertice (int id){
        arcos = new ArrayList<Arco<T>>();
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vertice)) return false;
        Vertice vertice = (Vertice) o;
        return getId() == vertice.getId();
    }

    public void addArco(Arco a){
        arcos.add(a);
    }

    public boolean hasArco(int a, int b){
        Arco arco = new Arco(a, b, null);
        return arcos.contains(arco);
    }

    public Arco<T> getArco(int a, int b){
        for (Arco<T> arco : arcos ) {
            if (arco.getVerticeOrigen() == a && arco.getVerticeDestino() == b){
                return arco;
            }
        }
        return null;
    }

    public int cantidadArcos(){ return arcos.size();}

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public ArrayList<Arco<T>> getArcos(){
        ArrayList<Arco<T>> aux = arcos;
        return aux;
    }

    public void eliminarArco(int n){
        Arco ar = new Arco(0,0,0);
        for (Arco a: arcos) {
            if (a.getVerticeDestino() == n){
                ar=a;
            }
        }
        arcos.remove(ar);
    }
}
