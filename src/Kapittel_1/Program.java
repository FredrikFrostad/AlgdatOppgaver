package Kapittel_1;


import java.util.Random;

public class Program {

    public static void main(String[] args) {

        int[] a = Tabell.randPerm(10);

        System.out.println("Tabell før turnering: ");
        Tabell.skrivLn(a);

        int[] b = Tabell.nestMaks(a);

        Tabell.skrivLn(b);

        int[] e = {-7,3,2,6,-8,-9,5,1,2,8,13,-4};

        Tabell.sortering(e);

        System.out.println();
        for (int i:e) {
            System.out.print(i + " ");
        }
    }
}



