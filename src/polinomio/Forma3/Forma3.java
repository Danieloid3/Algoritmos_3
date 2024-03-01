package polinomio.Forma3;

import polinomio.Forma1.Forma1;
import polinomio.Forma2.Forma2;

public class Forma3 {
    private Nodo punta;

    public Forma3() {
        this.punta = null;
    }


    public void forma3(String[] vectorB) {
        for (int i = 0; vectorB[i] != null && i < vectorB.length; i += 2) {
            Nodo nuevo = new Nodo(Integer.parseInt(vectorB[i]), Integer.parseInt(vectorB[i + 1]));
            if (punta == null) {
                punta = nuevo;
            } else {
                Nodo aux = punta;
                while (aux.getLiga() != null) {
                    aux = aux.getLiga();
                }
                aux.setLiga(nuevo);
            }
        }

    }

    public void ordenar() {
        Nodo P = new Nodo();
        Nodo Q = new Nodo();
        int coeficiente;
        int exponente;
        for (P = punta; P != null; P = P.getLiga()) {
            for (Q = P.getLiga(); Q != null; Q = Q.getLiga()) {
                if (P.getExponente() < Q.getExponente()) {
                    coeficiente = P.getCoeficiente();
                    exponente = P.getExponente();
                    P.setCoeficiente(Q.getCoeficiente());
                    P.setExponente(Q.getExponente());
                    Q.setCoeficiente(coeficiente);
                    Q.setExponente(exponente);
                }
            }
        }


        P = punta;
        while (P != null) {
            System.out.println("[" + P.getCoeficiente() + "]" + "[" + P.getExponente() + "]");
            P = P.getLiga();
        }
    }

    public void sumar(Forma3 Poli) {
        Nodo P = punta;
        Nodo Q = Poli.punta;
        while (P != null && Q != null) {
            if (P.getExponente() == Q.getExponente()) {
                P.setCoeficiente(P.getCoeficiente() + Q.getCoeficiente());
                P = P.getLiga();
                Q = Q.getLiga();
            } else if (P.getExponente() < Q.getExponente()) {
                Nodo aux = new Nodo(Q.getCoeficiente(), Q.getExponente());
                aux.setLiga(P);
                P = aux;
                Q = Q.getLiga();
            } else {
                P = P.getLiga();
            }
        }
        P = punta;
        System.out.println("--SUMA FORMA 3--");
        while (P != null) {
            System.out.println("[" + P.getCoeficiente() + "]" + "[" + P.getExponente() + "]");
            P = P.getLiga();
        }
    }

    public void evaluar(int x) {
        Nodo aux = punta;
        int resultado = 0;

        while (aux != null) {
            resultado += aux.getCoeficiente() * (int) Math.pow(x, aux.getExponente());
            aux = aux.getLiga();
        }

        System.out.println("El resultado al evaluar x es: " + resultado);
    }

    public void eliminar(int Dato) {
        Nodo P = punta;
        Nodo Q = null;
        while (P != null) {
            if (P.getCoeficiente() == Dato) {
                if (P == null) {
                    punta = P.getLiga();
                } else {
                    Q.setLiga(P.getLiga());
                }
                break;
            }
            Q = P;
            P = P.getLiga();
        }
        P = punta;
        System.out.println("---ELIMINAR FORMA 3");
        while (P != null) {
            System.out.println("[" + P.getCoeficiente() + "]" + "[" + P.getExponente() + "]");
            P = P.getLiga();
        }
    }

    public void Reconstruir() {
        String cadena = "";
        Nodo x = punta;
        while (x != null) {
            int coe = x.getCoeficiente();
            int gra = x.getExponente();
            if (x != punta && coe > 0) {
                cadena += "+";
            }
            if (coe != 1 && coe != -1 || gra == 0) {
                cadena += coe;
            } else if (coe == -1) {
                cadena += "-";
            }
            if (gra != 0) {
                cadena += "x";
                if (gra != 1) {
                    cadena += "^" + gra;
                }
            }
            x = x.getLiga();
        }
        System.out.println(cadena);
    }

    public void Multiplicar(Forma3 poli3) {
        Forma3 Nuevo = new Forma3();
        Nodo P = poli3.punta;
        Nodo Q = punta;

        while (P != null) {
            while (Q != null) {
                Nuevo.InsertarOrdenado(P.getCoeficiente() * Q.getCoeficiente(), P.getExponente() + Q.getExponente());
                Q = Q.getLiga();
            }
            Q = punta;
            P = P.getLiga();
        }
        P = Nuevo.punta;
        System.out.println("---MULTIPLICACION FORMA 3");
        while (P != null) {
            System.out.println("[" + P.getCoeficiente() + "]" + "[" + P.getExponente() + "]");
            P = P.getLiga();
        }

    }

    public void MostrarLista() {
        Nodo P = punta;
        String s = "";
        while (P != null) {
            System.out.println("[" + P.getCoeficiente() + "]" + "[" + P.getExponente() + "]");
            s += "[" + P.getCoeficiente() + "]" + "[" + P.getExponente() + "]";
            P = P.getLiga();
        }
    }

    public void InsertarOrdenado(int Dato, int Exponente) {
        Nodo x = new Nodo(); //Nodo (Dato)
        x.setCoeficiente(Dato);
        x.setExponente(Exponente);
        Nodo P = punta;
        boolean bool = false;
        Nodo Q = null;

        while (P != null) {
            if (P.getExponente() == Exponente) {
                P.setCoeficiente(P.getCoeficiente() + Dato);
                bool = true;
            }
            P = P.getLiga();
        }
        if (bool == false) {
            P = punta;
            if (punta == null) {
                punta = x;
            } else {
                while (P != null && P.getExponente() > Exponente) {
                    Q = P;
                    P = P.getLiga();
                }
                if (P == punta) {
                    x.setLiga(punta);
                    punta = x;
                } else {
                    Q.setLiga(x);
                    x.setLiga(P);
                }
            }
        }
    }

    public void sumaFormas(Forma2 poli2) {
        Forma1 nuevo = new Forma1(0);
        Nodo P = punta;
        int j = 1;

        int grado2 = 0;
        int grado3 = 0;
        int grado1 = 0;
        nuevo = new Forma1(poli2.getTerminos() / 2 + 1);

        while (P != null) {
            if (P.getExponente() > grado3) {
                grado3 = P.getExponente();
            }
            P = P.getLiga();
        }
        for (int i = 2; i <= poli2.getTerminos(); i += 2) {
            if (poli2.getVector()[i] > grado2) {
                grado2 = poli2.getVector()[i];
            }
        }
        if (grado2 > grado3) {
            nuevo.getVector()[0] = grado2;
        } else {
            nuevo.getVector()[0] = grado3;
        }

        int i = 2;
        P = punta;
        while ((i <= poli2.getTerminos()) && (P != null) && (j < nuevo.getVector().length)) {
            if (poli2.getVector()[i] == P.getExponente()) {
                nuevo.getVector()[j] = P.getCoeficiente() + poli2.getVector()[i - 1];
                j += 1;
                i += 2;
                P = P.getLiga();
            } else if (poli2.getVector()[i] > P.getExponente()) {
                nuevo.getVector()[j] = poli2.getVector()[i - 1];
                j += 1;
                i += 2;
            } else {
                nuevo.getVector()[j] = P.getCoeficiente();
                j += 1;
                P = P.getLiga();

            }
        }

        {


            for (i = 0; i < nuevo.getVector().length; i++) {
                System.out.println(nuevo.getVector()[i]);
            }

        }
    }
}


