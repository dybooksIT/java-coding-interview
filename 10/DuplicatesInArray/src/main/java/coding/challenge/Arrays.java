package coding.challenge;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public final class Arrays {
    private Arrays() {
        throw new AssertionError("Cannot be instantiated");
    }

    // 실행 시간이 O(n^2), 공간 복잡도가 O(1)
    public static boolean checkDuplicates1(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("The given array cannot be null or empty");
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    // 실행 시간이 O(n log n), 공간 복잡도가 O(1)
    public static boolean checkDuplicates2(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("The given array cannot be null or empty");
        }

        java.util.Arrays.sort(arr);

        int prev = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == prev) {
                return true;
            }

            prev = arr[i];
        }

        return false;
    }

    // 실행 시간과 공간 복잡도가 O(n)
    public static boolean checkDuplicates3(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("The given array cannot be null or empty");
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                return true;
            }

            set.add(arr[i]);
        }

        return false;
    }

    // 실행 시간과 공간 복잡도가 O(n)
    public static boolean checkDuplicates4(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("The given array cannot be null or empty");
        }

        Set set = new HashSet<>(java.util.Arrays.asList(
          IntStream.of(arr).boxed().toArray(Integer[]::new)));

        return arr.length != set.size();
    }

    // 실행 시간과 공간 복잡도가 O(n)
    public static boolean checkDuplicates5(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("The given array cannot be null or empty");
        }

        Long distinctCount = IntStream.of(arr)
          .boxed()
          .distinct()
          .count();

        return arr.length != distinctCount;
    }

    // 실행 시간이 O(n), 공간 복잡도가 O(1)
    public static boolean checkDuplicates6(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("The given array cannot be null or empty");
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[Math.abs(arr[i])] > 0) {
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            } else if (arr[Math.abs(arr[i])] == 0) {
                arr[Math.abs(arr[i])] = -(arr.length-1);
            } else {
                return true;
            }
        }

        return false;
    }
}