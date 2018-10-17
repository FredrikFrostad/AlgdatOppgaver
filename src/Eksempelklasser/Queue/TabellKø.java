package Eksempelklasser.Queue;

import Eksempelklasser.Tabellstack.Stakk;
import Eksempelklasser.Tabellstack.TabellStack;

import java.util.NoSuchElementException;

public class TabellKø<T> implements Kø<T>
{
    private T[] a;      // en tabell
    private int fra;    // posisjonen til den første i køen
    private int til;    // posisjonen til første ledige plass

    @SuppressWarnings("unchecked")      // pga. konverteringen: Object[] -> T[]
    public TabellKø(int lengde)
    {
        if (lengde < 1)
            throw new IllegalArgumentException("Må ha positiv lengde!");

        a = (T[])new Object[lengde];

        fra = til = 0;    // a[fra:til> er tom
    }

    public TabellKø()   // standardkonstruktør
    {
        this(8);
    }

    private T[] utvidTabell(int lengde)
    {
        @SuppressWarnings("unchecked")      // pga. konverteringen: Object[] -> T[]
                T[] b = (T[])new Object[lengde];  // ny tabell

        // kopierer intervallet a[fra:a.length> over i b
        System.arraycopy(a,fra,b,0,a.length - fra);

        // kopierer intervallet a[0:fra> over i b
        System.arraycopy(a,0,b,a.length - fra, fra);

        fra = 0; til = a.length;
        return b;
    }

    @Override
    public boolean leggInn(T verdi) {
        a[til] = verdi;                                 // ny verdi bakerst
        til++;                                          // øker til med 1
        if (til == a.length) til = 0;                   // hopper til 0
        if (fra == til) a = utvidTabell(2*a.length);    // sjekker og dobler
        return true;
    }

    @Override
    public T kikk() {
        return a[fra];
    }

    @Override
    public T taUt() {
        if (fra == til) throw new         // sjekker om køen er tom
                NoSuchElementException("Køen er tom!");

        T temp = a[fra];                  // tar vare på den første i køen
        a[fra] = null;                    // nuller innholdet
        fra++;                            // øker fra med 1
        if (fra == a.length) fra = 0;     // hopper til 0
        return temp;
    }

    @Override
    public int antall() {
        return fra <= til ? til - fra : a.length + til - fra;
    }

    @Override
    public boolean tom() {
        return fra == til;
    }

    @Override
    public void nullstill() {
        for (int i = 0; i < a.length; i++) {
            a[i] = null;
        }
        fra = til = 0;
    }

    @Override
    public String toString() {

        if (fra == til) return "[]";

        int i = fra;
        if (i == a.length) i = 0;

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(a[i++]);

        while (i != til) {
            if (i == a.length) i = 0;
            sb.append(", ").append(a[i]);
            i++;
            if (i == a.length) i = 0;
        }
        sb.append("]");

        return sb.toString();
    }

    public int indeksTil(T verdi) {
        System.out.println("lengde: " + a.length);
        int indeks = fra;
        if (indeks == a.length) indeks = 0;

        while (indeks != til) {
            if (verdi.equals(a[indeks])) {
                //System.out.println("fra: " + fra);
                //System.out.println("indeks: " + indeks);
                return fra <= indeks ? indeks - fra : a.length + indeks - fra;
            }
            indeks++;
            if (indeks == a.length) indeks = 0;
        }

        return -1; //Verdi ikke i kø
    }

    public static <T> void snu(Stakk<T> A)  {
        TabellKø<T> B = new TabellKø<>();

        while (!A.tom()) B.leggInn(A.taUt());
        while (!B.tom()) A.leggInn(B.taUt());
    }

    public static <T> void snu(Kø<T> A) {
        TabellStack<T> B = new TabellStack<>();

        while (!A.tom()) B.leggInn(A.taUt());
        while (!B.tom()) A.leggInn(B.taUt());
    }
}