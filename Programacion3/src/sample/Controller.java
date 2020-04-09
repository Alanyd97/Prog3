package sample;
public class Controller {
    public Alumno primero;
    public Controller(){
        primero = new Alumno();
        primero.setUltimo(primero);
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
                System.out.println("ultimo id: "+b.getUltimo().getMiID());
                inFinal(a);
            }else{
                inMedio(a, b);
            }
        }


    }

}
