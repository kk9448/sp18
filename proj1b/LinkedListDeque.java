import org.w3c.dom.traversal.NodeIterator;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {

    private Node sentinel;

    @Override
    public boolean equals(Object x) {

        if (x == this) {
            return true;
        }
        if (x == null) {
            return false;
        }
        if (x.getClass() != this.getClass()) {
            return false;
        }
        int i = 0;
        LinkedListDeque<T> o = (LinkedListDeque<T>) x;
        for (T item : this) {
            if (item != o.get(i)) {
                return false;
            }
            i++;
        }
        return true;
    }



    @Override
    public Iterator<T> iterator() {
        return new NodeIterator();
    }

    private class NodeIterator implements Iterator {
        private int num = 0;

        @Override
        public boolean hasNext() {
            return num < sentinel.size;
        }

        @Override
        public Object next() {
            T returnItem = get(num);
            num++;
            return returnItem;
        }
    }

    private class Node {
        private T item;
        private int size;
        Node lastPointer;
        private Node prev;
        private Node rest;

        Node() {
//            Type;
            size = 0;
            rest = null;
        }
        Node(T x) {
            item = x;
            size = 1;
            rest = null;
        }
    }



    public LinkedListDeque() {
        sentinel = new Node();
    }

//    public LinkedListDeque(T x) {
//        sentinel = new Node();
//        Node B = new Node(x);
//        sentinel.rest = B;
//        sentinel.size = sentinel.size + 1;
//        sentinel.LastPointer = B;
//    }
    @Override
    public void printDeque() {
        if (sentinel.rest == null) {
            return;
        }
        Node A = sentinel.rest;
        for (; A.rest != null; A = A.rest) {
            System.out.print(A.item + " ");
        }
        System.out.print(A.item + " ");
        System.out.println();
    }
    @Override
    public void addFirst(T x) {
        Node A = new Node(x);
        if (sentinel.size == 0) {
            sentinel.lastPointer = A;
            sentinel.rest = A;
        } else {
            A.rest = sentinel.rest;
            sentinel.rest.prev = A;
            sentinel.rest = A;


        }
        A.prev = sentinel;
        sentinel.size = sentinel.size + 1;


    }
    @Override
    public void addLast(T x) {


        Node A = new Node(x);
        if (sentinel.lastPointer == null) {
            sentinel.rest = A;
            sentinel.lastPointer = A;
            A.prev = sentinel;
        } else {
            sentinel.lastPointer.rest = A;
            A.prev = sentinel.lastPointer;
            sentinel.lastPointer = A;

        }

        sentinel.size = sentinel.size + 1;

    }
    @Override
    public boolean isEmpty() {
        if (sentinel.size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return sentinel.size;
    }
    @Override
    public T removeFirst() {
        if (sentinel.rest == null) {
            return null;
        }
        T tmp = sentinel.rest.item;
        if (sentinel.rest.rest == null) {
            sentinel.lastPointer.rest = null;
            sentinel.lastPointer = null;
            sentinel.rest = null;
            if (sentinel.size != 0) {
                sentinel.size = sentinel.size - 1;
            }
            return tmp;
        }
        sentinel.rest.rest.prev = sentinel;
        sentinel.rest = sentinel.rest.rest;
//        sentinel.LastPointer = sentinel.LastPointer.prev;
//        if (sentinel.size != 0) {
////            sentinel.size = sentinel.size - 1;
//        }
        sentinel.size = sentinel.size - 1;
        return tmp;
    }
    @Override
    public T removeLast() {
        if (sentinel.rest == null) {
            return null;
        }
        T A = sentinel.lastPointer.item;
        sentinel.lastPointer = sentinel.lastPointer.prev;
        sentinel.lastPointer.rest = null;
        if (sentinel.size != 0) {
            sentinel.size = sentinel.size - 1;
        }

        return A;

    }
    @Override
    public T get(int index) {
        if (index < 0) {
            return null;
        }
        Node A = sentinel.rest;
        for (int i = 0; i < index; A = A.rest) {
            i++;
        }
        return A.item;
    }

    @Override
    public String toString() {
        StringBuilder newString = new StringBuilder();
        Node A = sentinel;
        if (A.rest == null) {
            return null;
        }
        for (int i = 0; i < sentinel.size; i++) {
            newString.append(A.rest.item);
            A = A.rest;
        }
        return  newString.toString();
    }

    public T getRecursive(int index) {
        if (index < 0) {
            return null;
        }
        Node A = sentinel.rest;
        T B = recursive(0, index, A);
        return B;


    }

    private T recursive(int x, int index, Node A) {
        if (x == index) {
            return A.item;
        }
        A = A.rest;
        T B;
        B = recursive(x + 1, index, A);
        return B;
    }





}
