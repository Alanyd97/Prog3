package sample;
public class Main{
    public static void main(String[] args) {
        Controller controller = new Controller();
        //lista 1
        Alumno a = new Alumno();
        Alumno b = new Alumno();
        Alumno c = new Alumno();
        Alumno d = new Alumno();

        //lista 2
        a.setId(3);
        Alumno aa = new Alumno();
        Alumno ba = new Alumno();
        Alumno ca= new Alumno();
        Alumno da = new Alumno();
        a.setId(3);
        Alumno ea = new Alumno();

        //llenado de lista 1
        controller.inFinal(d);
        controller.inFinal(b);
        controller.inFinal(a);
        controller.inFinal(c);
        controller.inFinal(aa);
        controller.inFinal(ba);
        controller.inFinal(ca);
        controller.inFinal(da);
        controller.inFinal(ea);



        Alumno aux = controller.getPrimero();


        while (aux != null){
           System.out.println("alumnos 0: "+aux.getMiID());
            aux = aux.getSiguiente();
        }
        /*
        aux=controller1.getPrimero();
        System.out.println("--------");
        while (aux != null){
            System.out.println("alumnos 1: "+aux.getMiID());
            aux = aux.getSiguiente();
        }
        */
        aux = controller.extraerSecuencia();
        if (aux == null){
            System.out.println("no existe el indice");
        }else{
            while (aux != null){
                System.out.println("cadena: "+ aux.getMiID());
                aux=aux.getSiguiente();
            }
        }
        System.out.println("--------");
        aux = controller.extraerSecuencia();
        if (aux == null){
            System.out.println("no existe el indice");
        }else{
            while (aux != null){
                System.out.println("cadena: "+ aux.getMiID());
                aux=aux.getSiguiente();
            }
        }



    }
}
