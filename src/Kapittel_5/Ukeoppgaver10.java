package Kapittel_5;

import Eksempelklasser.Heapprioritetskø.HeapPrioritetsKø;
import Eksempelklasser.Heapprioritetskø.PrioritetsKø;
import Eksempelklasser.Tabell.Tabell;

public class Ukeoppgaver10 {

    public static void main(String[] args) {

        System.out.println("\n Oppgave 5.3.3 \n");

        {
            System.out.println("\n Oppgave 1: \n");

            int[] a = {3,5,7,10,5,8,18,12,17,11,10,14};
            PrioritetsKø<Integer> kø = HeapPrioritetsKø.naturligOrden();
            for (int element : a) kø.leggInn(element);

            kø.leggInn(6);  System.out.println(kø);     // legger inn 6
            kø.leggInn(10); System.out.println(kø);     // legger inn 10
            kø.leggInn(12); System.out.println(kø);     // legger inn 12

            // Utskrift:
            // [3, 5, 6, 10, 5, 7, 18, 12, 17, 11, 10, 14, 8]          se Figur 5.3.2 c)
            // [3, 5, 6, 10, 5, 7, 10, 12, 17, 11, 10, 14, 8, 18]      se Figur 5.3.2 d)
            // [3, 5, 6, 10, 5, 7, 10, 12, 17, 11, 10, 14, 8, 18, 12]  se Figur 5.3.2 e)
        }

        {
            System.out.println("\n Oppogave 2: \n");

            int[] a = {3,5,4,10,5,8,18,12,17,11,10,14};

            HeapPrioritetsKø<Integer> kø = HeapPrioritetsKø.naturligOrden();

            for (int k : a) kø.leggInn(k);

            System.out.println(kø.minimumsGrenen());

            // Utskrift: [3, 4, 8, 14]

            kø.leggInn(9);

            System.out.println(kø);
        }

        {
            System.out.println("\n Oppgave 3: \n");

            int n = 10;                           // velg n >= 0
            int[] a = Tabell.randPerm(n);         // en permutasjon av tallene fra 1 til n

            PrioritetsKø<Integer> kø = HeapPrioritetsKø.naturligOrden();
            for (int k: a) kø.leggInn(k);         // ett og ett tall inn i køen

            while (!kø.tom())
            {
                System.out.print(kø.taUt() + " ");  // tar ut fra køen
            }
            // Utskrift: 1 2 3 4 5 6 7 8 9 10
        }
    }
}
