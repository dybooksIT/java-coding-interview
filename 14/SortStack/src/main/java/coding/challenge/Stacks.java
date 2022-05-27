package coding.challenge;

import java.util.Stack;

public final class Stacks {
    private Stacks() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void sort(Stack<Integer> stack) {
        Stack<Integer> auxStack = new Stack<>();

        // 1단계: (a, b, c)
        while (!stack.isEmpty()) {
            int t = stack.pop();
            while (!auxStack.isEmpty() && auxStack.peek() > t) {
                stack.push(auxStack.pop());
            }
            auxStack.push(t);
        }

        // 2단계: 'auxStack'에서 요소를 다시 'stack'으로 복사
        while (!auxStack.isEmpty()) {
            stack.push(auxStack.pop());
        }
    }
}