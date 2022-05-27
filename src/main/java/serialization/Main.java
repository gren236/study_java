package serialization;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

public class Main {
    public static Animal[] deserializeAnimalArray(byte[] data) {
        try {
            ByteArrayInputStream byteStream = new ByteArrayInputStream(data);
            ObjectInputStream input = new ObjectInputStream(byteStream);

            int size = input.readInt();
            Animal[] result = new Animal[size];

            for (int i = 0; i < size; i++) {
                result[i] = (Animal) input.readObject();
            }

            return result;
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}
