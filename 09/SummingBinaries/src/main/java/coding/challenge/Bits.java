package coding.challenge;

public final class Bits {
    private Bits() {
        throw new AssertionError("Cannot be instantiated");
    }

    // p + q = 2 * (p & q) + (p ^ q)라는 방정식 사용
    public static int sum(int q, int p) {
        int xor;
        int and;
        int t;

        and = q & p;
        xor = q ^ p;

        // 'and'가 0을 반환하도록 유도합니다.
        while (and != 0) {
            and = and << 1; // 2를 곱합니다.

            // 재귀 알고리즘의 다음 단계를 준비합니다.
            t = xor ^ and;
            and = and & xor;
            xor = t;
        }

        return xor;
    }
}