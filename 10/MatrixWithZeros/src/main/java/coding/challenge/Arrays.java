package coding.challenge;

public final class Arrays {
    private Arrays() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void alignZeros(int[][] m) {
        if (m == null || m.length == 0) {
            throw new IllegalArgumentException("The given matrix cannot be null or empty");
        }

        boolean firstRowHasZeros = false;
        boolean firstColumnHasZeros = false;

        // 첫 번째 행에 0이 하나 이상 있는지 확인합니다.
        for (int j = 0; j < m[0].length; j++) {
            if (m[0][j] == 0) {
                firstRowHasZeros = true;
                break;
            }
        }

        // 첫 번째 열에 0이 하나 이상 있는지 확인합니다.
        for (int i = 0; i < m.length; i++) {
            if (m[i][0] == 0) {
                firstColumnHasZeros = true;
                break;
            }
        }

        // 행렬의 나머지 영역에 있는 모든 0을 찾습니다.
        for (int i = 1; i < m.length; i++) {
            for (int j = 1; j < m[0].length; j++) {
                if (m[i][j] == 0) {
                    m[i][0] = 0;
                    m[0][j] = 0;
                }
            }
        }

        // 첫 번째 열을 순회한 후 값이 0인 행을 찾아 해당 행을 모두 0으로 설정합니다.
        for (int i = 1; i < m.length; i++) {
            if (m[i][0] == 0) {
                setRowOfZero(m, i);
            }
        }

        // 첫 번째 행을 순회한 후 값이 0인 열을 찾아 해당 열을 모두 0으로 설정합니다.
        for (int j = 1; j < m[0].length; j++) {
            if (m[0][j] == 0) {
                setColumnOfZero(m, j);
            }
        }

        // 첫 번째 행에 0이 하나 이상 있으면 전체 행을 0으로 설정합니다.
        if (firstRowHasZeros) {
            setRowOfZero(m, 0);
        }

        // 첫 번째 열에 0이 하나 이상 있으면 전체 열을 0으로 설정합니다.
        if (firstColumnHasZeros) {
            setColumnOfZero(m, 0);
        }
    }

    private static void setRowOfZero(int[][] m, int r) {
        for (int j = 0; j < m[0].length; j++) {
            m[r][j] = 0;
        }
    }

    private static void setColumnOfZero(int[][] m, int c) {
        for (int i = 0; i < m.length; i++) {
            m[i][c] = 0;
        }
    }
}