package coding.challenge;

public final class Bits {
    private Bits() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int count(int q, int p) {
        if (q < 0 || p < 0) {
            throw new IllegalArgumentException("The q and p numbers must be positive");
        }

        int count = 0;

        // q와 p의 비트가 다른 부분이 1로 표시됩니다.
        int xor = q ^ p;

        while (xor != 0) {
            // 1 & 1일 때 1입니다.
            count += xor & 1;
            xor = xor >> 1;
        }

        return count;
    }
}