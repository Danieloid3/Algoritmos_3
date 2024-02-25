package Polinomio.Forma1;

import static Polinomio.Main.crear;

public class Forma1 {
    //Atributos
    public int datosUtiles, posicion;
    int[] vector;

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

    public String[] forma1(String vectorB[]) {
        int posicion;
        int j = 0;
        int i;
        vector[0] = datosUtiles - 1;
        for (i = 1; vectorB[i] != null; i += 2) {
            posicion = datosUtiles - Integer.parseInt(vectorB[i]);
            vector[posicion] = Integer.parseInt(vectorB[j]);
            j += 2;
        }
        System.out.println("--VECTOR EN FORMA 1--");
        for (i = 0; i < vector.length; i++) {
            System.out.println(vector[i]);
        }

        return vectorB;
    }



    public void eliminar(int exponente) {
        int i = 2;
        int j = 3;
        int mayor = 0;
        int expontenteA = datosUtiles - i;
        int exponenteB = datosUtiles - j;
        if (vector[0] == exponente) {
            vector[0] = Integer.parseInt("0");
            vector[1] = Integer.parseInt("0");

            while (i < datosUtiles) {
                if (expontenteA > exponenteB) {
                    mayor = expontenteA;
                } else {
                    mayor = exponenteB;
                }
                i++;
                j++;
            }
            vector[0] = mayor;

        } else {
            posicion = datosUtiles - exponente;
            vector[posicion] = Integer.parseInt("0");
        }

        System.out.println("--NUEVO VECTOR--");
        for (i = 0; i < vector.length; i++) {
            System.out.println(vector[i]);
        }
    }

    public int evaluar(int x) {
        int i;
        int grado = datosUtiles - 1;
        int suma = 0;

        for (i = 1; i < datosUtiles; i++) {
            suma = (int) (suma + vector[i] * Math.pow(x, grado));
            grado--;
            if (grado == 0) {
                suma = suma + vector[i + 1];
                break;
            }
        }
        System.out.println("La suma es: " + suma);
        return suma;
    }

    public void sumar(Forma1 Poli) {
        int i = 1;
        int j = 1;
        int expontenteA = datosUtiles - i;
        int exponenteB = Poli.getDatosUtiles() - j;
        int mayor=0;
        Forma1 suma = new Forma1(0);

        if(expontenteA> exponenteB){
            suma = new Forma1(datosUtiles);
            suma.vector[0] = vector[0];

        }else{
            suma = new Forma1(Poli.getDatosUtiles());
            suma.vector[0] = Poli.getVector()[0];

        }

        while (i < datosUtiles && j < Poli.getDatosUtiles()) {
            if (expontenteA > exponenteB) {
                suma.vector[i] = vector[i];
                i++;
                suma.vector[i] = vector[i] + Poli.getVector()[j];
                i++;
                j++;
            } else if (expontenteA < exponenteB) {
                suma.vector[i] = Poli.getVector()[j];
                j++;
            } else if (expontenteA == exponenteB){
                suma.vector[i] = vector[i] + Poli.getVector()[j];
                i++;
                j++;
            }
            suma.vector[i] = vector[i] + Poli.getVector()[j];
        }
        System.out.println("--SUMA FORMA 1--");
        for (i = 0; i < suma.vector.length; i++) {
            System.out.println(suma.vector[i]);
        }


    }

    public void insertar(String[] vectorMonomio) {

        String[] nuevoF1 = vectorMonomio;

        int expoA = Integer.parseInt(nuevoF1[0]);
        int expoV= vector[0];
        int pos=0;
        if(expoA > expoV){
            for(int i =1; i < datosUtiles;i++){
                pos = nuevoF1.length - 1-expoV;
                vector[pos] = Integer.parseInt(nuevoF1[i]);
                expoV--;
            }
        }
        else if(expoA < expoV) {
            pos = datosUtiles - expoA;
            vector[pos] += Integer.parseInt(nuevoF1[1]);
        }else{
            vector[1]+= Integer.parseInt(nuevoF1[1]);
        }
        System.out.println("--INSERTAR FORMA 1--");
        for (int i = 0; i < nuevoF1.length; i++) {
            System.out.println(nuevoF1[i]);
        }

    }

    public void reconstruir(){
        String cadena = "";
        for (int i = 1; i < vector.length; i++) {
            int grado = datosUtiles - i;
            if(vector[i] != 0){
                if(vector[i] != 1 && vector[i] != -1){
                    cadena += vector[i];
                }else if(vector[i] == -1){
                    if(i == vector.length-1){
                        cadena += vector[i];
                    }else{
                        cadena += "-";
                    }
                }else if(vector[i] == 1){
                    if(i == vector.length-1){
                        cadena += "+"+vector[i];
                    }
                }
                if(grado == 1){
                    cadena += "x";
                }else if(grado > 1){
                    cadena += "x^"+grado;
                }
                if(i+1 < vector.length && vector[i+1] > 0){
                    cadena += "+";
                }
            }
        }
        System.out.println(cadena);
    }
}