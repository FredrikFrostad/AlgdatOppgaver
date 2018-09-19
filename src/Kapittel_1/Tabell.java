package Kapittel_1;

import Eksempelklasser.Komparator;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

public class Tabell {

    private Tabell() {}

    public static void fratilKontroll(int tablengde, int fra, int til) {
        if (fra < 0) {                                 // fra er negativ
            throw new ArrayIndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");
        }
        if (til > tablengde) {                         // til er utenfor tabellen
            throw new ArrayIndexOutOfBoundsException
                    ("til(" + til + ") > tablengde(" + tablengde + ")");
        }
        if (fra > til) {                               // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
        }
        if (fra == til)
            throw new NoSuchElementException
                    ("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");
    }


    public static void vhKontroll(int tablengde, int v, int h) {
        if (v < 0) {
            throw new ArrayIndexOutOfBoundsException("v(" + v + ") < 0");
        }
        if (h >= tablengde) {
            throw new ArrayIndexOutOfBoundsException
                    ("h(" + h + ") >= tablengde(" + tablengde + ")");
        }
        if (v > h + 1) {
            throw new IllegalArgumentException
                    ("v = " + v + ", h = " + h);
        }
    }



    public static int minClosed(int[] a, int v, int h) {

        if (v < 0 || h > a.length || v >= h) {
            throw new IllegalArgumentException("illegalt intervall");
        }

        int m = v;
        int minverdi = a[v];

        for (int i = v + 1; i <= h; i++) {
            if (a[i] < minverdi) {
                m = i;
                minverdi = a[m];
            }
        }
        return m;
    }


    public static int[] randomarray(int numValues) {

        int[] values =new int[numValues];

        //Fyll arrayet med tallene 0 til 10
        for (int i = 0; i < numValues; i++) {
            values[i] = i+1;
        }

        //Loop gjennom arrayet og bytt random
        for (int i = numValues -1; i > 0; --i) {

            //Genererer et tilfeldig tall mellom 1 og 10
            int k = (int) (Math.random()*i);

            //bytt tallene i og k
            int temp = values[i];
            values[i] = values[k];
            values[k] = temp;
        }

        return values;
    }
    //Funksjon som finner minste verdi
    public static int findMinValue(int[] a) {
        int index = 0;

        for (int i = 1; i < a.length; i++)  {
            if (a[i] < a[index]) {
                index = i;
            }
        }
        return index;
    }

