package Polinomio;


import Polinomio.Forma1.Forma1;
import Polinomio.Forma3.Nodo;

import java.util.Scanner;
import java.util.logging.Logger;

public class Main {

        public static void main(String[] args) {
            String vectorS[] = crear();
            int grado = grado(vectorS);

            Forma1 Poli = new Forma1(grado + 1);
            Poli.ingresar(vectorS);


        }
    public static String [] crear(){
        Logger logger = Logger.getLogger(Main.class.getName());
        Scanner scanner = new Scanner(System.in);

        logger.info("Ingrese el polinomio: ");
        String polinomio = scanner.nextLine();
        //"15x^2+8x^3-3-2x";

        String data = "";
        int j = 0;  //Contador para el vector de Strings
        int i = 0; //Contador para el vector de caracteres

        char vectorA[] = polinomio.toCharArray();
        String vectorB[] = new String[vectorA.length];
        while (i < vectorA.length) {

            if (vectorA[i] == '-') {
                if (vectorA[i + 1] == 'x') {
                    data = "-1";
                    i += 1;
                } else {
                    data = data + vectorA[i];
                    i += 1;
                }
            }
            if (Character.isDigit(vectorA[i])) {
                data = data + vectorA[i];

            }
            if (vectorA[i] == '+') {
                if (vectorA[i + 1] == 'x') {
                    data = "1";
                } else {
                    data = data + vectorA[i + 1];
                    i += 1;
                }
            }
            if (vectorA[i] == '^') {
                data = data + vectorA[i + 1];
                vectorB[j] = data;
                data = "";
                i += 1;
                j += 1;
            }
            if (vectorA[i] == 'x') {
                if (data == ""){
                    vectorB[j] = "1";
                    j += 1;
                }
                else{
                    vectorB[j] = data;
                    data = "";
                    j += 1;

                }

                if (i == vectorA.length - 1) {
                    vectorB[j] = "1";
                    j += 1;
                }
            }


            if (i == vectorA.length - 1){
                vectorB[j] = data;
                if (Character.isDigit(vectorA[i])){
                    vectorB[j + 1] = "0";
                }

            }
            if (i != vectorA.length - 1){
                if ((data != "") && ((vectorA[i + 1] == '+' || vectorA[i + 1] == '-'))) {
                    vectorB[j] = data;
                    vectorB[j + 1] = "0";
                    data = "";
                    j += 2;
                }
            }

            i++;

        }

        return (vectorB);
    }


    public static int grado (String vector[])
    {
        int grado = 0;
        int i;
        for (i = 1; vector[i] != null; i += 2) {
            if (Integer.parseInt(vector[i]) > grado) {
                grado = Integer.parseInt(vector[i]);
            }
        }
        return grado;
        }
}


