package sample;

import java.util.ArrayList;

public class Arbol {
    private Nodo raiz;

    public Arbol(Integer a) { this.raiz = new Nodo(a);}

    //getter & setter
    public Object getRaiz() {return raiz.getInfo(); }

    public void insert(Integer a){
        this.raiz.insertar(a);
    }

    public boolean isEmpty(){
        return raiz == null;
    }

    public void inOrder(){
        this.raiz.inOrder();
    }

    public boolean hasElem(int n){
        return this.raiz.hasElem(n);
    }

    public ArrayList<Integer> getFrontera(){
        return this.raiz.getFrontera();
    }
    //element at lvl complejidad o(n)

    public int getMaxElem(){
       return this.raiz.getMaxElem();
    }

    public int getAltura(){
        return this.raiz.getAltura(raiz);
    }

    public ArrayList<Integer> getElementAtLvl(int n){
        return raiz.getElementAtLvl(n, 0);
    }

    public ArrayList<Integer> getRamaMasLarga(){
        return this.raiz.getRamaMasLarga(raiz);
    }
    public boolean eliminar(int n){
         return this.raiz.eliminar(n);
    }



}
