package coding.challenge;

public final class Bunks {
    private Bunks() {
        throw new AssertionError("Cannot be instantiated");
    }

    // O(n)
    public static int circularTour(int[] fuel, int[] dist) {
        int sumRemainingFuel = 0; // 현재 잔여 연료를 저장합니다.
        int totalFuel = 0;        // 전체 잔여 연료를 저장합니다.
        int start = 0;

        for (int i = 0; i < fuel.length; i++) {
            int remainingFuel = fuel[i] - dist[i];

            // (i - 1)의 잔여 연료 합이 >= 0이면 방문을 이어갑니다.
            if (sumRemainingFuel >= 0) {
                sumRemainingFuel += remainingFuel;
            // 그렇지 않다면 시작 인덱스를 현재 인덱스로 초기화합니다.
            } else {
                sumRemainingFuel = remainingFuel;
                start = i;
            }

            totalFuel += remainingFuel;
        }

        if (totalFuel >= 0) {
            return start;
        } else {
            return -1;
        }
    }
}