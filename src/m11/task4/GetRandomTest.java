package m11.task4;

import java.util.stream.Stream;

public class GetRandomTest {
    public static void main(String[] args) {

        Stream<Long> infiniteStream = Stream.iterate(0L, GetRandomTest::getRand);

        infiniteStream
                .limit(20)
                .forEach(System.out::println);
    }

    private static long getRand(long seed) {
        long a = 25214903917L;
        long c = 11L;
        long m = 281474976710656L;
        return (a * seed + c) % m;
    }
}
