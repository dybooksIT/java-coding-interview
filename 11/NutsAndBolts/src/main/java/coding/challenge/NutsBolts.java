package coding.challenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class NutsBolts {
    private NutsBolts() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void match(char[] nuts, char[] bolts) {
        if (nuts == null || bolts == null) {
            throw new IllegalArgumentException("Nuts/bolts arrays cannot be null");
        }

        if (nuts.length == 0 || bolts.length == 0) {
            throw new IllegalArgumentException("Nuts/bolts arrays cannot be empty");
        }

        // 이 맵에서 각 너트는 키이며 너트의 위치가 값입니다.
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < nuts.length; i++) {
            map.put(nuts[i], i);
        }

        // 각 볼트를 순회하며 일치하는 너트를 찾습니다.
        for (int i = 0; i < bolts.length; i++) {
            char bolt = bolts[i];
            if (map.containsKey(bolt)) {
                nuts[i] = bolts[i];
            } else {
                System.out.println("Bolt " + bolt + " has no nut");
            }
        }

        System.out.println("Matches between nuts and bolts: ");
        System.out.println("Nuts: " + Arrays.toString(nuts));
        System.out.println("Bolts: " +Arrays.toString(bolts));
    }
}