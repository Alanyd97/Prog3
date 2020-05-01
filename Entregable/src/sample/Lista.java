package sample;

import java.util.ArrayList;
import java.util.Iterator;

public class Lista  implements Iterable<Integer>{
    private Nodo primero;

    public Lista(Integer a){
        primero = new Nodo(a);
    }

    public void setPrimero(Integer a) {this.primero.setSiguiente(new Nodo(a));}

    public void inFirst(Integer a){
        Nodo b = new Nodo(a);
        b.setSiguiente(this.primero);
        this.primero = b;
    }

    public ArrayList<Integer> getSecuencias(ArrayList<Integer> a){
        ArrayList<Integer> aux = new ArrayList<>();
        for (int i = 0; i < a.size() ; i++) {
                if(((i+1) < a.size()-1) && (a.get(i) < a.get(i+1))){
                    aux.add(a.get(i));
                    aux.add(a.get(i+1));
                    i=i+1;
                }
        }
        return aux;
    }

    public ArrayList<Integer> extraerSecuencia(){
        Iterator<Integer> iterador = this.iterator();
        ArrayList<Integer> array = new ArrayList<>();
        while(iterador.hasNext()) {
            array.add(iterador.next());
        }
        array= this.getSecuencias(array);
        return array;
    }



    @Override
    public Iterator<Integer> iterator() {
        return new MyIterator(this.primero);
    }
}
