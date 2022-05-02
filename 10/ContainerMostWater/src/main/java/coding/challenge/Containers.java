package coding.challenge;

public final class Containers {
    private Containers() {
        throw new AssertionError("Cannot be instantiated");
    }

    /* O(n^2) */
    public static int maxArea(int[] heights) {
        if (heights == null) {
            throw new IllegalArgumentException("The given array cannot be null");
        }

        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                // 각 (i, j) 쌍을 순회합니다.
                maxArea = Math.max(maxArea, Math.min(heights[i], heights[j]) * (j - i));
            }
        }

        return maxArea;
    }

    /* O(n) */
    public static int maxAreaOptimized(int[] heights) {
        if (heights == null) {
            throw new IllegalArgumentException("The given array cannot be null");
        }

        int maxArea = 0;

        int i = 0; // 왼쪽 포인터
        int j = heights.length - 1; // 오른쪽 포인터

        // 면적은 음수가 될 수 없으므로 i는 j보다 클 수 없습니다.
        while (i < j) {
            // 각 쌍에 대해 면적을 계산합니다.
            maxArea = Math.max(maxArea, Math.min(heights[i], heights[j]) * (j - i));

            if (heights[i] <= heights[j]) {
                i++; // 왼쪽 포인터가 오른쪽 포인터보다 작습니다.
            } else {
                j--; // 오른쪽 포인터가 왼쪽 포인터보다 작습니다.
            }
        }

        return maxArea;
    }
}