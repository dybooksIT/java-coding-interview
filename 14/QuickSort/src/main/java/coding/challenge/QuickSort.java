package coding.challenge;

import java.util.Comparator;

public final class QuickSort {
    private QuickSort() {
        throw new AssertionError("Cannot be instantiated");
    }

    // 기본 요소를 위한 퀵 정렬(예: 정수)
    public static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int m = partition(arr, left, right);

            sort(arr, left, m - 1);
            sort(arr, m + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int m = left;
        for (int i = m; i < right; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, m++);
            }
        }

        swap(arr, right, m);

        return m;
    }

    // Comparator를 이용한 퀵 정렬
    public static <T> void sortWithComparator(
      T[] arr, int left, int right, Comparator<? super T> c) {

        if (left < right) {
            int m = partitionWithComparator(arr, left, right, c);

            sortWithComparator(arr, left, m - 1, c);
            sortWithComparator(arr, m + 1, right, c);
        }
    }

    private static <T> int partitionWithComparator(
      T[] arr, int left, int right, Comparator<? super T> c) {

        T pivot = arr[right];
        int m = left;
        for (int i = m; i < right; i++) {
            if (c.compare(arr[i], pivot) <= 0) {
                swap(arr, i, m++);
            }
        }

        swap(arr, right, m);

        return m;
    }

    // 헬퍼 메서드
    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    private static <T> void swap(T[] arr, int x, int y) {
        T temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}