package polinomio.Forma1;


import polinomio.Forma2.Forma2;

public class Forma1 {
    //Atributos
    public int datosUtiles;
    int[] vector;

    //Constructor
    public Forma1(int datosUtiles) {
        this.datosUtiles = datosUtiles;
        vector = new int[datosUtiles + 1];
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

    public String[] ingresarForma1(String vectorB[]) {
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
        int posicion;
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
        int mayor = 0;
        Forma1 suma = new Forma1(0);

        if (expontenteA > exponenteB) {
            suma = new Forma1(datosUtiles);
            suma.vector[0] = vector[0];

        } else {
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
            } else {
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

    public void insertar(String[] monomio) {
        int expoB = vector[0];
        int posicion = 0;
        int[] nuevo = new int[monomio.length+datosUtiles];

        for (int i = 0; i < monomio.length; i++) {
            if (monomio[i] != null) {
                nuevo[i] = Integer.parseInt(monomio[i]);

            }
        }
        int nuevoCoeficiente = nuevo[0];
        int exp_N = nuevo[1];
        int i=0;
        if (exp_N > expoB) {
            nuevo[i]=nuevo[i+1];
            nuevo[i+1]=nuevoCoeficiente;
            for ( i = 1; i < datosUtiles + 1; i++) {
                posicion = vector.length - expoB;
                nuevo[posicion] = vector[i];
                expoB--;
            }
            vector = nuevo;
            datosUtiles = nuevo[0] + 1;

            System.out.println("-- Insertar --");
            for ( i = 0; i < nuevo.length; i++) {
                System.out.println(nuevo[i]);
            }
        } else if (exp_N < expoB) {
            posicion = datosUtiles - exp_N;
            vector[posicion] += nuevo[1];
            System.out.println("-- Insertar --");
            for ( i = 0; i < vector.length ; i++) {
                System.out.println(vector[i]);
            }
        } else if (exp_N == expoB) {
            vector[1]+=nuevoCoeficiente;
            System.out.println("-- Insertar --");
            for ( i = 0; i < vector.length ; i++) {
                System.out.println(vector[i]);
            }
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

    public void multiplicar(Forma1 Poli){
        int [] A;
        int [] B;
        if (datosUtiles > Poli.datosUtiles) {
            A = vector;
            B = Poli.vector;
        } else {
            B = vector;
            A = Poli.vector;
        }
        int []C = new int[A[0] + B[0] +2];
        C[0] = A[0] + B[0];
        for (int j = 1; j < B.length; j++) {
            if (B[j] != 0) {
                for (int i = 1; i < A.length; i++) {
                    if (A[i] != 0) {
                        C[C[0] + 1 - ((A[0] + 1 - i) + (B[0] + 1 - j))] += A[i] * B[j];
                    }
                }
            }
        }

        System.out.println("--MULTIPLICACION FORMA 1--");
        for (int i = 0; i < C.length; i++) {
            System.out.println(C[i]);
        }
    }



}