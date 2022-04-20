package coding.challenge;

public final class Bits {
    private Bits() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int subtract(int q, int p) {
        while (p != 0) {
            // q에서 값이 0인 비트와 p에서 값이 1인 비트의 AND 연산을 통해 borrow를 구합니다.
            int borrow = (~q) & p;

            // 비트 중 하나 이상이 0인 경우 q에서 p를 뺍니다.
            q = q ^ p;
            
            // borrow를 한 자리만큼 왼쪽으로 시프트합니다.
            p = borrow << 1;
        }

        return q;
    }
}