package coding.challenge;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int cols = 5;
        int rows = 5;

        // 각 영역은 고도에 해당하는 1, 2, 3, 4, 5(가장 높음)라는 값을 갖습습니다.
        int elevation = 5;

        Random rnd = new Random();

        int[][] elevations = new int[rows][cols];

        // 임의의 고도를 추가합니다.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                elevations[i][j] = 1 + rnd.nextInt(elevation);
            }
        }

        // 화면에 각 격자 영역에 들어 있는 고도의 값을 표시합니다.
        System.out.println("Initial grid:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.format("%2s", elevations[i][j]);
            }
            System.out.println();
        }
        
        System.out.println("Middle cell has elevation: " + elevations[rows / 2][cols / 2]);
        FallingBall.computePath(elevations[rows / 2][cols / 2], rows / 2, cols / 2, rows, cols, elevations);

        System.out.println("Result grid:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.format("%2s", elevations[i][j]);
            }
            System.out.println();
        }
    }
}