package coding.challenge;

import java.util.Stack;

public final class Bars {
    private Bars() {
        throw new AssertionError("Cannot be instantiated");
    }

    // 실행 시간이 O(n), left[] 배열을 저장하기 위한 보조 공간이 O(n)
    public static int trapViaArray(int[] bars) {
        if (bars == null || bars.length == 0) {
            return 0;
        }

        int n = bars.length - 1;
        int water = 0;

        // 현재 막대의 왼쪽에 있는 막대의 최대 높이를 저장합니다.
        int[] left = new int[n];
        left[0] = Integer.MIN_VALUE;

        // 왼쪽에서 오른쪽으로 막대를 순환하면서 left[i]를 계산합니다.
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], bars[i - 1]);
        }

        // 현재 막대의 오른쪽에 있는 막대의 최대 높이를 저장합니다.
        int right = Integer.MIN_VALUE;

        // 오른쪽에서 왼쪽으로 막대를 순회하면서 고인 빗물을 계산합니다.
        for (int i = n - 1; i >= 1; i--) {
            right = Math.max(right, bars[i + 1]);

            // 현재 막대에 물을 저장할 수 있는지 확인합니다.
            if (Math.min(left[i], right) > bars[i]) {
                water += Math.min(left[i], right) - bars[i];
            }
        }

        return water;
    }

    // 실행 시간이 O(n), left[] 스택을 저장하기 위한 보조 공간이 O(n)
    public static int trapViaStack(int[] bars) {
        if (bars == null || bars.length == 0) {
            return 0;
        }

        int water = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < bars.length; i++) {
            while (!stack.empty() && bars[i] > bars[stack.peek()]) {
                int topBar = stack.pop();

                // 스택이 비어 있으면 빗물이 고일 수 없습니다.
                if (stack.empty()) {
                    continue;
                }

                int width = i - stack.peek() - 1;
                int height = Math.min(bars[i], bars[stack.peek()]) - bars[topBar];

                water += width * height;
            }

            stack.push(i);
        }

        return water;
    }

    // 실행 시간이 O(n)이고 공간 복잡도가 O(1)
    public static int trapOptimized(int[] bars) {
        // 포인터 2개를 사용합니다. left는 0, right는 bars.length-1을 나타냅니다.
        int left = 0;
        int right = bars.length - 1;

        int water = 0;

        int maxBarLeft = bars[left];
        int maxBarRight = bars[right];

        while (left < right) {
            // 왼쪽 포인터를 오른쪽으로 이동합니다.
            if (bars[left] <= bars[right]) {
                left++;
                maxBarLeft = Math.max(maxBarLeft, bars[left]);
                water += (maxBarLeft - bars[left]);
            // 오른쪽 포인터를 왼쪽으로 이동합니다.
            } else {
                right--;
                maxBarRight = Math.max(maxBarRight, bars[right]);
                water += (maxBarRight - bars[right]);
            }
        }

        return water;
    }
}