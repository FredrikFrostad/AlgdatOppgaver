package AlgdatLive;

public class Week9Heap {

    public static void printArrayBinTree(char[] data, int antall){

        int i = 1;
        int level = 0;

        while (i < antall) {

            int antallNoderNivå = (int) Math.pow(2,level);
            System.out.println("Antall noder på dette nivået: " + antallNoderNivå);
            for (int j = 0; j < Math.min(antallNoderNivå, antall - i+1); j++){

                int index = i-1 + j;
                System.out.println(data[index] + ", ");

            }
            i*=2;
            level++;
            //Eller vi kan gjøre dette:
            // i = i + antallNoderNivå;
        }
    }

    public static void createMinBT(char[] data) {
        for (int i = 0; i < data.length; i++) {

            //Vi vet at høyre barn har index 2*k+1
            //og at venstre barn har indeks 2k
            //når forelder har indeks k

            //Vil legger barn med indeks i, det vil si at forelder
            //har indeks (i+1)/2 i heltallsdivisjon

            int parentIndeksBT = (i+1) / 2;
            int parentIndeksArray = parentIndeksBT - 1;

            //Disse indeksene refererer til arrayindekser
            //For å få binærtreindeksen, pluss på en!!
            int child = i;
            int parent = parentIndeksArray;

            System.out.println("Legger til node: " + data[child]);
            while (parent >= 0 && data[child] < data[parent]) {

                //Bytt child og parent
                char temp = data[child];
                data[child] = data[parent];
                data[parent] = temp;

                //Oppdaterer child og parent pekere
                child = parent;
                parent = (parent + 1) / 2 - 1;
            }

            //printArrayBinTree(data, i +1);

        }
    }

    public static void main(String[] args) {
        System.out.println("Heap sort");

        char data[] = {'A','B','C','D','E','F','G','H','I','J'};
        //printArrayBinTree(data, data.length);

        System.out.println("creating minimum binary tree:");
        createMinBT(data);
    }
}
