package Polinomio.Forma1;

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

    public String [] ingresar(String vectorB[]) {
        int posicion;
        int j=0;
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
    public void Ajustar(){
        int cont=0,i =1;
        while(i<datosUtiles && vector[i]==0){
                cont++;
                i++;
        }
        while(i<datosUtiles){
            posicion= i-cont;
            vector[i]=posicion;
            i++;

        }
        datosUtiles=vector[0]-cont;
    }


    public void eliminar(int exponente){
        int i=2;
        int j=3;
        int mayor=0;
        int expontenteA=datosUtiles-i;
        int exponenteB=datosUtiles-j;
        if(vector[0]== exponente){
            vector[0] = Integer.parseInt("0");
            vector[1] = Integer.parseInt("0");

            while(i<datosUtiles){
                if(expontenteA>exponenteB){
                    mayor = expontenteA;
                }else {
                    mayor = exponenteB;
                }
                i++;
                j++;
            }
            vector[0] = mayor;

        }else {
            posicion = datosUtiles - exponente;
            vector[posicion] = Integer.parseInt("0");
        }

        System.out.println("--NUEVO VECTOR--");
        for ( i = 0; i < vector.length; i++) {
            System.out.println(vector[i]);
        }
    }

    public int evaluar(int x){
        int i;
        int grado = datosUtiles-1;
        int suma = 0;

        for (i = 1; i < datosUtiles; i++) {
            suma = (int) (suma + vector[i] * Math.pow(x,grado));
            grado--;
            if (grado == 0) {
                suma = suma + vector[i+1];
                break;
            }


        }
        System.out.println(Math.pow(2,2));
        System.out.println("La suma es: " + suma);
        return suma;
    }



}

