package coding.challenge;

public final class Elements {
    private static final int INT_SIZE = 32;

    private Elements() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int unique1(int arr[]) {
        if (arr == null || arr.length < 4) {
            throw new IllegalArgumentException("The given array is not valid");
        }

        int n = arr.length;
        int result = 0;

        int nr;
        int sumBits;

        // 모든 비트를 순회합니다.
        for (int i = 0; i < INT_SIZE; i++) {
            // 배열의 모든 요소에 대해 i번째에 설정된 비트의 합을 계산합니다.
            sumBits = 0;
            nr = (1 << i);
            for (int j = 0; j < n; j++) {
                if ((arr[j] & nr) == 0) {
                    sumBits++;
                }
            }

            // 합이 3의 배수가 아니라면 해당 비트는 고유한 요소의 비트입니다.
            if ((sumBits % 3) == 0) {
                result = result | nr;
            }
        }

        return result;
    }

    public static int unique2(int arr[]) {
        if (arr == null || arr.length < 4) {
            throw new IllegalArgumentException("The given array is not valid");
        }

        int oneAppearance = 0;
        int twoAppearances = 0;

        for (int i = 0; i < arr.length; i++) {
            twoAppearances = twoAppearances | (oneAppearance & arr[i]);
            oneAppearance = oneAppearance ^ arr[i];
            int neutraliser = ~(oneAppearance & twoAppearances);
            oneAppearance = oneAppearance & neutraliser;
            twoAppearances = twoAppearances & neutraliser;
        }

        return oneAppearance;
    }
}