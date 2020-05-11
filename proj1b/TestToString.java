import org.junit.Test;
import static org.junit.Assert.*;
public class TestToString {

    @Test
    public void testLinkListDeque() {
        LinkedListDeque a = new LinkedListDeque();
        a.addLast("c");
        a.addLast("a");
        a.addLast("t");
        assertEquals("cat", a.toString());
    }



}
