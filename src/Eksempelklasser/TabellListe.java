package Eksempelklasser;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class TabellListe<T> implements Liste<T> {

    private T[] a;
    private int antall;
    private int endringer;

    @SuppressWarnings("unchecked")          // pga. konverteringen: Object[] -> T[]
    public TabellListe(int størrelse)       // konstruktør
    {
        a = (T[])new Object[størrelse];       // oppretter tabellen
        antall = 0;                           // foreløpig ingen verdier
    }

    public TabellListe()                    // standardkonstruktør
    {
        this(10);                             // startstørrelse på 10
    }

    public TabellListe(T[] b)                    // en T-tabell som parameter
    {
        this(b.length);                            // kaller den andre konstruktøren

        for (T verdi : b)
        {
            if (verdi != null) a[antall++] = verdi;  // hopper over null-verdier
        }
    }

    /**
     * Legger inn ny verdi bakerst i tabellen
     * @param verdi verdi som skal legges inn, kan ikke være null
     * @return true
     */
    @Override
    public boolean leggInn(T verdi) {

        Objects.requireNonNull(verdi, "Kan ikke være null");

        if (antall == a.length) {
            a = Arrays.copyOf(a, (3*antall)/2 +1);
        }

        a[antall++] = verdi;

        return true;
    }

    @Override
    public void leggInn(int indeks, T verdi) {

        //Sjekker at verdi ikke er null
        Objects.requireNonNull(verdi, "kan ikke være null!");

        //Utvider tabell med 50% dersom den er full
        if (antall == a.length) {
            a = Arrays.copyOf(a, (3*antall)/2);
        }

        //Rydder plass til ny verdi
        System.arraycopy(a, indeks, a, indeks + 1, antall - indeks);

        a[indeks] = verdi;
        antall++;
    }

    @Override
    public boolean inneholder(T verdi) {

        Objects.requireNonNull(verdi, "Kan ikke være null!");

        return indeksTil(verdi) != -1 ? true : false;
    }

    @Override
    public T hent(int indeks) {
        indeksKontroll(indeks, false);
        return a[indeks];
    }

    @Override
    public int indeksTil(T verdi) {

        for (int i = 0; i < antall; i++) {
            if (a[i].equals(verdi)) return i;
        }
        return -1;
    }

    @Override
    public T oppdater(int indeks, T verdi) {

        Objects.requireNonNull(verdi, "kan ikke være null!");
        indeksKontroll(indeks, false);

        T gammelVerdi = a[indeks];
        a[indeks] = verdi;
        return gammelVerdi;
    }

    @Override
    public boolean fjern(T verdi) {

        for (int i = 0; i < a.length; i++) {
            if (a[i] == verdi) {
                a[i] = null;
                antall--;
                System.arraycopy(a, i + 1, a, i, antall-i);
                return true;
            }
        }
        return false;
    }

    @Override
    public T fjern(int indeks) {

        indeksKontroll(indeks, false);
        T verdi = a[indeks];

        antall--;
        System.arraycopy(a, indeks + 1, a, indeks, antall - indeks);
        return verdi;
    }

    @Override
    public boolean fjernHvis(Predicate<? super T> p) {

        Objects.requireNonNull(p,"argument kan ikke være null!");

        int j = 0, match = 0;

        for (int i = 0; i < antall; i++) {
            if (!p.test(a[i])) {
                a[j++] = a[i];
            }else{
                match++;
            }
        }

        for (int i = antall - match; i < antall; i++) {
            a[i] = null;
        }

        antall += -match;

        return match > 0;
    }

    @Override
    public void forEach(Consumer<? super T> action) {

        Objects.requireNonNull(action, "argument kan ikke være null!");

        for (int i = 0; i < antall; i++) {
            action.accept(a[i]);
        }
    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public boolean tom() {
        return antall == 0; //listen er tom hvis antall er 0
    }

    @Override
    public void nullstill() {

        if (antall > 0) a = (T[])new Object[10];

        else {
            for (int i = 0; i < antall; i++) {
                a[i] = null;
            }
        }
        antall = 0;
    }

    @Override
    public Iterator<T> iterator()
    {
        return new TabellListeIterator();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(a[0]);

        if (antall == 0) return  "[]";

        for (int i = 1; i < antall; i++) {
            sb.append(", ").append(a[i]);
        }

        sb.append("]");

        return sb.toString();
    }

    //Indre iterator-klasse
    private class TabellListeIterator implements Iterator<T>
    {
        private int denne = 0;       // instansvariabel
        private boolean fjernOK = false;
        private int iteratorendringer = endringer;

        public boolean hasNext()     // sjekker om det er flere igjen
        {
            return denne < antall;     // sjekker verdien til denne
        }

        public T next() {
            if (!hasNext())
                throw new NoSuchElementException("Tomt eller ingen verdier igjen!");
            T denneVerdi = a[denne];
            denne++;
            fjernOK = true;

            return denneVerdi;
        }

        public void remove() {
            if (!fjernOK) {
                throw new IllegalStateException("Ulovlig tillstand");
            }
            fjernOK = false;

            antall--;
            denne--;

            System.arraycopy(a,denne + 1, a, denne, antall- denne);
            a[antall] = null;
        }

        public void forEachRemaining(Consumer<? super T> action) {

            while (denne < antall) {
                action.accept(a[denne++]);
            }
        }
    }
}
