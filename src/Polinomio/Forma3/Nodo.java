package Polinomio.Forma3;

public class Nodo {
    private Nodo punta;
    private int coeficiente, expontente;
    private Nodo Liga = null;

    //Constructor
    public Nodo(int coeficiente, int expontente) {
        this.coeficiente = coeficiente;
        this.expontente = expontente;
        this.Liga=Liga;
    }

    //Getters and Setters
    public int getCoeficiente() {
        return coeficiente;
    }

    public void setCoeficiente(int coeficiente) {
        this.coeficiente = coeficiente;
    }

    public int getExpontente() {
        return expontente;
    }

    public void setExpontente(int expontente) {
        this.expontente = expontente;
    }

    public Nodo getLiga() {
        return Liga;
    }

    public void setLiga(Nodo liga) {
        Liga = liga;
    }












}
