import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testisPalindrome() {
//        boolean d = palindrome.isPalindrome("persiflage");
//        assertFalse(d);
//        boolean a = palindrome.isPalindrome("cat");
//        assertFalse(a);
        boolean b = palindrome.isPalindrome("racecar");
        assertTrue(b);
    }

    @Test
    public void testisPalindrome2() {
//        boolean d = palindrome.isPalindrome("persiflage");
//        assertFalse(d);
//        boolean a = palindrome.isPalindrome("cat");
//        assertFalse(a);
        boolean b = palindrome.isPalindrome("flake", new OffByOne());
        assertTrue(b);
    }

    @Test
    public void testisPalindrome3() {
//        boolean d = palindrome.isPalindrome("persiflage");
//        assertFalse(d);
//        boolean a = palindrome.isPalindrome("cat");
//        assertFalse(a);
        boolean b = palindrome.isPalindrome("flake", new OffByN(1));
        assertTrue(b);
    }

    @Test
    public void testisPalindrome4() {
//        boolean d = palindrome.isPalindrome("persiflage");
//        assertFalse(d);
//        boolean a = palindrome.isPalindrome("cat");
//        assertFalse(a);
        boolean b = palindrome.isPalindrome(null);
        assertFalse(b);
    }
    @Test
    public void testisPalindrome5() {
//        boolean d = palindrome.isPalindrome("persiflage");
//        assertFalse(d);
//        boolean a = palindrome.isPalindrome("cat");
//        assertFalse(a);
        boolean b = palindrome.isPalindrome(null, new OffByN(1));
        assertFalse(b);
    }



}
