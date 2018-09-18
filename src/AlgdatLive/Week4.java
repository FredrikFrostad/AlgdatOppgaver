package AlgdatLive;

import Kapittel_1.Tabell;

import java.util.Arrays;

public class Week4 {

    /*
    public static void partition(int[] a, int left, int right) {
        int v = left;
        int h = right;

        int pivot = a[(left + right) / 2];
        System.out.println("Pivot er : " + pivot);


        while (v <= h) {

            while (a[v] < pivot ) {
                v++;
            }
            while (a[h] > pivot) {
                h--;
            }

            if (v <= h) {

                int temp = a[h];
                a[h] = a[v];
                a[v] = temp;
                v++;
                h--;
            }
        }
    }
*/


    public static void main(String[] args) {

        int[] a = Tabell.randomarray(10);

        System.out.println("array før: " + Arrays.toString(a));

        System.out.println("Array etter partisjonering: " + Arrays.toString(a));
    }
}
