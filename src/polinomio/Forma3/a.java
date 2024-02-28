package polinomio.Forma3;
/*import javax.swing.*;
import java.util.Arrays;

public class Forma3 {
    public Nodo punta;
    Nodo Punta;

         public void CrearPolinomio(String VS[], int n) {
        int Exp[] = new int[n], pos = 0, mayor = 0;

            for (int i = 1; i < VS.length && VS[i] != null; i+=2){
                Exp[pos] = Integer.parseInt(VS[i]);
                pos++;
            }
            Arrays.sort(Exp);
            for (int i = Exp.length-1; i >= 0; i--){
                mayor = Exp[i];
                for (int j = 1; j < VS.length && VS[j] != null; j+=2){
                    if (mayor == Integer.parseInt(VS[j])){
                        InsertarFinal(Integer.parseInt(VS[j-1]), mayor);
                    }
                }
            }
    }
        public void InsertarFinal(int Dato, int Exponente)
        { public void ingresarForma3(String VS[], int n) {
            int Exp[] = new int[n], pos = 0, mayor = 0;

            for (int i = 1; i < VS.length && VS[i] != null; i+=2){
                Exp[pos] = Integer.parseInt(VS[i]);
                pos++;
            }
            Arrays.sort(Exp);
            for (int i = Exp.length-1; i >= 0; i--){
                mayor = Exp[i];
                for (int j = 1; j < VS.length && VS[j] != null; j+=2){
                    if (ma
            Nodo x= new Nodo (); //Nodo (Dato)
            x.setCoeficiente(Dato);
            x.setExponente(Exponente);
            Nodo p = Punta;
            if (Punta==null)
            {
                Punta = x ;
            }
            else
            {
                while (p.getLiga() != null)
                {
                    p= p.getLiga();
                }
                p.setLiga(x);
            }
        }
        public void MostrarLista ()
        {
            Nodo p = Punta;
            String s="";
            while (p != null)
            {
                System.out.print("[ " + p.getCoeficiente()+ "-"+ p.getExponente()+" ]");
                s+=  "[ "+ p.getCoeficiente()+"-"+ p.getExponente()+" ]";
                p= p.getLiga();
            }
        }

        public void Suma(Forma3 A, Forma3 B){
            Forma3 C = new Forma3();
            Nodo p = A.Punta, q = B.Punta;
            if (p.getExponente() > q.getExponente()){
                while (p != null || q != null){
                    if (p.getExponente() == q.getExponente()) {
                        C.InsertarFinal(p.getCoeficiente() + q.getCoeficiente(), p.getExponente());
                        p = p.getLiga();
                        q = q.getLiga();
                    }
                    else if (p.getExponente() > q.getExponente()){
                        C.InsertarFinal(p.getCoeficiente(), p.getExponente());
                        p = p.getLiga();
                    }
                    else{
                        C.InsertarFinal(q.getCoeficiente(), q.getExponente());
                        q = q.getLiga();
                    }
                }
            }
            else if (q.getExponente() > p.getExponente()){
                while (p != null || q != null){
                    if (p.getExponente() == q.getExponente()) {
                        C.InsertarFinal(p.getCoeficiente() + q.getCoeficiente(), p.getExponente());
                        p = p.getLiga();
                        q = q.getLiga();
                    }
                    else if (p.getExponente() > q.getExponente()){
                        C.InsertarFinal(p.getCoeficiente(), p.getExponente());
                        p = p.getLiga();
                    }
                    else{
                        C.InsertarFinal(q.getCoeficiente(), q.getExponente());
                        q = q.getLiga();
                    }
                }
            }
            else{
                while (p != null || q != null){
                    if (p.getExponente() == q.getExponente()) {
                        C.InsertarFinal(p.getCoeficiente() + q.getCoeficiente(), p.getExponente());
                        p = p.getLiga();
                        q = q.getLiga();
                    }
                    else if (p.getExponente() > q.getExponente()){
                        C.InsertarFinal(p.getCoeficiente(), p.getExponente());
                        p = p.getLiga();
                    }
                    else{
                        C.InsertarFinal(q.getCoeficiente(), q.getExponente());
                        q = q.getLiga();
                    }
                }
            }
            Nodo r = C.Punta;
            while (r != null){
                C.Eliminar (0);
                r = r.getLiga();
            }
            C.MostrarLista();
        }

        public void Eliminar (int Dato)
        {
            Nodo p = Punta, q = null;
            while (p != null) {
                if (p.getCoeficiente()==Dato) {
                    if (q == null) {
                        Punta = p.getLiga();
                    } else {
                        q.setLiga(p.getLiga());
                    }
                    break;
                }
                q = p;
                p = p.getLiga();
            }
        }

        public void Evaluar (Forma3 A, int x){
            int resultado = 0;
            Nodo p = A.Punta;
            while (p != null){
                if (p.getExponente() == 0){
                    resultado += p.getCoeficiente();
                    p = p.getLiga();
                    continue;
                }
                resultado += p.getCoeficiente() * Math.pow(x, p.getExponente());
                p = p.getLiga();
            }
            System.out.println("El resultado de evaluar el polinomio es: " + resultado);
        }

        public void Multiplicar (Forma3 A, Forma3 B){
            Forma3 C = new Forma3();
            Nodo p = A.Punta, q = B.Punta;

            while (p != null){
                while (q != null){
                    C.InsertarOrdenado(p.getCoeficiente() * q.getCoeficiente(), p.getExponente() + q.getExponente());
                    q = q.getLiga();
                }
                q = B.Punta;
                p = p.getLiga();
            }

            C.MostrarLista();
        }

        public void InsertarOrdenado(int Dato, int Exponente) {
            Nodo x = new Nodo(); //Nodo (Dato)
            x.setCoeficiente(Dato);
            x.setExponente(Exponente);
            Nodo p = Punta;
            Boolean b = false;
            Nodo q = null;

            while (p != null) {
                if (p.getExponente() == Exponente) {
                    p.setCoeficiente(p.getCoeficiente() + Dato);
                    b = true;
                }
                p = p.getLiga();
            }
            if (b == false) {
                p = Punta;
                if (Punta == null) {
                    Punta = x;
                } else {
                    while (p != null && p.getExponente() > Exponente) {
                        q = p;
                        p = p.getLiga();
                    }
                    if (p == Punta) {
                        x.setLiga(Punta);
                        Punta = x;
                    } else {
                        q.setLiga(x);
                        x.setLiga(p);
                    }
                }
            }
        }

        public void InsertarOrdenado2(int Dato, int Exponente) {
            Nodo x = new Nodo(); //Nodo (Dato)
            x.setCoeficiente(Dato);
            x.setExponente(Exponente);
            Nodo p = Punta;
            Boolean b = false, c = false;
            Nodo q = null;
            while (p != null){
                if (p.getExponente() == x.getExponente()){
                    c = true;
                }
                p = p.getLiga();
            }
            if (c == true){
                System.out.println("Ya hay un término con el mismo exponente (semejante)");
            }
            else {
                while (p != null) {
                    if (p.getExponente() == Exponente) {
                        p.setCoeficiente(p.getCoeficiente() + Dato);
                        b = true;
                    }
                    p = p.getLiga();
                }
                if (b == false) {
                    p = Punta;
                    if (Punta == null) {
                        Punta = x;
                    } else {
                        while (p != null && p.getExponente() > Exponente) {
                            q = p;
                            p = p.getLiga();
                        }
                        if (p == Punta) {
                            x.setLiga(Punta);
                            Punta = x;
                        } else {
                            q.setLiga(x);
                            x.setLiga(p);
                        }
                    }
                }
            }
        }

        public void Reconstruir (Forma3 A){
            String s = "";
            Nodo p = A.Punta;

            while (p != null){
                if (p.getCoeficiente() == 1){
                    if (p != Punta) {
                        s += "+";
                    }
                    if (p.getExponente() == 1) {
                        s += "x";
                    } else if (p.getExponente() == 0){
                        s += p.getCoeficiente();
                    } else {
                        s += "x^" + p.getExponente();
                    }
                }
                else if (p.getCoeficiente() == -1){
                    if (p.getExponente() == 1) {
                        s += "-x";
                    } else if (p.getExponente() == 0){
                        s += p.getCoeficiente();
                    } else {
                        s += "-x^" + (p.getExponente());
                    }
                } else {
                    if (p != Punta && p.getCoeficiente() > 0) {
                        s += "+";
                    }
                    if (p.getExponente() == 1) {
                        s += p.getCoeficiente() + "x";
                    } else if (p.getExponente() == 0) {
                        s += p.getCoeficiente();
                    } else {
                        s += p.getCoeficiente() + "x^" + p.getExponente();
                    }
                }
                p = p.getLiga();
            }
            System.out.println("El polinomio reconstruido es: " + s);
        }

        public void EliminarTermino(){
            int a = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el exponente del termino a eliminar"));
            boolean b = false;
            Nodo p = Punta;

            while (p != null){
                if (p.getExponente() == a){
                    b = true;
                }
                p = p.getLiga();
            }
            if (b == true) {
                p = Punta;
                if (a <= p.getExponente()) {
                    if (a == p.getExponente()) {
                        Punta = p.getLiga();
                    }
                    else {
                        while (p.getLiga() != null) {
                            if (a == p.getLiga().getExponente()) {
                                if (p.getLiga().getExponente() == 0){
                                    p.setLiga(p.getLiga().getLiga());
                                    break;
                                }
                                p.setLiga(p.getLiga().getLiga());
                            }
                            p = p.getLiga();
                        }
                    }
                }
                this.MostrarLista();
            }
            else {
                System.out.println("El termino no existe");
            }
        }
}

*/