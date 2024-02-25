package Polinomio;

import Polinomio.Forma1.Forma1;
import Polinomio.Forma3.Forma3;

import java.util.Scanner;
import java.util.logging.Logger;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getLogger(Main.class.getName());
        String [] vectorS = null;
        int grado = 0;
        Forma1 Poli = new Forma1(0);
        Forma3 Poli3 = new Forma3();
        int opcion;
        int exponente;


        do {
            System.out.println("------Menu------");
            System.out.println("1. Ingresar en Forma 1");
            System.out.println("2. Ingresar en Forma 2");
            System.out.println("3. Ingresar en Forma 3");
            System.out.println("4. Insertar");
            System.out.println("5. Eliminar");
            System.out.println("6. Reconstruir");
            System.out.println("7. Dar valor a 'x'");
            System.out.println("8. Sumar");
            System.out.println("9. Multiplicar");
            System.out.println("10. Salir");
            logger.info("Ingrese una opcion: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    vectorS = crear();
                    grado = grado(vectorS);
                    Poli = new Forma1(grado + 1);
                    Poli.forma1(vectorS);
                    break;
                case 2:
                    break;
                case 3:
                    String [] vector = crear();
                    Poli3.forma3(vector);
                    Poli3.ordenar();
                    break;
                case 4:
                    System.out.println("En que forma quiere insertar un dato: \n" + "1. Forma 1 \n" +  "2. Forma 2 \n" + "3. Forma 3 \n");
                    opcion = scanner.nextInt();
                    if (opcion == 1){
                        System.out.println("Ingrese el monomio: ");
                        String [] vectorMonomio = crear();
                        Poli.insertar(vectorMonomio);
                    }
                    /*else if (opcion == 2){
                        System.out.println("Exponente del dato a insertar ");
                        exponente = Integer.parseInt(scanner.nextLine());
                        System.out.println("Coeficiente del dato a insertar ");
                        int coeficiente = Integer.parseInt(scanner.nextLine());
                        Poli2.insertar(exponente, coeficiente);
                    }
                    else if (opcion == 3){
                        System.out.println("Exponente del dato a insertar ");
                        exponente = Integer.parseInt(scanner.nextLine());
                        System.out.println("Coeficiente del dato a insertar ");
                        int coeficiente = Integer.parseInt(scanner.nextLine());
                        Poli3.insertar(exponente, coeficiente);
                    }*/
                    break;
                case 5:
                    System.out.println("En que forma quiere eliminar un dato: \n" + "1. Forma 1 \n" +  "2. Forma 2 \n" + "3. Forma 3 \n");
                    opcion = scanner.nextInt();
                    if (opcion == 1){
                        System.out.println("Exponente del dato a eliminar ");
                        exponente = scanner.nextInt();
                        Poli.eliminar(exponente);
                    }
                    /*else if (opcion == 2){
                        System.out.println("Exponente del dato a eliminar ");
                        exponente = Integer.parseInt(scanner.nextLine());
                        Poli2.eliminar(exponente);
                    }
                    else if (opcion == 3){
                        System.out.println("Exponente del dato a eliminar ");
                        exponente = Integer.parseInt(scanner.nextLine());
                        Poli3.eliminar(exponente);
                    }*/

                    break;
                case 6:
                    System.out.println("En que forma quiere reconstruir: \n" + "1. Forma 1 \n" +  "2. Forma 2 \n" + "3. Forma 3 \n");
                    opcion = scanner.nextInt();
                    if (opcion == 1){
                       Poli.reconstruir();
                    }
                    /*else if (opcion == 2){
                        Poli2.reconstruir();
                    }
                    else if (opcion == 3){
                        Poli3.reconstruir();
                    }*/
                    break;
                case 7:
                    System.out.println("En que forma quiere dar valor a 'x': \n" + "1. Forma 1 \n" +  "2. Forma 2 \n" + "3. Forma 3 \n");
                    opcion = scanner.nextInt();
                    if (opcion == 1) {
                        System.out.println("Ingrese el valor de 'x': ");
                        int x = scanner.nextInt();
                        Poli.evaluar(x);
                    }
                    /*else if (opcion == 2){
                        System.out.println("Ingrese el valor de 'x': ");
                        int x = Integer.parseInt(scanner.nextLine());
                        Poli2.evaluar(x);
                    }*/
                    else if (opcion == 3){
                        System.out.println("Ingrese el valor de 'x': ");
                        int x = scanner.nextInt();
                        Poli3.evaluar(x);
                    }
                    break;
                case 8:
                    System.out.println("En que forma quiere sumar: \n" + "1. Forma 1 \n" +  "2. Forma 2 \n" + "3. Forma 3 \n");
                    opcion = scanner.nextInt();
                    if (opcion == 1){
                        String [] vectorSuma = crear();
                        Forma1 PoliSuma = new Forma1(grado(vectorSuma) + 1);
                        PoliSuma.forma1(vectorSuma);
                        PoliSuma.sumar(Poli);

                    }
                    /*else if (opcion == 2){
                        System.out.println("Ingrese el polinomio a sumar: ");
                        String [] vectorSuma = crear();
                        Forma2 PoliSuma = new Forma2();
                        PoliA.ingresar(vectorSuma);
                        Poli2.sumar(Poli);
                    }
                   */
                    else if (opcion == 3){
                        String [] vectorSuma = crear();
                        Forma3 PoliSuma = new Forma3();
                        PoliSuma.ordenar();
                        PoliSuma.sumar(Poli3);

                    }
                    break;
                case 9:
                    System.out.println("En que forma quiere multiplicar: \n" + "1. Forma 1 \n" +  "2. Forma 2 \n" + "3. Forma 3 \n");
                    opcion = scanner.nextInt();
                    if (opcion == 1){
                        System.out.println("Ingrese el polinomio a multiplicar: ");
                        String [] vectorA = crear();
                        Forma1 PoliA = new Forma1(grado(vectorA) + 1);
                        PoliA.forma1(vectorA);
                        //Poli.multiplicar(PoliA);
                    }
                    /*else if (opcion == 2){
                        System.out.println("Ingrese el polinomio a multiplicar: ");
                        String [] vectorA = crear();
                        Forma2 PoliA = new Forma2(grado(vectorA) + 1);
                        PoliA.ingresar(vectorA);
                        Poli2.multiplicar(PoliA);
                    }
                    else if (opcion == 3){
                        System.out.println("Ingrese el polinomio a multiplicar: ");
                        String [] vectorA = crear();
                        Poli3.multiplicar(vectorA);
                    }*/
                    break;

                case 10:
                    logger.info("Saliendo...");
                    break;
                default:
                    logger.info("Opcion no valida");
            }
        } while (opcion != 10);
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

            if (i == vectorA.length - 1) {
                if (data != "") {
                    vectorB[j] = data;
                    if (Character.isDigit(vectorA[i])) {
                        vectorB[j + 1] = "0";
                    }
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
}
