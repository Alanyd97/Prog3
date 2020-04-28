package sample;
import java.util.ArrayList;
import java.util.Iterator;

public class Main{
    public static void main(String[] args){

        //creado de nodos
        Nodo b = new Nodo(10);
        Nodo a = new Nodo(15);
        Nodo c = new Nodo(11);
        Nodo cbis = new Nodo(12);
        Nodo d = new Nodo(13);
        Nodo e = new Nodo(1);
        Nodo f = new Nodo(11);
        Nodo g = new Nodo(13);
        Nodo h = new Nodo(1);
        Nodo i = new Nodo(14);

        Lista lista = new Lista(null);
        lista.inFirst(i);
        lista.inFirst(h);
        lista.inFirst(g);
        lista.inFirst(e);
        lista.inFirst(f);
        lista.inFirst(d);
        lista.inFirst(a);
        lista.inFirst(cbis);
        lista.inFirst(c);
        lista.inFirst(b);
        Iterator<Integer> original = lista.iterator();
        System.out.println("Lista original:");
        while (original.hasNext()){
            Integer n = original.next();
            if (n != null){
                System.out.print(" -- "+n);
            }
        }
        ArrayList<Integer> secuencias = lista.extraerSecuencia();
        System.out.println(" ");
        System.out.println("Secuencias resultantes:");
        for (Integer n: secuencias) {
            System.out.print(" -- "+n);
        }
    }
}
