package Eksempelklasser.RSBintre;

import Eksempelklasser.TabelListe.Beholder;
import Eksempelklasser.Tabellstack.Stakk;
import Eksempelklasser.Tabellstack.TabellStack;

import java.util.Comparator;
import java.util.Iterator;

public class RSBinTre<T> implements Beholder<T> {

    private static final boolean SVART = true;
    private static final boolean RØD   = false;


    private static final class Node<T>    // en indre nodeklasse
    {
        private T verdi;             // nodens verdi
        private Node<T> venstre;     // peker til venstre barn
        private Node<T> høyre;       // peker til høyre barn
        private boolean farge;       // RØD eller SVART

        private Node(T verdi, Node<T> v, Node<T> h, boolean farge)  // konstruktør
        {
            this.verdi = verdi;
            venstre = v; høyre = h;
            this.farge = farge;
        }

    } // class Node

    private final Node<T> NULL;                  // en svart nullnode
    private Node<T> rot;                         // treets rot
    private int antall;                          // antall verdier
    private final Comparator<? super T> comp;    // treets komparator

    public RSBinTre(Comparator<? super T> comp)  // konstruktør
    {
        rot = NULL = new Node<>(null,null,null,SVART);
        this.comp = comp;
    }

    // konstruksjonsmetoder
    public static <T extends Comparable<? super T>> RSBinTre<T> rsbintre()
    {
        return new RSBinTre<>(Comparator.naturalOrder());
    }

    public static <T> RSBinTre<T> rsbintre(Comparator<? super T> c)
    {
        return new RSBinTre<>(c);
    }

    // Instansmetodene skal inn her

    @Override
    public boolean leggInn(T verdi) {
        if (rot == NULL)                            // treet er tomt
        {
            rot = new Node<>(verdi,NULL,NULL,SVART);  // roten skal være svart
            antall++;  return true;                   // vellykket innlegging
        }

        Stakk<Node<T>> stakk = new TabellStack<>();  // en stakk
        Node<T> p = rot;                             // hjelpevariabel
        int cmp = 0;                                 // hjelpevariabel

        while (p != NULL)
        {
            stakk.leggInn(p);                   // legger p på stakken
            cmp = comp.compare(verdi,p.verdi);  // sammenligner

            if (cmp < 0) p = p.venstre;         // til venstre
            else if (cmp > 0) p = p.høyre;      // til høyre
            else return false;                  // duplikater ikke tillatt
        }

        Node<T> x = new Node<>(verdi,NULL,NULL,RØD);  // en rød node
        antall++;

        Node<T> f = stakk.taUt();             // forelder til x

        if (cmp < 0) f.venstre = x;           // x blir venstre barn
        else f.høyre = x;                     // x blir høyre barn

        if (f.farge == SVART) return true;    // vellykket innlegging

        // Men hva hvis f er RØD?
        return true;
    }

    @Override
    public boolean inneholder(T verdi) {
        return false;
    }

    @Override
    public boolean fjern(T verdi) {
        return false;
    }

    @Override
    public int antall() {
        return 0;
    }

    @Override
    public boolean tom() {
        return false;
    }

    @Override
    public void nullstill() {

    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
