package Eksempelklasser.Tabellstack;

import java.util.Arrays;
import java.util.Stack;

public class TabellStack<T> implements Stakk<T> {

    private T[] a;
    private int antall;

    public TabellStack() {
        this(8);
    }

    @SuppressWarnings("unchecked")
    public TabellStack(int lengde) {

        if (lengde < 0) {
            throw new IllegalArgumentException
                    ("Negativ tabelllengde!");
        }

        a = (T[]) new Object[lengde];
        antall = 0;
    }

    @Override
    public void leggInn(T verdi) {

        if (antall == a.length) {
            a = Arrays.copyOf(a, (3*a.length)/2);
        }

        a[antall++] = verdi;
    }

    @Override
    public T kikk() {
        return a[antall-1];
    }

    @Override
    public T taUt() {
        T temp = a[antall-1];
        a[antall-- - 1] = null;
        return temp;
    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public boolean tom() {
        return antall == 0;
    }

    @Override
    public void nullstill() {
        if (antall > 0) {
            for (int i = 0; i < antall; i++) {
                a[i] = null;
            }
            antall = 0;
        }
    }

    @Override
    public String toString() {

        if (antall == 0) return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        if (antall > 0) {
            for (int i = antall-1; i > 0; i--) {
                sb.append(a[i]).append(", ");
            }
            sb.append(a[0]);
        }

        sb.append("]");
        return sb.toString();
    }

    public static <T> void snu(Stakk<T> A) {
        Stakk<T> B = new TabellStack<>();
        Stakk<T> C = new TabellStack<>();

        while (!A.tom()) { B.leggInn(A.taUt()); }
        while (!B.tom()) { C.leggInn(B.taUt());}
        while (!C.tom()) { A.leggInn(C.taUt());}
    }

    public static <T> void snu2(Stakk<T> A) {

        Stakk<T> B = new TabellStack<>();
        int i = A.antall() - 1;
        T temp;

        while (i > 0) {

            temp = A.taUt();
            for (int j = 0; j < i; j++) {
                B.leggInn(A.taUt());
            }
            A.leggInn(temp);
            while (!B.tom()) A.leggInn(B.taUt());
            i--;
        }
    }


    public static <T> void kopier(Stakk<T> A, Stakk<T> B) {
        if (A.antall() == 0) return;

        Stakk<T> C = new TabellStack<>();

        while (!A.tom()) C.leggInn(A.taUt());

        while (!C.tom()) {
            T temp = C.taUt();
            A.leggInn(temp);
            B.leggInn(temp);
        }
    }


    public static <T> void kopier2(Stakk<T> A, Stakk<T> B) {
        if (A.antall() == 0) return;

        int i = A.antall();
        T temp = null;

        while (i > 0) {
            for (int j = 0; j < i; j++) {
                B.leggInn(A.taUt());
            }
            temp = B.kikk();
            for (int j = 0; j < i; j++) {
                A.leggInn(B.taUt());
            }
            B.leggInn(temp);
            i--;
        }
        //B.leggInn(temp);
    }
}
