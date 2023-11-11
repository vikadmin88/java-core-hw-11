package m11.task5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsBlenderTest {
    public static void main(String[] args) {
        String[] arrFirst = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"};
        System.out.println("arrFirst = " + Arrays.toString(arrFirst));

        String[] arrSecond = new String[]{"A", "B", "C", "D", "E"};
        System.out.println("arrSecond = " + Arrays.toString(arrSecond));

        Stream<String> first = Stream.of(arrFirst);
        Stream<String> second = Stream.of(arrSecond);

        String result = zip(first, second)
                .collect(Collectors.joining(", "));
        System.out.println("result = " + result);
    }
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        List<T> resultList = new ArrayList<>();
        Iterator<T> iterFirst = first.iterator();
        Iterator<T> iterSecond = second.iterator();

        while (iterFirst.hasNext() && iterSecond.hasNext()) {
            resultList.add(iterFirst.next());
            resultList.add(iterSecond.next());
        }
        return resultList.stream();
    }
}
