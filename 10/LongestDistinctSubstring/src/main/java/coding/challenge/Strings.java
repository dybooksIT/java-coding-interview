package coding.challenge;

public final class Strings {
    private Strings() {
        throw new AssertionError("Cannot be instantiated");
    }

    private static final int ASCII_CODES = 256;

    public static String longestDistinctSubstring(String str) {
        if (str == null || str.isBlank()) {
            return "";
        }

        // 현재 창에 있는 플래그 문자
        boolean[] flagWindow = new boolean[ASCII_CODES];

        // 가장 긴 하위 문자열의 경계를 설정합니다.
        int left = 0;
        int right = 0;

        // wl과 wr은 슬라이딩 창 경계를 나타냅니다.
        for (int wl = 0, wr = 0; wr < str.length(); wr++) {
            // 문자가 현재 창에 있습니다.
            if (flagWindow[str.charAt(wr)]) {
                // 창 왼쪽에서 현재 문자까지 모든 문자를 제거합니다.
                while (str.charAt(wl) != str.charAt(wr)) {
                    flagWindow[str.charAt(wl)] = false;
                    wl++;
                }

                // 현재 문자를 제거합니다.
                wl++;
            } else {
                // 현재 문자는 지금 존재하지 않으므로 추가합니다.
                flagWindow[str.charAt(wr)] = true;

                // 필요하다면 창 크기를 최대로 업데이트합니다.
                if ((right - left) < (wr - wl)) {
                    left = wl;
                    right = wr;
                };
            }
        }

        // 가장 긴 하위 문자열을 반환합니다.
        return str.substring(left, right + 1);
    }
}