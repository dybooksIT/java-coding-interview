package coding.challenge;

public final class Bits {
    private Bits() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int next(int n) {
        int copyn = n;

        int zeros = 0;
        int ones = 0;

        // 0의 개수를 셉니다.
        while ((copyn != 0) && ((copyn & 1) == 0)) {
            zeros++;
            copyn = copyn >> 1;
        }

        // 조건에 맞는 첫 번째 0을 찾을 때까지 모든 1의 개수를 셉니다.
        while ((copyn & 1) == 1) {
            ones++;
            copyn = copyn >> 1;
        }

        // 1111...000...가 동일한 1의 개수로 만들 수 있는 가장 큰 숫자입니다.
        if (zeros + ones == 0 || zeros + ones == 31) {
            return -1;
        }

        int marker = zeros + ones;

        n = n | (1 << marker);
        n = n & (-1 << marker);
        n = n | (1 << (ones - 1)) - 1;

        return n;
    }

    public static int previous(int n) {
        int copyn = n;

        int zeros = 0;
        int ones = 0;

        // 1의 개수를 셉니다.
        while ((copyn & 1) == 1) {
            ones++;
            copyn >>= 1;
        }

        // 0000...111...가 1을 더하지 않은 가장 작은 숫자입니다.
        if (copyn == 0) {
            return -1;
        }

        // 조건에 맞는 첫 번째 1을 찾을 때까지 모든 0의 개수를 셉니다.
        while ((copyn != 0) && ((copyn & 1) == 0)) {
            zeros++;
            copyn >>= 1;
        }

        int marker = zeros + ones;

        n = n & (-1 << (marker + 1));
        int mask = (1 << (ones + 1)) - 1; 
        n = n | mask << (zeros - 1);

        return n;
    }
}