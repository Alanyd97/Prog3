
import java.util.ArrayList;

public class Main {


    public static void main(String... args) {


        CSVReader reader = new CSVReader("./data/familias-1.csv");

        ArrayList<Familia> familias = reader.read();
        for (Familia a: familias
             ) {
            //System.out.println(a);
        }

        CSVReader reader2 = new CSVReader("./data/familias-2.csv");

        ArrayList<Familia> familias2 = reader2.read();
        ArrayList<Dia> dias = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            dias.add(new Dia(i+1));
        }
        Backtracking b = new Backtracking( familias,dias);

        b.backtracking(familias, 7000);

    }
}
