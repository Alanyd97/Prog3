package sample;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {
    private ArrayList<Vertice> vertices;
    private int tiempo;
    private final int visitado = 1;
    private  final int noVisitado = 0;

    public GrafoDirigido(){
        vertices = new ArrayList<>();
    }

    //
    @Override
    public void agregarVertice(int verticeId) {
        vertices.add(new Vertice(verticeId));
    }

    @Override
    public void borrarVertice(int verticeId) {
        Vertice aux = new Vertice(0);
        for (Vertice vert: vertices){
            if (vert.getId() == verticeId){
                aux = vert;
            }
        }
        vertices.remove(aux);
        eliminarArcos(verticeId);
    }

    private void eliminarArcos(int n){
        for (Vertice v: vertices){
            v.eliminarArco(n);
        }
    }
    //
    public void setValores (ArrayList<Integer> valores){
        for (int i = 0; i < vertices.size()-1 ; i++) {
            vertices.get(i).setValor(valores.get(i));
        }
    }

    //
    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        Vertice v1 = new Vertice(verticeId1);
        Vertice v2 = new Vertice(verticeId2);
        if (vertices.contains(v1) && vertices.contains(v2)){
                Arco a = new Arco(verticeId1, verticeId2, etiqueta);
                Vertice v = vertices.get(getI(v1));
                v.addArco(a);
        }
    }

    private int getI(Vertice n){
        for (int i = 0; i < vertices.size()-1; i++) {
            if (vertices.get(i).equals(n)){
                return i;
            }
        }
        return -111;
    }


    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        Vertice aux = vertices.get(vertices.indexOf(new Vertice(verticeId1)));
        aux.eliminarArco(verticeId2);
    }

    //
    @Override
    public boolean contieneVertice(int verticeId) {
        Vertice<T> v = new Vertice<>(verticeId);
        return vertices.contains(v);
    }

    //
    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        for (Vertice v: vertices) {
            if (v.hasArco(verticeId1, verticeId2)){
                return true;
            }
        }
        return false;
    }

    //
    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        for (Vertice v : vertices) {
            if (v.hasArco(verticeId1, verticeId2)){
                return v.getArco(verticeId1,verticeId2);
            }
        }
        return null;
    }


    //
    @Override
    public int cantidadVertices() {
        return vertices.size();
    }

    //
    @Override
    public int cantidadArcos() {
        int count = 0;
        for (Vertice v: vertices) {
            count = count + v.cantidadArcos();
        }
        return count;
    }


    //
    @Override
    public Iterator<Integer> obtenerVertices() {
        ArrayList<Integer> aux = new ArrayList<>();
        for (Vertice n: vertices) {
            aux.add(n.getId());
        }
        return aux.iterator();
    }


    //
    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        ArrayList<Integer> arcos = new ArrayList<>();
        for (Vertice v: vertices) {
            if (v.getId() == verticeId){
                ArrayList<Arco<T>> a = new ArrayList<>();
                a = v.getArcos();
                for (Arco<T> arc: a){
                    arcos.add(arc.getVerticeDestino());
                }
                return arcos.iterator();
            }
        }
        return null;
    }

    //
    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        ArrayList<Arco<T>> arcos = new ArrayList<>();
        for (Vertice v: vertices) {
            arcos.addAll(v.getArcos());
        }
        return arcos.iterator();
    }

    //
    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId)    {
        ArrayList<Arco<T>> a = new ArrayList<>();
        for (Vertice v : vertices) {
            if (v.getId() == verticeId){
                a.addAll(v.getArcos());
                return a.iterator();
            }
        }
        return null;
    }



    //Blanco(No visitado) =-1
    //Amarillos(Visitado no calculado) = 0
    //Negro(Visitado) = 1
    public void setBlancos(){
        for (Vertice v: vertices){
            v.setColor(noVisitado);
        }
    }

    public ArrayList<Integer> dfs(int n) {
        ArrayList<Integer> camino = new ArrayList<>();
        ArrayList<Integer> mayor = new ArrayList<>();
        camino.add(n);
        int[] maxDuracion = new int[1];
        maxDuracion[0] = 0;
        dfs_visit(n, camino, 0, mayor, maxDuracion);
        return mayor;

    }

    // O(vertices) ya que va a recorrer todos los vertices de grafo
    private void dfs_visit(int actual, ArrayList<Integer> camino, int suma,ArrayList<Integer> mayor, int[] maxDuracion) {
        if (getVertice(actual).getArcos().size() != 0) {
            Iterator<Arco<T>> arcos = obtenerArcos(actual);
            while (arcos.hasNext()) {
                Arco<T> a = arcos.next();
                camino.add(a.getVerticeDestino());
                suma += (Integer) a.getEtiqueta();
                suma += getVertice(a.getVerticeDestino()).getValor();
                dfs_visit(a.getVerticeDestino(), camino, suma, mayor, maxDuracion);
                camino.remove(camino.size()-1);
                suma -= (Integer) a.getEtiqueta();
                suma -= getVertice(a.getVerticeDestino()).getValor();
            }
        } else {
            System.out.println(suma);
            if (suma > maxDuracion[0]) {
                maxDuracion[0] = suma;
                mayor.clear();
                mayor.addAll(camino);
            }
        }
    }

    private Vertice getVertice(int verticeid){
        for (Vertice v: vertices ){
            if (v.getId() == verticeid){
                return v;
            }
        }
        return null;
    }

}
