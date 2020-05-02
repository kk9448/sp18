import static org.junit.Assert.*;
import org.junit.Test;

public class NodeTest {

    @Test
    public void addLastTest() {
        LinkedListDeque LinkedListDeque= new LinkedListDeque();
        LinkedListDeque.addFirst(0);
        LinkedListDeque.removeLast() ;
        LinkedListDeque.addLast(3);
        LinkedListDeque.addFirst(4);
        LinkedListDeque.addFirst(5);
        LinkedListDeque.addFirst(6);
        LinkedListDeque.getRecursive(0);
        LinkedListDeque.addLast(8);
        LinkedListDeque.addFirst(9);
        System.out.print(LinkedListDeque.removeLast());
       LinkedListDeque.removeLast();
//        LinkedListDeque.removeFirst();
        System.out.print(LinkedListDeque.removeFirst());
    }

    @Test
    public void LLD() {
        LinkedListDeque LinkedListDeque= new LinkedListDeque();

        LinkedListDeque.addFirst(0);
        LinkedListDeque.addFirst(1);
        LinkedListDeque.removeFirst() ;
//        LinkedListDeque.removeLast();

        assertEquals(0, LinkedListDeque.removeLast());

    }

    @Test
    public void LLD2() {
        LinkedListDeque LinkedListDeque= new LinkedListDeque();


        LinkedListDeque.addLast(3);
        LinkedListDeque.addLast(5);
        LinkedListDeque.addLast(6);
        LinkedListDeque.addLast(7);
        LinkedListDeque.addLast(8);

//        LinkedListDeque.removeLast();
        assertEquals(3,LinkedListDeque.removeFirst());



    }

    @Test
    public void ArrayListTest() {
        ArrayDeque ArrayDeque = new ArrayDeque();
        ArrayDeque.addFirst(1);
        ArrayDeque.addFirst(2);
        ArrayDeque.addFirst(3);
        ArrayDeque.addFirst(4);
        ArrayDeque.addFirst(5);
        ArrayDeque.addFirst(6);
        ArrayDeque.addFirst(7);
        ArrayDeque.addFirst(8);
        ArrayDeque.addFirst(9);

        ArrayDeque.removeLast();
        ArrayDeque.removeFirst();
        ArrayDeque.printDeque();
    }

    @Test
    public void getTest() {
        LinkedListDeque LinkedListDeque= new LinkedListDeque();
        LinkedListDeque.addLast(1);
        LinkedListDeque.addLast(2);
        LinkedListDeque.addLast(3);
        LinkedListDeque.addLast(4);
        LinkedListDeque.addLast(5);
        LinkedListDeque.addLast(6);
        LinkedListDeque.addLast(7);
        LinkedListDeque.addLast(8);
//        a.removeFirst();
       int b = (int) LinkedListDeque.get(7);
       System.out.print(b);

    }


    @Test
    public void getADTest() {
        ArrayDeque ArrayDeque= new ArrayDeque();
        ArrayDeque.addLast(0);
        ArrayDeque.removeFirst()  ;
        ArrayDeque.isEmpty();
        assertEquals( "true",Boolean.toString(ArrayDeque.isEmpty()));

    }

    @Test
    public void getADTest2() {
        ArrayDeque ArrayDeque= new ArrayDeque();
        ArrayDeque.addLast(0);
        ArrayDeque.size();
        ArrayDeque.size();
        ArrayDeque.isEmpty();
        ArrayDeque.addLast(4);
        ArrayDeque.addLast(5);
        ArrayDeque.addLast(6);
        ArrayDeque.addFirst(7);
        ArrayDeque.addFirst(8);
        int b = (int) ArrayDeque.removeLast();
        System.out.print(b);

    }

    @Test
    public void getADTest3() {
        ArrayDeque ArrayDeque= new ArrayDeque();
        ArrayDeque.size();
        ArrayDeque.addFirst(1);
        ArrayDeque.addLast(2);
        assertEquals(2,ArrayDeque.removeLast());

    }

    @Test
    public void getADTest4() {
        ArrayDeque ArrayDeque= new ArrayDeque();
        ArrayDeque.addLast(0);
        ArrayDeque.get(0);
        assertEquals(0,ArrayDeque.get(0));

    }

    @Test
    public void getADTest5() {
        ArrayDeque ArrayDeque= new ArrayDeque();
        ArrayDeque.addLast(0);
        ArrayDeque.addFirst(1);
        ArrayDeque.removeLast();
        ArrayDeque.addLast(3);
//        assertEquals(8,ArrayDeque.get(0));

    }

}