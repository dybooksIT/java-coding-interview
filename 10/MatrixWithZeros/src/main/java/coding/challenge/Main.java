package coding.challenge;

public class Main {
    public static void main(String[] args) {
        int r = 5;
        int c = 8;

        // 동일한 행렬 3개
        int[][] m = new int[r][c];

        // 숫자 0, 1, 2, ... ,(s - 1)로 행렬을 초기화
        int v = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (Math.random() < 0.95d) {
                    m[i][j] = ++v;
                } else {
                    m[i][j] = 0;
                }
            }
        }

        System.out.println("Initial matrix:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.format("%4s", m[i][j]);
            }
            System.out.println();
        }

        System.out.println();
        Arrays.alignZeros(m);

        System.out.println("Result:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.format("%4s", m[i][j]);
            }
            System.out.println();
        }
    }
}