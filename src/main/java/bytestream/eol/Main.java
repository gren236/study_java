package bytestream.eol;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        byte[] data = {13, 10};
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(16);

        changeEOL(inputStream, outputStream);

        byte[] out = outputStream.toByteArray();
        for (byte b : out) {
            System.out.println(b);
        }
    }

    private static void changeEOL(InputStream in, OutputStream out) throws IOException {
        int current;
        int last;

        if ((last = in.read()) < 0) {
            return;
        }

        while ((current = in.read()) > 0) {
            if (last == 13 && current == 10) {
                last = current;
                continue;
            }

            out.write(last);
            last = current;
        }
        out.write(last);

        out.flush();
    }
}
