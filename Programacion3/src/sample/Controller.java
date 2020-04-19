package sample;

import java.util.Iterator;

public class Controller implements Iterable<Object>{
    public Alumno primero;

    public Controller(){
        primero.setId(9);
        primero = new Alumno();
        primero.setUltimo(primero);
        primero.setId(2);
    }

    public void setPrimero(Alumno lista) {this.primero = lista;}
    public Alumno getPrimero() {return primero;}

    public  void inFinal(Alumno a){sFinal(a, primero);}

    private void sFinal(Alumno a, Alumno b){
        Alumno aux = b.getNext();
        if (aux == null){
            b.setSiguiente(a);
            b.setUltimo(a);
        }else {
            sFinal(a, aux);
        }
    }

    public void inFirst(Alumno a){
        a.setSiguiente(this.primero);
        this.primero = a;
    }

    public void delFront(){
        Alumno aux = primero.getNext();
        primero.setSiguiente(null);
        primero = aux;
    }

    public  Alumno getIndex(int n){
        return sIndex(n, primero);
    }

    private Alumno sIndex(int n, Alumno b){
        Alumno aux = b;
        if (b != null){
            if (n == aux.getMiID()){
                return aux;
            }else{
                aux = aux.getNext();
                return sIndex(n, aux);
            }
        }else{return null;}
    }

    public void inMedio(Alumno a, Alumno b){
        Alumno aux = b;
        if (a.getMiID() < aux.getNext().getMiID()){
            a.setSiguiente(aux.getNext());
            aux.setSiguiente(a);
        }else{
            aux = aux.getNext();
            inMedio(a, aux);
        }
    }

    public void inOrdenado(Alumno a, Alumno b){
        if(a.getMiID()< b.getMiID()){
            inFirst(a);
        }else{
            if (a.getMiID()> b.getUltimo().getMiID()){
                inFinal(a);
            }else{
                inMedio(a, b);
            }
        }
    }

    public Alumno busca(int a, Alumno b){
        if (b != null){
            if (a == b.getMiID()){
                return b;
            }else{
                return busca(a, b.getNext());}
        }else{return null;}
    }

    public Alumno extrae(int n, Alumno a){
        if (a.getNext() != null){
            if (a.getNext().getMiID() == n){
                return removeMedio(a);
            }else{return extrae(n, a.getNext()); }
        }else{
            return null;
        }
    }

    //le dan el nodo anterior al cual eliminar y lo devuelve ya quitado
    private Alumno removeMedio(Alumno a){
        Alumno aux = a.getNext();
        a.setSiguiente(a.getNext().getNext());
        return aux;
    }


    //EJERCICIO ENTREGABLE

    public Alumno inSec(Alumno lista){
        if (lista.getNext() != null){//supongo que siempre le voy a pasar un puntero != null
            if (lista.getMiID() >= lista.getNext().getMiID()){
                return inSec(lista.getNext());
            }else{
                return lista;
            }
        }else{
            return lista;
        }
    }

    public Alumno finSec(Alumno lista){
       if (lista.getNext()!=null){
           if (lista.getMiID() < lista.getNext().getMiID()){
               return finSec(lista.getNext());
           }else{
               return lista;
           }
       }else{
           return lista;
       }
    }

    public Alumno extraerSecuencia(){
        Alumno primero = inSec(this.getPrimero());
        if (primero.getNext() != null){ //si el siguiente del inicio de secuencia es distinto de nulo
            Alumno ultimo = this.finSec(primero); // busco el final de secuencia
            if (this.getPrimero().getMiID() == primero.getMiID()){
                this.setPrimero(ultimo.getNext());
            }else{
                Alumno aux = this.getPrimero();
                while (aux.getNext().getMiID() != primero.getMiID()){
                    aux = aux.getNext();
                }
               aux.setSiguiente(ultimo.getNext());
            }
            ultimo.setSiguiente(null);
            return primero;
        }else{
            return null;
        }
    }

    public Iterator<Object> iterator(){
        return new MyIterator(this.primero);
    }

}
