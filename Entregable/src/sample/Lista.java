package sample;

import java.util.Iterator;

public class Lista  implements Iterable<Nodo>{
    public Nodo primero;

    public Lista(Nodo a){
        primero = a;
    }

    public void setPrimero(Nodo lista) {this.primero = lista;}

    public void inFirst(Nodo a){
        a.setSiguiente(this.primero);
        this.primero = a;
    }

    //busca el inicio de la secuencia
    public Nodo inSec(Nodo lista, Iterator<Nodo> i){
        if (i.hasNext()){
            Nodo aux = i.next();
            if (!lista.soyMenor(lista.getSiguiente())){
                i.next();
                return inSec(lista.getSiguiente(),i);
            }else return lista;
        }else return lista;
    }

    public Nodo finSec(Nodo lista, Iterator<Nodo> i){
        if (i.hasNext()){
            if (lista.getMiID() < lista.getSiguiente().getMiID()){
                this.setPrimero(i.next());
                return finSec(lista.getSiguiente(), i);
            }else{
                return lista;
            }
        }else{
            return lista;
        }
    }

    public Nodo extraerSecuencia(){
        Iterator<Nodo> iterador = this.iterator();
        Nodo inicio = this.inSec(iterador.next(), iterador);
        if (inicio.getSiguiente() != null){ //si el siguiente del inicio de secuencia es distinto de nulo
            Nodo ultimo = this.finSec(inicio, iterador); // busco el final de secuencia
            if(iterador.hasNext()){
                ultimo.setSiguiente(extraerSecuencia());
            }
            return inicio;
        }else{
            return null;
        }
    }

    @Override
    public Iterator<Nodo> iterator() {
        return new MyIterator(this.primero);
    }
}
