package Kapittel_1;

import Eksempelklasser.Heltall;
import Eksempelklasser.Måned;
import Eksempelklasser.Person;
import Eksempelklasser.Studium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class ukeoppgaver5 {

    public static void main(String[] args) {
        {
            int[] a = {5, 2, 7, 3, 9, 1, 8, 4, 6};
            double[] d = {5.7, 3.14, 7.12, 3.9, 6.5, 7.1, 7.11};
            String[] s = {"Sohil", "Per", "Thanh", "Fatima", "Kari", "Jasmin"};
            char[] c = "morradiz".toCharArray();

            int k = Tabell.maks(a);     // posisjonen til den største i a
            int l = Tabell.maks(d);     // posisjonen til den største i d
            int m = Tabell.maks(s);     // posisjonen til den største i s
            int n = Tabell.maks(c);     // posisjonen til den største i c

            System.out.println(a[k] + "  " + d[l] + "  " + s[m] + " " + c[n]);
        }
        /**
         * Oppgave 1.4.1_4:
         *For at vi skal kunne bruke compareTo, må vi wrappe den primitive integerer
         * i et Integer objekt. Ved kjøring av metoden ser vi at a.compareTo(b) gir
         * -1 dersom a < b, 0 dersom a = b, 1 dersom a > b
         */

        {
            Integer a = new Integer(3);
            Integer b = new Integer(6);

            System.out.println("output fra a.compareTo b: " + a.compareTo(b));


        }

        /**
         * Oppgave 1.4.1_5:
         *Ved å eksperimentere med compareTo og strenger kan vi observere følgende:
         *
         *      -Når vi sammenlikner a mot b er fortegenet negativt dersom a er minst, og positivt
         *      dersom a er størst. Hvis strengene er liker returneres 0. Verdien som
         *      returneres er ascii differansen mellom de første ulike elementene.
         *
         *      -Dersom a begynner med b eller motsatt, returneres differansen mellom
         *      lengden til a og lengden til b, med samme fortegnsregler som
         *      beskrevet over.
         */

        {
            String s = "mono";
            String t = "monofon";

            System.out.println("string.compareTo(string)" + s.compareTo(t));
        }

        /**
         * Oppgave 1.4.1_6:
         * Ved å bruke boolean sin comparator metode ser vi at true > false
         */

        {
            System.out.println("Boolean comparator: " + Boolean.compare(false, true));
        }

        /**
         * Oppgave 1.4.4_1:
         * a) OK
         *
         * b)OK
         *
         * c) Det fungerer matematisk og returnere verdi - h.verdi, fordi vi får
         * negativt fortegn dersom verdi < h.verdi, 0 dersom verdi == h.verdi og
         * positivt fortegn dersom verdi > h.verdi.
         *
         * Men siden vi bruker int som datatype, kan vi få problemer dersom vi overflyter
         * størrelsen som kan representeres ved 32bit signert to-komplement
         *
         * d) Koden i oppgave d skriver som forventet ut 0 og true
         *
         * e) Siden verdiene til både x og y er like, vil det skrives ut en identisk
         * hash for begge objektene.
         */
        System.out.println("\n Oppgave 1.4.4_1: ");
        {
            //a
            int[] a = {5, 2, 7, 3, 9, 1, 8, 10, 4, 6};          // en int-tabell
            Heltall[] h = new Heltall[a.length];       // en Heltall-tabell

            //b
            for (int i = 0; i < h.length; i++) h[i] = new Heltall(a[i]);
            Tabell.innsettingssortering(h);           // generisk sortering
            System.out.println(Arrays.toString(h));   // utskrift}

            //d
            Heltall x = new Heltall(3), y = new Heltall(3);  // x og y er like
            System.out.println(x.compareTo(y) + "  " + x.equals(y));

            //e
            System.out.println(x.hashCode() + "  " + y.hashCode());
        }

        /**
         * Oppgave 1.4.4_2:
         *
         * a) OK
         *
         * b) OK
         *
         * c) OK
         *
         * d) OK
         *
         * e) OK
         *
         * f) OK
         *
         * g) OK (lest, ikke relevant for intellij)
         *
         * h) OK Implementert toString metode i Eksempelklasse Person
         * Delimiter parameter definerer skilletegn
         *
         * i)
         */


        System.out.println("\n Oppgave 1.4.4_1 \n");

        //a, b
        {
        Person[] p = new Person[8];                   // en persontabell

        p[0] = new Person("Kari","Svendsen");         // Kari Svendsen
        p[1] = new Person("Boris","Zukanovic");       // Boris Zukanovic
        p[2] = new Person("Ali","Kahn");              // Ali Kahn
        p[3] = new Person("Azra","Zukanovic");        // Azra Zukanovic
        p[4] = new Person("Kari","Pettersen");        // Kari Pettersen
        p[5] = new Person("Karianne", "Trulsen");
        p[6] = new Person("Kjell", "Trulsen");
        p[7] = new Person("Ulf", "Lundell");



            int m = Tabell.maks(p);                       // posisjonen til den største
            System.out.println(p[m] + " er størst");      // skriver ut den største

            Tabell.innsettingssortering(p);// generisk sortering
            System.out.println("Innsettingssortering: ");
            System.out.println(Arrays.toString(p));       // skriver ut sortert

            // Utskrift:

            // Boris Zukanovic er størst
            // [Ali Kahn, Kari Pettersen, Kari Svendsen, Azra Zukanovic, Boris Zukanovic]
        }

        // c
        {
            Person[] p = new Person[8];                   // en persontabell

            p[0] = new Person("Kari","Svendsen");         // Kari Svendsen
            p[1] = new Person("Boris","Zukanovic");       // Boris Zukanovic
            p[2] = new Person("Ali","Kahn");              // Ali Kahn
            p[3] = new Person("Azra","Zukanovic");        // Azra Zukanovic
            p[4] = new Person("Kari","Pettersen");        // Kari Pettersen
            p[5] = new Person("Karianne", "Trulsen");
            p[6] = new Person("Kjell", "Trulsen");
            p[7] = new Person("Ulf", "Lundell");

            System.out.println("Arrays.sort: ");
            Arrays.sort(p);
            System.out.println(Arrays.toString(p));
        }

        // h
        {
            Person p = new Person("Anders", "Bardal");
            System.out.println(p.toString());
        }
        // i og j
        {
            Person[] p = new Person[8];                   // en persontabell

            p[0] = new Person("Kari","Svendsen");         // Kari Svendsen
            p[1] = new Person("Boris","Zukanovic");       // Boris Zukanovic
            p[2] = new Person("Ali","Kahn");              // Ali Kahn
            p[3] = new Person("Azra","Zukanovic");        // Azra Zukanovic
            p[4] = new Person("Kari","Pettersen");        // Kari Pettersen
            p[5] = new Person("Karianne", "Trulsen");
            p[6] = new Person("Kjell", "Trulsen");
            p[7] = new Person("Ulf", "Lundell");



            int m = Tabell.maks(p);                       // posisjonen til den største
            System.out.println(p[m] + " er størst");      // skriver ut den største

            Tabell.innsettingssortering(p);// generisk sortering
            System.out.println(Arrays.toString(p));       // skriver ut sortert

            System.out.println("ekstra kodelinjer: ");

            /*
            Stream s = Arrays.stream(p);
            Optional<Person> resultat = s.max(Comparator.naturalOrder());
            resultat.ifPresent(System.out::println);
            */
            //Utkommentert kodeblokk skrevet som en linje,
            //Merk at det er høyresiden av tillordningene som brukes
            Arrays.stream(p).max(Comparator.naturalOrder()).ifPresent(System.out::println);
        }

        /**
         * 1.4.5_1:
         *
         * a) OK
         *
         * b) OK
         *
         * c)
         */

        System.out.println("\n Oppgave 1.4.5: \n");

        // a
        {
            System.out.println("\n A: \n");

            for (Studium s : Studium.values())
            {
                System.out.println(s.toString() + " (" + s.name() + ")");
            }
            // Ingeniørfag - data (Data)
            // Informasjonsteknologi (IT)
            // Anvendt datateknologi (Anvendt)
            // Enkeltemnestudent (Enkeltemne)
        }

        // c
        {
            for (Måned m : Måned.values()) {
                System.out.println(m.toString());
                System.out.println(m.ordinal()+1);
            }
        }
    }


}

