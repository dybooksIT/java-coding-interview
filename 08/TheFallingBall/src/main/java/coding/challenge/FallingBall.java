package coding.challenge;

public final class FallingBall {
    private FallingBall() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void computePath(int prevElevation, int i, int j, int rows, int cols, int[][] elevations) {
        if (elevations == null) {
            throw new IllegalArgumentException("Elevations cannot be null");
        }

        // 공이 격자 지도의 영역 안에 있는지 확인합니다.
        if (i >= 0 && i <= (rows - 1) && j >= 0 && j <= (cols - 1)) {
            int currentElevation = elevations[i][j];

            // 공이 이전 칸에서 현재 칸으로 떨어질 수 있는지 확인합니다.
            if (prevElevation >= currentElevation && currentElevation > 0) {
                // 다음 이동을 계산할 때 사용하기 위해 현재 고도를 저장합니다.
                prevElevation = currentElevation;

                // 이 칸을 방문했다고 표시합니다.
                elevations[i][j] = 0;

                // 공을 이동할 수 있는지 확인합니다.
                computePath(prevElevation, i, j - 1, rows, cols, elevations);
                computePath(prevElevation, i - 1, j, rows, cols, elevations);
                computePath(prevElevation, i, j + 1, rows, cols, elevations);
                computePath(prevElevation, i + 1, j, rows, cols, elevations);
            }
        }
    }
}