package AlgdatLive;

import Eksempelklasser.Tabell.Tabell;

public class Week3 {

    public static void bubble(int[] a) {

        //Itererer over alle elementene i a
        for (int i = 0; i < a.length-1; ++i) {

            if (a[i] > a[i + 1]) {
                System.out.println("Inversjon i plass" + i + ", bytter om");
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
            }
        }
    }

    public static void bubbleSort(int[] a) {

        for (int i = 0; i < a.length; ++i) {
            bubble(a);
            Tabell.skrivLn(a);
        }
    }

    public static void bytt(int[]a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;


    }


    public static void main(String[] args) {

        int n = 5;
        int[] a = Tabell.randomarray(n);

        bubbleSort(a);
    }
}
