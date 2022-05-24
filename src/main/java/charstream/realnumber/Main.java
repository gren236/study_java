package charstream.realnumber;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String data = "a1 2 3";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(16);

        System.out.printf("%.6f", parseNumbers(inputStream));
    }

    private static double parseNumbers(InputStream inputStream) {
        Reader reader = new InputStreamReader(inputStream);
        Scanner scanner = new Scanner(reader).useDelimiter("[\\s\\n]").useLocale(Locale.US);
        double result = 0;

        while (scanner.hasNext()) {
            try {
                result += Double.parseDouble(scanner.next());
            } catch (NumberFormatException e) {
            }
        }

        return result;
    }
}
