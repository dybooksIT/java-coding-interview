package coding.challenge;

public class Main {
    public static void main(String[] args) {
        int s = 5;

        // 동일한 행렬 3개
        int[][] m1 = new int[s][s]; // rotateInNew 메서드를 호출할 때 사용
        int[][] m2 = new int[s][s]; // rotateWithTranspose 메서드를 호출할 때 사용
        int[][] m3 = new int[s][s]; // rotateRing 메서드를 호출할 때 사용

        // 숫자 0, 1, 2, ..., (s - 1)로 행렬을 초기화
        int v = 0;
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                m1[i][j] = ++v;
                m2[i][j] = m1[i][j];
                m3[i][j] = m1[i][j];
            }
        }

        System.out.println("Initial matrix:");
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                System.out.format("%4s", m1[i][j]);
            }

            System.out.println();
        }

        System.out.println();
        int[][] result = Arrays.rotateInNew(m1);
        System.out.println("Rotated counterclockwise by 90 degrees via new matrix:");
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                System.out.format("%4s", result[i][j]);
            }

            System.out.println();
        }

        System.out.println();
        Arrays.rotateWithTranspose(m2);
        System.out.println("Rotated counterclockwise by 90 degrees via transpose:");
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                System.out.format("%4s", m2[i][j]);
            }

            System.out.println();
        }

        System.out.println();
        Arrays.rotateRing(m3);
        System.out.println("Rotated counterclockwise by 90 degrees ring by ring:");
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                System.out.format("%4s", m3[i][j]);
            }

            System.out.println();
        }
    }
}