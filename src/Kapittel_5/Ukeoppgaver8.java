package Kapittel_5;

import Eksempelklasser.BinaryTree.BinTre;

public class Ukeoppgaver8 {

    public static void main(String[] args) {

        System.out.println("\n ******* Oppgave 5.1.1 ******\n");

        /**
         *  OPPGAVE 1:
         *
         *  a) Treet i oppgaven har 5 nivåer
         *
         *  b) Nodene som ligger på nivå 2 er: L O B
         *
         *  c) Nodene på nivå 3 er: A E N G
         *
         *  d)  Dersom det ikke legges til noen noder på niva 2, kan nivå 3 maksimail inneholde
         *      2 flere noder
         *
         *  e) På sAmme måte kan nivå 4 maksimalt inneholde 4 flere noder
         *
         *  f) Nodene K, F og C er etterkommere av noden A
         *
         *  g) Nodene D, I og L er forgjengere til noden A
         *
         *  h)  Alle noder med to eller flere nivåer med etterkommere er besteforeldre. I dette
         *      tilfellet gjelder det nodene: A, L , I , D, O, H,
         *
         *  i) Det er to enebarn i treet: L og K
         *
         *  k) D noden har dybde null
         *
         *  l) I nodens venstre subtre har høyde -1 og det venstre har høyde 3
         *
         *  m) Treet har 7 bladnoder
         *
         *  n) Treet har 8 indre noder
         *
         *  o)  La et binærtre ha n noder.
         *      Hva er minste og største antall bladnoder et binærtre kan ha?
         *
         *      Det maksimale antallet bladnoder i et binærtre er n/2 noder, der n er antaller
         *      noder i treet
         *
         *  OPPGAVE 2:
         *
         *  a)  Treet har 4 nivåer
         *
         *  b) Nodene på nivå 3 er G A H K
         *
         *  c) Nodene på nivå 2 er I og B
         *
         *  d) Nivå 4 kan inneholde 4 flere noder
         *
         *  e)
         *
         *  f) L, O M og C er etterkommere til noden A
         *
         *  g) Nodene E og I er forgjengere til noden A
         *
         *  h) Følgende noder er besteforeldre: A, K, I, B og E
         *
         *  i) Følgende noder er enebarn: G, H, K, L, D
         *
         *  j) Treets høyde er 4
         *
         *  k) Dybden til D noden er 3
         *
         *  l) I nodens venstre subtre har høyde 0 og det høyre har høyde 2
         *
         *  m) Det er 7 bladnoder i treet (n-1, der n = antall indre noder)
         *
         *  n) Det er 8 indre noder i treet (n+1, der n = antall bladnoder)
         *
         *  OPPFGAVE 3:
         *
         *  a)  Gjør flg. for treet i Oppgave 1: a) To noder kalles søskenbarn hvis de
         *      har samme besteforelder, men ikke samme forelder.
         *      Skriv opp de nodene som har minst ett søskenbarn.
         *      Hvor mange søskenbarn kan en node ha?
         *
         *      svar:   L og O er søskenbarn, L og B er søskenbarn.
         *              En node kan ha maksimalt to søskenbarn
         *
         *
         */

        System.out.println("\n ******* Oppgave 5.1.3 ******\n");

        /**
         *
         */
        {

        }

        System.out.println("\n ******* Oppgave 5.1.5 ******\n");

        /**
         * 1)   Kopier klassen BinTre over til deg. Legg den under package hjelpeklasser.
         *      Legg metodene i Programkode 5.1.5 b), c) og j) inn i klassen.
         *      Lag et program som kjører Programkode 5.1.5 c) og d)
         *
         * 2)   Lag kode som bygger opp trærne fra Oppgave 1 og 2 i Avsnitt 5.1.1.
         *
         * 3)   Gjør som over for Tre 1 og Tre 2 fra Oppgave 1 i Avsnitt 5.1.3.
         *
         * 4)   La {5,23,2,10,3,11,47,1,22,44} være posisjonstallene for nodene i et binærtre
         *      og {4,8,2,5,3,6,10,1,7,9} de tilhørende nodeverdiene i samme rekkefølge.
         *      Dvs. noden med posisjon 5 skal ha nodeverdi 4, osv. Tegn treet. Lag så kode som bygger treet.
         *
         * 5)   Lag kode som bygger et perfekt tre med 15 noder og med verdiene 1 - 15 i nivåorden
         *
         * 6)   Lag kode som bygger et tre med 15 noder der nodene har verdiene 1, 2, . . , 15 i nivåorden.
         *      Ingen noder i treet skal ha høyre barn. Tegn treet først
         *
         * 7)   Lag kode som bygger et tre med 15 noder der nodene har verdiene 1, 2, . . , 15 i nivåorden.
         *      Rotnodens to subtrær skal begge ha 7 noder. I det venstre subtreet skal ingen noder ha høyre
         *      barn og i det høyre subtreet skal ingen node ha venstre barn.
         *      Tegn treet først slik at du ser hvilke noder og posisjonstall du må ha.
         *
         * 8)   Lag metoden public int nodetype(int posisjon) i klassen BinTre.
         *      Den skal returnere 1 hvis posisjon hører til en bladnode, returnere 0 hvis posisjon hører til
         *      en indre node og -1 hvis posisjon ikke er i treet. Bruk metoden finnNode() i kodingen din.
         *
         */

        System.out.println("\n ******************** Oppgave 2: ******************");

        {
            String values = "DIHLOBAENGKMJFC";
            int[] pos = {1,2,3,5,6,7,10,11,12,13,21,42,43};

            BinTre<String> tre = new BinTre<>();

            for (int i = 0; i < pos.length; i++) {
                tre.leggInn(pos[i], values.substring(i,i+1));
            }

        }

        System.out.println("\n ******************** Oppgave 3: ******************");

        {
            String values = "OGBKRELIANHKDPCQMF";
            int[] pos = {1,2,3,4,5,6,7,9,11,12,14,18,19,24,25,38,39};

            BinTre<String> tre = new BinTre<>();

            for (int i = 0; i < pos.length; i++) {
                tre.leggInn(pos[i], values.substring(i,i + 1));
            }
        }

        System.out.println("\n ******************** Oppgave 4: ******************");

        {
            //Samme prosedyre som oppgaven over
        }

        System.out.println("\n ******************** Oppgave 5: ******************");

        {
            BinTre<Integer> tre = new BinTre<>();

            for (int i = 1; i <= 15; i++) {
                tre.leggInn(i,i);
                System.out.println(i);
            }
        }

        System.out.println("\n ******************** Oppgave 6: ******************");

        {
            BinTre<Integer> tre = new BinTre<>();
            int k = 1;
            int n = 15;
            for (int i = 1; i <= n; i++ ) {
                tre.leggInn(k, i);
                k *= 2;
                System.out.println(k + ", " + i);
            }
        }

        System.out.println("\n ******************** Oppgave 7: ******************");

        {

            BinTre<Integer> tre = new BinTre<>();

            int k = 1;
            int n = 15;

            for (int i = 1; i <= n - n / 2; i++) {
                tre.leggInn(k, i);
                k *= 2;
            }
        }

        System.out.println("\n ******************** Oppgave 8: ******************");

        {

        }
    }
}
