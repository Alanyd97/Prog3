package sample;
public class Alumno {

    private Alumno siguiente;
    private static Alumno ultimo;
    private static int id = 0;
    private int miID = 0;


    public Alumno(){
        siguiente = null;
        id = id+1;
        miID=id;
    }


    public static void setId(int id) {
        Alumno.id = id;
    }
    public void setMiID(int id){this.miID = id;}

    public int getMiID() {return miID;}
    public void setSiguiente(Alumno siguiente) { this.siguiente = siguiente; }
    public static void setUltimo(Alumno u) {ultimo = u;}
    public Alumno getSiguiente() { return siguiente; }
    public static Alumno getUltimo() { return Alumno.ultimo; }

    public Alumno alumnoIgual(Alumno a){
        if (equals(a)){ return this;}
        else{return null;}
    }

    public boolean equals(Object obj) {
        if (obj instanceof Alumno){
            Alumno a = (Alumno) obj;
            return a.getMiID() == getMiID();
        }else { return false;}
    }
}
