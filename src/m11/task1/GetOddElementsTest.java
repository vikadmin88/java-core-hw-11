package m11.task1;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class GetOddElementsTest {
    public final static String NAMES = "James, John,Robert,Michael, William,David, Richard, Charles, Joseph, Thomas, Christopher, Daniel, Paul";

    public static void main(String[] args) {
        System.out.println("Input names: " + NAMES);
        System.out.println("Result names: " + getNamesFromList(NAMES));
    }

    private static String getNamesFromList(String names) {
        AtomicInteger index = new AtomicInteger(0);
        Stream<String> namesStream = Arrays.stream(names.split(","));
        return namesStream
                .filter((it) -> (index.getAndIncrement() % 2 == 0) )
                .map(String::trim)
                .map(name -> index.get() + ". " + name)
                .collect(Collectors.joining(", "));
    }
}
