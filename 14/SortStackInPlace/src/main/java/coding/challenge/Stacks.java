package coding.challenge;

import java.util.Stack;

public final class Stacks {
    private Stacks() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void sort(Stack<Integer> stack) {
        if (stack == null) {
            throw new IllegalArgumentException("The given stack cannot be empty");
        }

        // 스택이 비어 있습니다(종료 조건).
        if (stack.isEmpty()) {
            return;
        }

        // 톱 요소를 제거합니다.
        int top = stack.pop();

        // 스택의 나머지 요소에 재귀를 적용합니다.
        sort(stack);

        // 팝한 요소를 정렬된 스택에 다시 삽입합니다.
        sortedInsert(stack, top);
    }

    private static void sortedInsert(Stack<Integer> stack, int element) {
        // 스택이 비어 있거나 요소가 스택의 모든 요소보다 큽니다(종료 조건).
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
            return;
        }

        // 요소가 톱 요소보다 작으므로 톱 요소를 제거합니다.
        int top = stack.pop();

        // 스택의 나머지 요소에 재귀를 적용합니다.
        sortedInsert(stack, element);

        // 팝한 요소를 스택에 다시 삽입합니다.
        stack.push(top);
    }
}