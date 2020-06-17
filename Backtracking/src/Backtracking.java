import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Backtracking {

    private ArrayList<Dia> dias;
    private Iterator<Dia> iDia;
    ArrayList<Familia> familias;
    public Backtracking(ArrayList<Familia> f){
        dias = new ArrayList<>();
        familias= f;
        for (int i = 0 ; i < 10; i++) {
            dias.add(new Dia(i+1));
        }
        iDia = dias.iterator();
    }



    public void backtracking(ArrayList<Familia> sinDesignar){
        if (sinDesignar.isEmpty()){
            System.out.println("gane");
        }else{
            for (int i = 0; i < sinDesignar.size(); i++){
                designar(sinDesignar.get(i), sinDesignar);
                System.out.println(sinDesignar.size());
            }
            backtracking(sinDesignar);
        }
        for (Dia a: dias
        ) {
            System.out.println(a);
        }
    }

    private boolean designar(Familia fam, ArrayList<Familia> sinDesignar){
        Dia a = dias.get(fam.diaPreferido()-1);
        if (fam.miembros() <= a.getCapacidadActual()){
            a.addFamilia(fam);
            sinDesignar.remove(fam);
            return true;
        }else{
            fam.setIndicePreferido(fam.getIndicePreferido()+1);
            return false;
        }
    }







}
