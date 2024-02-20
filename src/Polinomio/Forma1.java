package Polinomio;

import java.util.Scanner;
import java.util.logging.Logger;

public class Forma1 {
    //Atributos
    int datosUtiles, vector[];

    //Constructor

    public Forma1(int datosUtiles) {
        this.datosUtiles = datosUtiles;
        vector = new int[datosUtiles + 1];
    }

    public Forma1() {
        datosUtiles = 0;
        vector = new int[1];
    }

    public int getDatosUtiles() {
        return datosUtiles;
    }

    public void setDatosUtiles(int datosUtiles) {
        this.datosUtiles = datosUtiles;
    }

    public int[] getVector() {
        return vector;
    }

    public void setVector(int[] vector) {
        this.vector = vector;
    }

    public String [] ingresar(String vectorB[] ) {
        int posicion;
        int j=0;
        int i;
        vector[0] = datosUtiles - 1;
        for (i = 1; vectorB[i] != null; i += 2) {
            posicion = datosUtiles - Integer.parseInt(vectorB[i]);
            vector[posicion] = Integer.parseInt(vectorB[j]);
            j += 2;
        }

        for (i = 0; i < vector.length; i++) {
            System.out.println(vector[i]);
        }

        return vectorB;
    }

    }



