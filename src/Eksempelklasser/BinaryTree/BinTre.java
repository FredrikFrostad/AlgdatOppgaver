package Eksempelklasser.BinaryTree;

public class BinTre<T>           // et generisk binærtre
{
    private static final class Node<T>  // en indre nodeklasse
    {
        private T verdi;            // nodens verdi
        private Node<T> venstre;    // referanse til venstre barn/subtre
        private Node<T> høyre;      // referanse til høyre barn/subtre

        private Node(T verdi, Node<T> v, Node<T> h)    // konstruktør
        {
            this.verdi = verdi; venstre = v; høyre = h;
        }

        private Node(T verdi) { this.verdi = verdi; }  // konstruktør

    } // class Node<T>

    private Node<T> rot;      // referanse til rotnoden
    private int antall;       // antall noder i treet


    // Defaiult konstruktør
    public BinTre() { rot = null; antall = 0; }


    // Konstruktør med parametre
    public BinTre(int[] posisjon, T[] verdi)  // konstruktør
    {
        if (posisjon.length > verdi.length) throw new
                IllegalArgumentException("Verditabellen har for få elementer!");

        for (int i = 0; i < posisjon.length; i++) leggInn(posisjon[i],verdi[i]);
    }


    public final void leggInn(int posisjon, T verdi)  // final: kan ikke overstyres
    {
        if (posisjon < 1) throw new
                IllegalArgumentException("Posisjon (" + posisjon + ") < 1!");

        Node<T> p = rot, q = null;    // nodereferanser

        int filter = Integer.highestOneBit(posisjon) >> 1;   // filter = 100...00

        while (p != null && filter > 0)
        {
            q = p;
            p = (posisjon & filter) == 0 ? p.venstre : p.høyre;
            filter >>= 1;  // bitforskyver filter
        }

        if (filter > 0) throw new
                IllegalArgumentException("Posisjon (" + posisjon + ") mangler forelder!");
        else if (p != null) throw new
                IllegalArgumentException("Posisjon (" + posisjon + ") finnes fra før!");

        p = new Node<>(verdi);          // ny node

        if (q == null) rot = p;         // tomt tre - ny rot
        else if ((posisjon & 1) == 0)   // sjekker siste siffer i posisjon
            q.venstre = p;                // venstre barn til q
        else
            q.høyre = p;                  // høyre barn til q

        antall++;                       // en ny verdi i treet
    }

    private Node<T> finnNode(int posisjon)  // finner noden med gitt posisjon
    {
        if (posisjon < 1) return null;

        Node<T> p = rot;   // nodereferanse
        int filter = Integer.highestOneBit(posisjon >> 1);   // filter = 100...00

        for (; p != null && filter > 0; filter >>= 1)
            p = (posisjon & filter) == 0 ? p.venstre : p.høyre;

        return p;   // p blir null hvis posisjon ikke er i treet
    }

    public int nodeType(int posisjon) {

        if (posisjon < 1) {
            throw new IllegalArgumentException
                    ("argument må være et positivt heltall!!");
        }

        Node<T> node = finnNode(posisjon);

        if (node == null) return -1;
        else if (node.venstre != null || node.høyre != null) return 1;
        else return 1;
    }

    public boolean finnes(int posisjon)
    {
        return finnNode(posisjon) != null;
    }

    public T fjern(int posisjon) {

        T out;

        if (posisjon < 1) {
            throw new IllegalArgumentException
                    ("Argument må være et heltall større enn 0");
        }
        if (nodeType(posisjon) != 0) {
            throw new IllegalStateException
                    ("Node er ikke en bladnode!");
        }

        Node<T> node = rot, temp = null;

        int filter = Integer.highestOneBit(posisjon >> 1);

            for (; node != null && filter > 0; filter >>= 1) {
                temp = node;
                node = (posisjon & filter) == 0 ? node.venstre : node.høyre;
            }

        out = node.verdi;
        node.verdi = null;

            if (temp.venstre.equals(node)) {
                temp.venstre = null;
            }else {
                temp.høyre = null;
            }

        return out;
    }

    public T hent(int posisjon)
    {
        Node<T> p = finnNode(posisjon);

        if (p == null) throw new
                IllegalArgumentException("Posisjon (" + posisjon + ") finnes ikke i treet!");

        return p.verdi;
    }

    public T oppdater(int posisjon, T nyverdi)
    {
        Node<T> p = finnNode(posisjon);

        if (p == null) throw new
                IllegalArgumentException("Posisjon (" + posisjon + ") finnes ikke i treet!");

        T gammelverdi = p.verdi;
        p.verdi = nyverdi;

        return gammelverdi;
    }

    public int antall() { return antall; }               // returnerer antallet

    public boolean tom() { return antall == 0; }         // tomt tre?

} // class BinTre<T>