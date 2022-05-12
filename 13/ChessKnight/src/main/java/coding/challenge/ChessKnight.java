package coding.challenge;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class ChessKnight {
    private class Node {
        // (r, c): 체스판 좌표, (row, column)
        // distance: 시작 칸과의 최소 거리
        private final int r;
        private final int c;
        private int distance;

        private Node(int r, int c) {
            this.r = r;
            this.c = c;
        }

        private Node(int r, int c, int distance) {
            this.r = r;
            this.c = c;
            this.distance = distance;
        }
    }

    // 기사(knight)가 이동 가능한 8가지 수
    private static final int[] ROW = {2, 2, -2, -2, 1, 1, -1, -1};
    private static final int[] COL = {-1, 1, 1, -1, 2, -2, 2, -2};

    public int countknightMoves(int rs, int cs, int rt, int ct, int n) {
        // 소스(시작 칸) 좌표
        Node startCell = new Node(rs, cs);

        // 목적지(도착 칸) 좌표
        Node targetCell = new Node(rt, ct);

        return countknightMoves(startCell, targetCell, n);
    }

    // 너비 우선 탐색을 사용해 기사가 시작 칸에서 현재 칸까지 이동한 최소 단계 수를 찾습니다.
    private int countknightMoves(Node startCell, Node targetCell, int n) {
        // 방문한 칸을 저장합니다.
        Set<Node> visited = new HashSet<>();

        // 큐를 생성하고 시작 칸을 큐에 삽입합니다.
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(startCell);

        while (!queue.isEmpty()) {
            Node cell = queue.poll();

            int r = cell.r;
            int c = cell.c;
            int distance = cell.distance;

            // 도착 칸에 도달하면 거리를 반환합니다.
            if (r == targetCell.r && c == targetCell.c) {
                return distance;
            }

            // 방문하지 않은 칸입니다.
            if (!visited.contains(cell)) {
                // 현재 칸을 방문했다고 표시합니다.
                visited.add(cell);

                // 각 유효한 이동을 큐에 추가합니다(이동 가능한 8가지 수가 있음).
                for (int i = 0; i < 8; ++i) {
                    // 체스판의 현재 위치에서 기사의 새로운 유효한 위치를 가져와서
                    // 거리에 1을 더하여 큐에 넣습니다.
                    int rt = r + ROW[i];
                    int ct = c + COL[i];

                    if (valid(rt, ct, n)) {
                        queue.add(new Node(rt, ct, distance + 1));
                    }
                }
            }
        }

        // 경로 탐색이 불가능한 경우에는 에러 코드(Integer.MAX_VALUE)를 반환합니다.
        return Integer.MAX_VALUE;
    }

    // (r, c)가 유효한지 확인합니다(기사가 체스판 밖으로 나갈 수 없기 때문).
    private static boolean valid(int r, int c, int n) {
        if (r < 0 || c < 0 || r >= n || c >= n) {
            return false;
        }

        return true;
    }
}