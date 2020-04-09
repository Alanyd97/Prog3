package sample;
public class Main{
    public static void main(String[] args) {
        Controller controller = new Controller();
        //lista 1
        Alumno a = new Alumno();
        Alumno b = new Alumno();
        Alumno c = new Alumno();
        Alumno d = new Alumno();

        /*//lista 2
        a.setId(50);
        Alumno aa = new Alumno();
        Alumno ba = new Alumno();
        Alumno ca= new Alumno();
        Alumno da = new Alumno();
        */
        System.out.println(controller.getPrimero().getMiID());
        System.out.println(b.getMiID());
        //llenado de lista 1
        controller.inOrdenado(b, controller.getPrimero());//1-2-3
        controller.inOrdenado(d, controller.getPrimero());//5-1-2-3-4
        controller.inOrdenado(a, controller.getPrimero());//1-2
        controller.inOrdenado(c, controller.getPrimero());//1-2-3-4

        /*llenado de lista 2
            Controller controller1 = new Controller();
            controller1.inFinal(aa);//1-2
            controller1.inFinal(ca);//1-2-3-4
            controller1.inFinal(ba);//1-2-3
            controller1.inFirst(da);//5-1-2-3-4

       */

        Alumno aux = controller.getPrimero();

        while (aux != null){
           System.out.println(aux.getMiID());
            aux = aux.getSiguiente();
        }
        /*
        aux = controller.getIndex(1);
        if (aux == null){
            System.out.println("no existe el indice");
        }else{
            System.out.println("Alumno encontrado id: "+aux.getMiID());
        }
        */


    }
}
