package collections;

import java.util.HashSet;
import java.util.Set;

public class SetDifference {
    public static void main(String[] args) {
        Set<Integer> num1 = new HashSet<>();
        num1.add(3);
        num1.add(7);
        num1.add(9);

        HashSet<Integer> num2 = new HashSet<>();
        num2.add(5);
        num2.add(7);
        num2.add(12);

        Set<Integer> result = symmetricDifference(num1,num2);
        System.out.println(result);
    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> intersect = new HashSet<>(set1);
        intersect.retainAll(set2);

        Set<T> result = new HashSet<>(set1);
        result.addAll(set2);

        result.removeAll(intersect);

        return result;
    }
}
