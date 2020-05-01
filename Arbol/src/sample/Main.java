package sample;


public class Main {

    public static void main(String[] args){

        Arbol arbol = new Arbol(20);
        arbol.insert(12);
        arbol.insert(15);
        arbol.insert(30);
        arbol.insert(50);
        arbol.insert(2);
        arbol.insert(8);
        arbol.insert(29);
        arbol.insert(10);
        arbol.insert(28);
        arbol.insert(60);
        arbol.insert(26);

        arbol.inOrder();
        System.out.println(arbol.hasElem(15));

        System.out.println(arbol.eliminar(8)+" ||");

        arbol.inOrder();

    }
}
