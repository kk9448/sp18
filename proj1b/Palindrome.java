public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        ArrayDeque<Character> ans = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            ans.addLast(word.charAt(i));
        }
        return ans;
    }

    public boolean isPalindrome(String word) {
        /** using ArrayDeque*/
        ArrayDeque<Character> ori = new ArrayDeque<>();
        ArrayDeque<Character> reverse = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            reverse.addFirst(word.charAt(i));
            ori.addLast(word.charAt(i));

        }
        boolean c = ori.equals(reverse);
        return ori.equals(reverse);

        /** using LinkedListDeque*/
//        LinkedListDeque<Character> ori = new LinkedListDeque<>();
//        LinkedListDeque<Character> reverse = new LinkedListDeque<>();
//        for (int i = 0; i < word.length(); i++) {
//            ori.addFirst(word.charAt(i));
//            reverse.addLast(word.charAt(i));
//
//        }
//
//        boolean c = ori.equals(reverse);
//        return ori.equals(reverse);

    }
    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() == 1) {
            return true;
        }
        ArrayDeque<Character> ori = new ArrayDeque<>();
        ArrayDeque<Character> reverse = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            reverse.addFirst(word.charAt(i));
            ori.addLast(word.charAt(i));
        }

        int a = word.length() % 2;
        int b = word.length() / 2;

        for (int i = 0; i < word.length(); i++) {
            if (i == b && a != 0) {
                i++;
            }
            if (!cc.equalChars(ori.get(i), reverse.get(i))) {
                return false;
            }
        }
        return true;
    }
}
