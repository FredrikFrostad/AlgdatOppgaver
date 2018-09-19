package Eksempelklasser;

import java.util.Arrays;

public enum Måned {

    JAN (1, "januar"),
    FEB (2, "februar"),
    MAR (3, "mars"),
    APR (4, "april"),
    MAI (5, "mai"),
    JUN (6, "juni"),
    JUL (7, "juli"),
    AUG (8, "august"),
    SEP (9, "september"),
    OKT (10, "oktober"),
    NOV (11, "november"),
    DES (12, "desember");

    private final int mndnr;
    private final String fulltnavn;

    private Måned(int mndnr, String fulltnavn) {
        this.mndnr = mndnr;
        this.fulltnavn = fulltnavn;
    }

    @Override
    public String toString() { return fulltnavn; }

    public static String toString(int mnd) {

        if (mnd < 1 || mnd > 12) {
            throw new IllegalArgumentException
                    ("Tast inn et tall mellom 1 og 12");
        }
        return values()[mnd - 1].toString();

    }

    public int mndnr() {return this.mndnr;}

    public static Måned[] vår() {
        return Arrays.copyOfRange(values(),3,5);
    }

    public static Måned[] sommer() {
        return Arrays.copyOfRange(values(), 6, 8);
    }

    public static Måned[] Høst() {
        return Arrays.copyOfRange(values(), 9, 11);
    }

    public static Måned[] Vinter() {
        return Arrays.copyOfRange(values(), 12,2);
    }



}

