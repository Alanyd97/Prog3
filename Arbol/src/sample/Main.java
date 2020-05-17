package sample;
import java.io.*;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args){
        BufferedReader entrada = new BufferedReader( new InputStreamReader(System.in));
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
        try{
            Integer nivel;
            System.out.println("Ingresar nivel del arbol: ");
            nivel = new Integer(entrada.readLine());
            ArrayList<Integer> lista = arbol.getElementAtLvl(nivel);
            if (!(lista.isEmpty())){
                System.out.println("Los elementos del nivel "+nivel+" son: ");
                for (Integer a: lista
                ) {
                    System.out.print(" | "+a+" | ");
                }
            }else{
                System.out.println("no hay elementos a ese nivel");
            }
            System.out.println();
        }catch (Exception e){
            System.out.println(e);
        }
        try{
            Integer borrar;
            borrar = new Integer(entrada.readLine());
            while (!(borrar == 0)){
                System.out.println("Ingresar elemento a borrar: ");
                borrar = new Integer(entrada.readLine());
                System.out.println("Elementos previos:");
                arbol.inOrder();
                System.out.println("Elementos actuales: ");
                System.out.println("Borrado: "+arbol.eliminar(borrar));
                arbol.inOrder();
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }


}
