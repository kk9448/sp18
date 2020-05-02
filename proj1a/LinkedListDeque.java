public class LinkedListDeque<Type> {

    Node sentinel;

    private class Node{
        private Type item;
        private int size;
        Node LastPointer;
        private Node prev;
        private Node rest;

        public Node() {
//            Type;
            size = 0;
            rest = null;
        }
        public Node(Type x) {
            item = x;
            size = 1;
            rest = null;
        }
    }



    public LinkedListDeque() {
       sentinel = new Node();
    }

    public LinkedListDeque(Type x) {
        sentinel = new Node();
        Node B = new Node(x);
        sentinel.rest = B;
        sentinel.size = sentinel.size + 1;
        sentinel.LastPointer = B;
    }

    public void printDeque() {
        Node A = sentinel.rest;
        for (;A.rest != null; A=A.rest) {
            System.out.print(A.item + " ");
        }
        System.out.print(A.item + " ");
    }

    public void addFirst(Type x){
        Node A = new Node(x);
        if (sentinel.size == 0) {
            sentinel.LastPointer = A;
            sentinel.rest = A;
        } else {
            A.rest = sentinel.rest;
            sentinel.rest.prev = A;
            sentinel.rest = A;
        }

        sentinel.size = sentinel.size + 1;


    }
    public void addLast(Type x) {


        Node A = new Node(x);
        if (sentinel.LastPointer == null) {
            sentinel.rest = A;
            sentinel.LastPointer = A;
        }

        sentinel.LastPointer.rest = A;
        A.prev = sentinel.LastPointer;
        sentinel.LastPointer = A;
        sentinel.size = sentinel.size + 1;
    }

    public boolean isEmpty() {
        if (sentinel.rest == null) {
            return true;
        }
        return false;
    }

    public int size() {
        return sentinel.size;
    }

    public Type removeFirst() {
        if (sentinel.rest == null) {
            return null;
        }
        Type tmp = sentinel.rest.item;
        sentinel.rest = sentinel.rest.rest;
        sentinel.size = sentinel.size - 1;
        return tmp;
    }

    public Type removeLast() {
        if(sentinel.rest == null) {
            return null;
        }
        Type A = sentinel.LastPointer.item;
        sentinel.LastPointer = sentinel.LastPointer.prev;
        sentinel.LastPointer.rest = null;

        return A;

    }
    public Type get(int index) {
        Node A = sentinel.rest;
        for(int i = 0; i < index; A = A.rest, i ++) {

        }
        return A.item;
    }



}
