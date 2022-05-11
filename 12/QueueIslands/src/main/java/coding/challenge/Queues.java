package coding.challenge;

import java.util.ArrayDeque;
import java.util.Queue;

public final class Queues {
    private Queues() {
        throw new AssertionError("Cannot be instantiated");
    }

    private static class Cell {
        int r, c;

        public Cell(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    // 한 칸에서 이동 가능한 방향은 8가지가 있습니다.
    private static final int POSSIBLE_MOVEMENTS = 8;

    // 위, 오른쪽, 아래, 왼쪽 및 4가지 대각선 방향
    private static final int[] ROW = {-1, -1, -1, 0, 1, 0, 1, 1};
    private static final int[] COL = {-1, 1, 0, -1, -1, 1, 0, 1};

    public static int islands(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // 칸을 방문했는지 저장합니다.
        boolean[][] flagged = new boolean[m][n];

        int island = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1 && !flagged[i][j]) {
                    resolve(matrix, flagged, i, j);
                    island++;
                }
            }
        }

        return island;
    }

    private static void resolve(int[][] matrix, boolean[][] flagged, int i, int j) {
        Queue<Cell> queue = new ArrayDeque<>();
        queue.add(new Cell(i, j));

        // 주어진 칸을 방문했다고 표시합니다.
        flagged[i][j] = true;

        while (!queue.isEmpty()) {
            int r = queue.peek().r;
            int c = queue.peek().c;
            queue.poll();

            // 현재 칸에서 이동 가능한 8개의 칸을 모두 확인하고 유효한 칸을 큐에 추가합니다.
            for (int k = 0; k < POSSIBLE_MOVEMENTS; k++) {
                // 위치가 잘못된 경우 이 칸을 건너뜁니다.
                if (isValid(matrix, r + ROW[k], c + COL[k], flagged)) {
                    flagged[r + ROW[k]][c + COL[k]] = true;
                    queue.add(new Cell(r + ROW[k], c + COL[k]));
                }
            }
        }
    }

    // 현재 위치에서 (r, c) 칸으로 이동하는 것이 유효한지 확인합니다.
    private static boolean isValid(int[][] matrix, int r, int c,
      boolean[][] flagged) {
        return (r >= 0) && (r < flagged.length)
          && (c >= 0) && (c < flagged[0].length)
          && (matrix[r][c] == 1 && !flagged[r][c]);
    }
}