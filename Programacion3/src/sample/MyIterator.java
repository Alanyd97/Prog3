package sample;

import java.util.Iterator;

public class MyIterator implements Iterator<Object>{
    private Alumno a;
    public MyIterator(Alumno b){
        a=b;
    }
    public Alumno next(){
        Alumno next = a;
        a = a.getNext();
        return next;
    }
    public boolean hasNext(){
        return a.getNext() != null;
    }
}
