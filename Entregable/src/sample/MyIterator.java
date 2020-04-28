package sample;

import java.util.Iterator;

public class MyIterator implements  Iterator<Integer>{
    private Nodo a;
    public MyIterator(Nodo b){
        a=b;
    }

    public Integer next(){
        Integer next = a.getMiID();
        a = a.getSiguiente();
        return next;
    }

    public boolean hasNext(){
        return a != null;
    }


}