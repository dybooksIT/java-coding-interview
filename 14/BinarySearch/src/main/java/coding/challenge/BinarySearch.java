package coding.challenge;

public final class BinarySearch {
    private BinarySearch() {
        throw new AssertionError("Cannot be instantiated");
    }

    // 반복 기반 이진 검색
    public static int runIterative(int[] arr, int p) {
        // 검색 공간은 전체 배열입니다.
        int left = 0;
        int right = arr.length - 1;

        // 검색 공간에는 적어도 하나의 요소가 있습니다.
        while (left <= right) {
            // 검색 공간을 반으로 줄입니다.
            int mid = (left + right) / 2;

            // 오버플로가 발생할 수 있는 환경이라면 다음 코드를 활용하세요.
            // int mid = left + (right - left) / 2;
            // int mid = right - (right - left) / 2;

            // 검색 대상 요소를 찾았습니다.
            if (p == arr[mid]) {
                return mid;
            } // 'mid'를 포함하여 검색 공간의 오른쪽에 있는 모든 요소를 버립니다.
            else if (p < arr[mid]) {
                right = mid - 1;
            } // 'mid'를 포함하여 검색 공간의 왼쪽에 있는 모든 요소를 버립니다.
            else {
                left = mid + 1;
            }
        }

        // 일반적으로 -1은 배열에서 요소를 찾을 수 없음을 의미합니다.
        return -1;
    }

    // 재귀 기반 이진 검색
    public static int runRecursive(int[] arr, int left, int right, int p) {
        // 재귀 기반 종료 조건(검색 공간이 포함됨)
        if (left > right) {
            return -1;
        }

        // 검색 공간을 반으로 줄입니다.
        int mid = (left + right) / 2;

        // 오버플로가 발생할 수 있는 환경이라면 다음 코드를 활용하세요.
        // int mid = left + (right - left) / 2;

        // 검색 대상 요소를 찾았습니다.
        if (p == arr[mid]) {
            return mid;
        } // 'mid'를 포함하여 검색 공간의 오른쪽에 있는 모든 요소를 버립니다.
        else if (p < arr[mid]) {
            return runRecursive(arr, left, mid - 1, p);
        } // 'mid'를 포함하여 검색 공간의 왼쪽에 있는 모든 요소를 버립니다.
        else {
            return runRecursive(arr, mid + 1, right, p);
        }
    }
}