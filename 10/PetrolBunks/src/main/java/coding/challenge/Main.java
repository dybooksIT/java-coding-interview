package coding.challenge;

public class Main {
    public static void main(String[] args) {
        int[] dist = {5, 4, 6, 3, 5, 7};
        int[] fuel = {3, 3, 5, 5, 6, 8};

        // 정답: 인덱스 1
        // int[] dist = {2, 4, 1};
        // int[] fuel = {0, 4, 3};

        // 정답: 인덱스 1
        // int[] dist = {6, 5, 3, 5};
        // int[] fuel = {4, 6, 7, 4};

        // 해가 없으므로 -1 반환
        // int[] dist = {1, 3, 3, 4, 5};
        // int[] fuel = {1, 2, 3, 4, 5};

        // 정답 인덱스 2
        // int[] dist = {4, 6, 6};
        // int[] fuel = {6, 3, 7};

        int startPoint = Bunks.circularTour(fuel, dist);
        System.out.println("Start point: " + startPoint);
    }
}