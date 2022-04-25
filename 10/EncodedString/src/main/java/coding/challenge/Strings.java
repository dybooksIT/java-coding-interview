package coding.challenge;

public final class Strings {
    private Strings() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static char[] encodeWhitespaces(char[] str) {
        if (str == null) {
            throw new IllegalArgumentException("The given string cannot be null");
        }

        // 1단계: 공백을 셉니다.
        int countWhitespaces = 0;
        for (int i = 0; i < str.length; i++) {
            if (Character.isWhitespace(str[i])) {
                countWhitespaces++;
            }
        }
        
        if (countWhitespaces > 0) {
            // 2단계: 결과 char[]를 생성합니다.
            char[] encodedStr = new char[str.length + countWhitespaces * 2];

            // 3단계: 결과 char[]를 채웁니다.
            int index = 0;
            for (int i = 0; i < str.length; i++) {
                if (Character.isWhitespace(str[i])) {
                    encodedStr[index] = '%';
                    encodedStr[index + 1] = '2';
                    encodedStr[index + 2] = '0';
                    index = index + 3;
                } else {
                    encodedStr[index] = str[i];
                    index++;
                }
            }
            return encodedStr;
        }

        return str;
    }
}