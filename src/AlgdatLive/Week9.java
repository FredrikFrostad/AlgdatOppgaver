package AlgdatLive;

import java.util.Arrays;

public class Week9 {

    public static class BTNode {
        BTNode left_child, right_child;
        int value;

        BTNode() {
            left_child = null;
            right_child = null;
            value = -9999;
        }

        BTNode(int value) {
            this.value = value;
        }

        void addNewValue(int value) {

            if (value >= this.value) {
               if (right_child == null) {
                   new BTNode(value);
               }else
               right_child.addNewValue(value);
           }

           if (value < this.value) {
               if (left_child == null) {
                   new BTNode(value);
               }else {
                   left_child.addNewValue(value);
               }
           }
        }


        /**
         * rekursiv metode som leter gjennom intervallet [l, r] og lager en ny node av midtelementet
         *
         * @return den nye noden
         */
         static BTNode createBinarySearchTree(int[] a, int l, int r) {

            int midt = (l + r) / 2;
            int value = a[midt];

            BTNode node = new BTNode(value);



            if (r-l < 0) return null;
            //Lager rekursivt noder i venstre intervall [l, midt-1]
            node.left_child = createBinarySearchTree(a, l, midt-1);
            //Lager rekursivt noder i høyre intervall [midt + 1, r]
            node.right_child = createBinarySearchTree(a, midt+1, r);

            /*
            if (node.left_child != null) createBinarySearchTree(a, l, midt - 1);
            else if (node.right_child != null) createBinarySearchTree(a, midt + 1, r);
            */


            return node;
        }

        /**
         * Funksjon som skriver ut bredde først (nivå orden)
         */
        static void printBTBreadthFirst(BTNode root) {
            java.util.Deque<BTNode> queue = new java.util.ArrayDeque<BTNode>();

            //Legg første node på køen
            queue.addFirst(root);

            //Loop så lenge vi ikke har tom kø
            while (!queue.isEmpty()) {

                //Hent node fra køen
                BTNode current = queue.removeLast();

                //Skriv ut verdien
                System.out.print(current.value + ", ");

                //Legg barna på slutten av køen
                if (current.left_child != null) {
                    queue.addFirst(current.left_child);
                }
                if (current.right_child != null) {
                    queue.addFirst(current.right_child);
                }
            }
        }

        /**
         * Funksjon som skiver ut bredde først, men med linjeskift mellom nivåer
         */
        static void printBTBreadthFirstNewline(BTNode root) {
            java.util.Deque<BTNode> nodes = new java.util.ArrayDeque<BTNode>();

            nodes.addFirst(root);

            while (!nodes.isEmpty()) {
                //Hent ut størrelsen på køen => dette er antall noder på dette nivået
                int antall = nodes.size();
                System.out.println("Antall noder dette nivå: " + antall);

                //Skriv ut alle noder på dette nivået, og legg noder for neste nivå til køen
                for (int i=0; i<antall; ++i) {
                    BTNode current = nodes.removeLast();
                    System.out.print(current.value + ", ");
                    if (current.left_child != null) {
                        nodes.addFirst(current.left_child);
                    }
                    if (current.right_child != null) {
                        nodes.addFirst(current.right_child);
                    }
                }
                System.out.println();
            }
        }

        public static BTNode addNewNode(BTNode current, int value ) {


            if (current == null) {
                return new BTNode(value);
            }

            if (value >= current.value) {
                addNewNode(current.right_child, value);
            }
            if (value <= current.value) {
                addNewNode(current.left_child, value);
            }
            return current;
        }

        public static void main(String[] args) {
            int[] a = {1, 3, 4, 6, 7, 9, 11};
            System.out.println(Arrays.toString(a));

            BTNode myTree = createBinarySearchTree(a, 0, a.length - 1);

            BTNode.printBTBreadthFirst(myTree);

            System.out.println();

            addNewNode(myTree,8);

            BTNode.printBTBreadthFirstNewline(myTree);


        }
    }
}
