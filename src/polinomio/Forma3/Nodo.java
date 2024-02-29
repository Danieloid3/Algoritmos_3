package polinomio.Forma3;

public class Nodo {
    private int Coeficiente;
    private int Exponente;
    private Nodo Liga;

    public Nodo(int coeficiente, int exponente) {
        Coeficiente = coeficiente;
        Exponente = exponente;
        Liga = null;
    }

    public Nodo() {

    }


    public int getCoeficiente() {
        return Coeficiente;
    }

    public void setCoeficiente(int coeficiente) {
        Coeficiente = coeficiente;
    }

    public int getExponente() {
        return Exponente;
    }

    public void setExponente(int grado) {
        Exponente = grado;
    }

    public Nodo getLiga() {
        return Liga;
    }

    public void setLiga(Nodo liga) {
        Liga = liga;
    }


}