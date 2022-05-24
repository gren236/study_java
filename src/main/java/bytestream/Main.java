package bytestream;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStream stream;
        int result;
        stream = getStream( new byte[] {0x33, 0x45, 0x01});

        result = checkSumOfStream(stream);
        System.out.print(result);
    }

    public static InputStream getStream(byte [] data)  {
        return new ByteArrayInputStream(data);
    }

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int checkSum = 0;
        int current;

        while ((current = inputStream.read()) > 0) {
            checkSum = Integer.rotateLeft(checkSum, 1) ^ current;
        }

        return checkSum;
    }
}