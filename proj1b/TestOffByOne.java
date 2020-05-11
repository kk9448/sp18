import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void offByOne() {
//        OffByOne test = new OffByOne();
        char a = 'a';
        char b = 'b';
        assertTrue(offByOne.equalChars(a, b));

        a = 'r';
        b = 'q';
        assertTrue(offByOne.equalChars(a, b));

        a = 'a';
        b = 'e';
        assertFalse(offByOne.equalChars(a, b));

        a = 'z';
        b = 'a';
        assertFalse(offByOne.equalChars(a, b));


    }


    /*
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();
    // Your tests go here.
    Uncomment this class once you've created your CharacterComparator interface and OffByOne class. **/
}
