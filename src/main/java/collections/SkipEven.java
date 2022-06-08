package collections;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;
import java.lang.*;

public class SkipEven {
    public static void main(String[] args) {
        String data = "1 2 3 4 5 6 7";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes());

        Deque<Integer> result = buildOddCollection(inputStream);
        if (result.size() > 0) {
            Iterator<Integer> it = result.descendingIterator();
            System.out.print(it.next());

            while (it.hasNext()) {
                System.out.printf(" %d", it.next());
            }
        }
    }

    private static Deque<Integer> buildOddCollection(InputStream inputStream) {
        Scanner input = new Scanner(inputStream);
        Deque<Integer> result = new ArrayDeque<>();

        int i = 0;
        while (input.hasNextInt()) {
            int current = input.nextInt();

            if ((i % 2) != 0) {
                result.add(current);
            }

            i++;
        }

        return result;
    }
}
