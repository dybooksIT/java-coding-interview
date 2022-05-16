package coding.challenge;

public final class Numbers {
    private Numbers() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static String multiply(String a, String b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("a and b cannot be null");
        }

        int lenA = a.length();
        int lenB = b.length();

        if (lenA == 0 || lenB == 0) {
            return "0";
        }

        // 곱셈의 결과는 반대 순서로 저장됩니다.
        int c[] = new int[lenA + lenB];

        // 결과에서 위치를 찾는 인덱스
        int idx1 = 0;
        int idx2 = 0;

        // 'a'의 오른쪽에서 왼쪽으로 순회합니다.
        for (int i = lenA - 1; i >= 0; i--) {
            int carry = 0;
            int n1 = a.charAt(i) - '0';

            // 'b'에서 숫자를 곱할 때마다 위치를 왼쪽으로 이동할 때 사용합니다.
            idx2 = 0;

            // 'b'의 오른쪽에서 왼쪽으로 순회합니다.
            for (int j = lenB - 1; j >= 0; j--) {
                // 두 번째 숫자의 현재 자릿수
                int n2 = b.charAt(j) - '0';

                // 첫 번째 숫자의 현재 자릿수와 곱합니다.
                int sum = n1 * n2 + c[idx1 + idx2] + carry;

                // 다음 계산으로 넘어갈 자리 올림 수
                carry = sum / 10;

                c[idx1 + idx2] = sum % 10;
                idx2++;
            }

            // 자리 올림 수를 저장합니다.
            if (carry > 0) {
                c[idx1 + idx2] += carry;
            }

            // 'a'의 숫자를 곱할 때마다 위치를 왼쪽으로 이동합니다.
            idx1++;
        }

        // 오른쪽에 있는 '0'을 무시합니다.
        int i = c.length - 1;
        while (i >= 0 && c[i] == 0) {
            i--;
        }

        // 모두 '0'인 경우 'a' 또는 'b'중 하나 또는 둘 모두가 '0'입니다.
        if (i == -1) {
            return "0";
        }

        String result = "";
        while (i >= 0) {
            result += (c[i--]);
        }

        return result;
    }
}