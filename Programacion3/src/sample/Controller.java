package sample;
public class Controller {
    public Alumno primero;
    public Controller(){
        primero = new Alumno(null);
    }

    public void setPrimero(Alumno lista) {this.primero = lista;}
    public Alumno getLista() {return primero;}

    public  void inFinal(Alumno a){sFinal(a, primero);}

    private void sFinal(Alumno a, Alumno b){
        Alumno aux = b.getSiguiente();
        if (aux == null){
            aux.setSiguiente(a);
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

}
