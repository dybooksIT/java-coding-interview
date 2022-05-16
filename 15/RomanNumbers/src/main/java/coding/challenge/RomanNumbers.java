package coding.challenge;

public final class RomanNumbers {
    // 다음 소개하는 상수는 convert1 메서드에서 사용됩니다.
    private static final String HUNDREDTHS[]
      = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private static final String TENS[]
      = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static final String ONES[]
      = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    // 다음 소개하는 상수는 convert2 메서드에서 사용됩니다.
    private static final int[] DECIMALS
      = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] ROMANS
      = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    private RomanNumbers() {
        throw new AssertionError("Cannot be instantiated");
    }

    // 나누기 사용
    public static String convert1(int n) {
        if (n <= 0) {
            return "";
        }

        String roman = "";

        // 1단계: 천의 자리부터 시작하여 해당하는 로마 숫자를 출력합니다.
        // 예를 들어 천의 자리 숫자가 4면 4,000에 해당하는 로마 숫자인 ‘MMMM’을 출력합니다.
        while (n >= 1000) {
            roman = roman + 'M';
            n -= 1000;
        }

        // 2단계: 숫자를 100으로 나누어 백의 자릿수를 구하고 해당하는 로마 숫자를 출력합니다.
        roman = roman + HUNDREDTHS[n / 100];
        n = n % 100;

        // 3단계: 숫자를 10으로 나누어 십의 자릿수를 구하고 해당하는 로마 숫자를 출력합니다.
        roman = roman + TENS[n / 10];
        n = n % 10;

        // 4단계: 일의 자릿수에 해당하는 로마 숫자를 출력합니다.
        roman = roman + ONES[n];

        return roman;
    }

    // 빼기 사용
    public static String convert2(int n) {
        if (n <= 0) {
            return "";
        }

        String roman = "";
        int i = 0;

        while (n > 0) {
            if (n >= DECIMALS[i]) {
                roman += ROMANS[i];
                n -= DECIMALS[i];
            } else {
                i++;
            }
        }

        return roman;
    }
}