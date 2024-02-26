package polinomio.Forma3;

public class Forma3 {
    private Nodo punta;

    public void forma3(String vectorB[]) {
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
        Nodo aux = new Nodo(P.getCoeficiente(), P.getExponente());

        while (P != null && Q != null) {
            if (P.getExponente() < Q.getExponente()) {
                aux.setCoeficiente(P.getCoeficiente());
                aux.setExponente(P.getExponente());
                P.setCoeficiente(Q.getCoeficiente());
                P.setExponente(Q.getExponente());
                Q.setCoeficiente(aux.getCoeficiente());
                Q.setExponente(aux.getExponente());
            } else {
                Q = Q.getLiga();
                P = P.getLiga();
            }
        }
        Nodo x = punta;
        while (x != null) {
            System.out.println(x.getCoeficiente());
            System.out.println(x.getExponente());
            x = x.getLiga();
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
        System.out.println("--SUMA FORMA 3--");
        Nodo x = punta;
        while (x != null) {
            System.out.println(x.getCoeficiente());
            System.out.println(x.getExponente());
            x = x.getLiga();
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

    public void reconstruir() {
        String cadena = "";
        Nodo x = punta;
        while (x != null) {
            int coeficiente = x.getCoeficiente();
            int exponente = x.getExponente();
            if (x != punta && coeficiente > 0) {
                cadena += "+";
            }
            if (coeficiente != 1 && coeficiente != -1 || exponente == 0) {
                cadena += coeficiente;
            } else if (coeficiente == -1) {
                cadena += "-";
            }
            if (exponente != 0) {
                cadena += "x";
                if (exponente != 1) {
                    cadena += "^" + exponente;
                }
            }
            x = x.getLiga();
        }
        System.out.println(cadena);
    }


    public void Eliminar(int dato){
        Nodo P = punta;
        Nodo Q = P.getLiga();
        Nodo aux = new Nodo(0,0);
        while(P!=null && Q!=null){
            if(Q.getExponente()==dato){
                aux=Q;
                Q=Q.getLiga();
                aux.getLiga().setLiga(aux.getLiga());
                System.out.println("El dato se eliminó de la lista");

            }else{
                Q=Q.getLiga();

            }
        }
    }

    public void insertarOrdenado(int coeficiente, int expontente) {
        Nodo P = this.punta;
        Nodo Q = P;
        while (expontente > P.getExponente() && P != null) {
            Q = P;
            P = P.getLiga();
        }
        Nodo x = new Nodo(coeficiente, expontente);
        if (P != Q){
            Q.setLiga(x);
        }
        x.setLiga(P);
        if (P == Q){
            this.punta = x;
        }

    }

    public void multiplicar(Forma3 Poli){
        Nodo P = punta;
        Nodo Q = Poli.punta;
        Nodo R = null;
        Nodo T = null;
        while (P != null){
            while (Q != null){
                int coeficiente = P.getCoeficiente() * Q.getCoeficiente();
                int exponente = P.getExponente() + Q.getExponente();
                if (R == null){
                    R = new Nodo(coeficiente, exponente);
                    T = R;
                }else{
                    T.setLiga(new Nodo(coeficiente, exponente));
                    T = T.getLiga();
                }
                Q = Q.getLiga();
            }
            P = P.getLiga();
            Q = Poli.punta;
        }
        Forma3 resultado = new Forma3();
        resultado.punta = R;
    }
}