package Eksempelklasser.Tabellstack;

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

    }

    @Override
    public T kikk() {
        return null;
    }

    @Override
    public T taUt() {
        return null;
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
}
