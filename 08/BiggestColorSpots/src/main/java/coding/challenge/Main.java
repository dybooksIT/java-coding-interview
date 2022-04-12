package coding.challenge;

import java.util.Random;
 
public class Main {
    public static void main(String[] args) {
        int cols = 5;
        int rows = 5;
        int colors = 3; // 각 영역은 1, 2, 3번 색을 가질 수 있습니다.
        
        Random rnd = new Random();

        int[][] a = new int[rows][cols];

        // 랜덤으로 색 추가
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                a[i][j] = 1 + rnd.nextInt(colors);
            }
        }

        // 화면에 영역 색 표시
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }
        BiggestColorSpots spots = new BiggestColorSpots();
        spots.determineBiggestColorSpot(cols, rows, a);                
    }
}