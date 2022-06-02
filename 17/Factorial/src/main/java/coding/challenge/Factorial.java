package coding.challenge;

import java.util.stream.LongStream;

public class Factorial {
    static long factorial1(long n) {
        long result = 1;

        for (; n > 0; n--) {
            result *= n;
        }

        return result;
    }

    static long factorial2(long n) {
        return n == 1 ? 1 : n * factorial2(n - 1);
    }

    static long factorialTail(long n) {
        return factorial3(1, n);
    }

    static long factorial3(long acc, long v) {
        return v == 1 ? acc : factorial3(acc * v, v - 1);
    }

    static long factorial4(long n) {
        return LongStream.rangeClosed(1, n).reduce(1, (n1, n2) -> n1 * n2);
    }
}
