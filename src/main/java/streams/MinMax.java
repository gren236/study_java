package streams;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class MinMax {
    public static void main(String[] args) {
        findMinMax(
                Stream.of(9, 6, 8, 3, 19, 16, 18, 13),
                Integer::compareTo,
                (v1, v2) -> System.out.println("max = " + v2 + "\nmin = " + v1)
        );
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer
    ) {
        List<? extends T> collection = stream.sorted(order).toList();

        if (collection.isEmpty()) {
            minMaxConsumer.accept(null, null);
            return;
        }

        minMaxConsumer.accept(collection.get(0), collection.get(collection.size() - 1));
    }
}
