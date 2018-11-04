package Kapittel_6;

import Eksempelklasser.LenketHashTabell.LenketHashTabell;
import Kapittel_1.Tabell;

import java.util.Arrays;
import java.util.Iterator;

import static java.util.Objects.hash;

public class Ukeoppgaver11 {

    public static void main(String[] args) {


        System.out.println("********** Oppgave 6.1.1 ************");

        {
            System.out.println("Oppgave 1: \n");

            String[] text = {"lik1", "lik2", "lik3", "eq1", "eq2", "eq3", "h1", "h2", "h3", "h4"};
            String[] s = {"A"};
            String a = "A", b = "A", c = new String("A"), d = s[0];

            boolean lik1 = (a == b), lik2 = (a == c), lik3 = (a == d);
            boolean eq1 = a.equals(b), eq2 = a.equals(c), eq3 = a.equals(d);
            int h1 = a.hashCode(), h2 = b.hashCode(), h3 = c.hashCode(), h4 = d.hashCode();

            System.out.println("lik " + lik1);
            System.out.println("lik " + lik2);
            System.out.println("lik " + lik3);

            System.out.println("\nequals " + eq1);
            System.out.println("equals " + eq2);
            System.out.println("equals " + eq3);

            System.out.println("\nhash " + h1);
            System.out.println("hash " + h2);
            System.out.println("hash " + h3);
            System.out.println("hash " + h4);
        }

        {
            System.out.println("\n\nOppgave 2: \n");

            //Gitt koden under, hva blir verdiene til variablene?

            int[] a = {1, 2, 3}, b = a, c = {1, 2, 3};
            boolean lik1 = (a == b), lik2 = (a == c), lik3 = a.equals(c);
            // Svar: Koden vil gi verdiene:
            // lik1 = true
            // lik2 = false
            // lik3 = false (fordi equals her er det samme som ==, for å sammenlikne innhold
            //              må vi bruke Arrays.equals(a, c) !!

            System.out.println(lik1);
            System.out.println(lik2);
            System.out.println(lik3);

        }

        System.out.println("\n\n * *********Oppgave 6.1.3 ************\"\n");

        {
            System.out.println("\nOppgave 1: \n");

            /**
             * Denne oppgaven er løst med penn og papir
             */
        }

        {
            System.out.println("\nOppgave 2: \n");

            int n = 197;
            int[] hash = new int[n];

            for (int i = 0; i < 400; i++)
            {
                String s = "A";
                if (i < 100) s += 0;
                if (i < 10) s += 0;
                s += i;
                hash[s.hashCode() % n]++;
            }

            int m = Tabell.maks(hash);  // posisjonen til største verdi

            int maks = hash[m];         // den største verdien

            int[] frekvens = new int[maks + 1];
            for (int i = 0; i < hash.length; i++) frekvens[hash[i]]++;  // teller opp

            System.out.println(Arrays.toString(frekvens));  // [0, 48, 95, 54]



        }

        {
            System.out.println("\nOppgave 3: \n");

            int n = 197;
            int[] hash = new int[n];

            for (int i = 0; i < 400; i++)
            {
                String s = "A";
                if (i < 100) s += 0;
                if (i < 10) s += 0;
                s += i;
                hash[hash2(s) % n]++;    //Bruker hashfunksjon definert nederst i filen
            }

            int m = Tabell.maks(hash);  // posisjonen til største verdi

            int maks = hash[m];         // den største verdien

            int[] frekvens = new int[maks + 1];
            for (int i = 0; i < hash.length; i++) frekvens[hash[i]]++;  // teller opp

            System.out.println(Arrays.toString(frekvens));  // [0, 48, 95, 54]

        }

        {
            System.out.println("\nOppgave 4: \n");

            int n = 197;
            int[] hash = new int[n];

            for (int i = 0; i < 400; i++)
            {
                String s = "A";
                if (i < 100) s += 0;
                if (i < 10) s += 0;
                s += i;
                hash[elfhash(s) % n]++;     //Bruker elfhash definert nederst i filen
            }

            int m = Tabell.maks(hash);  // posisjonen til største verdi

            int maks = hash[m];         // den største verdien

            int[] frekvens = new int[maks + 1];
            for (int i = 0; i < hash.length; i++) frekvens[hash[i]]++;  // teller opp

            System.out.println(Arrays.toString(frekvens));  // [0, 48, 95, 54]

        }

        System.out.println("\n Oppgave 5: \n");

        System.out.println("Kode for å erstatte k med sitt komplement dersom k er negativ:");
        System.out.println(" if (k < 0) k = ~k");

        {
            System.out.println("\n Oppgave 6: \n");

            //Hva blir resten: -1 % 3 ? Vi kan isteden se bort fra fortegnet og la den første
            //biten være en vanlig bit. Hva blir Integer.remainderUnsigned(-1, 3) ?

            int j = -1 % 3;
            int i =Integer.remainderUnsigned(-1, 3);

            System.out.println("-1 % 3: " + j);
            System.out.println("Integer.remainderUnsigned(-1, 3): " + i);
        }

        {
            System.out.println("\n Oppgave 7: \n");

            int h = hash("ABC", 10, 3.14);
            System.out.println("Printer resultat av hashfunksjon: " + h);
        }

        System.out.println("\n Oppgave 6.1.4: \n");

        {
            System.out.println("\n Oppgave 1: \n");

            //Har kopiert nødvendige klasser fra kompendiet og inn i
            //pakke eksempelklasser

            String[] navn = {"Olga","Basir","Ali","Per","Elin","Siri",
                    "Ole","Mette","Anne","Åse","Leif","Mona","Lise"};

            LenketHashTabell<String> hashtabell = new LenketHashTabell<>();

            for (String n : navn) hashtabell.leggInn(n);

            System.out.println(hashtabell);
            // [Elin, Basir, Leif, Ole, Olga, Per, Mette, Mona, Anne, Ali, Lise, Åse, Siri]
        }

        {
            System.out.println("\n Oppgave 2: \n");

            System.out.println("Lagt inn metoder fjern, nullstill og iterator");
            System.out.println("Har latt klasse LenketHashTabell implementere Beholder");


        }

        {
            System.out.println("\n Oppgave 3: \n");

            String[] navn = {"Olga","Basir","Ali","Per","Elin","Siri",
                    "Ole","Mette","Anne","Åse","Leif","Mona","Lise"};

            System.out.println("Lager hashtabell med 11 som startdimensjon: ");
            LenketHashTabell<String> hashTabell = new LenketHashTabell<>(11);

            for (String e : navn) {
                hashTabell.leggInn(e);
                System.out.println(hashTabell);
            }
        }

        {
            System.out.println("\nSamme som over, men denne gangen med 0 som startdimensjon: \n");

            String[] navn = {"Olga","Basir","Ali","Per","Elin","Siri",
                    "Ole","Mette","Anne","Åse","Leif","Mona","Lise"};


            LenketHashTabell<String> hashTabell = new LenketHashTabell<>(0);

            for (String e : navn) {
                hashTabell.leggInn(e);
                System.out.println(hashTabell);
            }

            //Vi ser på utskriften at det blir gjort mange flere utvidelsesoperasjoner når vi starter
            //med dimensjon = 0. Dette fører til at tabellen ender opp med en annen lengde enn i eksmpelet
            //over. Dermed får vi andre indekser enn i det første tilfellet
        }

        {
            System.out.println("\n Oppgave 4: \n");

            //Tester at implemenstasjon av metode inneholder(T verdi) fungerer.

            String[] navn = {"Olga","Basir","Ali","Per","Elin","Siri",
                    "Ole","Mette","Anne","Åse","Leif","Mona","Lise"};


            LenketHashTabell<String> hashTabell = new LenketHashTabell<>(0);

            for (String e : navn) {
                hashTabell.leggInn(e);
                System.out.println(hashTabell);
            }

            System.out.println("\nSjekker om Anne er i tabellen, skal gi true: ");
            System.out.println(hashTabell.inneholder("Anne"));

            System.out.println("\nSjekker om Roger er i tabellen, skal gi false: ");
            System.out.println(hashTabell.inneholder("Roger"));
        }

        {
            System.out.println("\n Oppgave 5: \n");

            String[] navn = {"Olga","Basir","Ali","Per","Elin","Siri",
                    "Ole","Mette","Anne","Åse","Leif","Mona","Lise"};


            LenketHashTabell<String> hashTabell = new LenketHashTabell<>(13);

            for (String e : navn) {
                hashTabell.leggInn(e);
            }

            System.out.println("Før fjerning\n" + hashTabell.toString());
            hashTabell.fjern("Basir");
            System.out.println("\nEtter fjerning\n" + hashTabell.toString());

        }

        {
            System.out.println("\n Oppgave 6: \n");

            String[] navn = {"Olga","Basir","Ali","Per","Elin","Siri",
                    "Ole","Mette","Anne","Åse","Leif","Mona","Lise"};


            LenketHashTabell<String> hashTabell = new LenketHashTabell<>(13);

            for (String e : navn) {
                hashTabell.leggInn(e);
            }

            System.out.println("Før fjerning\n" + hashTabell.toString());
            hashTabell.nullstill();
            System.out.println("\nEtter fjerning\n" + hashTabell.toString());
        }

        {
            System.out.println("\n Oppgave 7: \n");

            String[] navn = {"Olga","Basir","Ali","Per","Elin","Siri",
                    "Ole","Mette","Anne","Åse","Leif","Mona","Lise"};


            LenketHashTabell<String> hashTabell = new LenketHashTabell<>(13);

            for (String e : navn) {
                hashTabell.leggInn(e);
            }

            Iterator<String> iter = hashTabell.iterator();

            System.out.println("Før fjerning\n" + hashTabell.toString());

            while (iter.hasNext()) {
                iter.next();
                iter.remove();
            }

            System.out.println("\nEtter fjerning\n" + hashTabell.toString());
        }
    }


    //Denne funksjonen brukes i 6.1.3 oppgave 3
    public static int hash2(String s)
    {
        int h = 0;
        for (int i = 0; i < s.length(); i++)
        {
            h = (h << 5) ^ s.charAt(i) ^ h;
        }
        return h;
    }

    //Denne funksjonen brukes i 6.1.3 oppgave 4
    public static int elfhash(String s)
    {
        int h = 0;
        for (int i = 0; i < s.length(); i++)
        {
            h = (h << 4) + s.charAt(i);
            int g = h & 0xf0000000;
            if (g != 0) h ^= (g >>> 24);
            h &= ~g;
        }
        return h;
    }

    //Denne funksjonen brukes i oppgave 6.1.3 - 7
    public static int hash(Object... verdier)
    {
        if (verdier == null) return 0;
        int h = 1;
        for (Object o : verdier)
        {
            h = h*31 + (o == null ? 0 : o.hashCode());
        }
        return h;
    }


}
