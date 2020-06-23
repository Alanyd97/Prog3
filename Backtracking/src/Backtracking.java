import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Backtracking {



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

    public static int getEstados() {
        return estados;
    }
    private boolean esResultado(){
        return bonoActual < bonoMinimo;
    }

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

    private void desDesignar(Familia fam, int index){
        diasTotales.get(fam.preferenciaEn(index)-1).remove(fam.getId());
        bonoActual = bonoActual - fam.getBono();
        fam.setBono(0);
    }

    private boolean esFinal(int i){
        return i== familias.size();
    }




}
