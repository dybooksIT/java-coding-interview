package coding.challenge;

import java.util.EmptyStackException;
import java.util.Stack;

public class MyStack {
    private int min;
    private final Stack<Integer> stack = new Stack<>();

    public void push(int value) {
        // int / 2 범위를 초과하는 값은 허용하지 않습니다.
        int r = Math.addExact(value, value);

        if (stack.empty()) {
            stack.push(value);
            min = value;
        } else if (value > min) {
            stack.push(value);
        } else {
            stack.push(r - min);
            min = value;
        }
    }

    // pop은 잘못된 값(클라이언트가 푸시하지 않은 값)일 수 있기 때문에 값을 반환하지 않습니다.
    public void pop() {
        if (stack.empty()) {
            throw new EmptyStackException();
        }

        int top = stack.peek();
        if (top < min) {
            min = 2 * min - top;
        }
        stack.pop();
    }

    public int min() {
        return min;
    }
}