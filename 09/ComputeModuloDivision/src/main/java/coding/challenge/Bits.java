package coding.challenge;

public final class Bits {
    private Bits() {
        throw new AssertionError("Cannot be instantiated");
    }

    // 'q'는 2의 거듭제곱이어야 합니다.
    public static int compute(int p, int q) {
        return p & (q - 1);
    }
}