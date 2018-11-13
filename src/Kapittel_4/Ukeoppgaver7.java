package Kapittel_4;

import Eksempelklasser.Queue.EnkeltLenketListe;
import Eksempelklasser.Queue.Kø;
import Eksempelklasser.Queue.TabellKø;
import Eksempelklasser.Tabellstack.Stakk;
import Eksempelklasser.Tabellstack.TabellStack;
import Eksempelklasser.Tabell.Tabell;

import java.util.Comparator;

public class Ukeoppgaver7 {

    public static void main(String[] args) {

        System.out.println("\n ************************* Ukeoppgaver 7 - Stakker og Køer ***************************");

        /**
         * Oppgaver til avsnitt 4.1.1
         *
         * 1) Vi gjør følgende operasjoner på en stack:
         *
         *      leggin 5;
         *      leggin 7;
         *      taut;
         *      leggin 3;
         *      leggin 7;
         *      taut;
         *
         *  Det tallet som nå ligger øverst på stacken er 3
         *
         *
         * 2)  Følgende kode utføres:
         *
         *    A.leggInn(2);
         *    A.leggInn(5);
         *    A.leggInn(1);
         *    A.kikk();
         *    A.taUt()
         *
         *    5 ligger nå øverst på stacken
         *
         *
         * 3) Vi skal flytte verdier fra A til B via C, slik at de har samme rekkefølge i B som i A;
         *
         *      while (!A.tom()) C.leggin(A.taut());
         *      while (!C.tom()) B.leggin(C.taut());
         *
         * 4) Er det mulig å snu rekkefølgen av verdiene på en stakk ved kun å
         *    bruke én hjelpestakk og én hjelpevariabel?
         *
         *    Ja det er mulig. Tenk Tower of Hanoi.
         *    Man flytter først den øverste verdien i A til hjelpevariablen temp,
         *
         *    deretter poppes de resterende verdiene i stack A over til stack B.
         *
         *    så legges verdien til temp tilbake i stack A og verdiene i stack
         *    B poppes tilbake til A
         *
         *    Deretter gjentas denne prossessen, denne operasjonen skal gjøres like
         *    mange ganger som det er elementer i A
         *
         * 5)   Er det mulig å flytte verdiene fra en stakk A til en stakk B
         *      slik at rekkefølgen på B blir som den var på A, ved kun å
         *      bruke én hjelpevariabel og ikke noe annet?
         *
         *      Ja det er mulig! Følgende fremgangsmæte må følges:
         *
         *      Popp alle verdier bortsett fra den siste fra A til B, skriv deretter den siste til temp.
         *
         *      Popp så alle verdiene fra B til A og legg til slutt verdien som er holdt av temp på toppen i A
         *
         *      Dette må gjøres like mange ganger som det er verdier i A
         *
         *
         * 6)   Er det mulig å få verdiene på en stakk sortert kun ved å bruke én
         *      hjelpestakk og noen enkelte hjelpevariabler?
         *
         *      Ja det er mulig!
         *
         *      Initialiser temp variabel ved å sette den lik A.peek()
         *      Popp deretter alle verdier fra A over til B via en if som sjekker om verdien som kommer fra A
         *      er mindre enn den som holders av temp. Dersom den er mindre pushes nåværende temp til B
         *      og gjeldende verdi fra A holdes av temp. Til slutt legges verdien som holdes av temp tilbake i A og
         *      verdiene i B poppes tilbake i A. Vi må gjøre dette med en løkke som i første iterasjon popper alle n
         *      verdiene fra A, i andre popper n-1, tredje n-2 osv. Til dette trenger vi en hjelpevariabel vi kan kalle
         *      teller eller noe annet passende. Til slutt vil A være sortert i synkende rekkefølge.
         */

        System.out.println("\n ******* Oppgave 4.1.2 ******\n");


        /**
         * 1) Har implementert metoden tøm i klassen Tabellstack
         *
         * 2) Lag en toString-metode i klassen TabellStakk<T>. Hvis stakken inneholder (fra toppen og nedover)
         * verdiene 1, 2 og 3, skal metoden returnere strengen "[1, 2, 3]".
         *
         * 3) Lag public static <T> void snu(Stakk<T> A). Den skal snu rekkefølgen på stakken A.
         * Bruk to TabellStakker som hjelpestakker. Se Figur 4.1.1 c). Parametertypen til A er Stakk<T>.
         * Da er det kun metodene i grensesnitt Stakk<T> som kan brukes.
         *
         * 4) Lag public static <T> void kopier(Stakk<T> A, Stakk<T> B).
         * Den skal kopiere innholdet av A over i B, dvs. A skal ha samme innhold som før etter kopieringen
         * og B skal inneholde de samme verdiene i samme rekkefølge som A.
         * Det antas at B er tom før kopieringen starter. Bruk kun én TabellStakk og en enkelt T-variabel
         * som hjelpemiddel. Typen til A og B er Stakk<T>. Da er det kun metodene i grensesnitt Stakk<T> som
         * kan brukes.
         *
         * 5) Som Oppgave 3, men én TabellStakk og en enkelt T-variabel som hjelpemiddel.
         *
         * 6) Som Oppgave 4, men bruk kun én enkelt hjelpevariabel av typen T.
         *
         * 7) Metoden public static <T> void sorter(Stakk<T> A, Comparator<? super T> c) skal sortere objektene
         * på A vha. komparatoren c. Lag metoden. Du skal kun bruke én hjelpestakk og noen enkelte
         * hjelpevariabler i kodingen.
         *
         */
        {
            System.out.println("\n Oppgave 1 og 2: \n");

            TabellStack stack = new TabellStack();

            stack.leggInn("1");
            stack.leggInn("2");
            stack.leggInn("3");

            System.out.println(stack.toString());

            stack.nullstill();
            System.out.println("Etter nullstilling" + stack.toString());
        }

            System.out.println("\n Oppgave 3: \n");

        {
            TabellStack stack = new TabellStack();

            stack.leggInn("1");
            stack.leggInn("2");
            stack.leggInn("3");
            stack.leggInn("4");
            stack.leggInn("5");

            System.out.println(stack.toString());

            TabellStack.snu(stack);

            System.out.println(stack.toString());
        }

        System.out.println("\n Oppgave 4: \n");

        {
            TabellStack stack = new TabellStack();
            TabellStack stack2 = new TabellStack();

            stack.leggInn("1");
            stack.leggInn("2");
            stack.leggInn("3");
            stack.leggInn("4");
            stack.leggInn("5");

            System.out.println("stack a: "+ stack.toString());
            System.out.println("stack b før kopi: "+stack2.toString());
            TabellStack.kopier(stack, stack2);
            System.out.println("stack b etter kopi: "+stack2.toString());
        }

        System.out.println("\n Oppgave 5: \n");

        {
            TabellStack stack = new TabellStack();

            stack.leggInn("1");
            stack.leggInn("2");
            stack.leggInn("3");
            stack.leggInn("4");
            stack.leggInn("5");

            System.out.println(stack.toString());
            TabellStack.snu2(stack);
            System.out.println(stack.toString());
        }

        System.out.println("\n Oppgave 6: \n");

        {
            TabellStack stack = new TabellStack();
            TabellStack stack2 = new TabellStack();

            stack.leggInn("1");
            stack.leggInn("2");
            stack.leggInn("3");
            stack.leggInn("4");
            stack.leggInn("5");

            System.out.println("Stack 1 før: " + stack.toString());
            System.out.println("Stack 2 før: " + stack2.toString());
            TabellStack.kopier2(stack, stack2);
            System.out.println("Stack 1 etter: " + stack.toString());
            System.out.println("Stack 2 etter: " + stack2.toString());
        }

        System.out.println("\n Oppgave 7: \n");


        System.out.println("\n ******* Oppgave 4.2.2 ******\n");

        /**
         * 4)       Flytt grensesnittet Kø over i ditt prosjekt (f.eks. under hjelpeklasser).
         *
         * 5)       Flytt klassen TabellKø over i ditt prosjekt (f.eks. under hjelpeklasser).
         *          Legg inn de ferdige metodene antall(), leggInn(), utvidTabell() og taUt() inn i klassen.
         *
         * 6)       Lag kode for metodene kikk(), tom() og nullstill() i TabellKø. Se grensesnittet Kø.
         *
         * 7)       Lag kode for metoden toString i TabellKø. Hvis køen er tom skal den returnere tegnstrengen "[]".
         *          Hvis den f.eks. inneholder A, B og C skal den returnere "[A, B, C]".
         *
         * 8)    	Det kan være aktuelt å kjenne til hvor langt ut i køen en bestemt verdi ligger.
         *          Legg inn metoden public int indeksTil(T verdi) som en ekstra metode i TabellKø.
         *          Den skal returnere posisjonen til første forekomst av verdi i køen. Ligger verdi først er
         *          posisjonen 0, nest først 1, osv. Hvis verdi ikke ligger i køen, skal metoden returnere -1.
         *
         * 9)       Lag metoden public static <T> void snu(Stakk<T> A).
         *          Den skal snu rekkefølgen av verdiene på stakken A. Bruk en kø som hjelpemiddel i kodingen
         *
         * 10)      Lag metoden public static <T> void snu(Kø<T> A). Den skal snu rekkefølgen av verdiene i køen A.
         *          Bruk en stakk som hjelpemiddel i kodingen.
         */

        System.out.println("\n************* Oppgave 6 og 7: *************\n");

        {
            TabellKø<Integer> kø = new TabellKø<>();

            System.out.println("tom: " + kø.tom());
            System.out.println("antall: " + kø.antall());
            System.out.println(kø.toString());

            for (int i = 0; i <= 10; i++) {
                kø.leggInn(i);
            }

            System.out.println("toString: " + kø.toString());
            System.out.println("antall: "+ kø.antall());
            System.out.println("tom: " + kø.tom());
            System.out.println("kikk: " + kø.kikk());
        }

        System.out.println("\n************* Oppgave 8: *************\n");

        {
            TabellKø<Integer> kø = new TabellKø<>();

            for (int i = 0; i <= 10; i++) {
                kø.leggInn(i);
            }

            System.out.println("toString: " + kø.toString());

            kø.taUt();
            kø.taUt();
            kø.taUt();
            kø.taUt();
            kø.taUt();
            kø.taUt();
            kø.taUt();
            kø.taUt();
            kø.taUt();

            for (int i = 12; i <= 20; i++) {
                kø.leggInn(i);
            }
            kø.leggInn(5);

            System.out.println("toString: " + kø.toString());

            System.out.println("indeks til verdi 5 er: " + kø.indeksTil(5));

        }


        System.out.println("\n************* Oppgave 9: *************\n");

        {
            TabellStack<Integer> stakk = new TabellStack<>();
            for (int i = 0; i < 10; i++) {
                stakk.leggInn(i);
            }

            System.out.println(stakk.toString());
            TabellKø.snu(stakk);
            System.out.println(stakk.toString());
        }

        System.out.println("\n************* Oppgave 10: *************\n");

        {
            TabellKø<Integer> kø = new TabellKø<>();
            for (int i = 0; i < 10; i++) {
                kø.leggInn(i);
            }

            System.out.println(kø.toString());
            TabellKø.snu(kø);
            System.out.println(kø.toString());
        }


        System.out.println("\n ******* Oppgave 4.2.2 ******\n");

        /**
         *  1) 	La klassen EnkeltLenketListe implementere Kø. Se Programkode 4.2.4 a).
         *  Legg så inn de to metodene kikk() og taUt(). Sjekk at Programkode 4.2.4 c) virker
         */

        System.out.println("\n************* Oppgave 1: *************\n");

        {
            Kø<Integer> kø = new EnkeltLenketListe<>();

            for (int i = 1; i <= 10; i++) kø.leggInn(i);

            while (!kø.tom())
            {
                System.out.print(kø.taUt() + " ");
            }
        }

        System.out.println("\n************* Oppgave 4: *************\n");

        {
            Integer[] a = Tabell.randPermInteger(10);

            Kø<Integer> kø = new EnkeltLenketListe<>();
            for (Integer i : a) kø.leggInn(i);

            System.out.println(kø);    // usortert

            Stakk<Integer> stakk = new TabellStack<>();

            EnkeltLenketListe.sorter(kø, stakk, Comparator.naturalOrder());

            System.out.println(kø);    // sortert
        }
    }
}
