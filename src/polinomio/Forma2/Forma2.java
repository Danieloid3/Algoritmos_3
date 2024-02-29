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
    public void ingresarForma2(String[] vectorB) {
        int j = 0;
        int i;
        int posicion;
        int grado = 0;
        int factor = 0;
        boolean independiente = false;
        vector[0] = terminos / 2;
        for (i = 1; vectorB[i] != null; i += 2) {
            if (Integer.parseInt(vectorB[i]) == 0) {
                independiente = true;

            }
            if (Integer.parseInt(vectorB[i]) > grado) {
                grado = Integer.parseInt(vectorB[i]);
            }
        }

        if (grado > (terminos / 2)) {
            if (independiente) {
                factor = terminos + (grado - terminos / 2) * 2;
            } else {
                factor = terminos + (grado - terminos / 2) * 2 + 2;
            }

        }else {
            factor = terminos;
        }

        for (i = 1; vectorB[i] != null; i += 2) {
            posicion = factor - Integer.parseInt(vectorB[i])*2;
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
    //Sumar dos polinomios de forma 2
    public void sumar(Forma2 Poli){
        int i = 1;
        int j = 1;
        int k = 1;
        int[] vectorC = new int[terminos + Poli.terminos + 1];

        int terminosC = 0;
        int terminosA = vector[0]*2;
        int terminosB = Poli.vector[0]*2;
        while (i <= terminosA && j <= terminosB) {
            if (vector[i+1] == Poli.vector[j+1]) {
                vectorC[k] = vector[i] + Poli.vector[j];
                vectorC[k + 1] = vector[i + 1];
                i += 2;
                j += 2;
            } else if (vector[i+1] < Poli.vector[j+1]) {
                vectorC[k] = Poli.vector[j];
                vectorC[k + 1] = Poli.vector[j + 1];
                j += 2;
            } else {
                vectorC[k] = vector[i];
                vectorC[k + 1] = vector[i + 1];
                i += 2;
            }
            k += 2;
            terminosC++;
        }
        while (i <= terminosA) {
            vectorC[k] = vector[i];
            vectorC[k + 1] = vector[i + 1];
            i += 2;
            k += 2;
            terminosC++;
        }
        while (j <= terminosB) {
            vectorC[k] = Poli.vector[j];
            vectorC[k + 1] = Poli.vector[j + 1];
            j += 2;
            k += 2;
            terminosC++;
        }
        vectorC[0] = terminosC;
        System.out.println("--SUMA FORMA 2--");

        i = 0;
        while (i < vectorC.length) {

            System.out.println(vectorC[i]);

            if (vectorC[i]==0 && vectorC[i+1]==0) {
                break;
            }
            i++;
        }
    }
    //Multiplicar dos polinomios de forma 2
    public void multiplicar(Forma2 Poli){
        int i = 1;
        int j = 1;
        int k = 1;
        int[] vectorC = new int[terminos + Poli.terminos + 1];
        int terminosC = 0;
        int terminosA = vector[0]*2;
        int terminosB = Poli.vector[0]*2;
        for (i = 1; i <= terminosA; i += 2) {
            for (j = 1; j <= terminosB; j += 2) {
                vectorC[k] = vector[i] * Poli.vector[j];
                vectorC[k + 1] = vector[i + 1] + Poli.vector[j + 1];
                k += 2;
                terminosC++;
            }
        }
        vectorC[0] = terminosC;
        System.out.println("--MULTIPLICACION FORMA 2--");
        i = 0;
        while (i < vectorC.length) {
            System.out.println(vectorC[i]);
            if (vectorC[i]==0 && vectorC[i+1]==0) {
                break;
            }
            i++;
        }
    }
    //reconstruir polinomio de forma 2
    public void reconstruir(){
        int i = 1;
        int j = 1;
        int k = 1;
        int[] vectorC = new int[terminos + 1];
        int terminosC = 0;
        for (i = 1; i <= terminos; i += 2) {
            vectorC[k] = vector[i];
            vectorC[k + 1] = vector[i + 1];
            k += 2;
            terminosC++;
        }
        vectorC[0] = terminosC;
        System.out.println("--RECONSTRUCCION FORMA 2--");
        i = 0;
        while (i < vectorC.length) {
            System.out.println(vectorC[i]);
            if (vectorC[i]==0 && vectorC[i+1]==0) {
                break;
            }
            i++;
        }
    }
    //Evaluar polinomio de forma 2
    public void evaluar(int x){
        int i = 1;
        int resultado = 0;
        for (i = 1; i <= terminos; i += 2) {
            resultado += vector[i] * (int) Math.pow(x, vector[i + 1]);
        }
        System.out.println("--EVALUACION FORMA 2--");
        System.out.println(resultado);
    }
    //insertar un termino nuevo
    public void insertar(int coeficiente, int exponente){
        int i = 1;
        int j = 1;
        int k = 1;
        int[] vectorC = new int[terminos + 3];
        int terminosC = 0;
        int terminosA = vector[0]*2;
        vectorC[0] = vector[0] + 1;
        for (i = 1; i <= terminosA; i += 2) {
            if (exponente > vector[i + 1]) {
                vectorC[k] = vector[i];
                vectorC[k + 1] = vector[i + 1];
                k += 2;
                terminosC++;
            } else {
                vectorC[k] = coeficiente;
                vectorC[k + 1] = exponente;
                k += 2;
                terminosC++;
                vectorC[k] = vector[i];
                vectorC[k + 1] = vector[i + 1];
                k += 2;
                terminosC++;
                i += 2;
                break;
            }
        }
        while (i <= terminosA) {
            vectorC[k] = vector[i];
            vectorC[k + 1] = vector[i + 1];
            k += 2;
            terminosC++;
            i += 2;
        }
        vectorC[0] = terminosC;
        System.out.println("--INSERCION FORMA 2--");
        i = 0;
        while (i < vectorC.length) {
            System.out.println(vectorC[i]);
            if (vectorC[i]==0 && vectorC[i+1]==0) {
                break;
            }
            i++;
        }
    }


}