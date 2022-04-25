package coding.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Strings {
    private Strings() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static List<Integer> extract(String str) {
        if (str == null || str.isBlank()) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            int cp = str.codePointAt(i);
            if (i < str.length() - 1 && str.codePointCount(i, i + 2) == 1) {
                result.add(cp);
                result.add(str.codePointAt(i+1));
                i++;
            }

            /*
            // 또는 다음 코드 사용
            int cp = str.codePointAt(i);               
            if (Character.charCount(cp) == 2) { // 상수 2는 서러게이트 페어를 의미합니다.
                result.add(cp);
                result.add(str.codePointAt(i+1));
                i++;
            } 
            */
        }

        return result;
    }
}