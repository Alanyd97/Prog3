package sample;

public class Nodo {
    private Nodo mayores;
    private  Nodo menores;
    private int id;

    public Nodo(int id) {
        this.mayores = null;
        this.menores = null;
        this.id = id;
    }

    // getter & setter
    public void setId(int id) {this.id = id; }
    public void setMayores(Nodo mayores) {this.mayores = mayores; }
    public void setMenores(Nodo menores) {this.menores = menores; }
    public int getId() {return id; }
    public Nodo getMayores() {return mayores; }
    public Nodo getMenores() {return menores;}
    //--------------------

    //retorna si el nodo actual es mayor al parametro
    public boolean nodoMayor(Nodo a){return this.getId() > a.getId();}
    public boolean nodoIgual(Nodo a){return this.getId()==a.getId();}


}
