package sample;
import java.util.ArrayList;
import java.util.Iterator;

public class Main{
    public static void main(String[] args){

        Lista lista = new Lista(12);
        lista.inFirst(10);
        lista.inFirst(11);
        lista.inFirst(12);
        lista.inFirst(12);
        lista.inFirst(13);
        lista.inFirst(1);
        lista.inFirst(11);
        lista.inFirst(13);
        lista.inFirst(2);
        lista.inFirst(14);
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
