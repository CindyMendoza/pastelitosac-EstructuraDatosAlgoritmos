package com.company.Clases;

public class Demo {


    /*Se tienen 4 arreglos que contienen los siguientes datos: nombre, edad, sexo, documentos

    Se pide:
            1.	Determinar la cantidad de hombres cuya edad sea mayor a 40.
            2.	Dado el número de DNI, obtener el nombre de dicho ciudadano.
            3.	Dado un nombre, determinar cuántos homónimos tiene dicho ciudadano.
            4.	Determinar cuántos ciudadanos tienen la coincidencia de que su edad se encuentre en alguna parte de su número de documento.
            Por ejemplo si un ciudadano tiene su número de documento 42264954 y tiene 26 años, entonces cumple con la condición de coincidencia.
            */

    //nombre, edad, sexo, documentos


    public static void main(String[] args) {
        String nombre [] = {"Victor", "Ronald","Carolina","Victor"};
        int edad [] = {75, 30,20,11};
        char sexo [] = {'H', 'M'};
        int documentos []={74000645,65443678,98767876,54567765};



        for (int i=0; i<nombre.length; i++){
            System.out.println(nombre[i]+ " "+ edad[i]+" "+documentos[i]);
        }
        int suma=0;
        for (int i=0; i<edad.length; i++){
            if (edad[i]>40){
                suma ++;

                System.out.println("Documentos de "+documentos[i]);
            }
        }
        System.out.println("Totan de nombres mayores a 40 años: "+suma);

        int homo=0;
        for (int i=0; i<nombre.length; i++) {
            for (int j = 0; j < nombre.length; j++) {
                if (nombre[j]==nombre[i]){
                    homo++;

                    System.out.println( "homónimos repetidos : "+ homo);
            }
            }
        }

        int totalDni=0, dato1, dato2;
        int nuevo = 0;

        for (int i=0; i<edad.length; i++){
            nuevo = documentos[i];

            if (edad[i]==documentos[i]){
                totalDni ++;
                System.out.println("Repetidos de "+totalDni);
            }

        }
        System.out.println("Ciudanos con considencias con DNI "+nuevo);

    }
}
