package coding.challenge;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 배열 integers1, integers2 초기화
        int[] integers1 = {4, 2, 11, 7, 18, 3, 14, 7, 4, 16};
        int[] integers2 = {4, 2, 8, 7, 8, 2, 2, 7, 4, 9};

        System.out.println("\n\nSort via Bucket sort:");
        System.out.println("-------------------------");

        int[] integersC1 = integers1.clone();
        int[] integersC2 = integers1.clone();
        int[] integersC3 = integers2.clone();
        int[] integersC4 = integers2.clone();

        BucketSort.sort1(integersC1);
        BucketSort.sort1(integersC2);
        // BucketSort.sort2(integersC3);
        // BucketSort.sort2(integersC4);
        System.out.println("Sorted C1: " + Arrays.toString(integersC1));
        System.out.println("Sorted C2: " + Arrays.toString(integersC2));
        // System.out.println("Sorted C3: " + Arrays.toString(integersC3));
        // System.out.println("Sorted C4: " + Arrays.toString(integersC4));
    }
}