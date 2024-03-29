package coding.challenge;

import java.util.Stack;

public class Numbers {
    private Numbers() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void smallestAfterRemove(String n, int k) {
        if (n == null || k <= 0 || k >= n.length()) {
            System.out.println("The number is: " + 0);
            return;
        }

        int i = 0;
        Stack<Character> stack = new Stack<>();
        while (i < n.length()) {
            // 현재 자리 숫자가 이전 자리 숫자보다 작으면 이전 자리 숫자를 버립니다.
            while (k > 0 && !stack.isEmpty() && stack.peek() > n.charAt(i)) {
                stack.pop();
                k--;
            }

            stack.push(n.charAt(i));
            i++;
        }

        // '2222'와 같은 코너 케이스를 처리합니다.
        while (k > 0) {
            stack.pop();
            k--;
        }

        System.out.println("The number is (as a printed stack; " + "ignore leading 0s (if any)): " + stack);
    }
}