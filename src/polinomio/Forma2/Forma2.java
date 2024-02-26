package polinomio.Forma2;

public class Forma2 {
    int terminos;
    int[] vector;
    int datosUtiles;

    //Constructor
    public Forma2(int terminos) {
        this.terminos = terminos;
        vector = new int[terminos + 1];
    }

    public int getTerminos() {
        return terminos;
    }

    public void setTerminos(int terminos) {
        this.terminos = terminos;
    }

    public int[] getVector() {
        return vector;
    }

    public void setVector(int[] vector) {
        this.vector = vector;
    }

    //Métodos
    public void ingresarForma2(String[] vectorB){
        int j = 0;
        int i;
        int posicion;
        vector[0] = terminos/2;
        for (i = 1; vectorB[i] != null; i += 2) {
            posicion = terminos - Integer.parseInt(vectorB[i])*2;
            vector[posicion - 1] = Integer.parseInt(vectorB[j]);
            vector[posicion] = Integer.parseInt(vectorB[j + 1]);

            j += 2;
        }
        System.out.println("--VECTOR EN FORMA 2--");
        for (i = 0; i < vector.length; i++) {
            System.out.println(vector[i]);
        }



    }
    public void eliminar2(int exponente){
        int i = 2;
        int j = 3;
        int posicion;
        int mayor = 0;
        int expontenteA = terminos - i;
        int exponenteB = terminos - j;
        if (vector[0] == exponente) {
            vector[0] = Integer.parseInt("0");
            vector[1] = Integer.parseInt("0");
        }
        while (i < terminos) {
            if (vector[i] == exponente) {
                vector[i] = Integer.parseInt("0");
                vector[i + 1] = Integer.parseInt("0");
                if (expontenteA > exponenteB) {
                    mayor = expontenteA;
                } else {
                    mayor = exponenteB;
                }
                for (int k = i; k < mayor; k++) {
                    vector[k] = vector[k + 2];
                    vector[k + 1] = vector[k + 3];
                }
                vector[0] = vector[0] - 1;
                terminos = terminos - 2;
            }
            i += 2;
            j += 2;
            expontenteA = terminos - i;
            exponenteB = terminos - j;
        }
        System.out.println("--VECTOR EN FORMA 2--");
        for (i = 0; i < vector.length; i++) {
            System.out.println(vector[i]);
        }
    }

}