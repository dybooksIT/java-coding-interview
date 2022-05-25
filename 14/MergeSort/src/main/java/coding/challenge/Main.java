package coding.challenge;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 배열 integers 초기화
        int[] integers = {52, 28, 91, 19, 76, 33, 43, 57, 20};

        System.out.println("\n\nSort via Merge sort:");
        System.out.println("----------------------");

        MergeSort.sort(integers);
        System.out.println("Sorted: " + Arrays.toString(integers));
    }
}