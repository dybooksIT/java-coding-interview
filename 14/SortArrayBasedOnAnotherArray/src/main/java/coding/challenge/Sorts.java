package coding.challenge;

import java.util.Map;
import java.util.TreeMap;

public final class Sorts {
    private Sorts() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void custom(int[] firstArr, int[] secondArr) {
        if (firstArr == null || secondArr == null) {
            throw new IllegalArgumentException("The given input cannot be null");
        }

        // 데이터를 정렬하여 저장하는 TreeMap을 사용하여 첫 번째 배열 각 요소의 빈도를 저장합니다.
        Map<Integer, Integer> frequencyMap = new TreeMap<>();

        for (int i = 0; i < firstArr.length; i++) {
            frequencyMap.putIfAbsent(firstArr[i], 0);
            frequencyMap.put(firstArr[i], frequencyMap.get(firstArr[i]) + 1);
        }

        // 첫 번째 배열의 요소 덮어쓰기
        int index = 0;

        for (int i = 0; i < secondArr.length; i++) {
            // 현재 요소가 'frequencyMap'에 있으면 첫 번째 배열에 현재 요소를 n번 삽입합니다.
            // n은 첫 번째 배열에서 해당 요소의 빈도를 나타냅니다.
            int n = frequencyMap.getOrDefault(secondArr[i], 0);

            while (n-- > 0) {
                firstArr[index++] = secondArr[i];
            }

            // 요소를 Map에서 삭제합니다.
            frequencyMap.remove(secondArr[i]);
        }

        // 나머지 요소(첫 번째 배열에는 있지만 두 번째 배열에는 없는 요소)를 복사합니다.
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int count = entry.getValue();

            while (count-- > 0) {
                firstArr[index++] = entry.getKey();
            }
        }
    }
}