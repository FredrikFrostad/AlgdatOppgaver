package Eksempelklasser.TabelListe;

@FunctionalInterface
public interface Komparator<T>      // et funksjonsgrensesnitt
{
    int compare(T o1, T o2);          // en abstrakt metode

    public static <T extends Comparable<? super T>> Komparator<T> naturligOrden()
    {
        return (x, y) -> x.compareTo(y);
    }

    public static <T extends Comparable<? super T>> Komparator<T> omvendtOrden()
    {
        return (x, y) -> y.compareTo(x);
    }

    public static <T, R extends Comparable<? super R>> Komparator<T> orden(Funksjon<? super T, ? extends R> velger)
    {
        return (x, y) -> velger.anvend(x).compareTo(velger.anvend(y));
    }

    public static <T, R> Komparator<T> orden(Funksjon<? super T, ? extends R> velger, Komparator<? super R> c)
    {
        return (x, y) -> c.compare(velger.anvend(x), velger.anvend(y));
    }

    //Default metoder

    default Komparator<T> deretter(Komparator<? super T> c) {
        return (x, y) -> {
            int k = compare(x, y);
            return k != 0 ? k : c.compare(x,y);
        };
    }

    default <R extends Comparable<? super R>> Komparator<T>
    deretter(Funksjon<? super T, ? extends R> velger) {

        return (x, y) -> {
            int k = compare(x, y);
            return k != 0 ? k : velger.anvend(x).compareTo(velger.anvend(y));
        };
    }


    default <R> Komparator<T>
    deretter(Funksjon<? super T, ? extends R> velger, Komparator<? super R> c) {

        return (x, y) -> {
            int k = compare(x, y);
            return k != 0 ? k : c.compare(velger.anvend(x), velger.anvend(y));
        };
    }

    default Komparator<T> omvendt() {
        return (x,y) -> compare(y, x);
    }
}