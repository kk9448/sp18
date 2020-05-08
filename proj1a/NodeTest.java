import static org.junit.Assert.*;
import org.junit.Test;

public class NodeTest {

    @Test
    public void addLastTest() {
        LinkedListDeque linkedListDeque = new LinkedListDeque();
        linkedListDeque.addFirst(0);
        linkedListDeque.removeLast();
        linkedListDeque.addLast(3);
        linkedListDeque.addFirst(4);
        linkedListDeque.addFirst(5);
        linkedListDeque.addFirst(6);
        linkedListDeque.getRecursive(0);
        linkedListDeque.addLast(8);
        linkedListDeque.addFirst(9);
        System.out.print(linkedListDeque.removeLast());
        linkedListDeque.removeLast();
//        LinkedListDeque.removeFirst();
        System.out.print(linkedListDeque.removeFirst());
    }

    @Test
    public void llD() {
        LinkedListDeque linkedListDeque = new LinkedListDeque();

        linkedListDeque.addFirst(0);
        linkedListDeque.addFirst(1);
        linkedListDeque.removeFirst();
//        LinkedListDeque.removeLast();

        assertEquals(0, linkedListDeque.removeLast());

    }

    @Test
    public void llD2() {
        LinkedListDeque linkedListDeque = new LinkedListDeque();


        linkedListDeque.addLast(3);
        linkedListDeque.addLast(5);
        linkedListDeque.addLast(6);
        linkedListDeque.addLast(7);
        linkedListDeque.addLast(8);

//        LinkedListDeque.removeLast();
        assertEquals(3, linkedListDeque.removeFirst());


    }

    @Test
    public void llD3() {
        LinkedListDeque linkedListDeque = new LinkedListDeque();


        linkedListDeque.addFirst(0);
        linkedListDeque.removeFirst();
//        LinkedListDeque.removeLast();
//        assertEquals(3,LinkedListDeque.removeFirst());


    }

    @Test
    public void llD4() {
        LinkedListDeque linkedListDeque = new LinkedListDeque();


        linkedListDeque.addLast(0);
        linkedListDeque.addLast(1);
        linkedListDeque.removeFirst();
        linkedListDeque.isEmpty();
        linkedListDeque.removeFirst();


    }

    @Test
    public void llD5() {
        LinkedListDeque linkedListDeque = new LinkedListDeque();


        linkedListDeque.size();
        linkedListDeque.addFirst(1);
        linkedListDeque.addFirst(2);
        linkedListDeque.removeLast();
        linkedListDeque.removeFirst();


    }

    @Test
    public void llD6() {
        LinkedListDeque linkedListDeque = new LinkedListDeque();


        linkedListDeque.addLast(0);
        linkedListDeque.removeFirst();


    }

    @Test
    public void llD7() {
        LinkedListDeque linkedListDeque = new LinkedListDeque();


        linkedListDeque.isEmpty();
        linkedListDeque.addFirst(1);
        linkedListDeque.isEmpty();
        linkedListDeque.removeLast();
        linkedListDeque.addLast(4);
        linkedListDeque.removeFirst();
        linkedListDeque.addLast(6);
        linkedListDeque.removeLast();
        linkedListDeque.addLast(8);
        linkedListDeque.removeLast();
        linkedListDeque.size();
        assertEquals(0, linkedListDeque.size());


    }

    @Test
    public void llD8() {
        LinkedListDeque linkedListDeque = new LinkedListDeque();


        linkedListDeque.isEmpty();
        linkedListDeque.addFirst(1);
        linkedListDeque.removeFirst();
        linkedListDeque.addFirst(3);
        linkedListDeque.removeFirst();
        linkedListDeque.isEmpty();
        assertEquals("true", Boolean.toString(linkedListDeque.isEmpty()));


    }

    @Test
    public void llD9() {
        LinkedListDeque linkedListDeque = new LinkedListDeque();


        linkedListDeque.isEmpty();
        linkedListDeque.addLast(1);
        linkedListDeque.removeFirst();
        linkedListDeque.addLast(3);
        linkedListDeque.addLast(4);
        linkedListDeque.removeFirst();
        linkedListDeque.removeFirst();
        linkedListDeque.isEmpty();
        assertEquals("true", Boolean.toString(linkedListDeque.isEmpty()));


    }

    @Test
    public void llD10() {
        LinkedListDeque linkedListDeque = new LinkedListDeque();


        linkedListDeque.addLast(0);
        linkedListDeque.addFirst(1);
        linkedListDeque.removeFirst();
        linkedListDeque.get(0);
        linkedListDeque.addFirst(4);
//        LinkedListDeque.removeLast();
        assertEquals(0, linkedListDeque.removeLast());


    }


    @Test
    public void arrayListTest() {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.addFirst(1);
        arrayDeque.addFirst(2);
        arrayDeque.addFirst(3);
        arrayDeque.addFirst(4);
        arrayDeque.addFirst(5);
        arrayDeque.addFirst(6);
        arrayDeque.addFirst(7);
        arrayDeque.addFirst(8);
        arrayDeque.addFirst(9);

        arrayDeque.removeLast();
        arrayDeque.removeFirst();
        arrayDeque.printDeque();
    }

