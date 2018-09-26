package AlgdatLive;

import javafx.scene.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Week6 {

    public static void main(String[] args) {
        System.out.println("uke 6!");

        ArrayList<String> minArrayliste = new ArrayList<>(32);

        for (int i = 0; i < 32; i++) {
            minArrayliste.add(i, "17" + i);
        }

        minArrayliste.forEach(e -> System.out.print(e + ", "));

        String value = "";
        for (Iterator<String> iter = minArrayliste.iterator();
        iter.hasNext();
        value = iter.next()) {
            System.out.println(value);
        }

        /*
        Node very_last_node = new Node("C", null);
        Node last_node = new Node("B", very_last_node);
        Node first_node = new Node("A", last_node);

        for (Node current_node = first_node;
        current_node != null;
        current_node = current_node.getNext()) {
            System.out.print("[" + current_node.value + "]");
        }
        */

        LinkedList myLinkedList = new LinkedList();
        myLinkedList.add("A");
        myLinkedList.add("B");
        myLinkedList.add("C");
        myLinkedList.add("D");

        myLinkedList.insert("E", 2);

    }

    static class MyArraylist {
        int [] data;
        MyArraylist(int size) {
            data = new int[size];
        }

        void set(int i, int value) {
           if (i < 0 || i > data.length) {
               throw new IndexOutOfBoundsException("Feil index");

           }
        }
    }

    static class LinkedList {

        Node head;

        public LinkedList() {
            head = null;
        }

        public void add(String value) {
            Node new_node = new Node(value, head);
            head = new_node;
        }

        public void insert(String value, int index) {
            Node current_node = head;
            for (int i = 0; i < index-1; ++i) {
                current_node = current_node.getNext();
            }
            Node new_node = new Node(value, current_node.getNext());
            current_node.next_node = new_node;
        }

        public String toString() {
            String out = "";



            return out;
        }

        static class Node {

            Node next_node;
            String value;

            public Node(String value, Node next_node) {
                this.value = value;
                this.next_node = next_node;
            }

            Node getNext() {
                return next_node;
            }
        }
    }
}
