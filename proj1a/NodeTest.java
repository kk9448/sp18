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
    public void addFirstTest() {
        LinkedListDeque<Integer> a= new LinkedListDeque<>();

        a.removeLast();
        a.removeLast();
        a.removeLast();
        a.printDeque();
        System.out.println("size is " + a.size());

        LinkedListDeque b= new LinkedListDeque<String>();
        b.addFirst("123");
        b.addFirst("456");
        String c = (String) b.removeLast();

        b.printDeque();
        System.out.println("removed is " + c);

    }

    @Test
    public void ArrayListTest() {
        ArrayDeque a = new ArrayDeque();
        a.addFirst(1);
        a.addFirst(2);
        a.addFirst(3);
        a.addFirst(4);
        a.addFirst(5);
        a.addFirst(6);
        a.addFirst(7);
        a.addFirst(8);
        a.addFirst(9);

        a.removeLast();
        a.removeFirst();
        a.printDeque();
    }

    @Test
    public void getTest() {
        LinkedListDeque a= new LinkedListDeque();
        a.addLast(1);
        a.addLast(2);
        a.addLast(3);
        a.addLast(4);
        a.addLast(5);
        a.addLast(6);
        a.addLast(7);
        a.addLast(8);
//        a.removeFirst();
       int b = (int) a.get(7);
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

}
