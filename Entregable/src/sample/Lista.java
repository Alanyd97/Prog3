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
    public Nodo inSec(Iterator<Nodo> i){
        if (i.hasNext()){
            Nodo aux = i.next();
            if (!aux.soyMenor(aux.getSiguiente())){
                return inSec(i);
            }else return aux;
        }else return null;
    }

    public Nodo finSec(Iterator<Nodo> i){
        Nodo aux = i.next();
        if (i.hasNext()){
            if (aux.soyMenor(aux.getSiguiente())){
                return finSec(i);
            }else{
                return aux;
            }
        }else{
            return aux;
        }
    }

    public Nodo extraerSecuencia(){
        Iterator<Nodo> iterador = this.iterator();
        if (iterador.hasNext()){ //si el siguiente del inicio de secuencia es distinto de nulo
            Nodo inicio = this.inSec(iterador);
            Nodo ultimo = this.finSec(iterador); // busco el final de secuencia
            if(iterador.hasNext()){
                this.setPrimero(ultimo.getSiguiente());
                ultimo.setSiguiente(extraerSecuencia());
                return inicio;
            }else{
                return inicio;
            }
        }else{
            return null;
        }
    }

    @Override
    public Iterator<Nodo> iterator() {
        return new MyIterator(this.primero);
    }
}
