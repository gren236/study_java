import java.util.Arrays;

public class Study {
    /**
     * Merges two given sorted arrays into one
     *
     * @param a1 first sorted array
     * @param a2 second sorted array
     * @return new array containing all elements from a1 and a2, sorted
     */
    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] result = new int[a1.length + a2.length];

        int a1i = 0;
        int a2i = 0;
        for (int i = 0; i < result.length; i++) {
            // Check if arrays are out of bound
            if (a2i + 1 > a2.length) {
                result[i] = a1[a1i];
                a1i++;
                continue;
            } else if (a1i + 1 > a1.length) {
                result[i] = a2[a2i];
                a2i++;
                continue;
            }

            // Decide which value to copy
            if (a1[a1i] <= a2[a2i]) {
                result[i] = a1[a1i];
                a1i++;
            } else {
                result[i] = a2[a2i];
                a2i++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeArrays(new int[]{0, 2, 2}, new int[]{1, 3})));
    }
}
