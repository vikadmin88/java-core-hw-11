package m11.task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GetSortedArrayTest {

    public static void main(String[] args) {
        String[] arrStr = new String[]{"1, 2, 0, 6", "4, 5", "", "-2"};
        System.out.printf("Input Array: %s Size: %d: \n", Arrays.toString(arrStr), arrStr.length);
        System.out.println("Expected: \"-2, 0, 1, 2, 4, 5, 6\"");

        String retListSorted;
        // ver 2
        retListSorted = Arrays.stream(arrStr)
                .flatMap((p) -> Arrays.stream(p.split(",")))
                .map(String::trim)
                .filter(it -> !it.isEmpty())
                .map(Integer::parseInt)
                .sorted()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "\"", "\""));
        System.out.println("Result =  " + retListSorted);

/*
        // ver 1
        List<Integer> retIntList = new ArrayList<>();

        for (String arr : arrStr) {
            Stream<String> extArr = Arrays.stream(arr.split(","));
            retIntList.addAll(
                extArr
                    .map(String::trim)
                    .filter(it -> !it.isEmpty())
                    .map(Integer::parseInt)
                    .collect(Collectors.toList())
            );
        }

        retListSorted = retIntList
                .stream()
                .sorted()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "\"", "\""));
        System.out.println("Result =  " + retListSorted);
*/

    }
}
