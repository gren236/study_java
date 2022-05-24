package charstream;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {
        byte[] data = {48, 49, 50, 51};
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);

        System.out.println(readAsString(inputStream, StandardCharsets.UTF_8));
    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        StringBuilder result = new StringBuilder();

        Reader reader = new InputStreamReader(inputStream, charset);
        int current;
        while ((current = reader.read()) > 0) {
            result.append((char)current);
        }

        return result.toString();
    }
}
