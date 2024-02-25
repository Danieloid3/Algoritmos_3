package Polinomio.Forma3;

import java.util.Scanner;

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
        Nodo P = punta;
        Nodo Q = punta.getLiga();
        Nodo aux = new Nodo(P.getCoeficiente(), P.getExpontente());

        while (P != null && Q != null) {
            if (P.getExpontente() < Q.getExpontente()) {
                aux.setCoeficiente(P.getCoeficiente());
                aux.setExpontente(P.getExpontente());
                P.setCoeficiente(Q.getCoeficiente());
                P.setExpontente(Q.getExpontente());
                Q.setCoeficiente(aux.getCoeficiente());
                Q.setExpontente(aux.getExpontente());
            } else {
                Q = Q.getLiga();
                P = P.getLiga();
            }
        }

        while (punta != null) {
            System.out.println(punta.getCoeficiente());
            System.out.println(punta.getExpontente());
            punta = punta.getLiga();

        }
    }

    public void sumar(Forma3 Poli){
        Nodo P = punta;
        Nodo Q = Poli.punta;
        while (P != null && Q != null) {
            if (P.getExpontente() == Q.getExpontente()) {
                P.setCoeficiente(P.getCoeficiente() + Q.getCoeficiente());
                P = P.getLiga();
                Q = Q.getLiga();
            } else if (P.getExpontente() < Q.getExpontente()) {
                Nodo aux = new Nodo(Q.getCoeficiente(), Q.getExpontente());
                aux.setLiga(P);
                P = aux;
                Q = Q.getLiga();
            } else {
                P = P.getLiga();
            }
        }
        while (P != null) {
            System.out.println("--SUMA FORMA 3--");
            System.out.println(P.getCoeficiente());
            System.out.println(P.getExpontente());
            P = P.getLiga();
        }
    }

    public void evaluar(int x) {
        Nodo aux = punta;
        int resultado = 0;

        while (aux != null) {
            resultado += aux.getCoeficiente() * (int)Math.pow(x, aux.getExpontente());
            aux = aux.getLiga();
        }

        System.out.println("El resultado al evaluar x es: " + resultado);
        while (aux != null) {
            System.out.println("--SUMA FORMA 3--");
            System.out.println(aux.getCoeficiente());
            System.out.println(aux.getExpontente());
            aux = aux.getLiga();
        }
    }

    public void Eliminar(int dato){
        Nodo P=punta;
        Nodo Q=P.getLiga();
        boolean found = false;
        Nodo aux=new Nodo();
        while(P!=null && Q!=null){
            if(Q.getExpontente()==dato){
                aux=Q;
                Q=Q.getLiga();
                aux.getLiga().setLigaI(aux.getLigaI());
                aux.getLiga().setLigaD(aux.getLigaD());
                found = true;
                System.out.println("El dato se eliminó de la lista");

            }else{
                Q=Q.getLiga();

            }
        }
        if(!found) System.out.println("El dato no se encontró en la lista");
    }
    public void insertarOrdenado(int coeficiente, int expontente) {
        if (this.punta == null) return;
        Nodo P = this.punta;
        Nodo Q = P;

        while (dato > P.getDato() && P != null) {
            Q = P;
            P = P.getLigaD();
        }
        Nodo x = new Nodo(dato);
        if (P != Q) Q.setLigaD(x);
        x.setLigaD(P);
        x.setLigaI(Q);
        if (P == Q) this.punta = x;
    }

}






