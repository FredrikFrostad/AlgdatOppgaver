package Kapittel_4;

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
    }
}
