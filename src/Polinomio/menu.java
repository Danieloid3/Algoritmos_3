package Polinomio;

import Polinomio.Forma1.Forma1;
import Polinomio.Forma3.Forma3;
import Polinomio.Forma3.Nodo;

import java.util.Scanner;
import java.util.logging.Logger;

import static Polinomio.Main.crear;


public class menu {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getLogger(menu.class.getName());
        String vectorS[] = null;
        int grado = 0;
        Forma1 Poli = new Forma1(0);
        Forma3 Poli3 = new Forma3();
        int opcion;
        int exponente;


        do {
            System.out.println("------Menu------");
            System.out.println("1. Forma 1");
            System.out.println("2. Forma 2");
            System.out.println("3. Forma 3");
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
                    Poli.ingresar(vectorS);
                    break;
                case 2:
                    break;
                case 3:
                    String vector[] = crear();
                    Poli3.forma3(vector);
                    break;
                case 4:
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
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;

                case 10:
                    logger.info("Saliendo...");
                    break;
                default:
                    logger.info("Opcion no valida");
            }
        } while (opcion != 3);
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
