package sample;

public class Arbol {
    private Nodo raiz;

    public Arbol(Nodo a) { this.raiz = a;}


    //getter & setter
    public Nodo getRaiz() {return raiz; }
    public void setRaiz(Nodo raiz) {this.raiz = raiz; }


    public void insert(Nodo a){
        insertarOrdenado(a, this.raiz);
    }

    private void insertarOrdenado(Nodo a, Nodo padre){
            if (padre.nodoMayor(a)){
                if(padre.getMenores() == null){
                    padre.setMenores(a);
                }else{
                    insertarOrdenado(a, padre.getMenores());
                }
            }else{
                if (padre.getMayores() == null){
                    padre.setMayores(a);
                }else{
                    insertarOrdenado(a, padre.getMayores());
                }
            }
    }

    
    public void inOrder(Nodo a){ //para hacerlo descendente dar vuelta los IF
        if (a.getMenores() != null){
            inOrder(a.getMenores());
        }
        System.out.println(a.getId()); //en pre order, va el sout primero y en post order va ultimo
        if (a.getMayores() != null){
            inOrder(a.getMayores());
        }

    }










}
