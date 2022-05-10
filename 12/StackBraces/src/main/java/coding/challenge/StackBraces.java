package coding.challenge;

import java.util.Stack;

public final class StackBraces {
    private StackBraces() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static boolean bracesMatching(String bracesStr) {
        if (bracesStr == null || bracesStr.isBlank()) {
            return false;
        }

        Stack<Character> stackBraces = new Stack<>();

        int len = bracesStr.length();
        for (int i = 0; i < len; i++) {
            switch (bracesStr.charAt(i)) {
                case '{':
                    stackBraces.push(bracesStr.charAt(i));
                    break;
                case '}':
                    // 짝이 맞지 않는 중괄호를 발견했습니다.
                    if (stackBraces.isEmpty()) {
                        return false; 
                    }

                    // 짝을 찾을 때마다 해당하는 '{'을 팝합니다.
                    stackBraces.pop();
                    break;
                default:
                    return false;
            }
        }

        return stackBraces.empty();
    }
}