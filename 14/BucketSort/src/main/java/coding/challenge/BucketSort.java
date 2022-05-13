package coding.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class BucketSort {
    private BucketSort() {
        throw new AssertionError("Cannot be instantiated");
    }

    // 분산-정렬-수집 기법
    public static void sort1(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        // 해시 코드를 가져옵니다.
        int[] hashes = hash(arr);

        // 버킷을 생성하고 초기화합니다.
        List<Integer>[] buckets = new List[hashes[1]];
        for (int i = 0; i < hashes[1]; i++) {
            buckets[i] = new ArrayList();
        }

        // 요소를 버킷에 분배합니다.
        for (int e : arr) {
            buckets[hash(e, hashes)].add(e);
        }

        // 각 버킷을 정렬합니다.
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        // 버킷으로부터 요소를 수집합니다.
        int p = 0;
        for (List<Integer> bucket : buckets) {
            for (int j : bucket) {
                arr[p++] = j;
            }
        }
    }

    private static int[] hash(int[] arr) {
        int m = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (m < arr[i]) {
                m = arr[i];
            }
        }

        return new int[]{m, (int) Math.sqrt(arr.length)};
    }

    private static int hash(int num, int[] hashes) {
        return (int) ((double) num / hashes[0] * (hashes[1] - 1));
    }

    // 분산-정렬-수집 기법
    public static void sort2(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        // 주어진 배열의 최댓값을 찾습니다.
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // 최대 버킷을 생성합니다.
        int[] bucket = new int[max + 1];

        // 자바에서는 bucket[]이 자동으로 0으로 초기화되므로 이 작업은 중복된 작업입니다.
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = 0;
        }

        // 버킷에 요소를 분배합니다.
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }

        // 버킷에서 요소를 수집합니다.
        int p = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                arr[p++] = i;
            }
        }
    }
}