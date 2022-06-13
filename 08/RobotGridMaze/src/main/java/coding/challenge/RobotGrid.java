package coding.challenge;

import java.awt.Point;
import java.util.Set;

public final class RobotGrid {
    private RobotGrid() {
        throw new AssertionError("Cannot be instantiated");
    }

    // 일반 재귀 알고리즘
    // 왼쪽 위 모서리 (m, n)에서 재귀로 이동하여 오른쪽 아래 모서리 (0, 0)에 도달합니다.
    public static boolean computePath(int m, int n, boolean[][] maze, Set<Point> path) {
        if (path == null || maze == null) {
            throw new IllegalArgumentException("Path and maze cannot be null");
        }

        // 격자 지도에서 벗어났기 때문에 반환합니다.
        if (m < 0 || n < 0) {
            return false;
        }

        // 이 칸으로는 이동할 수 없습니다.
        if (maze[m][n]) {
            return false;
        }

        // 목표에 도착했습니다(목표는 오른쪽 아래 칸입니다).
        if (((m == 0) && (n == 0))
                || computePath(m, n - 1, maze, path) // 또는 오른쪽으로 이동할 수 있습니다.
                || computePath(m - 1, n, maze, path)) { // 또는 아래쪽으로 이동할 수 있습니다.
            // 현재 칸을 경로에 추가합니다.
            path.add(new Point(m, n));

            return true;
        }

        return false;
    }

    // 메모이제이션
    // 왼쪽 위 모서리 (m, n)에서 재귀로 이동하여 오른쪽 아래 모서리 (0, 0)에 도달합니다.
    public static boolean computePath(int m, int n, boolean[][] maze, Set<Point> path, Set<Point> visitFailed) {
        if (path == null || maze ==null || visitFailed == null) {
            throw new IllegalArgumentException("Path, maze and visitFailed cannot be null");
        }

        // 격자 지도에서 벗어났기 때문에 반환합니다.
        if (m < 0 || n < 0) {
            return false;
        }

        // 이 칸으로는 이동할 수 없습니다.
        if (maze[m][n]) {
            return false;
        }

        Point cell = new Point(m, n);

        // 이미 해당 칸을 방문한 적이 있는지 확인
        if (visitFailed.contains(cell)) {
            return false;
        }

        // 목표에 도착했습니다(목표는 오른쪽 아래 칸입니다).
        if (((m == 0) && (n == 0))
                || computePath(m, n - 1, maze, path, visitFailed) // 또는 오른쪽으로 이동할 수 있습니다.
                || computePath(m - 1, n, maze, path, visitFailed)) { // 또는 아래쪽으로 이동할 수 있습니다.
            // 현재 칸을 경로에 추가합니다.
            path.add(cell);

            return true;
        }

        visitFailed.add(cell);

        return false;
    }
}