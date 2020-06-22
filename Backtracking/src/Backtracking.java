import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Backtracking {

    private ArrayList<Dia> dias;
    private ArrayList<Dia> diasTotales;
    private int bonoMinimo;

    public Backtracking(ArrayList<Familia> f, ArrayList<Dia> d){
        diasTotales = d;
        bonoMinimo = 7000;
    }


    private boolean esResultado(int bono){
        return bono < bonoMinimo;
    }

    public void backtracking(ArrayList<Familia> sinDesignar , int bono){
        if (esFinal(sinDesignar)){
            System.out.println(bonoMinimo);
            for(Dia a : diasTotales){
                bono = bono + a.getBono();
            }
            if (esResultado(bono)){
                bonoMinimo = bono;
                System.out.println("minimo: "+bonoMinimo);
            }
        }else{
            for (int j = 0; j < sinDesignar.size(); j++) {
                Familia fam = sinDesignar.get(j);
                sinDesignar.remove(j);
                if(designar(fam))
                    backtracking(sinDesignar, bono);
                desDesignar(sinDesignar, fam);

            }
        }
    }

    private boolean designar(Familia fam){
        for (int i = 0 ; i < 3 ;i++ ){
            if (diasTotales.get(fam.preferenciaEn(i)-1).addFamilia(fam)){
                return true;
            }
        }
        return false;
    }

    private void desDesignar(ArrayList<Familia> sinDesignar, Familia fam){
        sinDesignar.add(fam);
        if (fam.fueDesignada()){
            diasTotales.get(fam.getDiaDesignado()-1).remove(fam.getId());
        }
    }

    private boolean esFinal(ArrayList<Familia> sinDesignar){
        if (sinDesignar.isEmpty() || contiene(sinDesignar)){
            return true;
        }else{
            return false;
        }
    }

    private boolean contiene(ArrayList<Familia> sinDesignar){
        for (Familia a : sinDesignar){
            if(a.getIndicePreferido() > 3){
                return true;
            }
        }
        return false;
    }










}
