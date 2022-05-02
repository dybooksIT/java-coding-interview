package coding.challenge;

public final class Arrays {
    private Arrays() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int findAbsoluteDistinct(int[] m) {
        if (m == null) {
            return -1;
        }

        int count = m.length;

        int left = 0;
        int right = m.length - 1;

        while (left < right) {
            // 왼쪽과 오른쪽에서 중복 요소를 제거합니다.
            while (left < right && m[left] == m[left + 1]) {
                count--;
                left++;
            }

            while (right > left && m[right] == m[right - 1]) {
                count--;
                right--;
            }

            // 요소 하나만 남습니다.
            if (left == right) {
                break;
            }

            int sum = m[left] + m[right];

            // 제로섬 쌍을 만나면 고유 요소 수를 줄입니다.
            if (sum == 0) {
                count--;

                left++;
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        return count;
    }
}