package coding.challenge;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayConvertStream {
    private ArrayConvertStream() {
        throw new AssertionError("Cannot be instantiated");
    }

    // Arrays 클래스의 stream 메서드를 이용해 T 배열을 스트림으로 변환합니다.
    public static <T> Stream<T> toStream1(T[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Inputs cannot be null");
        }

        return Arrays.stream(arr);
    }

    // Stream 인터페이스의 of 메서드를 이용해 T 배열을 스트림으로 변환합니다.
    public static <T> Stream<T> toStream2(T[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Inputs cannot be null");
        }

        return Stream.of(arr);
    }

    // List 인터페이스의 stream 메서드를 이용해 T 배열을 스트림으로 변환합니다.
    public static <T> Stream<T> toStream3(T[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Inputs cannot be null");
        }

        return Arrays.asList(arr).stream();
    }

    // Arrays 클래스의 stream 메서드를 이용해 원시 타입 배열(int)을 스트림으로 변환합니다.
    public static IntStream toStream4(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Inputs cannot be null");
        }

        return Arrays.stream(arr);
    }

    // IntStream 인터페이스의 of 메서드를 이용해 원시 타입 배열(int)을 스트림으로 변환합니다.
    public static IntStream toStream5(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Inputs cannot be null");
        }

        return IntStream.of(arr);
    }
}