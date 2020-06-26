import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> datos = new ArrayList();
        int[] arrDatos = {68, 42, 47, 5, 76, 95, 23, 88, 90, 85, 31, 71, 60, 10, 46, 61, 50, 92, 74, 6, 97, 66, 1, 56, 27, 7, 14};
        for (int a : arrDatos) {
            System.out.print(a+" |");
            datos.add(a);
        }
        System.out.println(" ");
        System.out.println("----------------------------------------------------------------");
        Hashing hash = new Hashing(4, 1, 2, 1.5, datos);

        hash.printMap();
        hash.hashing(datos);
        hash.printMap();


    }
}
