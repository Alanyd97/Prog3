
import java.util.ArrayList;

public class Main {


    public static void main(String... args) {


        CSVReader reader = new CSVReader("./data/familias-1.csv");

        ArrayList<Familia> familias = reader.read();
        for (Familia a: familias
             ) {
            System.out.println(a);
        }

        CSVReader reader2 = new CSVReader("./data/familias-2.csv");

        ArrayList<Familia> familias2 = reader2.read();

        Backtracking b = new Backtracking(familias);
        ArrayList<Familia> aux = new ArrayList<>();
        aux.addAll(familias);
        b.backtracking(aux);

    }
}
