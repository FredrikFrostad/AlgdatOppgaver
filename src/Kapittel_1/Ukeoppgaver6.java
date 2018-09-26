package Kapittel_1;


import Eksempelklasser.TabelListe.Liste;
import Eksempelklasser.TabelListe.TabellListe;

import java.util.Iterator;

public class Ukeoppgaver6 {



    public static void main(String[] args) {


        System.out.println("\n******************** Oppgave 3.2.2: \n");


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

        System.out.println("\n******************** Oppgave 3.2.3: \n");


        /**
         * Oppgave 3.2.3:
         *
         */

        {
            String[] s2 = {"m", "o", "r", "a", "d", "i", null, null, null};
            TabellListe liste2 = new TabellListe(s2);

            System.out.println("antall: " + liste2.antall());
            System.out.println("hent: " + liste2.hent(0));
            System.out.println("indeks til: " + liste2.indeksTil("i"));

            System.out.println(liste2.toString());

            //Tester metode som fjerner første element som matcher parameter
            liste2.fjern("o");

            System.out.println(liste2.toString());

            //Tester metodte som fjerner element på index gitt som parameter
            liste2.fjern(1);

            System.out.println(liste2.toString());

            //Tester metode som nullstiller liste2
            liste2.nullstill();

            System.out.println(liste2.toString());
        }

        System.out.println("\n******************** Oppgave 3.2.4: \n");

        /**
         * Oppgave 3.2.4:
         *
         * Har lagt inn metoder i Tabelliste og TabellisteIterator
         * Koden under tester alle metodene.
         *
         * Husk på å bruke funksjonelle interface som argumenter for å tillate
         * bruk av lambdakonstruksjoner
         */

        {
            String[] s = {"Jens","Per","Kari","Ole","Berit","Jens","Anne","Nils","Siv"};

            Liste<String> liste3 = new TabellListe<>();
            for (String navn : s) liste3.leggInn(0,navn);  // legger inn først
            System.out.println("Vi henter " + liste3.hent(5) + ".");
            System.out.println("Nils er på plass " + liste3.indeksTil("Nils") + "!");
            liste3.oppdater(2,"Anna");  // bytter ut Anne med Anna på plass 2
            System.out.println(liste3.fjern(0) + " er slettet!");
            System.out.println("Listeinnhold: " + liste3);
            liste3.fjernHvis(x -> x.equals("Jens"));  // fjerner alle forekomster av Jens
            liste3.forEach(x -> System.out.print(x + " "));
        }

        /**
         * Oppgave 3.2.5:
         * Flere iteratorer samtidig
         *
         *
         */

        System.out.println("\n\n******************** Oppgave 3.2.5: \n");

        {
        /*
            System.out.println("\nEksempel 1:\n");
            String[] s = {"Per","Kari","Ole"};

            TabelListe<String> liste = new TabellListe<>();

            for (String navn : s) liste.leggInn(navn);

            System.out.println(liste);

            Iterator<String> i = liste.iterator();     // oppretter en iterator
            System.out.println(i.next());              // den første i listen

            liste.fjern("Per");                        // fjerner den første
            System.out.println(i.next());              // den neste i listen
        */
        }

        {
            System.out.println("\nEksempel 2:\n");

            String[] s = {"Per","Kari","Ole"};

            Liste<String> liste4 = new TabellListe<>(s);

            for (String navn : s) liste4.leggInn(navn);

            System.out.println(liste4);

            // Utskrift: [Per, Kari, Ole]

            Iterator<String> i = liste4.iterator();     // oppretter en iterator i
            Iterator<String> j = liste4.iterator();     // oppretter en iterator j

            System.out.println(i.next());              // den første i listen
            i.remove();                                // fjerner den første
            System.out.println(i.next());              // den første i listen
            //System.out.println(j.next());    // hvis vi bruker den andre iteratoren kastes det en exception!!



        }

        /**
         * Oppgave 3.3.2:
         */

        System.out.println("\n:\n");
    }
}