    //Funskjon som finner største verdi
    public static int findMaximum(int[] num_values) {

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < num_values.length; i++) {

            if (max < num_values[i]) {
                max = num_values[i];
            }
        }
        return  max;
    }

    //Metode som bytter om to integere i et array
    public static void bytt(int[] a, int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //Metode som bytter om to characters i et array
    public static void bytt(char[] c, int i, int j) {

        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

    //Metode som skriver ut verdiene i et halvåpent intervall
    public static void skriv(int[] a, int fra, int til) {

        //Sjekker at intervallet er gyldig
        fratilKontroll(a.length, fra, til);

        for (int i = fra; i < a.length; i++) {

            if (i < til) {
                System.out.print(a[i] + " ");
            }
            else {
                System.out.print(a[i]);
            }
        }

    }

    public static void skriv(int[] a) {

        for (int i = 0; i < a.length ; i++) {

            if (i < a.length - 1) {
                System.out.print(a[i] + " ");
            }
            else {
                System.out.print(a[i]);
            }
        }
    }



    public static void skrivLn(int[] a, int fra, int til) {

        //Sjekker at intervallet er gyldig
        fratilKontroll(a.length, fra, til);

        for (int i = fra; i < a.length; i++) {

            if (i < til) {
                System.out.print(a[i] + " ");
            }
            else {
                System.out.println(a[i]);
            }
        }
    }


    public static void skrivLn(int[] a) {

        for (int i = 0; i < a.length ; i++) {

            if (i < a.length - 1) {
                System.out.print(a[i] + " ");
            }
            else {
                System.out.println(a[i]);
            }
        }
    }

    public static int[] randPerm(int n)  // en effektiv versjon
    {
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall

        Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k+1);        // en tilfeldig tall fra 0 til k
            bytt(a,k,i);                   // bytter om
        }

        return a;                        // permutasjonen returneres
    }



    public static void randPerm(int[] a)  // stokker om a
    {
        Random r = new Random();     // en randomgenerator

        for (int k = a.length - 1; k > 0; k--)
        {
            int i = r.nextInt(k + 1);  // tilfeldig tall fra [0,k]
            bytt(a,k,i);
        }
    }

    public static int maks(int[] a, int fra, int til) {

        //Sjekker om arrayet er gyldig (ikke null)
        if(a == null) throw new NullPointerException
                (a.toString() + "is null");

        //Sjekker intervallets gyldighet
        fratilKontroll(a.length, fra, til);

        int m = fra;              // indeks til største verdi i a[fra:til>
        int maksverdi = a[fra];   // største verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++)
        {
            if (a[i] > maksverdi)
            {
                m = i;                // indeks til største verdi oppdateres
                maksverdi = a[m];     // største verdi oppdateres
            }
        }

        return m;  // posisjonen til største verdi i a[fra:til>
    }

    public static int maks(int[] a) { // bruker hele tabellen

    //Sjekker om arrayet er gyldig (ikke null)
        if(a == null) throw new NullPointerException
            ("Tabellen er null");

        return maks(a,0,a.length);     // kaller metoden over
    }

    //Metode som snur rekkefølgen på verdiene i et integer array
    public static void snu(int[] a) {

        int[] temp = a.clone();

        for (int i = a.length - 1; i >= 0; i--) {
            a[a.length - (i + 1)] = temp[i];
        }
    }


    //Metode som snur rekkefølgen på verdiene i et lukket intervall
    //i en integer tabell
    public static void snu(int[] a, int v, int h) {

        //Sjekker at intervallet er gyldig
        fratilKontroll(a.length, v, h);

        while (v < h) {
            bytt(a, v++, h--);
        }
    }

    //Metode som snur rekkefølgen på verdiene i et char array
    public static void snu(char[] a) {

        char[] temp = a.clone();

        for (int i = a.length - 1; i >= 0; i--) {
            a[a.length - (i + 1)] = temp[i];
        }
    }

    //Metode som snur rekkefølgen på verdiene i et lukket intervall
    // i en char tabell
    public static void snu(char[] a, int v, int h) {

        //Sjekker at intervallet er gyldig
        fratilKontroll(a.length, v, h);

        while (v < h) {
            bytt(a,v++, h--);
        }
    }


    public static int[] nestMaks(int[] a)   // en turnering
    {
        int n = a.length;                // for å forenkle notasjonen

        if (n < 2) // må ha minst to verdier!
            throw new IllegalArgumentException("a.length(" + n + ") < 2!");

        int[] b = new int[2*n];          // turneringstreet
        System.arraycopy(a,0,b,n,n);     // legger a bakerst i b

        for (int k = 2*n-2; k > 1; k -= 2)   // lager turneringstreet
            b[k/2] = Math.max(b[k],b[k+1]);

        int maksverdi = b[1], nestmaksverdi = Integer.MIN_VALUE;

        for (int m = 2*n - 1, k = 2; k < m; k *= 2)
        {
            int tempverdi = b[k+1];  // ok hvis maksverdi er b[k]
            if (maksverdi != b[k]) { tempverdi = b[k]; k++; }
            if (tempverdi > nestmaksverdi) nestmaksverdi = tempverdi;
        }

        return new int[] {maksverdi,nestmaksverdi}; // størst og nest størst

    } // nestMaks

    //Forbedret metode som finner nest største verdi et array og returnerer dennes index
    public static int[] nestMaksFront(int[] a) {

        int n = a.length;

        int m = maks(a);  // m er posisjonen til tabellens største verdi

        bytt(a, 0, m);

        int nm = maks(a,1,n);     // nm skal inneholde posisjonen til nest største verdi

        if(nm == m) nm = 0;

        bytt(a, 0, m );

        return new int[] {m,nm};      // m i posisjon 0 , nm i posisjon 1

    }

    public static int[] nestMaksBak(int[] a) {

        int n = a.length;
        int m = maks(a);        //Posisjonen til tabellens største verdi
        bytt(a,n-1 ,m);      //Flytter største verdi til siste plass i arrayet

        int nm = maks(a, 0, n-1);   //Finner største verdi i intervallet [0:n-1>

        if (nm == m) nm = n;

        bytt(a, n-1, m);

        return new int[] {m,nm};
    }




    //Metode som sorterer verdiene i et array i stigende rekkefølge
    public static void sortering(int[] a) {

        int m;
        int i = a.length;

        while (i > 0) {
            m = maks(a,0, i);
            bytt(a, i-1, m);
            --i;
        }
    }

    public static int maks(double[] a)     // legges i class Tabell
    {
        int m = 0;                           // indeks til største verdi
        double maksverdi = a[0];             // største verdi

        for (int i = 1; i < a.length; i++) if (a[i] > maksverdi)
        {
            maksverdi = a[i];     // største verdi oppdateres
            m = i;                // indeks til største verdi oppdaters
        }
        return m;     // returnerer posisjonen til største verdi
    }

