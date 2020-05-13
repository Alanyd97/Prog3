package sample;

import java.util.ArrayList;

public class Vertice {
    private ArrayList<Arco> arcos;
    private int valor;
    private int color;
    private int d;
    private int f;

    public Vertice (int n){
        arcos = new ArrayList<Arco>();
        int valor = n;
    }

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
}
