package sample;
import java.util.Iterator;

public class Main{
    public static void main(String[] args){

        //creado de nodos
        Nodo b = new Nodo(10);
        Nodo a = new Nodo(15);
        Nodo c = new Nodo(11);
        Nodo d = new Nodo(13);
        Nodo e = new Nodo(1);
        Nodo f = new Nodo(11);
        Nodo g = new Nodo(13);
        Nodo h = new Nodo(1);
        Nodo i = new Nodo(111);

        Lista lista = new Lista(null);
        lista.inFirst(i);
        lista.inFirst(h);
        lista.inFirst(g);
        lista.inFirst(e);
        lista.inFirst(f);
        lista.inFirst(d);
        lista.inFirst(c);
        lista.inFirst(b);
        lista.inFirst(a);

        Iterator<Nodo> iterador = lista.iterator();
        while (iterador.hasNext()){
            Nodo ab = iterador.next();
            System.out.println(ab.getMiID());
            System.out.println("-------------");
        }
        System.out.println("-------------");
        Nodo nos = lista.extraerSecuencia();
        while(nos != null){
            System.out.println("secuencia "+nos.getMiID());
            nos=nos.getSiguiente();
            System.out.println("-------------");
        }
    }
}
