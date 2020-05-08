package sample;

import java.util.ArrayList;

public class Nodo {
    private Nodo mayores;
    private  Nodo menores;
    private int id;

    public Nodo(int id) {
        this.mayores = null;
        this.menores = null;
        this.id = id;
    }

    // getter & setter
    public void setInfo(int id) {this.id = id; }
    public void setMayores(Nodo mayores) {this.mayores = mayores; }
    public void setMenores(Nodo menores) {this.menores = menores; }
    public int getInfo() {return id; }
    public Nodo getMayores() {return mayores;}
    public Nodo getMenores() {return menores;}



}
