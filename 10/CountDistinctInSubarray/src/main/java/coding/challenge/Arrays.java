package coding.challenge;

import java.util.HashMap;
import java.util.Map;

public final class Arrays {
    private Arrays() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void find(int[] m, int n) {
        if (m == null) {
            throw new IllegalArgumentException("The given array cannot be null");
        }

        if (n <= 0) {
            throw new IllegalArgumentException("The given sub-array size cannot be <= 0");
        }

        // 크기가 n인 현재 창에 요소의 빈도를 저장합니다.
        Map<Integer, Integer> frequency = new HashMap<>();

        // 크기가 n인 모든 하위 배열의 고유한 요소 수를 계산합니다.
        int countDistinct = 0;

        for (int i = 0; i < m.length; i++) {
            // 첫 n개 요소를 건너뜁니다.
            if (i >= n) {
                // 하위 배열에서 첫 번째 요소를 제거합니다.
                frequency.putIfAbsent(m[i - n], 0);
                frequency.put(m[i - n], frequency.get(m[i - n]) - 1);

                // 0이 남아 있으면 고유 요소 수를 줄입니다.
                if (frequency.get(m[i - n]) == 0) {
                    countDistinct--;
                }
            }

            // 하위 배열에 현재 요소를 추가합니다.
            frequency.putIfAbsent(m[i], 0);
            frequency.put(m[i], frequency.get(m[i]) + 1);

            // 해당 요소가 현재 창에서 첫 번째인지 확인합니다.
            if (frequency.get(m[i]) == 1) {
                countDistinct++;
            }

            if (i >= n - 1) {
                System.out.println("Distinct elements in the "
                  + "sub-array [" + (i - n + 1) + ", " + i + "]" + " is "
                  + countDistinct);
            }
        }
    }
}