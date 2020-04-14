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
        controller.inOrdenado(b, controller.getPrimero());//1-2-3
        controller.inOrdenado(d, controller.getPrimero());//5-1-2-3-4
        controller.inOrdenado(a, controller.getPrimero());//1-2
        controller.inOrdenado(c, controller.getPrimero());//1-2-3-4

        //llenado de lista 2
            Controller controller1 = new Controller();
            controller1.inFinal(aa);//1-2
            controller1.inFinal(ba);//1-2-3
            controller1.inFinal(ca);//1-2-3-4
            controller1.inFinal(da);//5-1-2-3-4
        controller1.inFinal(ea);//5-1-2-3-4



        Alumno aux = controller.getPrimero();


        while (aux != null){
           System.out.println("alumnos 0: "+aux.getMiID());
            aux = aux.getSiguiente();
        }
        aux=controller1.getPrimero();
        System.out.println("--------");
        while (aux != null){
            System.out.println("alumnos 1: "+aux.getMiID());
            aux = aux.getSiguiente();
        }

        aux = controller.extraerSecuencia(controller1.getPrimero());
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
