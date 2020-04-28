package sample;


public class Main {

    public static void main(String[] args){
        Nodo a = new Nodo(20);
        Nodo b = new Nodo(10);
        Nodo c = new Nodo(15);
        Nodo d = new Nodo(30);
        Nodo e = new Nodo(50);
        Nodo f = new Nodo(2);
        Nodo g = new Nodo(8);
        Nodo h = new Nodo(21);

        Arbol arbol = new Arbol(a);
        arbol.insert(b);
        arbol.insert(c);
        arbol.insert(d);
        arbol.insert(e);
        arbol.insert(f);
        arbol.insert(g);
        arbol.insert(h);

        arbol.inOrder(arbol.getRaiz());


    }
}
