package Kapittel_1;


import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

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




            //Tabell.innsettingssortering(b);
            //Tabell.skriv(b);
    }
}



