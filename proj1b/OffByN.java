public class OffByN implements CharacterComparator {
    private int a;

    public OffByN(int x) {
        a = x;
    }
    @Override
    public boolean equalChars(char x, char y) {
        if (x + a == y || y + a == x) {
            return true;
        } else {
            return false;
        }
    }
}
