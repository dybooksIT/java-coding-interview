package coding.challenge;

public final class Arrays {
    private Arrays() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int find(int[] m, int x) {
        if (m == null || m.length == 0) {
            return -1;
        }

        int left = 0;
        int right = m.length - 1;

        while (left <= right) {
            // 검색 대상 배열의 중앙 인덱스를 지정합니다.
            int middle = (left + right) / 2;

            // 목푯값을 찾았습니다.
            if (m[middle] == x) {
                return middle;
            }

            // 배열의 오른쪽 영역(m[middle ... right])이 정렬된 상태인지 확인합니다.
            if (m[middle] <= m[right]) {
                // 목푯값 x가 m[middle ... right] 범위 안에 있는지 확인합니다.
                if (x > m[middle] && x <= m[right]) {
                    left = middle + 1;  // 오른쪽 영역에서 검색합니다.
                } else {
                    right = middle - 1;	// 왼쪽 영역에서 검색합니다.
                }
            } else { // 배열의 왼쪽 영역(m[left ... middle])이 정렬된 상태입니다.
                // 목푯값 x가 m[left ... middle] 범위 안에 있는지 확인합니다.
                if (x >= m[left] && x < m[middle]) {
                    right = middle - 1; // 왼쪽 영역에서 검색합니다.
                } else {
                    left = middle + 1;  // 오른쪽 영역에서 검색합니다.
                }
            }
        }

        return -1;
    }
}