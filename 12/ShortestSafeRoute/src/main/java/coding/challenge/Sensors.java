package coding.challenge;

import java.util.ArrayDeque;
import java.util.Queue;

public class Sensors {
    private Sensors() {
        throw new AssertionError("Cannot be instantiated");
    }

    // a board cell
    private static class Cell {
        int r;        // 행(row)
        int c;        // 열(column)
        int distance; // 현재 칸에서 시작 칸까지의 거리

        Cell(int r, int c, int distance) {
            this.r = r;
            this.c = c;
            this.distance = distance;
        }
    };

    // m×n 행렬
    private static final int M = 10;
    private static final int N = 10;

    // 한 칸에서 이동 가능한 4가지 방향(위, 오른쪽, 아래, 왼쪽)
    private static final int ROW_4[] = {-1, 0, 0, 1};
    private static final int COL_4[] = {0, -1, 1, 0};

    // 한 칸에서 이동 가능한 8가지 방향(위, 오른쪽, 아래, 왼쪽, 대각선 4가지 뱡향)
    private static final int ROW_8[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int COL_8[] = {-1, 0, 1, -1, 1, -1, 0, 1};

    // 주어진 행렬의 첫 번째 열에서 마지막 열까지의 최단 경로 찾기
    public static int shortestPath(int[][] board) {
        // 센서와 인접한 칸을 안전하지 않은 칸으로 표시
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 8; k++) {
                    if (board[i][j] == 0 && isValid(i + ROW_8[k], j + COL_8[k])
                      && board[i + ROW_8[k]][j + COL_8[k]] == 1) {
                        board[i + ROW_8[k]][j + COL_8[k]] = -1;
                    }
                }
            }
        }

        // 행렬 원소 업데이트
        for (int i = 0; i < M; i++) {
            System.out.println();
            for (int j = 0; j < N; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                }
                System.out.print(board[i][j] + "  ");
            }
        }

        // 너비 우선 탐색(BFS) 기반으로 순회하는 메서드를 호출해 최단 경로 찾기
        return findShortestPath(board);
    }

    // 첫 번째 열에서 마지막 열까지 행렬을 횡단하는 데 필요한 최소 단계 수(최단 경로 또는 거리) 찾기
    private static int findShortestPath(int[][] board) {
        // 칸을 방문했는지 저장합니다.
        boolean[][] visited = new boolean[M][N];

        Queue<Cell> queue = new ArrayDeque<>();

        // 첫 번째 열의 모든 칸을 처리합니다.
        for (int r1 = 0; r1 < M; r1++) {
            // 칸이 안전한 경우 방문했다고 표시하고 거리를 0으로 지정하여 큐에 넣습니다.
            if (board[r1][0] == 1) {
                queue.add(new Cell(r1, 0, 0));
                visited[r1][0] = true;
            }
        }

        while (!queue.isEmpty()) {
            // 큐에서 맨 앞 노드를 팝하여 처리합니다.
            int rIdx = queue.peek().r;
            int cIdx = queue.peek().c;
            int dist = queue.peek().distance;

            queue.poll();

            // 목적지를 발견하면 최소 거리를 반환합니다.
            if (cIdx == N - 1) {
                return (dist + 1);
            }

            // 현재 칸에서 이동할 수 있는 4개의 칸을 모두 확인하고 유효한 칸을 큐에 추가합니다.
            for (int k = 0; k < 4; k++) {
                if (isValid(rIdx + ROW_4[k], cIdx + COL_4[k])
                  && isSafe(board, visited, rIdx + ROW_4[k], cIdx + COL_4[k])) {
                    // 칸을 방문했다고 표시하고 거리에 1을 더해서 큐에 밀어 넣습니다.
                    visited[rIdx + ROW_4[k]][cIdx + COL_4[k]] = true;
                    queue.add(new Cell(rIdx + ROW_4[k], cIdx + COL_4[k], dist + 1));
                }
            }
        }

        return -1;
    }

    // 현재 위치에서 (r, c) 칸으로 이동하는 것이 안전한지 확인합니다.
    private static boolean isSafe(int[][] board,
      boolean visited[][], int r, int c) {
        return (board[r][c] == 1 && !visited[r][c]);
    }

    // (r, c) 칸이 행렬에 있는지 확인합니다.
    private static boolean isValid(int r, int c) {
        return (r < M && c < N && r >= 0 && c >= 0);
    }
}
