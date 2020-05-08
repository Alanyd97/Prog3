package com.company;
import java.io.InputStreamReader;
import java.io.BufferedReader;

// REPASO
// char = caracter(cualquiera del teclado) (ojo con charAt(0)
//int = entero
//Doble = 12.23
//Float = 12.23435435
//siempre a la hora de pedir un dato try catch
// if para preguntar por un dato(o mas segun necesites) else si no se cumple
//switch para preguntar por un dato que tenga multiples valores
//while = mientras pase algo hace tal cosa
//for i = 0 hasta que i sea > 10 sumale 1 a i


class Main {
    public static void main(String[] args) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        char caracter;
        int  n;
        final int comparacion = 20;
        try{
            System.out.println("Ingresar caracter:");
            //caracter = entrada.readLine().charAt(0);
            n = Integer.valueOf(entrada.readLine());
            if (n > comparacion || n < comparacion){
                System.out.println("Es mayor");
            }else if(n<comparacion){
                System.out.println("Es menor");
            }else{
                System.out.println("Es igual");
            }
            switch (n){
                case 1: {
                    System.out.println("es 1");
                } break;
                case 2: {
                    System.out.println("es 2");
                } break;
                case 3: {
                    System.out.println("es 3");
                } break;
                case 4: {
                    System.out.println("es 4");
                }break;
                default:{
                    //algun codigo
                }
            }

        }catch (Exception exc){
            System.out.println(exc);
        }


        boolean condicion = true;
        while (condicion == true){
            //pedir dato
            //si es vocal imprimi
            //sino condicion = falso
        }


        for (int i = 0; i < 10; i ++){
            System.out.println("Hola"+i);
        }




    }
/*
    char caracter;
        try{
        System.out.println("Ingresar un entero: ");
        int n = Integer.valueOf(entrada.readLine());
        System.out.println("dato ingresado: "+n);
        System.out.println("Ingresar un caracter: ");
        caracter = entrada.readLine().charAt(0);
        System.out.println("Caracter ingresado: " + caracter );

        switch (n){
            case 1: {
                System.out.println("es 1");
            } break;
            case 2: {
                System.out.println("es 2");
            } break;
            case 3: {
                System.out.println("es 3");
            } break;
            case 4: {
                System.out.println("es 4");
            }break;
            default:{
                //algun codigo
            }
        }
    }catch  (Exception e){
        System.out.println(e);
    }
    */
}
