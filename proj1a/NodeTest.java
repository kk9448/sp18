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
        a.addFirst(3);
        a.addFirst(5);
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
        a.addFirst(3);
        a.addFirst(32);
        a.addFirst(3);
        a.addFirst(32);
        a.addFirst(3);
        a.addFirst(32);
        a.addLast(1);
        a.addFirst(32);
        a.addFirst(3);
        a.addFirst(32);
        a.addLast(1);
        a.removeLast();
        a.removeFirst();
        a.printDeque();
    }
}
