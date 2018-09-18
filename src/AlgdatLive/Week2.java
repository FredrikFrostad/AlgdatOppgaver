package AlgdatLive;

public class Week2 {

    public  static int maks(int[] a, int fra, int til) {
        //Husk feilsjekk at fra og til er i arryet

        int m = fra;
        int maxverdi  = 0;

        for (int i = fra + 1; i < til; ++i) {
            if (a[i] > maxverdi) {
                maxverdi = a[i];
                m = i;
            }
        }
        return m;
    }


    public static void main(String[] args) {
        int[] a = {1,3,7,5,40,8,9,12};

        int x = maks(a,0,a.length);
        int y = maks(a,0,x);
        int z = maks(a,x+1,a.length);

        System.out.println(x + " " + y + " " + z);
    }
}

