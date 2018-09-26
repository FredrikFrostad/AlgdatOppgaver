package Eksempelklasser.Lenketliste;

import Eksempelklasser.TabelListe.Liste;

import java.util.Iterator;
import java.util.Objects;

public class EnkeltLenketListe<T> implements Liste<T> {

    private Node<T> hode, hale;
    private int antall;

    public EnkeltLenketListe() {
        hode = hale = null;
        antall = 0;
    }

    private static final class Node<T> {

        private T verdi;
        private Node<T> neste;

        private Node(T verdi, Node<T> neste) {
            this.verdi = verdi;
            this.neste = neste;
        }
    }

    /**
     * Legger inn  en verdi bakerst i listen
     * @param verdi parameter != 0
     * @return true hvis vellykket, ellers false
     */
    @Override
    public boolean leggInn(T verdi) {

        Objects.requireNonNull(verdi, "null-verdi er ikke tillatt!");

        if (antall == 0) {
            hode = hale = new Node<>(verdi,null);
        }else{
            hale = hale.neste = new Node<>(verdi, null);
        }

        antall++;
        return true;
    }

    @Override
    public void leggInn(int indeks, T verdi) {

        Objects.requireNonNull(verdi,"null-verdier er ikke tillatt!");

        indeksKontroll(indeks, true);

        if (indeks == 0) {
            hode = new Node<>(verdi, hode);
            if (antall == 0) {
                hale = hode;
            }else if (indeks == antall) {
                hale = hale.neste = new Node<>(verdi, null);
            }else {
                Node<T> p = hode;
                for (int i = 0; i < indeks - 1; ) p = p.neste;
                p.neste = new Node<>(verdi, p.neste);
            }
        }
        antall++;
    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public void nullstill() {

        Node<T> p = hode, q = null;

        while (p != null) {
            q = p.neste;
            p.neste = null;
            p.verdi = null;
            p = q;
        }

       hode = hale = null;
        antall = 0;
    }

    public String toString() {

        if (antall == 0) return "[]";

        StringBuilder out = new StringBuilder();
        out.append("[").append(hode.verdi);

            Node<T> p = hode.neste;

            while (p.neste != null) {
                out.append(", ").append(p.verdi);
                p = p.neste;
            }

        out.append("]");

        return out.toString();
    }

    @Override
    public boolean inneholder(T verdi) {
        return false;
    }

    @Override
    public T hent(int indeks) {
        return null;
    }

    @Override
    public int indeksTil(T verdi) {
        return 0;
    }

    @Override
    public T oppdater(int indeks, T verdi) {
        return null;
    }

    @Override
    public boolean fjern(T verdi) {
        return false;
    }

    @Override
    public T fjern(int indeks) {
        return null;
    }

    @Override
    public boolean tom() {
        return antall == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
