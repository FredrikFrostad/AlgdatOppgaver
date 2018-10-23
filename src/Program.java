import Eksempelklasser.Lenketliste.EnkeltLenketListe;
import Eksempelklasser.Queue.TabellKø;
import Eksempelklasser.TabelListe.Liste;
import Eksempelklasser.TabelListe.TabellListe;
import Eksempelklasser.Tabellstack.TabellStack;
import Kapittel_1.Tabell;

import java.util.Arrays;

import static javafx.scene.input.KeyCode.T;

public class Program {

    public static void main(String[] args) {

        String[] s = {"Sohil","Per","Thanh","Fatima","Kari","Jasmin"};
        int k = Tabell.maks(s);        // hvilken maks-metode?
        System.out.println(s[k]);      // Utskrift:  Thanh

        String[] t = {"Per","Kari","Ole","Anne","Ali","Eva", "Rodney", "William", "Espen",
                "Jonathan", "Else", "Margrete", "Sasha", "Rocco"};
        Tabell.innsettingssortering(t);
        System.out.println(Arrays.toString(t));  // [Ali, Anne, Eva, Kari, Ole, Per]

        double[] d = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};
        System.out.println(d.length);
        Double[] b = new Double[d.length];
        for (int i = 0; i < d.length; i++) {
            b[i] = d[i];
        }

        //Arrays.stream(d).forEach(e -> System.out.println());
        Arrays.stream(b)
                .filter(e -> e > 7)
                .map(e -> e*2)
                .forEach(e -> System.out.println(e));

        String[] str = {"Jens","Per","Kari","Ole","Berit","Jens","Anne","Nils","Siv"};

        Liste<String> liste = new TabellListe<>();

        for (String navn : str) liste.leggInn(0,navn);  // legger inn først

        System.out.println("Listeinnhold: " + liste);

        liste.fjernHvis(e -> e.equals("Jens"));

        System.out.println("Listeinnhold: " + liste);

        System.out.println(liste.inneholder("Berit"));


        TabellStack stack = new TabellStack();

        stack.leggInn("1");
        stack.leggInn("2");
        stack.leggInn("3");

        System.out.println(stack.toString());

        System.out.println("test terniary operator: ");
        System.out.println(test(10));

        System.out.println("Tabellkø testing: ");

        TabellKø<Integer> kø = new TabellKø<>();

        for (int i = 0; i <= 10; i++) {
            kø.leggInn(i);
        }

        System.out.println(kø.taUt());
        System.out.println(kø.taUt());
        System.out.println(kø.taUt());
        System.out.println(kø.taUt());
        System.out.println(kø.taUt());

        System.out.println(kø.toString());

        kø.leggInn(11);
        kø.leggInn(12);
        kø.leggInn(13);
        kø.leggInn(14);
        kø.leggInn(15);

        System.out.println(kø.taUt());
        System.out.println(kø.taUt());
        System.out.println(kø.taUt());



        System.out.println(kø.toString());

        System.out.println("\ntesting av bitoperatorer: \n");

        //System.out.println("printer ONEbitrepresentasjon av int: " + Integer.highestOneBit(35));
        //System.out.println("printer binærrepresentasjon av int: " + Integer.toBinaryString(32));
        //System.out.println("printer binærrepresentasjon av int: " + Integer.toBinaryString(8192));
        //System.out.println("printer binærrepresentasjon av int: " + Integer.toBinaryString(4096));
        //System.out.println("printer binærrepresentasjon av int: " + Integer.toBinaryString(2048));
        //System.out.println("printer binærrepresentasjon av int: " + Integer.toBinaryString(1024));
        //System.out.println("printer binærrepresentasjon av int: " + Integer.toBinaryString(512));
        //System.out.println("printer binærrepresentasjon av int: " + Integer.toBinaryString(256));
        //System.out.println("printer binærrepresentasjon av int: " + Integer.toBinaryString(128));
        //System.out.println("printer binærrepresentasjon av int: " + Integer.toBinaryString(32));
        //System.out.println("printer binærrepresentasjon av int: " + Integer.toBinaryString(16));
        //System.out.println("printer binærrepresentasjon av int: " + Integer.toBinaryString(8));
        //System.out.println("printer binærrepresentasjon av int: " + Integer.toBinaryString(4));
        //System.out.println("printer binærrepresentasjon av int: " + Integer.toBinaryString(2));
        //System.out.println("printer binærrepresentasjon av int: " + Integer.toBinaryString(1));
        //System.out.println("printer binærrepresentasjon av int: " + Integer.toBinaryString(0));
        int pos = 10;
        int filter = Integer.highestOneBit(pos >> 1);
        System.out.println(Integer.toBinaryString(pos & filter
        ));
        filter >>= 1;

        //System.out.println(Integer.toBinaryString(pos));
        //System.out.println(Integer.toBinaryString(filter & 13));
        //System.out.println(Integer.toBinaryString(pos & filter));
        //filter >>= 1;
        //System.out.println(Integer.toBinaryString(pos & filter));
        //filter >>= 1;
        //System.out.println(Integer.toBinaryString(pos & filter));
        //filter >>= 1;
        //System.out.println(Integer.toBinaryString(pos & filter));
        filter >>= 1;
        //System.out.println(Integer.toBinaryString(filter >>=1 & 13));
        //System.out.println(Integer.toBinaryString(filter >>=1 & 13));
       // System.out.println(filternonbit);
       // System.out.println(filternonbit >>= 1);
       // System.out.println(filternonbit);
        //String bitstr = Integer.toBinaryString(bit);
        //System.out.println("bitforskyver deretter med 1: " + bit);
        //System.out.println("bitforskyver deretter med 1: " + bitstr);


    }
    public static int test(int b) {
        int a = 5;

        return a < b ? returner(a) : b;

    }

    public static int returner(int a) {
        return 123456 + a;
    }
}



