package AlgdatLive;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;

public class Week7 {

    /*
    Stack og Queue:

    En stack kan sees på som en stabel med tallerkener, der du kun har tilgang til den øverste tallerkenen.
    Dvs at man kan jobbe (poppe) seg gjennom stabelen fra toppen.

    push    -> legger på en "tallerken" i stack
    pop     -> fjerner en "tallerken" fra stack
            -> Call stack
            -> Last in, first out queue (LIFO - queue)

     */


    /*
    Double ended queue - DEQUE



     */

    {
        Deque<Integer> deq = new Deque<Integer>() {
            @Override
            public void addFirst(Integer integer) {

            }

            @Override
            public void addLast(Integer integer) {

            }

            @Override
            public boolean offerFirst(Integer integer) {
                return false;
            }

            @Override
            public boolean offerLast(Integer integer) {
                return false;
            }

            @Override
            public Integer removeFirst() {
                return null;
            }

            @Override
            public Integer removeLast() {
                return null;
            }

            @Override
            public Integer pollFirst() {
                return null;
            }

            @Override
            public Integer pollLast() {
                return null;
            }

            @Override
            public Integer getFirst() {
                return null;
            }

            @Override
            public Integer getLast() {
                return null;
            }

            @Override
            public Integer peekFirst() {
                return null;
            }

            @Override
            public Integer peekLast() {
                return null;
            }

            @Override
            public boolean removeFirstOccurrence(Object o) {
                return false;
            }

            @Override
            public boolean removeLastOccurrence(Object o) {
                return false;
            }

            @Override
            public boolean add(Integer integer) {
                return false;
            }

            @Override
            public boolean offer(Integer integer) {
                return false;
            }

            @Override
            public Integer remove() {
                return null;
            }

            @Override
            public Integer poll() {
                return null;
            }

            @Override
            public Integer element() {
                return null;
            }

            @Override
            public Integer peek() {
                return null;
            }

            @Override
            public boolean addAll(Collection<? extends Integer> c) {
                return false;
            }

            @Override
            public void push(Integer integer) {

            }

            @Override
            public Integer pop() {
                return null;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public Iterator<Integer> iterator() {
                return null;
            }

            @Override
            public Iterator<Integer> descendingIterator() {
                return null;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }
        };
    }

    public static void main(String[] args) {
        MyStack a = new MyStack(10);
        MyStack b = new MyStack(10);
        MyStack c = new MyStack(10);


        for (int i = 0; i < 10; i++) {
            a.push(10+i);
        }

        for (int i = 0; i < 10; i++){
            int verdi = a.pop();
            b.push(verdi);
        }

        for (int i = 0; i < 10; i++){
            c.push(b.pop());
            a.push(c.pop());
            System.out.println(a.pop());
        }
    }

    public static class MyStack {

        int data[];
        int size;

        MyStack(int capacity) {
            data  = new int[capacity];
            size = 0;
        }

        /**
         * Legger et nytt element i stacken
         * @param value
         */
        void push(int value) {

            if (size > data.length) {
                throw new ArrayIndexOutOfBoundsException
                        ("Stack overflow");
            }

            data[size] = value;
            size = size + 1;
        }

        /**
         * Fjerner øverste element i stacken og returnerer verdien til elementet
         * @return elementet som fjernes sin verdi
         */
        int pop() {

            if (size < 0) {
                throw new ArrayIndexOutOfBoundsException
                        ("stack underflow");
            }
            size--;
            return data[size];
        }
    }
}
