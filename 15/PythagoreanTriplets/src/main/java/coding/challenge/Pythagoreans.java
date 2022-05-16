package coding.challenge;

import java.util.Arrays;

public final class Pythagoreans {
    private Pythagoreans() {
        throw new AssertionError("Cannot be instantiated");
    }

    // 시간 복잡도 O(n^2)
    public static void triplet(int arr[]) {
        int len = arr.length;

        // 1단계
        for (int i = 0; i < len; i++) {
            arr[i] = arr[i] * arr[i];
        }

        // 2단계
        Arrays.sort(arr);

        // 3~5단계
        for (int i = len - 1; i >= 2; i--) {
            int b = 0;
            int c = i - 1; 

            // 6단계
            while (b < c) {
                // 6-c단계
                if (arr[b] + arr[c] == arr[i]) {
                    System.out.println("Triplet: " + Math.sqrt(arr[b]) + ", "
                      + Math.sqrt(arr[c]) + ", " + Math.sqrt(arr[i]));
                    b++;
                    c--;
                }

                // 6-a 및 6-b단계
                if (arr[b] + arr[c] < arr[i]) {
                    b++;
                } else {
                    c--;
                }
            }
        }
    }
}