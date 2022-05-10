package coding.challenge;

import java.util.Stack;

public final class Stacks {
    private Stacks() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static String reverse(String str) {
        Stack<Character> stack = new Stack();

        // 문자열의 각 문자를 스택에 푸시합니다.
        char[] chars = str.toCharArray();
        for (char c : chars) {
            stack.push(c);
        }

        // 스택에서 모든 문자를 팝하고 다시 문자열에 삽입합니다.
        for (int i = 0; i < str.length(); i++) {
            chars[i] = stack.pop();
        }

        // 문자열을 반환합니다.
        return new String(chars);
    }
}