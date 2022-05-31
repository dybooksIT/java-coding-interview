package coding.challenge;

import java.util.Arrays;

public final class Numbers {
    private Numbers() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void findNextGreater(int arr[]) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("The given array cannot be null or empty");
        }

        int minPosition = -1;
        int len = arr.length;

        int prevDigit;
        int currentDigit;

        // 1단계: 가장 오른쪽부터 한 자리씩 자릿수를 순회합니다.
        // 이전 자릿수보다 작은 자릿수의 바로 앞 자릿수를 찾을 때까지 탐색을 계속합니다.
        for (int i = len - 1; i > 0; i--) {
            currentDigit = arr[i];
            prevDigit = arr[i - 1];
            if (currentDigit > prevDigit) {
                minPosition = i;
                break;
            }
        }

        // 'minPosition'이 -1이면 해당 숫자가 없습니다.
        // 이것은 숫자가 내림차순임을 의미합니다.
        // 주어진 자릿수와 같은 자릿수 집합을 갖는 더 큰 수는 없습니다.
        if (minPosition == -1) {
            System.out.println("There is no greater number with "
              + "same set of digits as the given one.");
        } else {
            int x = arr[minPosition - 1];
            int nextSmallestPosition = minPosition;

            // 2단계: 1단계에서 찾은 이전 자릿수보다 작은 자릿수(minPosition – 1)의
            // 오른쪽에 있는 자릿수를 순회하며
            // 해당 자릿수보다 큰 모든 자릿수 중 가장 작은 자릿수를 찾습니다.
            // 이 조건에 맞는 자릿수를 nextSmallestPosition이라고 표시하겠습니다.
            for (int i = minPosition + 1; i < len; i++) {
                if (arr[i] > x && arr[i] < arr[minPosition]) {
                    nextSmallestPosition = i;
                }
            }

            // 3단계: 1단계와 2단계에서 찾은 두 자릿수를 교환합니다.
            swap(arr, minPosition - 1, nextSmallestPosition);

            // 4단계: 마지막으로 minPosition을 포함해 오른쪽에 있는 모든 자릿수를 오름차순으로 정렬합니다.
            Arrays.sort(arr, minPosition, len);

            // 결과를 출력합니다.
            System.out.print("The next greater number is: ");
            for (int i : arr) {
                System.out.print(i);
            }

            System.out.println();
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int aux = arr[i];
        arr[i] = arr[j];
        arr[j] = aux;
    }
}