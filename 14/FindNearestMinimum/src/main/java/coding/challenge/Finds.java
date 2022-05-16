package coding.challenge;

import java.util.Stack;

public final class Finds {
    private Finds() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void leftSmaller(int arr[]) {
        Stack<Integer> stack = new Stack<>();

        // 스택의 톱 요소가 arr[i]보다 크면 스택에서 제거합니다.
        for (int i = 0; i < arr.length; i++) {
            while (!stack.empty() && stack.peek() >= arr[i]) {
                stack.pop();
            }

            // 스택이 비어 있으면 arr[i]의 왼쪽에 작은 요소가 없습니다.
            if (stack.empty()) {
                System.out.print("_, ");
            } else {
                // 스택의 톱은 arr[i]의 왼쪽에서 가장 가까운 작은 요소입니다.
                System.out.print(stack.peek() + ", ");
            }

            // arr[i]를 스택에 푸시합니다.
            stack.push(arr[i]);
        }
    }
}