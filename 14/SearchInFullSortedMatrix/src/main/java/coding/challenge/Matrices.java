package coding.challenge;

public final class Matrices {
    private Matrices() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static boolean search(int[][] matrix, int element) {
        if (matrix== null || matrix.length == 0) {
            return false;
        }

        int rows = matrix.length;    // 행의 개수
        int cols = matrix[0].length; // 열의 개수

        // 검색 공간은 [0, (rows * cols) - 1] 범위의 배열입니다.
        int left = 0;
        int right = (rows * cols) - 1;

        // 이진 검색을 시작합니다.
        while (left <= right) {
            int mid = (left + right) / 2;
            int midElement = matrix[mid / cols][mid % cols];

            if (element == midElement) {
                return true;
            } else if (element < midElement) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }
}