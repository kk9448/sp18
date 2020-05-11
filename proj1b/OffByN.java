public class OffByN implements CharacterComparator {
    int a;
    OffByN(int x) {
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
