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

        // Step 1: Start from the rightmost digit and find the 
        // first digit that is smaller than the digit next to it. 
        for (int i = len - 1; i > 0; i--) {
            currentDigit = arr[i];
            prevDigit = arr[i - 1];
            if (currentDigit > prevDigit) {
                minPosition = i;
                break;
            }
        }

        // If 'min' is -1 then there is no such digit. This means that the
        // digits are in descending order. There is no greater 
        // number with same set of digits as the given one.
        if (minPosition == -1) {
            System.out.println("There is no greater number with "
              + "same set of digits as the given one.");
        } else {
            int x = arr[minPosition - 1];
            int nextSmallestPosition = minPosition;

            for (int i = minPosition + 1; i < len; i++) {
                if (arr[i] > x && arr[i] < arr[minPosition]) {
                    nextSmallestPosition = i;
                }
            }

            // Steps 2 and 3: Swap 'min' with 'len-1'
            swap(arr, minPosition - 1, nextSmallestPosition);

            // Step 4: Sort in ascending order all the digits 
            // to the right side of the swapped 'len-1'
            Arrays.sort(arr, minPosition, len);

            // print the result
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
