package sample;
import java.io.BufferedReader;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args){
        Arbol arbol = new Arbol();
        arbol.generarArbolRandom();
        //Recorridos en Orden
        System.out.println("InOrder:");
            arbol.inOrder();
        System.out.println("PreOrder:  ");
            arbol.preOrder();
        System.out.println("PosOrder:  ");
            arbol.posOrder();

        //Conslutas simples
        System.out.println("Is empty: "+arbol.isEmpty());
        System.out.println("Get Max Element: "+arbol.getMaxElem());
        int n = 4;
        System.out.println("Elemento a buscar "+n);
        System.out.println("Has element: "+arbol.hasElem(n));
        System.out.println("Altura:"+ arbol.getAltura());
        System.out.println("----------------------------------------------------------");
        System.out.println("Fronteras:");
        for (Integer a: arbol.getFrontera()
             ) {
            System.out.print(a+ "/");
        }
        System.out.println(" ");
        System.out.println("----------------------------------------------------------");
        System.out.println("Get longest branch:");
        for (Integer a: arbol.getRamaMasLarga()
             ) {
            System.out.print(a+" | ");
        }System.out.println(" ");
    }
}