/*
    public static int maks(String[] a)    // legges i class Tabell
    {
        int m = 0;                          // indeks til største verdi
        String maksverdi = a[0];            // største verdi

        for (int i = 1; i < a.length; i++) if (a[i].compareTo(maksverdi) > 0)
        {
            maksverdi = a[i];  // største verdi oppdateres
            m = i;             // indeks til største verdi oppdaters
        }
        return m;  // returnerer posisjonen til største verdi
    }
*/

    public static <T extends Comparable<? super T>> int maks(T[] a)
    {
        int m = 0;                     // indeks til største verdi
        T maksverdi = a[0];            // største verdi

        for (int i = 1; i < a.length; i++) if (a[i].compareTo(maksverdi) > 0)
        {
            maksverdi = a[i];  // største verdi oppdateres
            m = i;             // indeks til største verdi oppdaters
        }
        return m;  // returnerer posisjonen til største verdi
    } // maks

    public static <T extends Comparable<? super T>> void innsettingssortering(T[] a)
    {
        for (int i = 1; i < a.length; i++)  // starter med i = 1
        {
            T verdi = a[i];        // verdi er et tabellelemnet
            int  j = i - 1;        // j er en indeks
            // sammenligner og forskyver:
            for (; j >= 0 && verdi.compareTo(a[j]) < 0 ; j--) a[j+1] = a[j];

            a[j + 1] = verdi;      // j + 1 er rett sortert plass
        }
    }

    public static <T> void innsettingssortering(T[] a, Komparator<? super T> c)
    {
        for (int i = 1; i < a.length; i++)  // starter med i = 1
        {
            T verdi = a[i];        // verdi er et tabellelemnet
            int  j = i - 1;        // j er en indeks

            // sammenligner og forskyver:
            for (; j >= 0 && c.compare(verdi,a[j]) < 0 ; j--) a[j+1] = a[j];

            a[j + 1] = verdi;      // j + 1 er rett sortert plass
        }
    }

    public static int maks(char[] a) {

        int m = 0;
        char maksverdi = a[0];

        for (int i = 1; i < a.length; i++) {
            if (a[i] > maksverdi) {
                maksverdi = a[i];
                m = i;
            }
        }
        return m;
    }

    public static <T> int maks(T[] a, Komparator<? super T> c) {

        T maksverdi = a[0];
        int index = 0;

        for (int i = 1; i < a.length; i++) {
            if (c.compare(a[i],maksverdi) > 0) {
                maksverdi = a[i];
            }
        }

        return index;
    }

    public static Integer[] randPermInteger(int n)
    {
        Integer[] a = new Integer[n];               // en Integer-tabell
        Arrays.setAll(a, i -> i + 1);               // tallene fra 1 til n

        Random r = new Random();   // hentes fra  java.util

        for (int k = n - 1; k > 0; k--)
        {
            int i = r.nextInt(k+1);  // tilfeldig tall fra [0,k]
             bytt(a,k,i);             // bytter om
        }
        return a;  // tabellen med permutasjonen returneres
    }


    public static void skriv(Object[] a, int fra, int til) {

        for (int i = fra; i < til; i++) {
            System.out.print(" " + a[i]);
        }
    }

    public static void skrivln(Object[] a, int fra, int til) {

        for (int i = fra; i < til; i++) {
            System.out.print(" " + a[i]);
        }
        System.out.println();
    }

    public static void skrivln(Object[] a) {

        for (Object o : a) {
            System.out.print(" " + o);
        }
        System.out.println();
    }


    public static void skriv(Object[] a) {

        for (Object o : a) {
            System.out.print(" " + o);
        }
    }

    public static void bytt(Object[] a, int i, int j) {

        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
