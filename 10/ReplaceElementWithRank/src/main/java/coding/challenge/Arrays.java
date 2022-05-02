package coding.challenge;

import java.util.Map;
import java.util.TreeMap;

public final class Arrays {
    private Arrays() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void replace(int[] m) {
        if (m == null) {
            throw new IllegalArgumentException("The given array cannot be null");
        }

        Map<Integer, Integer> treemap = new TreeMap<>();

        // 요소와 인덱스를 저장합니다.
        for (int i = 0; i < m.length; i++) {
            treemap.put(m[i], i);
        }

        // 순위는 1부터 시작합니다.
        int rank = 1;

        // Map 객체를 이용해 반복 실행하고 각 요소를 순위로 바꿉니다.
        for (Map.Entry<Integer, Integer> entry : treemap.entrySet()) {
            m[entry.getValue()] = rank++;
        }
    }
}