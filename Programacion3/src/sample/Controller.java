package sample;
public class Controller {
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
        Alumno aux = b.getSiguiente();
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
        Alumno aux = primero.getSiguiente();
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
                aux = aux.getSiguiente();
                return sIndex(n, aux);
            }
        }else{return null;}
    }

    public void inMedio(Alumno a, Alumno b){
        Alumno aux = b;
        if (a.getMiID() < aux.getSiguiente().getMiID()){
            a.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(a);
        }else{
            aux = aux.getSiguiente();
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
                return busca(a, b.getSiguiente());}
        }else{return null;}
    }

    public Alumno extrae(int n, Alumno a){
        if (a.getSiguiente() != null){
            if (a.getSiguiente().getMiID() == n){
                return removeMedio(a);
            }else{return extrae(n, a.getSiguiente()); }
        }else{
            return null;
        }
    }

    //le dan el nodo anterior al cual eliminar y lo devuelve ya quitado
    private Alumno removeMedio(Alumno a){
        Alumno aux = a.getSiguiente();
        a.setSiguiente(a.getSiguiente().getSiguiente());
        return aux;
    }

    //EJERCICIO ENTREGABLE

    public Alumno inSec(Alumno lista){
        if (lista.getSiguiente() != null){//supongo que siempre le voy a pasar un puntero != null
            if (lista.getMiID() >= lista.getSiguiente().getMiID()){
                return inSec(lista.getSiguiente());
            }else{
                return lista;
            }
        }else{
            return lista;
        }
    }

    public Alumno finSec(Alumno lista){
       if (lista.getSiguiente()!=null){
           if (lista.getMiID() < lista.getSiguiente().getMiID()){
               return finSec(lista.getSiguiente());
           }else{
               return lista;
           }
       }else{
           return lista;
       }
    }

    public Alumno extraerSecuencia(){
        Alumno primero = inSec(this.getPrimero());
        if (primero.getSiguiente() != null){ //si el siguiente del inicio de secuencia es distinto de nulo
            Alumno ultimo = this.finSec(primero); // busco el final de secuencia
            if (this.getPrimero().getMiID() == primero.getMiID()){
                this.setPrimero(ultimo.getSiguiente());
            }else{
                Alumno aux = this.getPrimero();
                while (aux.getSiguiente().getMiID() != primero.getMiID()){
                    aux = aux.getSiguiente();
                }
               aux.setSiguiente(ultimo.getSiguiente());
            }
            ultimo.setSiguiente(null);
            return primero;
        }else{
            return null;
        }
    }
}
