package streams;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordsTop {
    public static void main(String[] args) {
        String strTest1 = "Мама мыла-мыла-мыла раму!";
        String strTest2 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.";

        try (ByteArrayInputStream bas = new ByteArrayInputStream(strTest2.getBytes());
             InputStreamReader test = new InputStreamReader(bas, StandardCharsets.UTF_8)
        ) {
            System.out.print(getScoreStream(test));
        } catch (Exception e) {
        }
    }

    public static String getScoreStream(InputStreamReader inputStreamReader) {
        // Prepare the stream
        BufferedReader br = new BufferedReader(inputStreamReader);
        Stream<String> result = br.lines();

        // List top ten occurring words
        return result.map(lines -> lines.split("[\\s-]"))
                .flatMap(Arrays::stream)
                .map(word -> Pattern.compile("\\W", Pattern.UNICODE_CHARACTER_CLASS).matcher(word).replaceAll(""))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList()).stream()
                .limit(10)
                .collect(Collectors.joining("\n"));
    }
}
