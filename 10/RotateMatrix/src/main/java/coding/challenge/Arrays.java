package coding.challenge;

public final class Arrays {
    private Arrays() {
        throw new AssertionError("Cannot be instantiated");
    }

    // 별도의 행렬에서 주어진 행렬을 회전
    public static int[][] rotateInNew(int[][] m) {
        if (m == null || m.length == 0) {
            throw new IllegalArgumentException("The given matrix cannot be null or empty");
        }

        if (m.length != m[0].length) {
            throw new IllegalArgumentException("The given matrix must be of type nxn");
        }

        int r[][] = new int[m.length][m.length];

        int offset = m.length - 1;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                r[offset - j][i] = m[i][j];
            }
        }

        return r;
    }

    // 주어진 행렬을 O(n^2)의 시간 복잡도와 O(1)의 공간 복잡도로 회전
    public static boolean rotateWithTranspose(int m[][]) {
        if (m == null || m.length == 0) {
            throw new IllegalArgumentException("The given matrix cannot be null or empty");
        }

        if (m.length != m[0].length) {
            throw new IllegalArgumentException("The given matrix must be of type nxn");
        }

        transpose(m);

        for (int i = 0; i < m[0].length; i++) {
            for (int j = 0, k = m[0].length - 1; j < k; j++, k--) {
                int temp = m[j][i];
                m[j][i] = m[k][i];
                m[k][i] = temp;
            }
        }

        return true;
    }

    // 행렬의 전치
    private static void transpose(int m[][]) {
        for (int i = 0; i < m.length; i++) {
            for (int j = i; j < m[0].length; j++) {
                int temp = m[j][i];
                m[j][i] = m[i][j];
                m[i][j] = temp;
            }
        }
    }

    // 고리를 기반으로 고리 회전
    // 주어진 행렬을 O(n^2)의 시간 복잡도와 O(1)의 공간 복잡도로 회전
    public static boolean rotateRing(int[][] m) {
        if (m == null || m.length == 0) {
            throw new IllegalArgumentException("The given matrix cannot be null or empty");
        }

        if (m.length != m[0].length) {
            throw new IllegalArgumentException("The given matrix must be of type nxn");
        }

        int len = m.length;

        // 시계 반대 방향으로 회전합니다.
        for (int i = 0; i < len / 2; i++) {
            for (int j = i; j < len - i - 1; j++) {
                int temp = m[i][j];

                // 오른쪽 → 위쪽
                m[i][j] = m[j][len - 1 - i];

                // 아래쪽 → 오른쪽
                m[j][len - 1 - i] = m[len - 1 - i][len - 1 - j];

                // 왼쪽 → 아래쪽
                m[len - 1 - i][len - 1 - j] = m[len - 1 - j][i];

                // 위쪽 → 왼쪽
                m[len - 1 - j][i] = temp;
            }
        }

        // 시계 방향으로 회전합니다.
        /*
        for (int i = 0; i < len / 2; i++) {
            for (int j = i; j < len - 1 - i; j++) {
                int temp = m[i][j];
                
                // 오른쪽 → 위쪽
                m[i][j] = m[len - 1 - j][i];

                // 아래쪽 → 왼쪽
                m[len - 1 - j][i] = m[len - 1 - i][len - 1 - j];

                // 오른쪽 → 아래쪽
                m[len - 1 - i][len - 1 - j] = m[j][len - 1 - i];

                // 위쪽 → 오른쪽
                m[j][len - 1 - i] = temp;
            }
        } */

        return true;
    }
}