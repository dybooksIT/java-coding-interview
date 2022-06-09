package coding.challenge;

public final class Bits {
    private static final int MAX_INT_BITS = 32;

    private Bits() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int leftRotate(int n, int k) {
        if (n < 0) {
            return -1;
        }

        int fallBits = n << k;
        int fallBitsShiftToRight = n >> (MAX_INT_BITS - k);

        return fallBits | fallBitsShiftToRight;
    }

    public static int rightRotate(int n, int k) {
        if (n < 0) {
            return -1;
        }

        int fallBits = n >> k;
        int fallBitsShiftToLeft = n << (MAX_INT_BITS - k);

        return fallBits | fallBitsShiftToLeft;
    }
}