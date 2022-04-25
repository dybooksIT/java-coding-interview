package coding.challenge;

public final class Strings {
    private Strings() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static boolean isOneEditAway(String q, String p) {
        if (q == null || p == null
                || q.isBlank() || p.isBlank()) {
            return false;
        }

        // 문자열 사이의 차이점이 2개 이상이면 두 번 이상의 수정이 필요합니다.
        if (Math.abs(q.length() - p.length()) > 1) {
            return false;
        }

        // q와 p의 길이를 비교하여 더 짧은 문자열을 정합니다.
        String shorter = q.length() < p.length() ? q : p;
        String longer = q.length() < p.length() ? p : q;

        int is = 0;
        int il = 0;
        boolean marker = false;
        while (is < shorter.length() && il < longer.length()) {
            if (shorter.charAt(is) != longer.charAt(il)) {
                // 첫 번째 차이점을 이미 발견한 상태에서 두 번째
                // 차이점을 발견했다면 false를 반환합니다.
                if (marker) {
                    return false;
                }

                marker = true;

                if (shorter.length() == longer.length()) {
                    is++;
                }
            } else {
                is++;
            }
            il++;
        }

        return true;
    }
}