    @Test
    public void getTest() {
        LinkedListDeque linkedListDeque = new LinkedListDeque();
        linkedListDeque.addLast(1);
        linkedListDeque.addLast(2);
        linkedListDeque.addLast(3);
        linkedListDeque.addLast(4);
        linkedListDeque.addLast(5);
        linkedListDeque.addLast(6);
        linkedListDeque.addLast(7);
        linkedListDeque.addLast(8);
//        a.removeFirst();
        int b = (int) linkedListDeque.get(7);
        System.out.print(b);

    }


    @Test
    public void getADTest() {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.addLast(0);
        arrayDeque.removeFirst();
        arrayDeque.isEmpty();
        assertEquals("true", Boolean.toString(arrayDeque.isEmpty()));

    }

    @Test
    public void getADTest2() {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.addLast(0);
        arrayDeque.size();
        arrayDeque.size();
        arrayDeque.isEmpty();
        arrayDeque.addLast(4);
        arrayDeque.addLast(5);
        arrayDeque.addLast(6);
        arrayDeque.addFirst(7);
        arrayDeque.addFirst(8);
        int b = (int) arrayDeque.removeLast();
        System.out.print(b);

    }

    @Test
    public void getADTest3() {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.size();
        arrayDeque.addFirst(1);
        arrayDeque.addLast(2);
        assertEquals(2, arrayDeque.removeLast());

    }

    @Test
    public void getADTest4() {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.addLast(0);
        arrayDeque.get(0);
        assertEquals(0, arrayDeque.get(0));

    }

    @Test
    public void getADTest5() {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.addLast(0);
        arrayDeque.addFirst(1);
        arrayDeque.removeLast();
        arrayDeque.addLast(3);
//        assertEquals(8,ArrayDeque.get(0));

    }

    @Test
    public void getADTest6() {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.addFirst(0);
        arrayDeque.removeFirst();
        arrayDeque.addFirst(2);
//        assertEquals(8,ArrayDeque.get(0));

    }

    @Test
    public void getADTest7() {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.addFirst(0);
        arrayDeque.isEmpty();
        arrayDeque.addFirst(2);
        arrayDeque.addFirst(3);
        arrayDeque.addFirst(4);
        arrayDeque.addFirst(5);
        arrayDeque.isEmpty();
        arrayDeque.removeLast();
        arrayDeque.addFirst(8);
        arrayDeque.addFirst(9);
        arrayDeque.addFirst(10);
        arrayDeque.addFirst(11);

    }


    @Test
    public void getADTest9() {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.addFirst(0);
        arrayDeque.size();
        arrayDeque.removeFirst();
        arrayDeque.addFirst(3);
    }

    @Test
    public void getADTest10() {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.addLast(0);
        arrayDeque.addFirst(1);
        arrayDeque.addLast(2);
        arrayDeque.addLast(3);
        arrayDeque.get(2);
        arrayDeque.get(2);
        arrayDeque.get(2);
        arrayDeque.removeLast();
        arrayDeque.addFirst(8);
        arrayDeque.removeLast();
        assertEquals(8, arrayDeque.get(0));
    }

    @Test
    public void getADTest11() {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.addFirst(0);
        arrayDeque.addFirst(1);
        arrayDeque.addFirst(2);
        arrayDeque.addFirst(3);
        arrayDeque.addFirst(4);
        arrayDeque.addFirst(5);
        arrayDeque.addFirst(6);
        arrayDeque.addFirst(7);
        arrayDeque.addFirst(8);
//        ArrayDeque.removeLast();

        assertEquals(0, arrayDeque.removeLast());
    }

    @Test
    public void getADTest12() {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.addLast(0);
        arrayDeque.addLast(1);
        arrayDeque.addLast(2);
        arrayDeque.removeLast();
        arrayDeque.removeLast();
        arrayDeque.removeFirst();
        arrayDeque.addLast(6);
        arrayDeque.addLast(7);
        arrayDeque.addFirst(8);
        arrayDeque.get(0);
        arrayDeque.addLast(10);
        arrayDeque.removeFirst();
        arrayDeque.removeLast();
        arrayDeque.get(1);

        assertEquals(7, arrayDeque.get(1));
    }

    @Test
    public void getADTest13() {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.addLast(0);
        arrayDeque.get(0);
        arrayDeque.addLast(2);
        arrayDeque.removeLast();
        arrayDeque.get(0);
        arrayDeque.removeFirst();
        arrayDeque.addFirst(6);
        arrayDeque.addLast(7);
        arrayDeque.removeFirst();
        arrayDeque.removeFirst();
        arrayDeque.addFirst(10);
        arrayDeque.addFirst(11);
        arrayDeque.addFirst(12);
        arrayDeque.addLast(13);
        arrayDeque.get(1);
        arrayDeque.addLast(15);
        arrayDeque.addLast(16);
        arrayDeque.removeFirst();
        arrayDeque.get(3);
        arrayDeque.addFirst(19);
        arrayDeque.addLast(20);
        arrayDeque.addFirst(21);
        arrayDeque.removeLast();
        arrayDeque.get(1);

        assertEquals(19, arrayDeque.get(1));
    }

