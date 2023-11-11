package m11.task2;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GetSortedUpperCaseTest {
    public final static String NAMES = "James, John,Robert,Michael,     William,David, Richard, Charles, Joseph, Thomas, Christopher, Daniel, Paul";

    public static void main(String[] args) {
        System.out.println("Input names: " + NAMES);
        System.out.println("Result names: " + getNamesFromList(NAMES));
    }

    private static String getNamesFromList(String names) {
        Stream<String> namesStream = Arrays.stream(names.split(","));
        return namesStream
                .map(String::trim)
                .map(String::toUpperCase)
                .sorted((e1, e2) -> e2.compareTo(e1))
                .collect(Collectors.joining(", "));
    }
}
