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
    public void LLD3() {
        LinkedListDeque LinkedListDeque= new LinkedListDeque();


        LinkedListDeque.addFirst(0);
        LinkedListDeque.removeFirst();
//        LinkedListDeque.removeLast();
//        assertEquals(3,LinkedListDeque.removeFirst());



    }

    @Test
    public void LLD4() {
        LinkedListDeque LinkedListDeque= new LinkedListDeque();


        LinkedListDeque.addLast(0);
        LinkedListDeque.addLast(1);
        LinkedListDeque.removeFirst() ;
        LinkedListDeque.isEmpty();
        LinkedListDeque.removeFirst();



    }
    @Test
    public void LLD5() {
        LinkedListDeque LinkedListDeque= new LinkedListDeque();


        LinkedListDeque.size();
        LinkedListDeque.addFirst(1);
        LinkedListDeque.addFirst(2);
        LinkedListDeque.removeLast() ;
        LinkedListDeque.removeFirst();



    }

    @Test
    public void LLD6() {
        LinkedListDeque LinkedListDeque= new LinkedListDeque();


        LinkedListDeque.addLast(0);
        LinkedListDeque.removeFirst();



    }

    @Test
    public void LLD7() {
        LinkedListDeque LinkedListDeque= new LinkedListDeque();


        LinkedListDeque.isEmpty();
        LinkedListDeque.addFirst(1);
        LinkedListDeque.isEmpty();
        LinkedListDeque.removeLast() ;
        LinkedListDeque.addLast(4);
        LinkedListDeque.removeFirst() ;
        LinkedListDeque.addLast(6);
        LinkedListDeque.removeLast()  ;
        LinkedListDeque.addLast(8);
        LinkedListDeque.removeLast()  ;
        LinkedListDeque.size();
        assertEquals( 0,    LinkedListDeque.size());



    }

    @Test
    public void LLD8() {
        LinkedListDeque LinkedListDeque= new LinkedListDeque();


        LinkedListDeque.isEmpty();
        LinkedListDeque.addFirst(1);
        LinkedListDeque.removeFirst()  ;
        LinkedListDeque.addFirst(3);
        LinkedListDeque.removeFirst() ;
        LinkedListDeque.isEmpty();
        assertEquals( "true",Boolean.toString( LinkedListDeque.isEmpty()));


    }

    @Test
    public void LLD9() {
        LinkedListDeque LinkedListDeque= new LinkedListDeque();


        LinkedListDeque.isEmpty();
        LinkedListDeque.addLast(1);
        LinkedListDeque.removeFirst() ;
        LinkedListDeque.addLast(3);
        LinkedListDeque.addLast(4);
        LinkedListDeque.removeFirst() ;
        LinkedListDeque.removeFirst() ;
        LinkedListDeque.isEmpty();
        assertEquals( "true",Boolean.toString( LinkedListDeque.isEmpty()));


    }

    @Test
    public void LLD10() {
        LinkedListDeque LinkedListDeque= new LinkedListDeque();


        LinkedListDeque.addLast(0);
        LinkedListDeque.addFirst(1);
        LinkedListDeque.removeFirst()  ;
        LinkedListDeque.get(0);
        LinkedListDeque.addFirst(4);
//        LinkedListDeque.removeLast();
        assertEquals( 0,LinkedListDeque.removeLast());


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

    @Test
    public void getADTest6() {
        ArrayDeque ArrayDeque= new ArrayDeque();
        ArrayDeque.addFirst(0);
        ArrayDeque.removeFirst();
        ArrayDeque.addFirst(2);
//        assertEquals(8,ArrayDeque.get(0));

    }

    @Test
    public void getADTest7() {
        ArrayDeque ArrayDeque= new ArrayDeque();
        ArrayDeque.addFirst(0);
        ArrayDeque.isEmpty();
        ArrayDeque.addFirst(2);
        ArrayDeque.addFirst(3);
        ArrayDeque.addFirst(4);
        ArrayDeque.addFirst(5);
        ArrayDeque.isEmpty();
        ArrayDeque.removeLast() ;
        ArrayDeque.addFirst(8);
        ArrayDeque.addFirst(9);
        ArrayDeque.addFirst(10);
        ArrayDeque.addFirst(11);

    }



    @Test
    public void getADTest9() {
        ArrayDeque ArrayDeque= new ArrayDeque();
        ArrayDeque.addFirst(0);
        ArrayDeque.size();
        ArrayDeque.removeFirst();
        ArrayDeque.addFirst(3);
    }

    @Test
    public void getADTest10() {
        ArrayDeque ArrayDeque= new ArrayDeque();
        ArrayDeque.addLast(0);
        ArrayDeque.addFirst(1);
        ArrayDeque.addLast(2);
        ArrayDeque.addLast(3);
        ArrayDeque.get(2) ;
        ArrayDeque.get(2) ;
        ArrayDeque.get(2) ;
        ArrayDeque.removeLast()  ;
        ArrayDeque.addFirst(8);
        ArrayDeque.removeLast()  ;
        assertEquals(8,ArrayDeque.get(0));
;    }

    @Test
    public void getADTest11() {
        ArrayDeque ArrayDeque= new ArrayDeque();
        ArrayDeque.addFirst(0);
        ArrayDeque.addFirst(1);
        ArrayDeque.addFirst(2);
        ArrayDeque.addFirst(3);
        ArrayDeque.addFirst(4);
        ArrayDeque.addFirst(5);
        ArrayDeque.addFirst(6);
        ArrayDeque.addFirst(7);
        ArrayDeque.addFirst(8);
//        ArrayDeque.removeLast();

        assertEquals(0, ArrayDeque.removeLast());
    }

    @Test
    public void getADTest12() {
        ArrayDeque ArrayDeque= new ArrayDeque();
        ArrayDeque.addLast(0);
        ArrayDeque.addLast(1);
        ArrayDeque.addLast(2);
        ArrayDeque.removeLast()   ;
        ArrayDeque.removeLast()   ;
        ArrayDeque.removeFirst() ;
        ArrayDeque.addLast(6);
        ArrayDeque.addLast(7);
        ArrayDeque.addFirst(8);
        ArrayDeque.get(0)    ;
        ArrayDeque.addLast(10);
        ArrayDeque.removeFirst()  ;
        ArrayDeque.removeLast()   ;
        ArrayDeque.get(1);

        assertEquals(7, ArrayDeque.get(1));
    }

    @Test
    public void getADTest13() {
        ArrayDeque ArrayDeque= new ArrayDeque();
        ArrayDeque.addLast(0);
        ArrayDeque.get(0) ;
        ArrayDeque.addLast(2);
        ArrayDeque.removeLast() ;
        ArrayDeque.get(0) ;
        ArrayDeque.removeFirst()  ;
        ArrayDeque.addFirst(6);
        ArrayDeque.addLast(7);
        ArrayDeque.removeFirst()  ;
        ArrayDeque.removeFirst()  ;
        ArrayDeque.addFirst(10);
        ArrayDeque.addFirst(11);
        ArrayDeque.addFirst(12);
        ArrayDeque.addLast(13);
        ArrayDeque.get(1)   ;
        ArrayDeque.addLast(15);
        ArrayDeque.addLast(16);
        ArrayDeque.removeFirst() ;
        ArrayDeque.get(3) ;
        ArrayDeque.addFirst(19);
        ArrayDeque.addLast(20);
        ArrayDeque.addFirst(21);
        ArrayDeque.removeLast() ;
        ArrayDeque.get(1);

        assertEquals(19, ArrayDeque.get(1));
    }

    @Test
    public void getADTest14() {
        ArrayDeque ArrayDeque= new ArrayDeque();
        ArrayDeque.addFirst(0);
        ArrayDeque.addFirst(1);
        ArrayDeque.addFirst(2);
        ArrayDeque.addFirst(3);
        ArrayDeque.addFirst(4);
        ArrayDeque.addFirst(5);
        ArrayDeque.isEmpty();
        ArrayDeque.addFirst(7);
        ArrayDeque.addFirst(8);
//        ArrayDeque.removeFirst();

        assertEquals(8,  ArrayDeque.removeFirst());
    }

    @Test
    public void getADTest15() {
        ArrayDeque ArrayDeque= new ArrayDeque();

        ArrayDeque.addLast(0);
        ArrayDeque.addFirst(1);
//        ArrayDeque.removeFirst();
//        ArrayDeque.removeFirst();
        assertEquals(1,  ArrayDeque.removeFirst());
    }

}
