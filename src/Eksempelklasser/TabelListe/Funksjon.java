package Eksempelklasser.TabelListe;

@FunctionalInterface
public interface Funksjon<T,R>    // T for argumenttype, R for returtype
{
    R anvend(T t);
}