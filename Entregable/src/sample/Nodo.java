package sample;

public class Nodo{

    private Nodo siguiente;
    private int miID = 0;


    public Nodo(int id){
        miID=id;
    }
    

    public int getMiID() {return miID;}
    public void setSiguiente(Nodo siguiente) { this.siguiente = siguiente; }
    public Nodo getSiguiente() { return siguiente; }
    public boolean soyMenor(Nodo a){
        return this.getMiID() < a.getMiID();
    }

}
