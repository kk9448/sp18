import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    @Test
    public void testOffByOne() {
        OffByOne test = new OffByOne();
        char a = 'a';
        char b = 'b';
        assertTrue(test.equalChars(a,b));

        a = 'r';
        b = 'q';
        assertTrue(test.equalChars(a,b));

        a = 'a';
        b = 'e';
        assertFalse(test.equalChars(a,b));

        a = 'z';
        b = 'a';
        assertFalse(test.equalChars(a,b));


    }


    /*
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();
    // Your tests go here.
    Uncomment this class once you've created your CharacterComparator interface and OffByOne class. **/
}
