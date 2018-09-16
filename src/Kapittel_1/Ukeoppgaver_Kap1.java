package Kapittel_1;

public class Ukeoppgaver_Kap1 {

    public static int maks(int[] a)  // versjon 3 av maks-metoden
    {

            int sisteIndex = a.length - 1;       // siste posisjon i tabellen
            int m = 0;                     // indeks til største verdi
            int maksverdi = a[0];          // største verdi
            int temp = a[sisteIndex];            // tar vare på siste verdi
            a[sisteIndex] = 0x7fffffff;          // legger tallet 2147483647 sisteIndex

            for (int i = 0; ; i++)         // i starter med 0
                if (a[i] >= maksverdi)       // denne blir sann til slutt
                {
                    if (i == sisteIndex)             // sjekker om vi er ferdige
                    {
                        a[sisteIndex] = temp;          // legger siste verdi tilbake
                        return temp >= maksverdi ? sisteIndex : m;   // er siste størst?
                    } else {
                        if (maksverdi != a[i]) {
                            maksverdi = a[i];        // maksverdi oppdateres
                            m = i;                   // m oppdateres
                        } else {
                            maksverdi = a[i];
                        }
                    }
                }
    }
}
