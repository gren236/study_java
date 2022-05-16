import java.util.Arrays;
import java.util.function.DoubleUnaryOperator;

public class Study {
    /**
     * Merges two given sorted arrays into one
     *
     * @param a1 first sorted array
     * @param a2 second sorted array
     * @return new array containing all elements from a1 and a2, sorted
     */
    private static int[] mergeArrays(int[] a1, int[] a2) {
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

    /**
     * @param roles roles
     * @param textLines array of lines
     * @return Grouped list of role lines
     */
    private static String printTextPerRole(String[] roles, String[] textLines) {
        // Build a resulting structure array
        int[][] resultStructure = new int[roles.length][0];
        for (int i = 0; i < textLines.length; i++) {
            String line = textLines[i];
            for (int j = 0; j < roles.length; j++) {
                String role = roles[j];
                if (line.matches(String.format("^%s:.*$", role))) {
                    // Add to role
                    int n = resultStructure[j].length;
                    resultStructure[j] = Arrays.copyOf(resultStructure[j], n + 1);
                    resultStructure[j][n] = i;
                }
            }
        }

        // Build a resulting string (using StringBuilder)
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < resultStructure.length; i++) {
            // Add role to result
            result.append(roles[i]).append(":\n");

            for (int j = 0; j < resultStructure[i].length; j++) {
                int textLinesIndex = resultStructure[i][j];
                result.append(textLinesIndex + 1)
                        .append(")")
                        .append(textLines[textLinesIndex].split(":", 2)[1])
                        .append("\n");
            }
            result.append("\n");
        }

        return result.toString();
    }

    public static double sqrt(double x) {
        if (x < 0) throw new IllegalArgumentException("Expected non-negative number, got " + x);

        return Math.sqrt(x);
    }

    public static int testCatch() {
        try {
            System.out.println("Try Called!");
            int a = 2;
            int b = 2;
            return a + b;
        } catch (Exception e) {
            // ...
        } finally {
            System.out.println("Finally Called!");
        }

        return 42;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeArrays(new int[]{0, 2, 2}, new int[]{1, 3})));

        String[] roles = {
                "Городничий", "Аммос Федорович",
                "Артемий Филиппович",
                "Лука Лукич"};
        String[] textLines = {
                "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};
        System.out.println(printTextPerRole(roles, textLines));

        System.out.println(testCatch());
    }
}
