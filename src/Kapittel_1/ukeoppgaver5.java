package Kapittel_1;

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
            System.out.println("Boolean comparator: " + Boolean.compare(false,true));
        }
    }
}

