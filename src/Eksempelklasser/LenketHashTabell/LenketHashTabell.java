package Eksempelklasser.LenketHashTabell;

import Eksempelklasser.TabelListe.Beholder;

import java.util.*;

public class LenketHashTabell<T>  implements Beholder<T> {

    //Dette er en indre nodeklasse som vi bruker for å befolke hastabellen med verdier

    private static class Node<T>      // en indre nodeklasse
    {
        private final T verdi;          // nodens verdi
        private final int hashverdi;    // lagrer hashverdien
        private Node<T> neste;          // peker til neste node

        private Node(T verdi, int hashverdi, Node<T> neste)  // konstruktør
        {
            this.verdi = verdi;
            this.hashverdi = hashverdi;
            this.neste = neste;
        }
    }
    // class Node

    //********************* Instansvariabler og konstruktører for klassen LenketHashTabell

    private Node<T>[] hash;           // en nodetabell
    private final float tetthet;      // eng: loadfactor
    private int grense;               // eng: threshold (norsk: terskel)
    private int antall;               // antall verdier
    private int endringer = 0;

    @SuppressWarnings({"rawtypes","unchecked"})  // en annotasjon

    // konstruktør
    public LenketHashTabell(int dimensjon) {

        if (dimensjon < 0) throw new IllegalArgumentException("Negativ dimensjon!");

        hash = new Node[dimensjon];                // bruker raw type
        tetthet = 0.75f;                           // maksimalt 75% full
        grense = (int)(tetthet * hash.length);     // gjør om til int
        antall = 0;                                // foreløpig ingen verdier
    }

    // standardkonstruktør (no-arg konstruktør)
    public LenketHashTabell() {

        this(13);  // velger 13 som startdimensjon inntil videre
    }

    public int antall() {

        return antall;
    }

    public boolean tom() {

        return antall == 0;
    }

    public boolean leggInn(T verdi) {

        Objects.requireNonNull(verdi, "verdi er null!");

        if (antall >= grense)
        {
            utvid();
        }

        int hashverdi = verdi.hashCode() & 0x7fffffff;  // fjerner fortegn
        int indeks = hashverdi % hash.length;           // finner indeksen

        // legger inn først i listen som hører til indeks
        hash[indeks] = new Node<>(verdi, hashverdi, hash[indeks]);  // lagrer hashverdi

        antall++;        // en ny verdi
        endringer++;
        return true;     // vellykket innlegging
    }


    public String toString() {

        StringJoiner s = new StringJoiner(", ", "[", "]");

        for (Node<T> p : hash)              // går gjennom tabellen
        {
            for (; p != null; p = p.neste)    // går gjennom listen
            {
                s.add(p.verdi.toString());
            }
        }
        return s.toString();
    }

    public boolean inneholder(T verdi) {

        if (verdi == null) return false;                    //Tabellen kan ikke inneholde nullverdier

        int hashverdi = verdi.hashCode() & 0x7fffffff;      //Fjerner fortegn på hashverdien

        Node<T> p = hash[hashverdi % hash.length];          //Går direkte til indeks som korrespondere med verdien

        while (p != null) {                                 //Itererer over alle noder på denne indeksen

            if (p.verdi.equals(verdi)) return true;         //Returnerer true hvis verdi er i listen
            p = p.neste;
        }

        return false;                                       //Fant ikke verdi, returnerer false
    }

    public boolean fjern(T verdi) {

        if (verdi == null) return false;                    //Tabellen kan ikke inneholde nullverdier

        int hashverdi = verdi.hashCode() & 0x7fffffff;
        int index = hashverdi % hash.length;

        Node<T> node = hash[index], forrige = null;

        while (node != null) {

            if (node.verdi.equals(verdi)) break;

            forrige = node;
            node = node.neste;

        }

        if (node == null) {
            return false;
        }
        else if(node == hash[index]) {
            hash[index] = node.neste;
        }else {
                forrige.neste = node.neste;
        }

        endringer++;
        antall--;
        return false;
    }

    public void nullstill() {

        if (antall > 0) {

            for (int i = 0; i < hash.length; i++) {
                hash[i] = null;
            }
        }
    }

    public Iterator<T> iterator() {
        return new HashTabellIterator();
    }

    private void utvid()                                            // hører til LenketHashTabell
    {
        @SuppressWarnings({"rawtypes","unchecked"})                 // bruker raw type
                Node<T>[] nyhash = new Node[2*hash.length + 1];     // dobling + 1

        for (int i = 0; i < hash.length; i++)                       // den gamle tabellen
        {
            Node<T> p = hash[i];                                    // listen til hash[i]

            while (p != null)                                       // går nedover
            {
                Node<T> q = p.neste;                                // hjelpevariabel
                int nyindeks = p.hashverdi % nyhash.length;         // indeks i ny tabell

                p.neste = nyhash[nyindeks];                         // p skal legges først

                nyhash[nyindeks] = p;
                p = q;                                              // flytter p til den neste
            }

            hash[i] = null;                                         // nuller i den gamle
        }

        hash = nyhash;                                              // bytter tabell
        grense = (int)(tetthet * hash.length);                      // ny grense
    }


    private class HashTabellIterator implements Iterator<T>
    {
        private int indeks = 0;
        private Node<T> p = null;
        private boolean fjernOK = false;
        private int iteratorendringer = endringer;

        private HashTabellIterator()
        {
            while (indeks < hash.length && hash[indeks] == null) indeks++;
            p = indeks < hash.length ? hash[indeks] : null;
        }

        public boolean hasNext()
        {
            return p != null;
        }

        public T next()
        {
            if (!hasNext())
                throw new NoSuchElementException("Ingen flere verdier");


            T verdi = p.verdi;                  // tar vare på verdien

            if (p.neste != null)
            {
                p = p.neste;   // hvis p ikke er den siste
            }
            else  // må gå til neste indeks der hash[indeks] er ulik null
            {
                while (++indeks < hash.length && hash[indeks] == null);
                p = indeks < hash.length ? hash[indeks] : null;
            }
            fjernOK = true;
            return verdi;                       // returnerer verdien
        }


        public void remove() {

            if (iteratorendringer != endringer) throw new ConcurrentModificationException
                    ("Listen er endret!!");

            if (!fjernOK) throw new IllegalStateException
                    ("Ulovlig tilstand!!");

            fjernOK = false;

            int index = this.indeks;

            if (index == hash.length || p == hash[index]) {
                while (hash[--index] == null);

                Node<T> q = hash[index];

                if (q.neste == null) {
                    hash[index] = null;
                }else {
                    Node<T> f = q;

                    while (q.neste == null) {
                        f = q.neste;
                        q = q.neste;
                    }

                    f.neste = null;
                }
            }else {

                if (hash[index].neste == p) {
                    hash[index] = p;
                } else {
                    Node<T> q = hash[index];

                    while (q.neste.neste != p) {
                        q = q.neste;
                    }
                    q.neste = p;
                }
            }
            endringer++;
            iteratorendringer++;
            antall--;
        }

    } // class HashTabellIterator

}  // class LenketHashTabell