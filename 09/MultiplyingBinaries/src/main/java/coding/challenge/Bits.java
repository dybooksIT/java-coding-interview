package coding.challenge;

public final class Bits {
    private Bits() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int multiply(int q, int p) {
        int result = 0;

        while (p != 0) {
            // p의 최하위 비트가 1일 때만 q의 값을 계산합니다.
            if ((p & 1) != 0) {
                result = result + q;
            }

            q = q << 1;  // q는 한 자리만큼 왼쪽으로 시프트합니다.
            p = p >>> 1; // p는 한 자리만큼 오른쪽으로 논리 시프트합니다.
        }

        return result;
    }
}