package coding.challenge;

public final class Digits {
    private Digits() {
        throw new AssertionError("Cannot be instantiated");
    }

    // 재귀 기반 풀이
    public static int decoding(char[] digits, int n) {
        // 종료 조건
        if (n == 0 || n == 1) {
            return 1;
        }

        // digits[]가 0으로 시작할 경우(예를 들어 '0212')
        if (digits == null || digits[0] == '0') {
            return 0;
        }

        int count = 0;

        // 마지막 숫자가 0이 아니면 마지막 숫자를 단어 수에 더해야 합니다.
        if (digits[n - 1] > '0') {
            count = decoding(digits, n - 1);
        }

        // 마지막 두 자리가 26보다 작거나 같은 숫자를 나타내는 경우
        // 마지막 두 자리로 decoding 메서드를 호출합니다.
        if (digits[n - 2] == '1' || (digits[n - 2] == '2' && digits[n - 1] < '7')) {
            count += decoding(digits, n - 2);
        }

        return count;
    }

    // 동적 프로그래밍 기반 풀이
    public static int decoding(char digits[]) {
        // digits[]가 0으로 시작할 경우(예를 들어 '0212')
        if (digits == null || digits[0] == '0') {
            return 0;
        }

        int n = digits.length;

        // 하위 문제의 결과를 저장합니다.
        int count[] = new int[n + 1];

        count[0] = 1;
        count[1] = 1;

        for (int i = 2; i <= n; i++) {
            count[i] = 0;

            // 마지막 숫자가 0이 아니면 마지막 숫자를 단어 수에 더해야 합니다.
            if (digits[i - 1] > '0') {
                count[i] = count[i - 1];
            }

            // 마지막에서 두 번째 숫자가 2보다 작고 마지막 숫자가 7보다 작은 경우
            // 마지막 두 숫자는 유효한 문자를 나타냅니다.
            if (digits[i - 2] == '1' || (digits[i - 2] == '2' && digits[i - 1] < '7')) {
                count[i] += count[i - 2];
            }
        }

        return count[n];
    }
}