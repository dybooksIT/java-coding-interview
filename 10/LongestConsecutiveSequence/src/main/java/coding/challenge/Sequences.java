package coding.challenge;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Sequences {
    private Sequences() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int findLongestConsecutive(int[] sequence) {
        if (sequence == null) {
            throw new IllegalArgumentException("The given sequence cannot be empty");
        }

        // 주어진 시퀀스를 기반으로 집합을 구성합니다.
        Set<Integer> sequenceSet = IntStream.of(sequence)
          .boxed()
          .collect(Collectors.toSet());

        int longestSequence = 1;

        for (int elem : sequence) {
            // 'elem-1'이 집합에 없으면 새로운 시퀀스로 간주합니다.
            if (!sequenceSet.contains(elem - 1)) {
                int sequenceLength = 1;

                // 집합에서 요소 'elem + 1', 'elem + 2', 'elem + 3', ...을 검색합니다.
                while (sequenceSet.contains(elem + sequenceLength)) {
                    sequenceLength++;
                }

                // 가장 긴 시퀀스의 길이를 계산합니다.
                longestSequence = Math.max(longestSequence, sequenceLength);
            }
        }

        return longestSequence;
    }
}