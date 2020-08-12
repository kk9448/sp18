
/**
 * Class for doing Radix sort
 *
 * @author Akhil Batra, Alexander Hwang
 *
 */
public class RadixSort {
//    private static int RADIX = 256;
    /**
     * Does LSD radix sort on the passed in array with the following restrictions:
     * The array can only have ASCII Strings (sequence of 1 byte characters)
     * The sorting is stable and non-destructive
     * The Strings can be variable length (all Strings are not constrained to 1 length)
     *
     * @param asciis String[] that needs to be sorted
     *
     * @return String[] the sorted array
     */
    public static String[] sort(String[] asciis) {
        // TODO: Implement LSD Sort
        int max = Integer.MIN_VALUE;;
//        for (int i = 0; i < asciis.length; i++) {
//            max = asciis[i].length() > max ? asciis[i].length() : max;
//        }
        for (String s : asciis) {
            max = max > s.length() ? max : s.length();
        }
        String[] sorted = new String[asciis.length];
        System.arraycopy(asciis, 0, sorted, 0, asciis.length);
        for (int i = max - 1; i >= 0; i--) {
            sorted = sortHelperLSD(sorted, i);
        }
        return sorted;
    }

    /**
     * LSD helper method that performs a destructive counting sort the array of
     * Strings based off characters at a specific index.
     * @param asciis Input array of Strings
     * @param index The position to sort the Strings on.
     */
    private static String[] sortHelperLSD(String[] asciis, int index) {
        int[] count = new int[256];
        String[] res = new String[asciis.length];
        for (String x : asciis) {
            if (x.length() - 1 < index) {
                count[0]++;
            } else {
                count[(int) x.charAt(index)]++;
            }
        }
        int[] starts = new int[256];
        int place = 0;
        for (int i = 0; i < 256; i++) {
            starts[i] = place;
            place += count[i];
        }

        for (String x : asciis) {
            int pos;
            if (x.length() - 1 < index) {
                pos = starts[0];
                starts[0]++;
            } else {
                pos = starts[(int) x.charAt(index)];
                starts[(int) x.charAt(index)]++;
            }
            res[pos] = x;
        }
        return res;
    }

    /**
     * MSD radix sort helper function that recursively calls itself to achieve the sorted array.
     * Destructive method that changes the passed in array, asciis.
     *
     * @param asciis String[] to be sorted
     * @param start int for where to start sorting in this method (includes String at start)
     * @param end int for where to end sorting in this method (does not include String at end)
     * @param index the index of the character the method is currently sorting on
     *
     **/
    private static void sortHelperMSD(String[] asciis, int start, int end, int index) {
        // Optional MSD helper method for optional MSD radix sort
        return;
    }
}
