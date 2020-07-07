import java.util.ArrayList;
import java.util.Iterator;

public class Greedy {
    private ArrayList<Familia> familias;
    private int bono;
    private Dia[] dias;
    public  Greedy(ArrayList<Familia> a){
        familias= new ArrayList<Familia>();
        familias.addAll(a);
        dias = new Dia[100];
        bono = 0;
        inicializarArreglo();
    }

    private Dia[] inicializarArreglo(){
        for (int i = 0; i < dias.length; i++) {
            dias[i] = new Dia(i+1);
        }
        return dias;
    }

    public void entregable(Iterator<Familia> iFam){
        if (iFam.hasNext()){
            while (iFam.hasNext()){
                Familia a = iFam.next();
                if (!(designar(a))){
                    System.out.println("error");
                }
            }
        }
        debug();
    }

    private void debug(){
        int iterador =0;
        for (Dia a: dias) {
            iterador=iterador + a.getCantFamilias();
            bono = bono + a.getBono();
        }
        System.out.println("familias designadas: "+ iterador+"  bono: "+bono);
    }

    private boolean designar(Familia a){
        for (int i = 0; i < 8; i++) {
            if (dias[a.preferenciaEn(i)-1].addFamilia(a, i)){
                System.out.println(dias[a.preferenciaEn(i)-1].getId() == a.getDesignado());
                return true;
            }
        }
        return false;
    }


}
