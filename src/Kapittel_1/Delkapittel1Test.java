package Kapittel_1;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest {
    @org.junit.jupiter.api.Test
    void randomarray() {

        //test at det fungerer med lengde 1:
        int my_array[] = Tabell.randomarray(1);
        assertEquals(my_array[0], 1);

        //test at arrayet inneholder 1
        my_array = Tabell.randomarray(3);


        int num_values = 10;

        my_array = Tabell.randomarray(num_values);

        //assertFalse(true);
        assertEquals(my_array.length, num_values);

        int min = num_values;
        int max = 0;

        for (int i = 0; i < num_values; i++) {
            if (min > my_array[i]) {
                min = my_array[i];
            }
            if (max < my_array[i]) {
                max = my_array[i];
            }
        }

        //Sjekker at største og minste verdi stemmer
        assertEquals(min,1);
        assertEquals(max, num_values);

        //Sjekk at metoden fungerer med lengde 0
        int values2[] = Tabell.randomarray(0);
        assertEquals(values2.length, 0);

        //Sjekk at metoden fungerer med negativt inputargument

        //Dette feiler:
        //int values2[] = Kapittel_1.Tabell.randomarray(-1);
        //assertEquals(values2.length, -1);

        //Her må vi bruke en anonym funksjon fordi assertThrows trenger
        //en funksjon som "argument"
        assertThrows(java.lang.NegativeArraySizeException.class,
                () -> {
                    Tabell.randomarray(-1);});

    }

    @org.junit.jupiter.api.Test
    void findMinValue() {
    }

}