package coding.challenge;

public class KnightTour {
    private final int n;

    public KnightTour(int n) {

        if (n <= 1) {
            throw new IllegalArgumentException("The grid must be bigger than " + n + "x" + n);
        }

        this.n = n;
    }

    // 나이트가 이동할 수 있는 8가지 이동 경로
    public static final int COL[] = {1, 2, 2, 1, -1, -2, -2, -1, 1};
    public static final int ROW[] = {2, 1, -1, -2, -2, -1, 1, 2, 2};

    public void knightTour(int r, int c, int cell, int visited[][]) {
        if (r < 0 || c < 0 || cell < 0) {
            throw new IllegalArgumentException("The r, c and cell cannot be negative");
        }

        if (visited == null) {
            throw new IllegalArgumentException("The visited[][] cannot be null");
        }

        // 현재 칸을 방문했다고 표시합니다.
        visited[r][c] = cell;

        // 이미 경로를 찾았습니다.
        if (cell >= n * n) {
            print(visited);
            // 이전 경로로 돌아가며 방문 표시를 취소합니다.
            visited[r][c] = 0;
            return;
        }

        // 가능한 모든 이동 방향을 확인하고 각각의 유효한 이동에 관해 반복합니다.
        for (int i = 0; i < (ROW.length - 1); i++) {
            int newR = r + ROW[i];
            int newC = c + COL[i];

            // 새 위치가 유효하며 방문한 적이 없는 칸인지 확인합니다.
            if (isValid(newR, newC) && visited[newR][newC] == 0) {
                knightTour(newR, newC, cell + 1, visited);
            }
        }

        // 이전 경로로 돌아가며 방문 표시를 취소합니다.
        visited[r][c] = 0;
    }

    // (r, c)가 유효한 체스판 좌표인지 확인합니다.
    private boolean isValid(int r, int c) {
        return !(r < 0 || c < 0 || r >= n || c >= n);
    }

    // 결과 경로를 체스판 형식으로 출력합니다.
    private void print(int[][] visited) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.format("%3s", visited[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}