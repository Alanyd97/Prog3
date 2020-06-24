import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Backtracking {

    /*
    El estado inicial es cuando el iterador de la familia el encargado
    de decir si pudo avanzar en las iteraciones debido los resultados
    del calculo de los bonos y demas esta en 0, el estado seria "agregue
    una familia" ya sea probando las posibilidades con todos los dias con
    todas las familias una por una las ramas hijas de la raiz(no agregue
    ninguna familia) abro 3 posibilidades, que se agregue en el dia 1
    trayendo sus resultados, en el dia 2 y viendo sus resultados y para
    el dia 3 lo mismo, en cada estado que avanza tiene que tomar la misma
    desicion pero con la siguiente familia avanzando y retrocediendo
    actualizando el resultado del bono hasta encontrar el bono minimo
    Las dos podas son de bono que la suma del bono actual con la familia
    que estoy por agregar no supere el bono minimo, y como avanzo por
    familias "podo" las familias que puede recorrer a las que no estan
    designadas
     */

    private static int estados;
    private ArrayList<Dia> diasTotales;
    private int bonoMinimo;
    private ArrayList<Familia> familias;
    private int bonoActual;


    public Backtracking(ArrayList<Familia> f, ArrayList<Dia> d){
        estados = 0;
        diasTotales = d;
        bonoMinimo = 7000;
        familias = f;
        bonoActual = 0;
    }

    //Retorna el contador de estados actualizados por c/u de los estados visiados
    public static int getEstados() {
        return estados;
    }
    //retorna si el bono actual es menor al bono minimo
    private boolean esResultado(){
        return bonoActual < bonoMinimo;
    }

    /*  Comienza contando un nuevo estado, pregunta si el estado es final
        un estado es final cuando el iterador de familias (iActual) es igual al .size()
        de familias luego pregunta si es resultado en caso de ser sierto se actualiza
        el bono
        Sino tomo la primer familia e itero 3 veces(una por cada dia del arreglo de dias
        de esa familia) y pregunto si lo puedo designar en caso de ser sierto hago una poda
        preguntando si sumando a esa familia excedo el bono minimo si no lo excedo avanzo
        el iterador y vuelvo a llamar a backtracking cuando sale vuelvo todo el estado para atras
     */
    public void backtracking(int iActual){
        estados++;
        if (esFinal(iActual)){
            if (esResultado()){
                bonoMinimo = bonoActual;
            }
        }else{
            Familia fam = familias.get(iActual);
            for (int j = 0; j < 3; j++) {
                if (designar(fam, j) ){
                    if (mejorBono()){
                        iActual++;
                        backtracking(iActual);
                        iActual--;
                    }
                    desDesignar(fam, j);
                }
            }
        }
    }

    public int getBonoMinimo(){return this.bonoMinimo;}

    private boolean mejorBono(){
        return bonoActual < bonoMinimo;
    }

    /*
    A designar le llega una familia y una iteracion del dia preferencial de la familia
    pregunto si en ese dia se puede designar en caso de ser asi pregunto si se tiene
    que calcular el bono se suma y actualiza el bono actual seteo el valor del bono de
    la familia
    */
    private boolean designar(Familia fam, int i){
        if (diasTotales.get(fam.preferenciaEn(i)-1).addFamilia(fam)){
            int bonoFamilia = 0;
            if (i != 0){
                 bonoFamilia =  (25 + (10 * fam.miembros()) + (5*i));
            }
            bonoActual = bonoActual + bonoFamilia;
            fam.setBono(bonoFamilia);
            return true;
        }
        return false;
    }

    //Deja ttodo como estaba, remueve la familia del dia designado
    //actualiza el bono y setea el bono de esa familia
    private void desDesignar(Familia fam, int index){
        diasTotales.get(fam.preferenciaEn(index)-1).remove(fam.getId());
        bonoActual = bonoActual - fam.getBono();
        fam.setBono(0);
    }

    private boolean esFinal(int i){
        return i== familias.size();
    }




}
