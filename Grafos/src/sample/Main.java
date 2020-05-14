package sample;


import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args){
        GrafoDirigido gd = new GrafoDirigido();
        gd.agregarVertice(0);
        gd.agregarVertice(1);
        gd.agregarVertice(2);
        gd.agregarVertice(3);
        gd.agregarVertice(4);
        gd.agregarVertice(5);
        gd.agregarVertice(6);
        gd.agregarVertice(7);
        gd.agregarVertice(8);
        gd.agregarVertice(9);
        gd.agregarVertice(10);
        gd.agregarVertice(11);
        gd.agregarVertice(12);
        ArrayList<Integer> valores = new ArrayList<>();
        valores.add(0);
        valores.add(4);
        valores.add(18);
        valores.add(4);
        valores.add(13);
        valores.add(22);
        valores.add(18);
        valores.add(12);
        valores.add(3);
        valores.add(2);
        valores.add(3);
        valores.add(1);
        valores.add(5);
        gd.setValores(valores);
        gd.agregarArco(0, 2, 0);
        gd.agregarArco(0, 1, 0);
        gd.agregarArco(1, 3, 3);
        gd.agregarArco(3, 6, 8);
        gd.agregarArco(3, 4, 5);
        gd.agregarArco(4, 11, 3);
        gd.agregarArco(11, 12, 9);
        gd.agregarArco(2, 7, 18);
        gd.agregarArco(2, 5, 1);
        gd.agregarArco(5, 6, 2);
        gd.agregarArco(6, 10, 6);
        gd.agregarArco(6, 12, 2);
        gd.agregarArco(7, 8, 7);
        gd.agregarArco(8, 9, 4);
        gd.agregarArco(9, 10, 1);

        System.out.println("cantidad de vertices: " + gd.cantidadVertices());
        System.out.println("cantidad de arcos: " + gd.cantidadArcos());
        System.out.println("Contiene vertice: 5  " + gd.contieneVertice(5));
        System.out.println("Contiene arco: 0,0  " + gd.existeArco(0, 0));
        System.out.println("Contiene arco: 9,10  " + gd.existeArco(9, 10));
        System.out.println("Obtener etiqueta: 9,10  " + gd.obtenerArco(9, 10).getEtiqueta());
        Iterator n = gd.obtenerVertices();
        System.out.println("------------------------------");
        System.out.println("Id vertices: ");
        while (n.hasNext()){
            System.out.print(n.next()+" | ");
        }
        System.out.println(" ");
        n = gd.obtenerArcos();
        System.out.println("------------------------------");
        System.out.println("Id arcos: ");
        while (n.hasNext()){
            Arco a = (Arco) n.next();
            System.out.println("Ori:"+a.getVerticeOrigen()+" Dest:"+a.getVerticeDestino());
        }
        System.out.println(" ");
        n = gd.obtenerAdyacentes(6);
        System.out.println("------------------------------");
        System.out.println("Adyacentes de "+6+": ");
        while (n.hasNext()){
            System.out.print(n.next()+" | ");
        }
        System.out.println("  ");
        Iterator arc = gd.obtenerArcos(3);
        System.out.println("------------------------------");
        System.out.println("Arcos de "+3+": ");
        while (arc.hasNext()){
            Arco ar = (Arco) arc.next();
            System.out.print("Orig:"+ ar.getVerticeOrigen()+" Dest:"+ar.getVerticeDestino()+" | ");
        }
        System.out.println(" ");
        System.out.println("------------------------------");
        System.out.println("Vertice a eliminar: 6");
        System.out.println("Vertices previos");
        n = gd.obtenerVertices();
        while (n.hasNext()){
            System.out.print(n.next()+" | ");
        }
        gd.borrarVertice(6);
        System.out.println("    ");
        System.out.println("Vertices actuales");
        n = gd.obtenerVertices();
        while (n.hasNext()){
            System.out.print(n.next()+" | ");
        }
        System.out.println("    ");
        System.out.println("------------------------------");
        System.out.println("Arcos actuales");
        n = gd.obtenerArcos();
        System.out.println("Id arcos: ");
        while (n.hasNext()){
            Arco a = (Arco) n.next();
            System.out.println("Ori:"+a.getVerticeOrigen()+" Dest:"+a.getVerticeDestino());
        }
        System.out.println("------------------------------");
        gd.borrarArco(11,12);
        System.out.println("Arcos borrados: 11, 12");
        System.out.println("Arcos actuales");
        n = gd.obtenerArcos();
        System.out.println("Id arcos: ");
        while (n.hasNext()){
            Arco a = (Arco) n.next();
            System.out.println("Ori:"+a.getVerticeOrigen()+" Dest:"+a.getVerticeDestino());
        }
    }


}
