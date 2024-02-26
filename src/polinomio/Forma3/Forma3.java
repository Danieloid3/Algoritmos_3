package polinomio.Forma3;

import java.util.Scanner;


public class Forma3 {
    private Nodo punta;

    public Forma3(String cadena) {
        String[] Vs = crearVectorString(cadena);
        punta = null;
        for (int i = 0; i < Vs.length && Vs[i] != null; i += 2) {
            insertarDescendente(Integer.parseInt(Vs[i]), Integer.parseInt(Vs[i + 1]));
        }
    }

    public String[] crearVectorString(String Cadena) {
        String S = "";
        int j = 0;

        Cadena.toLowerCase();

        char Vc[] = Cadena.toCharArray();
        String Vs[] = new String[Vc.length + 1];

        for (int i = 0; i < Vc.length; i++) {
            if (Character.isDigit(Vc[i])) {
                S += Character.toString(Vc[i]);
                if (i == Vc.length - 1) {
                    Vs[j] = S;
                    Vs[j + 1] = "0";
                }
            } else if (Vc[i] == '-' || Vc[i] == '+') {
                if (S.equals("")) {
                    if (Vc[i] == '-') {
                        S += Character.toString(Vc[i]);
                    }
                } else {
                    Vs[j] = S;
                    Vs[j + 1] = "0";
                    j += 2;
                    S = "";
                    if (Vc[i] == '-') {
                        S += Character.toString(Vc[i]);
                    }
                }
            } else if (Vc[i] == 'x') {
                if (S.equals("") || Vc[i - 1] == '-') {
                    S += "1";
                    Vs[j] = S;
                } else {
                    Vs[j] = S;
                }
                j++;
                S = "";
                if (i != Vc.length - 1 && Vc[i + 1] == '^') {
                    Vs[j] = Character.toString(Vc[i + 2]);
                    i += 2;
                    j++;
                } else {
                    Vs[j] = "1";
                    j++;
                }

            }
        }

        return Vs;
    }

    public void insertarDescendente(int d, int c) {
        Nodo p = punta, x = new Nodo(d, c), q = punta;
        if (punta == null) {
            punta = x;
            punta.setLiga(null);
        } else {
            if (x.getExponente() < p.getExponente()) {
                do {
                    p = p.getLiga();
                } while (p != null && x.getExponente() < p.getExponente());
                if (p != null) {
                    x.setLiga(p);
                    while (q.getLiga() != p) {
                        q = q.getLiga();
                    }
                    q.setLiga(x);
                } else {
                    while (q.getLiga() != p) {
                        q = q.getLiga();
                    }
                    q.setLiga(x);
                }
            } else {
                x.setLiga(punta);
                punta = x;
            }
        }
    }

    public void mostrar() {
        Nodo x = punta;
        do {
            if (x.getLiga() == null) {
                System.out.print("[" + x.getCoeficiente() + "][" + x.getExponente() + "]\n");
            } else {
                System.out.print("[" + x.getCoeficiente() + "][" + x.getExponente() + "]-->");
            }
            x = x.getLiga();
        } while (x != null);
    }

    public void insertar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el monomio a insertar: ");
        String cadena = scanner.nextLine();

        Forma3 monomio = new Forma3(cadena);
        Nodo x = punta;
        while (x != null && x.getExponente() != monomio.punta.getExponente()) {
            x = x.getLiga();
        }
        if (x == null) {
            insertarDescendente(monomio.punta.getCoeficiente(), monomio.punta.getExponente());
        } else {
            x.setCoeficiente(x.getCoeficiente() + monomio.punta.getCoeficiente());
        }
        redimensionar();
        mostrar();
    }

    public void redimensionar() {
        Nodo x = punta, q = punta;
        while (x != null) {
            if (x.getCoeficiente() == 0) {
                if (x == punta) {
                    punta = x.getLiga();
                    x.setLiga(null);
                } else {
                    q = punta;
                    while (q.getLiga() != x) {
                        q = q.getLiga();
                    }
                    q.setLiga(x.getLiga());
                    x.setLiga(null);
                }
            }
            if (x.getLiga() != null && x.getExponente() == x.getLiga().getExponente()) {
                if (x == punta) {
                    x.setCoeficiente(x.getCoeficiente() + x.getLiga().getCoeficiente());
                } else {
                    q = punta;
                    while (q.getLiga() != x) {
                        q = q.getLiga();
                    }
                    x.setCoeficiente(x.getCoeficiente() + x.getLiga().getCoeficiente());
                }
            }
            x = x.getLiga();
        }
    }

    public void eliminar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el monomio a eliminar: ");
        String cadena = scanner.nextLine();

        Forma3 monomio = new Forma3(cadena);
        Nodo x = punta;
        while (x != null && (x.getExponente() != monomio.punta.getExponente() || x.getCoeficiente() != monomio.punta.getCoeficiente())) {
            x = x.getLiga();
        }
        if (x == null) {
            System.out.println("No se encuentra el monomio a eliminar");
        } else {
            x.setCoeficiente(-x.getCoeficiente() + monomio.punta.getCoeficiente());
            redimensionar();
            mostrar();
        }
    }

    public void reconstruir() {
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

    public void evaluar() {
        Nodo x = punta;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el valor a evaluar: ");
        int valor = scanner.nextInt();

        int resultado = 0;
        while (x != null) {
            resultado += x.getCoeficiente() * (Math.pow(valor, x.getExponente()));
            x = x.getLiga();
        }
        System.out.println(resultado);
    }

    public void sumar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el polinomio a sumar: ");
        String cadena = scanner.nextLine();
        Forma3 polinomio = new Forma3(cadena), resultado = new Forma3();
        Nodo x = punta, q = polinomio.punta;
        while (x != null || q != null) {
            if (x != null && q != null) {
                if (x.getExponente() > q.getExponente()) {
                    resultado.insertarDescendente(x.getCoeficiente(), x.getExponente());
                    x = x.getLiga();
                } else if (x.getExponente() < q.getExponente()) {
                    resultado.insertarDescendente(q.getCoeficiente(), q.getExponente());
                    q = q.getLiga();
                } else if (x.getExponente() == q.getExponente()) {
                    resultado.insertarDescendente((q.getCoeficiente() + x.getCoeficiente()), q.getExponente());
                    q = q.getLiga();
                    x = x.getLiga();
                }
            } else if (x != null) {
                resultado.insertarDescendente(x.getCoeficiente(), x.getExponente());
                x = x.getLiga();
            } else {
                resultado.insertarDescendente(q.getCoeficiente(), q.getExponente());
                q = q.getLiga();
            }
        }
        resultado.redimensionar();
        punta = resultado.punta;
        mostrar();
    }

    public Forma3() {
        punta = null;
    }

    public void multiplicar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el polinomio a multiplicar: ");
        String cadena = scanner.nextLine();
        Forma3 B = new Forma3(cadena);
        Nodo p = punta;
        Nodo q = B.punta;
        Nodo aux;

        int coeficiente = 0;
        int exponente = 0;
        Forma3 R = new Forma3();
        while (q != null) {
            aux = p;
            while (p != null) {
                exponente = p.getExponente() + q.getExponente();
                coeficiente = p.getCoeficiente() * q.getCoeficiente();
                R.insertarDescendente(coeficiente, exponente);
                p = p.getLiga();
            }
            p = aux;
            q = q.getLiga();
        }
        R.redimensionar();
        punta = R.punta;
        mostrar();
    }

}

