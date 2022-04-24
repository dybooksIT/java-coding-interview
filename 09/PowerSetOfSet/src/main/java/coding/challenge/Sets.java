package coding.challenge;
 
import java.util.HashSet;
import java.util.Set;

public final class Sets {
    private Sets() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static Set<Set<Character>> powerSet(char[] set) {
        if (set == null) {
            throw new IllegalArgumentException("The given set cannot be null");
        }

        // 부분집합의 개수는 2^n 개입니다.
        long subsetsNo = (long) Math.pow(2, set.length);

        // 부분집합을 저장합니다.
        Set<Set<Character>> subsets = new HashSet<>();

        // 각 부분집합을 하나씩 생성합니다.
        for (int i = 0; i < subsetsNo; i++) {
            Set<Character> subset = new HashSet<>();

            // i의 모든 비트를 확인합니다.
            for (int j = 0; j < set.length; j++) {
                // i에서 j번째 비트가 1이면 set[j]를 현재 부분집합에 추가합니다.
                if ((i & (1 << j)) != 0) {
                    subset.add(set[j]);
                }
            }

            subsets.add(subset);
        }

        return subsets;
    }
}