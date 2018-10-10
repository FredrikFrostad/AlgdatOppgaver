package Kapittel_1;

import Eksempelklasser.Objects_101.*;
import Eksempelklasser.TabelListe.Komparator;

import java.util.Arrays;
import java.util.Comparator;

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
         *For at vi skal kunne bruke compareTo, må vi wrappe den primitive integeren
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
            System.out.println("innsettingssortering: ");
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
         * 1.4.5:
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
            System.out.println("\n B: \n");

            for (Måned m : Måned.values()) {
                System.out.println(m.toString());
                System.out.println(m.ordinal()+1);
            }
        }

        // d

        {

            System.out.println("\n D: \n");

            Student[] s = new Student[5];  // en Studenttabell

            s[0] = new Student("Kari", "Svendsen", Studium.Data);    // Kari Svendsen
            s[1] = new Student("Boris", "Zukanovic", Studium.IT);    // Boris Zukanovic
            s[2] = new Student("Ali", "Kahn", Studium.Anvendt);      // Ali Kahn
            s[3] = new Student("Azra", "Zukanovic", Studium.IT);     // Azra Zukanovic
            s[4] = new Student("Kari", "Pettersen", Studium.Data);   // Kari Pettersen

            Tabell.innsettingssortering(s);                     // Programkode 1.4.2 e)
            for (Student t : s) System.out.println(t);

            // Utskrift:
            // Ali Kahn Anvendt
            // Kari Pettersen Data
            // Kari Svendsen Data
            // Azra Zukanovic IT
            // Boris Zukanovic I
        }

        /**
         * Oppgave 1.4.6:
         *
         * 1) OK - alle metoder lagt in og kjørt
         *
         * 2) OK - alle metoder lagt inn, kjørt og endret pr oppgave
         *
         * 3)
         */

        System.out.println("\n Oppgave 1.4.6: \n");

        // Oppgave 1:
        {
            Person[] p = new Person[5];                       // en persontabell
            p[0] = new Person("Kari", "Svendsen");            // Kari Svendsen
            p[1] = new Person("Boris", "Zukanovic");          // Boris Zukanovic
            p[2] = new Person("Ali", "Kahn");                 // Ali Kahn
            p[3] = new Person("Azra", "Zukanovic");           // Azra Zukanovic
            p[4] = new Person("Kari", "Pettersen");           // Kari Pettersen

            class FornavnKomparator implements Komparator<Person>
            {
                public int compare(Person p1, Person p2)        // to personer
                {
                    return p1.fornavn().compareTo(p2.fornavn());  // sammenligner fornavn
                }
            }

            Komparator<Person> c = new FornavnKomparator();   // en instans av klassen
            //Tabell.innsettingssortering(  p, c);                // se Programkode 1.4.6 b)

            System.out.println(Arrays.toString(p));           // Utskrift av tabellen p
            // [Ali Kahn, Azra Zukanovic, Boris Zukanovic, Kari Svendsen, Kari Pettersen]

        }
        System.out.println("\nSamme sammenlikning, men skrevet med en lambda: ");
        {
            Person[] p = new Person[5];                       // en persontabell
            p[0] = new Person("Kari", "Svendsen");            // Kari Svendsen
            p[1] = new Person("Boris", "Zukanovic");          // Boris Zukanovic
            p[2] = new Person("Ali", "Kahn");                 // Ali Kahn
            p[3] = new Person("Azra", "Zukanovic");           // Azra Zukanovic
            p[4] = new Person("Kari", "Pettersen");           // Kari Pettersen

            Komparator<Person> c = (p1, p2) -> p1.fornavn().compareTo(p2.fornavn());
            System.out.println(Arrays.toString(p));           // Utskrift av tabellen p

            System.out.println("\nOg til slutt med lamda som argument: ");
            Tabell.innsettingssortering(p, (p1,p2) -> p1.fornavn().compareTo(p2.fornavn()));
            System.out.println(Arrays.toString(p));
        }

        // Oppgave 2:
        System.out.println("\nDeloppgave 2, lambdametode i innsettsortering: ");
        System.out.println("\nSortert etter naturlig orden for enum Studium: ");
        {
            Student[] s = new Student[5];                             // en studenttabell
            s[0] = new Student("Kari","Svendsen", Studium.Data);      // Kari Svendsen
            s[1] = new Student("Boris","Zukanovic", Studium.IT);      // Boris Zukanovic
            s[2] = new Student("Ali","Kahn", Studium.Anvendt);        // Ali Kahn
            s[3] = new Student("Azra","Zukanovic", Studium.IT);       // Azra Zukanovic
            s[4] = new Student("Kari","Pettersen", Studium.Data);     // Kari Pettersen

            Tabell.innsettingssortering(s, (s1,s2) -> s1.studium().compareTo(s2.studium()));
            System.out.println(Arrays.toString(s));

            System.out.println("\nVi ordner på samme måte med annen kode: ");

            Komparator<Student> c = (s1,s2) ->
            {
                int cmp = s1.studium().compareTo(s2.studium());
                return cmp != 0 ? cmp : s1.compareTo(s2);
            };

            //Tabell.innsettingssortering(s, c);    // Programkode 1.4.6 b)
            System.out.println(Arrays.toString(s));

            System.out.println("\nVi dropper komparatorvariablen c," +
                    " og lar lambdauttrykket inngå direkte som parameter: ");

            Tabell.innsettingssortering(s, (s1,s2) -> s1.studium().compareTo(s2.studium()));
            System.out.println(Arrays.toString(s));

            // Oppgave 3 - lag et lambdauttrykk som ordner studentene etter studium,
            //fornavn og etternavn:

            System.out.println("\nLambda som sorterer på studium, fornavn " +
                    "etternavn: ");
            Tabell.innsettingssortering(s, (s1,s2) -> {
               int result = s1.studium().compareTo(s2.studium());
               if (result == 0) {return result;}
               result = s1.fornavn().compareTo(s2.fornavn());
               if (result == 0) {return result;}
               return s1.etternavn().compareTo(s2.etternavn());
            });
            System.out.println(Arrays.toString(s));
        }

        //Oppgave 5:
        //Lag en lambda slik at like lange strenger ordnes alfabetisk(lexikografisk)
        System.out.println("\nOppgave 5:");
        {
            //String[] s = {"Lars","Anders","Bodil","Kari","Per","Berit"};
            String[] s = {"21","18","8","13","20","6","16","25","3","10"};
            Tabell.innsettingssortering(s, (s1,s2) -> {
                int result = s1.length() - s2.length();
                if (result != 0) {return result;}
                return s1.compareTo(s2);

            });

            System.out.println(Arrays.toString(s));
            // Utskrift: [Per, Lars, Kari, Bodil, Berit, Anders]
        }

        //Oppgave 7:
        //Endre lambda konstruksjonen i 1.4.6h slik at studiene ordnes alfabetisk etter
        //navn

        System.out.println("\nOppgave 7: ");
        {

            Student[] s = new Student[5];                             // en studenttabell
            s[0] = new Student("Kari","Svendsen", Studium.Data);      // Kari Svendsen
            s[1] = new Student("Boris","Zukanovic", Studium.IT);      // Boris Zukanovic
            s[2] = new Student("Ali","Kahn", Studium.Anvendt);        // Ali Kahn
            s[3] = new Student("Azra","Zukanovic", Studium.IT);       // Azra Zukanovic
            s[4] = new Student("Kari","Pettersen", Studium.Data);     // Kari Pettersen


            Komparator<Student> c = (s1,s2) ->
            {
                int cmp = s1.studium().toString().compareTo(s2.studium().toString());
                return cmp != 0 ? cmp : s1.compareTo(s2);
            };

            //Tabell.innsettingssortering(s, c);    // Programkode 1.4.6 b)
            System.out.println(Arrays.toString(s));
        }

        /**
         * Oppgave 1.4.7:
         * 1) OK - lagt inn alle interface
         *
         *
         */

        System.out.println("\nOppgave 2:\n");

        {
            Double[] d = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};

            Tabell.innsettingssortering(d, (s1,s2) ->{
                return s1.compareTo(s2);
            });

            System.out.println("\nInsettingssortering naturlig orden; ");
            System.out.println(Arrays.toString(d));

            Tabell.innsettingssortering(d, (s1,s2) -> {
                return s2.compareTo(s1);
            });

            System.out.println("\nInnsttingssortering motsatt orden komparator: ");
            System.out.println(Arrays.toString(d));
        }

        System.out.println("\nOppgave 3: \n");

        {
            Boolean[] b = {false, true, true, false, false, true, false, true};

            Tabell.innsettingssortering(b, (s1,s2) ->  {
                return s1.compareTo(s2);
            });

            System.out.println("\ninnsettingssortering naturlig orden: ");
            System.out.println(Arrays.toString(b));
        }

        System.out.println("\nOppgave 4:\n ");

        {
            Person[] p = new Person[5];                       // en persontabell
            p[0] = new Person("Kari", "Svendsen");            // Kari Svendsen
            p[1] = new Person("Boris", "Zukanovic");          // Boris Zukanovic
            p[2] = new Person("Ali", "Kahn");                 // Ali Kahn
            p[3] = new Person("Azra", "Zukanovic");           // Azra Zukanovic
            p[4] = new Person("Kari", "Pettersen");           // Kari Pettersen

            //Sortering via en orden teknikk:
            //Tabell.innsettingssortering(p, Komparator.orden(s1 -> s1.etternavn().toString()));
            //Dette kan skrives enda enklere:
            //Tabell.innsettingssortering(p, Komparator.orden(Person::etternavn));

            System.out.println(Arrays.toString(p));

            Tabell.innsettingssortering(p, (s1,s2) -> {
                return s1.etternavn().compareTo(s2.etternavn());
            });

            System.out.println(Arrays.toString(p));
        }

        System.out.println("\nOppgave 5: \n");

        {
            String[] s = {"Lars","Anders","Bodil","Kari","Per","Berit"};
            Tabell.innsettingssortering(s,(s1,s2) -> s2.length() - s1.length());
            System.out.println(Arrays.toString(s));
        }

        /**
         * Oppgave 1.4.8
         *
         * Oppg 1: Lagt inn kode i komparator klasse
         *
         * Oppg 2: Blir Komparator.orden(x -> x) og
         * Komparator.naturligOrden() det samme? Forklar!
         *
         * rett fra fasit:
         *
         *Lambda-uttrykket x -> x representerer det som i matematikk kalles
         * identitetsfunksjonen, dvs. funksjonen f som er slik at f(x) = x.
         * Det betyr at det ordnes mhp. x og det er samme som naturlig ordning
         * siden x er en instans av en sammenlignbar type.
         * Dermed er Komparator.orden(x -> x) og Komparator.naturligOrden() det samme.
         */

        System.out.println("\n *********** OPPGAVE 1.4.8 **************");

        System.out.println("\n Oppgave 3: \n");

        {
            Komparator<Integer> c = (x,y) ->
            {
                if (((x - y) & 1) == 0) return 0;  // x og y oddetall eller x og y partall
                else if ((x & 1) == 0) return 1;   // x partall og y oddetall
                else return -1;                    // x oddetall og y partall
            };

            Integer[] b = {6,2,7,1,9,5,10,8,4,3};
            //Tabell.innsettingssortering(b, c.deretter(x -> x));

            System.out.println(Arrays.toString(b));
        }

        System.out.println("\n Oppgave 4: \n");

        {
            String[] s = {"21","18","8","13","20","6","16","25","3","10","110","150","100"};
            //Tabell.innsettingssortering(s, Komparator.orden(String::length).deretter(x -> x));

            System.out.println(Arrays.toString(s));
        }

        System.out.println("\n *********** OPPGAVE 1.4.9 **************");

        /**
         * Oppgave 1: Har implementert Comparator i alle metoder som tidligere
         * brukte Komparator.
         *
         * Oppgave 2:
         */

        System.out.println("\n Oppgave 1: \n");

        {
            String[] s = {"Sohil","Per","Thanh","Ann","Kari","Jon"};       // String-tabell
            Comparator<String> c =  Comparator.comparing(String::length);  // etter lengde
            Tabell.innsettingssortering(s, c.thenComparing(x -> x));       // vanlig orden
            System.out.println(Arrays.toString(s));                        // skriver ut
        }
    }
}

