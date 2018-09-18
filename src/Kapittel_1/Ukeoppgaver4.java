package Kapittel_1;

public class Ukeoppgaver4 {

    //Oppgave 1 - a


    /**
     * Metode som iterativt finner løsningen på en hardkodet differenslikning
     * @param n leddet vi ønsker å finne
     * @return løsningen på likningen
     */
    public static int a(int n) {

        if (n < 0) {
            throw new IllegalArgumentException
                    ("Parameterverdi må være positiv");
        }

        int x = 0, y = 1, z = 0;

        for (int i = 0; i < n; i++) {
            z = 2*y + 3*x;
            x = y;
            y = z;
        }

        return z;
    }

    public static void mod(int n) {
        System.out.println(n % 10);
        System.out.println(n/10);
    }

    /**
     * Metode som finner tverrsummen til et tall
     * @param n parametertallet vi skal finne tverrsummen til
     * @return tversummen som en integer
     */
    public static int tverrsum(int n) {
        int out = 0;
        while (n > 0) {
            out += n % 10;
            n = (n / 10);
        }
        return out;
    }

    /**
     * Metode som finner sifferroten til et tall
     * @return sifferroten som en integer
     */
    public static int sifferrot(int n) {

        if (n < 10) return n;
        else{return sifferrot(tverrsum(n));}
    }

    /**
     * Metode som finner summen av kvadrattallene fra 1 til n
     * @param n
     * @return
     */
    public static int kvadratsum(int n) {

        if (n == 1) return 1;
        else {
            return kvadratsum((n-1)) + n*n;
        }
    }

    public static int sum(int k, int n) {


        return 0;
    }

    public static void main(String[] args) {
       // System.out.println(a(2));
        //mod(23536);
        //int o = tverrsum(99);
        //System.out.println(o);
        int i = kvadratsum(4);
        System.out.println(i);
    }

}
