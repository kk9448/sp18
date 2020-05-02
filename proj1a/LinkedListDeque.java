public class LinkedListDeque<T> {

    private Node sentinel;

    private class Node{
        private T item;
        private int size;
        Node LastPointer;
        private Node prev;
        private Node rest;

        public Node() {
//            Type;
            size = 0;
            rest = null;
        }
        public Node(T x) {
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

    public void printDeque() {
        if (sentinel.rest == null) {
            return ;
        }
        Node A = sentinel.rest;
        for (;A.rest != null; A=A.rest) {
            System.out.print(A.item + " ");
        }
        System.out.print(A.item + " ");
    }

    public void addFirst(T x){
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
    public void addLast(T x) {


        Node A = new Node(x);
        if (sentinel.LastPointer == null) {
            sentinel.rest = A;
            sentinel.LastPointer = A;
            A.prev = sentinel;
        } else {
            sentinel.LastPointer.rest = A;
            A.prev = sentinel.LastPointer;
            sentinel.LastPointer = A;
            sentinel.size = sentinel.size + 1;
        }


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

    public T removeFirst() {
        if (sentinel.rest == null) {
            return null;
        }
        T tmp = sentinel.rest.item;
        sentinel.rest = sentinel.rest.rest;
        sentinel.size = sentinel.size - 1;
        return tmp;
    }

    public T removeLast() {
        if(sentinel.rest == null) {
            return null;
        }
        T A = sentinel.LastPointer.item;
        sentinel.LastPointer = sentinel.LastPointer.prev;
        sentinel.LastPointer.rest = null;

        return A;

    }
    public T get(int index) {
        if (index < 0) {
            return null;
        }
        Node A = sentinel.rest;
        for(int i = 0; i < index; A = A.rest, i++) {

        }
        return A.item;
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
        B = recursive(x+1,index, A);
        return B;
    }



}
