package sample;

import java.util.ArrayList;

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
    public void setInfo(int id) {this.id = id; }
    private void setMayores(Nodo mayores) {this.mayores = mayores; }
    private void setMenores(Nodo menores) {this.menores = menores; }
    public int getInfo() {return id; }
    private Nodo getMayores() {return mayores; }
    private Nodo getMenores() {return menores;}
    //--------------------

    public void insertar(int n) { // agrega ordenado con busqueda recursiva segun el nodo y los punteros del mismo
        if (this.getInfo() != 0) { // la complejidad es O(n)
            if (n < id) {
                if (this.menores == null) {
                    this.menores = new Nodo(n);
                } else {
                    this.menores.insertar(n);
                }
            } else {
                if( n > id){
                    if (this.mayores == null)  this.mayores = new Nodo(n);
                    else this.mayores.insertar(n);
                }
            }
        } else setInfo(n);

    }

    public void inOrder(){ // la complejidad es O(n)
        if (getMenores() != null){//para hacerlo descendente dar vuelta los IF, primero mayores y luego menores
            this.getMenores().inOrder();
        }
        System.out.print(getInfo()+" / "); //en pre order, va el sout primero(ya sea ascendente o descendente)
        if (getMayores() != null){          // y en post order primero se va hasta la hora luego imprime
            getMayores().inOrder();
        }
    }

    public boolean hasElem(int n) { //busqueda recursiva que devuelve un boolean si  encuentra el elemento en el arbol
        if(this.getInfo() == n) {// la complejidad es O(n)
            return true;
        }else {
            if(n < this.getInfo()) {
                if(menores == null) {
                    return false;
                }else {
                    return menores.hasElem(n);
                }
            }else {
                if(mayores == null) {
                    return false;
                }else {
                    return mayores.hasElem(n);
                }
            }
        }
    }

    public ArrayList<Integer> getFrontera(){
        ArrayList<Integer> aux = new ArrayList<>();
        if(menores != null) {
            aux.addAll(menores.getFrontera());
            if(mayores != null) {
                aux.addAll(mayores.getFrontera());
            }
        } else if(mayores != null) {
            aux.addAll(mayores.getFrontera());
        }else {
            aux.add(this.getInfo());
        }
        return aux;
    }

    public int getMaxElem(){
        if (mayores != null){
            return mayores.getMaxElem();
        }else{
            return getInfo();
        }
    }

    public int getMinElem(){
        if (menores != null){
            return menores.getMinElem();
        }else{
            return getInfo();
        }
    }

    public int getAltura(Nodo a) {
        if (a == null) {
            return 0;
        }
        int men = getAltura(a.menores);
        int may = getAltura(a.mayores);
        if (men>may){
            return men+1;
        }
        else {
            return may+1;
        }
    }

    public ArrayList<Integer> getElementAtLvl(int n, int nivel){
        ArrayList<Integer> lista = new ArrayList<>();
        if(n == nivel){
            lista.add(this.getInfo());
            return lista;
        }else{
            if(mayores != null){
                lista.addAll(mayores.getElementAtLvl(n, nivel+1));
                if(menores != null){
                    lista.addAll((menores.getElementAtLvl(n, nivel+1)));
                }
            }else if (menores != null){
                lista.addAll((menores.getElementAtLvl(n, nivel+1)));
                if(mayores != null){
                    lista.addAll(mayores.getElementAtLvl(n, nivel+1));
                }
            }
            return lista;
        }

    }


    public ArrayList<Integer> getRamaMasLarga(Nodo a) {
        if (a == null){
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> men = getRamaMasLarga(a.menores);
        ArrayList<Integer> may = getRamaMasLarga(a.mayores);
        if (men.size()>may.size()){
            men.add(a.getInfo());
            return men;
        }
        else {
            may.add(a.getInfo());
            return may;
        }
    }

    public boolean eliminar(int n){
       if (getInfo() == n){
           return eliminarRaiz(this, n);
       }else{
           Nodo aux = anteriorAEliminar(n);
           if (n > aux.getInfo()){
               if (aux.getMayores().esHoja()){
                   aux.setMayores(null);
                   return true;
               }else if (aux.getMayores().esRaiz()){
                   return aux.getMayores().eliminar(n);
               }else{
                   aux.setMayores(aux.getMayores().esRama());
                   return true;
               }
           }else{
               if (aux.getMenores().esHoja()){
                   aux.setMenores(null);
                   return true;
               }else if (aux.getMenores().esRaiz()){
                   return aux.getMenores().eliminar(n);
               }else{
                   aux.setMenores(aux.getMenores().esRama());
                   return true;
               }
           }
       }
    }


    private boolean esHoja(){
        return mayores == null && menores == null;
    }

    private boolean esRaiz(){
        return mayores != null && menores != null;
    }

    private Nodo esRama(){
        if (mayores == null || menores == null){
            if(mayores == null){
                return menores;
            }else{
                return mayores;
            }
        }else return null;
    }

    private boolean eliminarRaiz(Nodo a, int b){
        if (a.getInfo() == b){
            if(a.esRaiz()){
                int n = a.getMayores().getMinElem();
                Nodo aux = a.anteriorAEliminar(n);
                a.setInfo(n);
                if(aux.getMenores().esHoja()){
                    aux.setMenores(null);
                    return true;
                }else{ aux.setMayores(aux.getMayores().esRama()); return true; }
            }else{
                return false;
            }
        }else{
            return false;
        }
    }


    private Nodo anteriorAEliminar(int n) {
        if (n > getInfo()){
            if (mayores != null){
                if (mayores.getInfo() == n){
                    return this;
                }else{
                    return mayores.anteriorAEliminar(n);
                }
            }else{
                return null;
            }
        }else if(n< getInfo()){
            if (menores != null){
                if(menores.getInfo() == n){
                    return this;
                }else{
                    return menores.anteriorAEliminar(n);
                }
            }else{
                return null;
            }
        }else{
            return this;
        }
    }



}
