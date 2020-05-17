package sample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class Arbol {
    private Nodo raiz;

    public Arbol() {raiz = null;}

    //getter & setter
    //Complejidad O(1) yaque accede a un solo elemento
    public Integer getRaiz() {
        if (isEmpty()){
            return raiz.getInfo();
        }else return -1;
    }

    public void generarArbolRandom(){
        int contador = 15;
        if (isEmpty()){
            raiz = new Nodo(ThreadLocalRandom.current().nextInt(0, 40+1));
        }
        while (contador != 0){
            int n = ThreadLocalRandom.current().nextInt(0, 40+1);
            if (!(this.hasElem(n))){
                System.out.println("elemento"+n);
                insert(n);
                contador--;
            }

        }
    }

    //Todos y cada uno de estos 3 recorridos tienen como complejidad
    // o(n)/n=cantidad nodos
    public void inOrder(){
        inOrder(this.raiz);
        System.out.println("       ");
        System.out.println("----------------------------------------------------------");
    }
    public void preOrder(){
        System.out.println("Raiz: "+raiz.getInfo());
        preOrder(this.raiz);
        System.out.println("       ");
        System.out.println("----------------------------------------------------------");
    }
    public void posOrder(){
        posOrder(this.raiz);
        System.out.println("       ");
        System.out.println("----------------------------------------------------------");
    }


    private void inOrder(Nodo a){
        if (a.getMenores() != null){
            inOrder(a.getMenores());
        }
        System.out.print(a.getInfo()+" | ");
        if (a.getMayores() != null){
           inOrder( a.getMayores());
        }
    }

    private void posOrder(Nodo a){
        if (a.getMenores() != null){
            inOrder(a.getMenores());
        }
        if (a.getMayores() != null){
            inOrder( a.getMayores());
        }
        System.out.print(a.getInfo()+" | ");
    }

    private void preOrder(Nodo a){
        System.out.print(a.getInfo()+" | ");
        if (a.getMayores() != null){
            inOrder(a.getMayores());
        }
        if (a.getMenores() != null){
            inOrder(a.getMenores());
        }
    }

    public void insert(Integer a){
        insertar(a, raiz);
    }

    // Complejidad O(log n), en el peor caso debera recorrer una parte del
    // arbol, menores o mayores, para encontrar la info
    private void insertar(int n, Nodo a) { // agrega ordenado con busqueda recursiva segun el nodo y los punteros del mismo
        if (n < a.getInfo()) {
            if (a.getMenores() == null) {
                a.setMenores(new Nodo(n));
            } else {
                insertar(n, a.getMenores());
            }
        } else if (n > a.getInfo()) {
            if(n > a.getInfo()){
                if (a.getMayores() == null){
                    a.setMayores(new Nodo(n));
                }
                else insertar(n, a.getMayores());
            }
        }else{
            a.setInfo(n);
        }
    }

    //complejidad o(1) ya que accede a un solo elemento
    public boolean isEmpty(){
        return raiz == null;
    }

    // la complejidad es O(n) en el peor caso recorre todo el arbol
    public boolean hasElem(int n){
        return hasElem(n, this.raiz);
    }

    private boolean hasElem(int n, Nodo a) { //busqueda recursiva que devuelve un boolean si  encuentra el elemento en el arbol
        if(a.getInfo() == n) {
            return true;
        }else {
            if(n < a.getInfo()) {
                if(a.getMenores() == null) {
                    return false;
                }else {
                    return hasElem(n, a.getMenores());
                }
            }else {
                if(a.getMayores() == null) {
                    return false;
                }else {
                    return hasElem(n, a.getMayores());
                }
            }
        }
    }


    public ArrayList<Integer> getFrontera(){
        return getFrontera(this.raiz);
    }

    //O(n)/n=cantidad de nodos, si o si recorre el arbol entero
    private ArrayList<Integer> getFrontera(Nodo a){
        ArrayList<Integer> aux = new ArrayList<>();
        if(a.getMenores() != null) {
            aux.addAll(getFrontera(a.getMenores()));
            if(a.getMayores() != null) {
                aux.addAll(getFrontera(a.getMayores()));
            }
        } else if(a.getMayores() != null) {
            aux.addAll(getFrontera(a.getMayores()));
        }else {
            aux.add(a.getInfo());
        }
        return aux;
    }

    public int getMaxElem(){
       return getMaxElem(this.raiz);
    }

    //O(n)/n= cantidad de nodos de la rama mas menor del derecho
    private int getMaxElem(Nodo a){
        if (a.getMayores() != null){
            return getMaxElem(a.getMayores());
        }else{
            return a.getInfo();
        }
    }

    //O(n)/n= cantidad de nodos, ya que en el peor de los casos
    //recorreria todo el arbol hasta encontrar la altura
    public int getAltura(){
        return getAltura(raiz);
    }

    private int getAltura(Nodo a) {
        if (a == null) {
            return 0;
        }
        int men = getAltura(a.getMenores());
        int may = getAltura(a.getMayores());
        if (men>may){
            return men+1;
        }
        else {
            return may+1;
        }
    }

    //O(n) en el peor caso seria n=Altura entonces recorreria todo el arbol
    public ArrayList<Integer> getElementAtLvl(int lvl){
        return getElementAtLvl(lvl,0, raiz);
    }

    private ArrayList<Integer> getElementAtLvl(int n, int nivel, Nodo a){
        ArrayList<Integer> lista = new ArrayList<>();
        if(n == nivel){
            lista.add(a.getInfo());
            return lista;
        }else{
            if(a.getMayores() != null){
                lista.addAll(getElementAtLvl(n, nivel+1, a.getMayores()));
                if(a.getMenores() != null){
                    lista.addAll((getElementAtLvl(n, nivel+1, a.getMenores())));
                }
            }else if (a.getMenores() != null){
                lista.addAll((getElementAtLvl(n, nivel+1, a.getMenores())));
                if(a.getMayores() != null){
                    lista.addAll(getElementAtLvl(n, nivel+1, a.getMayores()));
                }
            }
            return lista;
        }

    }

    //ver getMinElem
    private int getMinElem(Nodo a){
        if (a.getMenores() != null){
            return getMinElem(a.getMenores());
        }else{
            return a.getInfo();
        }
    }

    //o(n)/n=cantidad de nodos
    //el peor caso es que el arbol sea similar a una lista vinculada
    public ArrayList<Integer> getRamaMasLarga(){
        ArrayList<Integer> a = getRamaMasLarga(raiz);
        Collections.reverse(a);
        return a;
    }

    private ArrayList<Integer> getRamaMasLarga(Nodo a) {
        if (a == null){
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> men = getRamaMasLarga(a.getMenores());
        ArrayList<Integer> may = getRamaMasLarga(a.getMayores());
        if (men.size()>may.size()){
            men.add(a.getInfo());
            return men;
        }
        else {
            may.add(a.getInfo());
            return may;
        }
    }

    //o(log n) en su caso es buscar en una u otra rama del arbol
    public boolean eliminar(int n){
         return eliminar(n, raiz);
    }


    private boolean eliminar(int n, Nodo a){
        if (a.getInfo() == n){
            return eliminarRaiz(a, n);
        }else{
            Nodo aux = anteriorAEliminar(n, a);
            if (n > aux.getInfo()){
                if (esHoja(aux.getMayores())){
                    aux.setMayores(null);
                    return true;
                }else if (esRaiz(aux.getMayores())){
                    return eliminar(n, aux.getMayores());
                }else{
                    aux.setMayores(esRama(aux.getMayores()));
                    return true;
                }
            }else{
                if (esHoja(aux.getMenores())){
                    aux.setMenores(null);
                    return true;
                }else if (esRaiz(aux.getMenores())){
                    return eliminar(n, aux.getMenores());
                }else{
                    aux.setMenores(esRama(aux.getMenores()));
                    return true;
                }
            }
        }
    }

    private boolean esHoja(Nodo a){ //devuelve un boolean si no tiene hijos
        return a.getMayores() == null && a.getMenores() == null;
    }

    private boolean esRaiz(Nodo a){ //devuelve boolean si tiene ambos hijos
        return a.getMayores() != null && a.getMenores() != null;
    }

    private Nodo esRama(Nodo a){ //devuelve un puntero al nodo siguiente a ser reemplazado
        if (a.getMayores() == null || a.getMenores() == null){
            if(a.getMayores() == null){
                return a.getMenores();
            }else{
                return a.getMayores();
            }
        }else return null;
    }

    private boolean eliminarRaiz(Nodo a, int b){  // cambia el valor de la raiz por el mas izquierdo del primer derecho
        if (a.getInfo() == b){                   // busca el nodo a eliminar a partir de esta raiz y pregunta
            if(esRaiz(a)){                      //si este es una rama o una hoja y lo elimina
                int n = getMinElem(a.getMayores());
                Nodo aux = anteriorAEliminar(n, a);
                a.setInfo(n);
                if(esHoja(aux.getMenores())){
                    aux.setMenores(null);
                    return true;
                }else{ aux.setMayores(esRama(aux.getMayores())); return true; }
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    private Nodo anteriorAEliminar(int n, Nodo a) {//algoritmo de busqueda que devuelve un puntero al nodo anterior
        if (n > a.getInfo()){                // que se debe eliminar
            if (a.getMayores() != null){
                if (a.getMayores().getInfo() == n){
                    return a;
                }else{
                    return anteriorAEliminar(n, a.getMayores());
                }
            }else{
                return null;
            }
        }else if(n< a.getInfo()){
            if (a.getMenores() != null){
                if(a.getMenores().getInfo() == n){
                    return a;
                }else{
                    return anteriorAEliminar(n, a.getMenores());
                }
            }else{
                return null;
            }
        }else{
            return a;
        }
    }



}
