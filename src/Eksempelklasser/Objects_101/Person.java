package Eksempelklasser.Objects_101;

import java.util.Objects;

public class Person implements Comparable<Person>
{
    private final String fornavn;         // personens fornavn
    private final String etternavn;       // personens etternavn

    public Person(String fornavn, String etternavn)   // konstruktør
    {
        Objects.requireNonNull(fornavn, "Fornavn kan ikke være null");
        Objects.requireNonNull(etternavn, "Etternavn kan ikke være null");
        this.fornavn = fornavn;
        this.etternavn = etternavn;
    }

    public String fornavn() { return fornavn; }       // aksessor
    public String etternavn() { return etternavn; }   // aksessor

    public int compareTo(Person p)    // pga. Comparable<Person>
    {
        int cmp = etternavn.compareTo(p.etternavn);     // etternavn
        if (cmp != 0) return cmp;             // er etternavnene ulike?
        return fornavn.compareTo(p.fornavn);  // sammenligner fornavn
    }
/*
    public boolean equals(Object o)      // vår versjon av equals
    {
        if (o == this) return true;
        if (!(o instanceof Person)) return false;
        return compareTo((Person)o) == 0;
    }
*/
    public boolean equals(Object o) {

        if (o == this) {return true;}   //Sjekker om det er samme objekt
        if (o == null) {return false;}  //Sjekker at o ikke er null
        if (o.getClass() != getClass()) {return false;} //Sjekker om o tilhører samme klasse
        final Person p = (Person)o;
        return etternavn.equals(p.etternavn) && fornavn.equals(p.fornavn);
    }

    public boolean equals(Person p) {
        if (p == this) {return true;}
        if (p == null) {return false;}
        return etternavn.equals(p.etternavn) && fornavn.equals(p.fornavn);
    }

    public int hashCode() { return Objects.hash(etternavn, fornavn); }

    //public String toString() { return fornavn + " " + etternavn; }

    public String toString() {
        return String.join("_",fornavn, etternavn);
    }

} // class Person