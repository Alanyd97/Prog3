import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Backtracking {

    private ArrayList<Dia> dias;
    ArrayList<Familia> familias;
    public Backtracking(ArrayList<Familia> f){
        familias = f;
        for (int i = 0; i < 10; i++) {
            dias.add(new Dia(i+1));
        }
    }



    public void backtracking(ArrayList<Familia> sinDesignar , ArrayList<Dia> diasActuales){
        if (sinDesignar.isEmpty()){
            //calcular y devolver bono
        }else{
            for(int i = 0; i < diasActuales.size(); i++){
                for (int j = 0; j < sinDesignar.size(); j++) {
                    Familia fam = sinDesignar.get(j);
                    Dia diaActual = diasActuales.get(j);
                    if (designar(sinDesignar, diasActuales, diaActual, fam)){
                        backtracking(sinDesignar, diasActuales);
                        desDesignar(sinDesignar, diasActuales, diaActual, fam);
                    }
                }
            }
        }
    }

    private boolean designar(ArrayList<Familia> sinDesignar,  ArrayList<Dia> diasActuales, Dia diaActual, Familia fam){
        int dia = fam.diaPreferido();
        //si lo agrega
        if (diaActual.addFamilia(fam)){
            if (diaActual.getCapacidadActual() <=4){
                diasActuales.remove(diaActual);
            }
            fam.setDiaDesignado(diaActual.getId());
            sinDesignar.remove(fam);
            return true;
        }else{
            fam.setIndicePreferido(fam.getIndicePreferido()+1);
            if (fam.getDiaDesignado() > 2)
                return false;
            else
                return true;
        }
    }

    private void desDesignar(ArrayList<Familia> sinDesignar, ArrayList<Dia> diasActuales, Dia diaActual, Familia fam){
        diaActual.remove(fam.getId());
        if (!sinDesignar.contains(fam)){
            sinDesignar.add(fam);
        }
        if (!diasActuales.contains(diaActual)){
            diasActuales.add(diaActual);
        }
    }










}
