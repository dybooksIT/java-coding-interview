package coding.challenge;

public class Main {
    public static void main(String[] args) {
        int[] dist1 = {5, 4, 6, 3, 5, 7};
        int[] fuel1 = {3, 3, 5, 5, 6, 8};

        // 정답: 인덱스 1
        int[] dist2 = {2, 4, 1};
        int[] fuel2 = {0, 4, 3};

        // 정답: 인덱스 1
        int[] dist3 = {6, 5, 3, 5};
        int[] fuel3 = {4, 6, 7, 4};

        // 해가 없으므로 -1 반환
        int[] dist4 = {1, 3, 3, 4, 5};
        int[] fuel4 = {1, 2, 3, 4, 5};

        // 정답 인덱스 2
        int[] dist5 = {4, 6, 6};
        int[] fuel5 = {6, 3, 7};

        int startPoint1 = Bunks.circularTour(fuel1, dist1);
        System.out.println("Start point: " + startPoint1);

        int startPoint2 = Bunks.circularTour(fuel2, dist2);
        System.out.println("Start point: " + startPoint2);

        int startPoint3 = Bunks.circularTour(fuel3, dist3);
        System.out.println("Start point: " + startPoint3);

        int startPoint4 = Bunks.circularTour(fuel4, dist4);
        System.out.println("Start point: " + startPoint4);

        int startPoint5 = Bunks.circularTour(fuel5, dist5);
        System.out.println("Start point: " + startPoint5);
    }
}