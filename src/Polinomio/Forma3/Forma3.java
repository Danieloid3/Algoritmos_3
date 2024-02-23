package Polinomio.Forma3;

public class Forma3 {
    private Nodo punta;

    public Forma3() {
        this.punta = null;
    }


    public void forma3(String vectorB[]) {
        for (int i = 0; vectorB[i] != null && i<vectorB.length; i += 2) {
                Nodo nuevo = new Nodo(Integer.parseInt(vectorB[i]), Integer.parseInt(vectorB[i+1]));
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
        while(punta != null) {
            System.out.println(punta.getCoeficiente());
            System.out.println(punta.getExpontente());
            punta = punta.getLiga();

        }
    }




}


