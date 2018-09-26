package Kapittel_1;


import Eksempelklasser.Liste;
import Eksempelklasser.TabellListe;

public class Ukeoppgaver6 {



    public static void main(String[] args) {

        /**
         * Oppgave 3.2.2
         *
         * 1) Har lagt inn alle metoder spesifisert i kompendiet
         *
         * 2) Lag en String-tabell s, en instans av TabellListe med s som parameter
         * og sjekk at aksessor-metodene virker som de skal.
         * Sjekk at det virker hvis s har en eller flere null-er.
         *
         * 3) Lag metoden toString
         *
         */
        {
            //Oppgave 2
            String[] s = {"m", "o", "r", "a", "d", "i", null, null, null};
            TabellListe liste = new TabellListe(s);

            System.out.println("antall: " + liste.antall());
            System.out.println("hent: " + liste.hent(0));
            System.out.println("indeks til: " + liste.indeksTil("i"));

            //Oppgave 3
            System.out.println(liste.toString());
        }
        /**
         * Oppgave 3.2.3:
         *
         */

        {
            String[] s = {"m", "o", "r", "a", "d", "i", null, null, null};
            TabellListe liste = new TabellListe(s);

            System.out.println("antall: " + liste.antall());
            System.out.println("hent: " + liste.hent(0));
            System.out.println("indeks til: " + liste.indeksTil("i"));

            System.out.println(liste.toString());

            //Tester metode som fjerner første element som matcher parameter
            liste.fjern("o");

            System.out.println(liste.toString());

            //Tester metodte som fjerner element på index gitt som parameter
            liste.fjern(1);

            System.out.println(liste.toString());

            //Tester metode som nullstiller liste
            liste.nullstill();

            System.out.println(liste.toString());
        }

        /**
         * Oppgave 3.2.4:
         *
         *
         */

        {
            String[] s = {"Jens","Per","Kari","Ole","Berit","Jens","Anne","Nils","Siv"};

            Liste<String> liste = new TabellListe<>();

            for (String navn : s) liste.leggInn(0,navn);  // legger inn først

            System.out.println("Vi henter " + liste.hent(5) + ".");

            System.out.println("Nils er på plass " + liste.indeksTil("Nils") + "!");

            liste.oppdater(2,"Anna");  // bytter ut Anne med Anna på plass 2

            System.out.println(liste.fjern(0) + " er slettet!");

            System.out.println("Listeinnhold: " + liste);

            liste.fjernHvis(x -> x.equals("Jens"));  // fjerner alle forekomster av Jens

            liste.forEach(x -> System.out.print(x + " "));
        }
    }




}