    @Test
    public void getADTest14() {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.addFirst(0);
        arrayDeque.addFirst(1);
        arrayDeque.addFirst(2);
        arrayDeque.addFirst(3);
        arrayDeque.addFirst(4);
        arrayDeque.addFirst(5);
        arrayDeque.isEmpty();
        arrayDeque.addFirst(7);
        arrayDeque.addFirst(8);
//        ArrayDeque.removeFirst();

        assertEquals(8, arrayDeque.removeFirst());
    }

    @Test
    public void getADTest15() {
        ArrayDeque arrayDeque = new ArrayDeque();

        arrayDeque.addLast(0);
        arrayDeque.addFirst(1);
//        ArrayDeque.removeFirst();
//        ArrayDeque.removeFirst();
        assertEquals(1, arrayDeque.removeFirst());
    }

    @Test
    public void getADTest16() {
        ArrayDeque arrayDeque = new ArrayDeque();

        arrayDeque.addLast(0);
        arrayDeque.removeLast();
        arrayDeque.addLast(2);
        arrayDeque.removeFirst();
        arrayDeque.addFirst(4);
        arrayDeque.addFirst(5);
        arrayDeque.removeFirst();
        arrayDeque.get(0);
        arrayDeque.get(0);
        arrayDeque.addLast(9);
        arrayDeque.addFirst(10);
        arrayDeque.addLast(11);
        arrayDeque.addLast(12);
        arrayDeque.addFirst(13);
        arrayDeque.get(1);
        arrayDeque.addFirst(15);
        arrayDeque.removeFirst();
        arrayDeque.get(1);
        arrayDeque.addFirst(18);
        arrayDeque.addLast(19);
//        ArrayDeque.removeFirst();
        assertEquals(18, arrayDeque.removeFirst());
    }

    @Test
    public void getADTest17() {
        ArrayDeque arrayDeque = new ArrayDeque();

        arrayDeque.addFirst(0);
        arrayDeque.removeLast();
        arrayDeque.addLast(2);
        arrayDeque.removeFirst();
        arrayDeque.addLast(4);
        arrayDeque.addLast(5);
        arrayDeque.removeLast();
        arrayDeque.removeLast();
        arrayDeque.addLast(8);
        arrayDeque.removeFirst();
        arrayDeque.addLast(10);
        arrayDeque.addLast(11);
        arrayDeque.get(0);
        arrayDeque.addFirst(13);
        arrayDeque.addFirst(14);
//        ArrayDeque.removeLast();
        assertEquals(11, arrayDeque.removeLast());
    }

    @Test
    public void getADTest18() {
        ArrayDeque arrayDeque = new ArrayDeque();

        arrayDeque.addFirst(0);
        arrayDeque.get(0);
        arrayDeque.get(0);
        arrayDeque.get(0);
        arrayDeque.removeLast();
        arrayDeque.addLast(5);
        arrayDeque.addLast(6);
        arrayDeque.addFirst(7);
        arrayDeque.removeFirst();
        arrayDeque.get(0);
        arrayDeque.removeFirst();
        arrayDeque.addLast(11);
        arrayDeque.addFirst(12);
        arrayDeque.get(1);
        arrayDeque.addLast(14);
        arrayDeque.get(0);
        arrayDeque.addLast(16);
        arrayDeque.removeLast();
        arrayDeque.addFirst(18);
        arrayDeque.get(2);
//        ArrayDeque.removeLast();
//        ArrayDeque.removeLast();
        assertEquals(14, arrayDeque.removeLast());
    }

    @Test
    public void getADTest19() {
        ArrayDeque arrayDeque = new ArrayDeque();

        arrayDeque.addLast(0);
        arrayDeque.addLast(1);
        arrayDeque.addLast(2);
        arrayDeque.addLast(3);
        arrayDeque.removeLast();
        arrayDeque.addLast(5);
        arrayDeque.removeFirst();
        arrayDeque.addLast(7);
        arrayDeque.addFirst(8);
        arrayDeque.addLast(9);
//        ArrayDeque.get(0);
        arrayDeque.addFirst(11);
        arrayDeque.removeFirst();
//        ArrayDeque.removeFirst();

        assertEquals(8, arrayDeque.removeFirst());
    }


    @Test
    public void getADTest20() {
        ArrayDeque arrayDeque = new ArrayDeque();

        arrayDeque.addLast(0);
        arrayDeque.addLast(1);
        arrayDeque.removeFirst();
        arrayDeque.addLast(3);
        arrayDeque.addLast(4);
        arrayDeque.addLast(5);
        arrayDeque.addLast(6);
        arrayDeque.addLast(7);
        arrayDeque.addLast(8);
        arrayDeque.addLast(9);
        arrayDeque.addLast(10);
//        ArrayDeque.removeFirst();

        assertEquals(1, arrayDeque.removeFirst());
    }

}
