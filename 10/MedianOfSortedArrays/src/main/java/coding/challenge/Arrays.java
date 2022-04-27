package coding.challenge;

public final class Arrays {
    private Arrays() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static float median(int[] q, int[] p) {
        if (q == null || p == null) {
            return -1;
        }

        int lenQ = q.length;
        int lenP = p.length;

        if (lenQ > lenP) {
            swap(q, p);
        }

        int qPointerMin = 0;
        int qPointerMax = q.length;
        int midLength = (q.length + p.length + 1) / 2;

        int qPointer;
        int pPointer;

        while (qPointerMin <= qPointerMax) {
            qPointer = (qPointerMin + qPointerMax) / 2;
            pPointer = midLength - qPointer;

            // 이진 검색을 수행합니다.
            if (qPointer < q.length && p[pPointer - 1] > q[qPointer]) {
                // qPointer를 증가시켜야 합니다.
                qPointerMin = qPointer + 1;
            } else if (qPointer > 0 && q[qPointer - 1] > p[pPointer]) {
                // qPointer를 감소시켜야 합니다.
                qPointerMax = qPointer - 1;
            } else { // we found the poper qPointer    
                int maxLeft = 0;

                if (qPointer == 0) { // 배열 q의 첫 번째 요소인가?
                    maxLeft = p[pPointer - 1];
                } else if (pPointer == 0) { // 배열 p의 첫 번째 요소인가?
                    maxLeft = q[qPointer - 1];
                } else { // 중간 어딘가에 위치한 요소라면 → 최댓값을 찾습니다.
                    maxLeft = Integer.max(q[qPointer - 1], p[pPointer - 1]);
                }

                // 배열 q와 p의 길이의 합이 홀수이면, 왼쪽 영역의 최댓값을 반환합니다.
                if ((q.length + p.length) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;

                if (qPointer == q.length) { // 배열 q의 마지막 요소인가?
                    minRight = p[pPointer];
                } else if (pPointer == p.length) { // 배열 p의 마지막 요소인가?
                    minRight = q[qPointer];
                } else { // 중간 어딘가에 위치한 요소라면 → 최솟값을 찾습니다.
                    minRight = Integer.min(q[qPointer], p[pPointer]);
                }

                return (maxLeft + minRight) / 2.0f;
            }
        }
        return -1;
    }

    // j가 항상 0보다 크도록 배열 q가 p보다 작아야 합니다.
    private static void swap(int[] q, int[] p) {
        int[] aux = q;
        q = p;
        p = aux;
    }
}