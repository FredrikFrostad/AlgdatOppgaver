package AlgdatLive;

import java.util.ArrayDeque;

public class Week8 {



        //Klasse for å representere et binærtre
        public static class BTNode {
            BTNode left_child;
            BTNode right_child;
            char value;

            BTNode(char value) {
                this.value = value;
            }

            public String toString() {
                return Character.toString(this.value);
            }
        }

        /**
         * Funksjon som bruker en stack til å skrive ut dybde først
         */
        static void printBTDepthFirstStack(BTNode root) {
            java.util.Deque<BTNode> stack = new java.util.ArrayDeque<>(100);

            //Lett første node på stacken
            stack.addFirst(root);

            //Loop så lenge stacken ikke er tom
            while (!stack.isEmpty()) {
                //Skriv ut stackens innhold
                System.out.println("Stackens innhold: " + stack);

                //Hent ut node fra stacken
                BTNode current = stack.removeFirst();

                //Skriv ut preorden her
                System.out.print(current.value + ", ");

                //Legg høyre barn på stacken
                if (current.right_child != null) {
                    stack.addFirst(current.right_child);
                }

                //Skriv ut inorden her
                //System.out.print(current.value + ", ");

                //Legg venstre barn på stacken
                if (current.left_child != null) {
                    stack.addFirst(current.left_child);
                }

                //Skriv ut postorden her
                //System.out.print(current.value + ", ");

            }
        }

        /**
         * Funksjon som skriver ut dybde først ved rekursjon
         */
        static void printBTDepthFirstRecursive(BTNode root) {
            //Preorden her

            //Rekursivt kall for venstre barn
            if (root.left_child != null) {
                printBTDepthFirstRecursive(root.left_child);
            }

            //Inorden her
            System.out.print(root.value + ", ");

            //Rekursivt kall for høyre barn her
            if (root.right_child != null) {
                printBTDepthFirstRecursive(root.right_child);
            }

            //Post orden her
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

        public static void main(String[] args) {
            System.out.println("Week 8");

            BTNode root = new BTNode('A');

            root.left_child = new BTNode('B');
            root.right_child = new BTNode('C');

            root.left_child.left_child = new BTNode('D');
            root.left_child.right_child = new BTNode('E');
            root.right_child.left_child = new BTNode('F');
            root.right_child.right_child = new BTNode('G');

            root.right_child.left_child.right_child = new BTNode('X');

            System.out.println("Rekursiv dybde først:");
            printBTDepthFirstRecursive(root);
            System.out.println();
            System.out.println();

            System.out.println("Stack-basert dybde først:");
            printBTDepthFirstStack(root);
            System.out.println();
            System.out.println();

            System.out.println("Kø-basert bredde først:");
            printBTBreadthFirst(root);
            System.out.println();
            System.out.println();

            System.out.println("Kø-basert bredde først med linjeskift:");
            printBTBreadthFirstNewline(root);
        }
    }


