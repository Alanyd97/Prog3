package sample;

import java.util.Iterator;

public class MyIterator implements  Iterator<Nodo>{
    private Nodo a;
    public MyIterator(Nodo b){
        a=b;
    }
    public Nodo next(){
        Nodo next = a;
        a = a.getSiguiente();
        return next;
    }
    public boolean hasNext(){
        return a != null;
    }

}