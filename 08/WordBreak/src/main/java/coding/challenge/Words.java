package coding.challenge;

import java.util.Set;

public final class Words {
    private Words() {
        throw new AssertionError("Cannot be instantiated");
    }

    // 일반 재귀 알고리즘
    public static boolean breakItPlainRecursive(Set<String> dictionary, String str) {
        if (dictionary == null || str == null  || dictionary.isEmpty() || str.isBlank()) {
            return false;
        }

        return breakItPlainRecursive(dictionary, str, 0);
    }

    private static boolean breakItPlainRecursive(Set<String> dictionary, String str, int index) {
        if (index == str.length()) {
            return true;
        }

        boolean canBreak = false;
        for (int i = index; i < str.length(); i++) {
            canBreak = canBreak || dictionary.contains(str.substring(index, i + 1))  && breakItPlainRecursive(dictionary, str, i + 1);
        }

        return canBreak;
    }

    // 상향식 접근법
    public static boolean breakItBottomUp(Set<String> dictionary, String str) {
        if (dictionary == null || str == null || dictionary.isEmpty() || str.isBlank()) {
            return false;
        }

        boolean[] table = new boolean[str.length() + 1];
        table[0] = true;

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; table[i] && j <= str.length(); j++) {
                if (dictionary.contains(str.substring(i, j))) {
                    table[j] = true;
                }
            }
        }

        return table[str.length()];
    }

    // 모든 시퀀스 출력
    public static void printAllSequences(Set<String> dictionary, String str, String result) {
        // 문자열 끝에 도달하면 결과(시퀀스)가 출력됩니다.
        if (str.length() == 0) {
            System.out.println(result);
            return;
        }

        for (int i = 1; i <= str.length(); i++) {
            // 현재 문자열의 모든 접두사를 고려합니다.
            String prefix = str.substring(0, i);

            // 접두사가 사전에 포함되었으면 결과에 접두사를 추가하고 나머지 문자열에 재귀 알고리즘을 적용합니다.
            if (dictionary.contains(prefix)) {
                printAllSequences(dictionary, str.substring(i), result + " " + prefix);
            }
        }
    }
}