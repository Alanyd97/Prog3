package sample;

public class Nodo{

    private Nodo siguiente;
    private Integer miID = 0;


    public Nodo(Integer id){
        miID=id;
    }
    

    public Integer getMiID() {return miID;}
    public void setSiguiente(Nodo siguiente) { this.siguiente = siguiente; }
    public Nodo getSiguiente() { return siguiente; }

}
