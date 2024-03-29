package coding.challenge;

public final class Coins {
    private Coins() {
        throw new AssertionError("Cannot be instantiated");
    }

    // 일반 재귀 알고리즘
    public static int calculateChange(int n) {
        if (n <= 0) {
            return -1;
        }

        int[] coins = {25, 10, 5, 1};
        return calculateChange(n, coins, 0);
    }

    // 일반 재귀 알고리즘
    private static int calculateChange(int amount, int[] coins, int position) {
        if (position >= coins.length - 1) {
            return 1;
        }

        int coin = coins[position];
        int count = 0;
        for (int i = 0; i * coin <= amount; i++) {
            int remaining = amount - i * coin;
            count += calculateChange(remaining, coins, position + 1);
        }
        return count;
    }

    // 메모이제이션
    public static int calculateChangeMemoization(int n) {
        if (n <= 0) {
            return -1;
        }

        int[] coins = {25, 10, 5, 1};
        int[][] cache = new int[n + 1][coins.length];

        return calculateChangeMemoization(n, coins, 0, cache);
    }

    // 메모이제이션
    private static int calculateChangeMemoization(int amount, int[] coins, int position, int[][] cache) {
        if (cache[amount][position] > 0) {
            return cache[amount][position];
        }

        if (position >= coins.length - 1) {
            return 1;
        }

        int coin = coins[position];
        int count = 0;

        for (int i = 0; i * coin <= amount; i++) {
            int remaining = amount - i * coin;
            count += calculateChangeMemoization(remaining, coins, position + 1, cache);
        }

        cache[amount][position] = count;

        return count;
    }
}