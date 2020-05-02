import static org.junit.Assert.*;
import org.junit.Test;

public class NodeTest {

    @Test
    public void addLastTest() {
        LinkedListDeque a= new LinkedListDeque();
        a.addLast(3);
        a.addLast(5);
//        a.removeFirst();
        a.removeLast();
        a.printDeque();

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
        ArrayDeque a= new ArrayDeque();
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

}
