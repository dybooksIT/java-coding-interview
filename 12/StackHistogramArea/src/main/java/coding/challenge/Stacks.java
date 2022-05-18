package coding.challenge;

import java.util.Stack;

public final class Stacks {
    private Stacks() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int maxAreaUsingStack(int[] histogram) {
        Stack<Integer> stack = new Stack<>();

        int maxArea = 0;
        for (int bar = 0; bar <= histogram.length; bar++) {
            int barHeight;
            if (bar == histogram.length) {
                // 마지막 막대의 높이까지 고려하도록 0으로 초기화합니다.
                barHeight = 0;
            } else {
                barHeight = histogram[bar];
            }

            while (!stack.empty() && barHeight < histogram[stack.peek()]) {
                // 스택에 있는 막대보다 작은 막대를 발견합니다.
                int top = stack.pop();

                // 왼쪽 경계를 찾습니다.
                int left = stack.isEmpty() ? -1 : stack.peek();

                // 직사각형 영역의 너비를 계산합니다.
                int areaRectWidth = bar - left - 1;

                // 현재 직사각형의 면적을 계산합니다.
                int area = areaRectWidth * histogram[top];
                maxArea = Integer.max(area, maxArea);
            }

            // 스택에 현재 막대(인덱스)를 추가합니다.
            stack.push(bar);
        }

        return maxArea;
    }
}