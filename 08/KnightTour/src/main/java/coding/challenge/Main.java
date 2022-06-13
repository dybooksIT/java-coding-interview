package coding.challenge;

public class Main {
    public static final int GRID_SIZE = 5; // 최솟값 5

    public static void main(String[] args) {
        KnightTour knightTour = new KnightTour(GRID_SIZE);

        // visited[][]에 현재 경로를 저장합니다.
        int visited[][] = new int[GRID_SIZE][GRID_SIZE];

        int cell = 1;

        // 구석의 칸 (0, 0)에서 나이트 투어를 시작합니다.
        knightTour.knightTour(0, 0, cell, visited);
    }
}