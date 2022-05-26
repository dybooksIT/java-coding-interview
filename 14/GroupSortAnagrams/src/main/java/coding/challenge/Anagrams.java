package coding.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams implements Comparator<String> {
    // 적절한 문자 개수를 저장하도록 설정 값(26)을 바꿀 수 있습니다.
    private final static int RANGE_a_z = 26;

    // Comparator를 이용한 그룹 애너그램
    @Override
    public int compare(String wordl, String word2) {
        return sortWordChars(wordl).compareTo(sortWordChars(word2));
    }

    // 해싱으로 에너그램 그룹화(O(nm log m))
    public void printAnagrams(String words[]) {
        Map<String, List<String>> result = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            // 각 문자열의 문자를 정렬합니다.
            String word = words[i];
            String sortedWord = sortWordChars(word);

            if (result.containsKey(sortedWord)) {
                result.get(sortedWord).add(word);
            } else {
                // 새로운 에너그램 그룹을 생성합니다.
                List<String> anagrams = new ArrayList<>();
                anagrams.add(word);
                result.put(sortedWord, anagrams);
            }
        }

        // 결과를 출력합니다.
        System.out.println(result.values());
    }

    // 해싱으로 에너그램 그룹화(O(nm))
    public void printAnagramsOptimized(String[] words) {
        Map<String, List<String>> result = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char[] wordToChar = new char[RANGE_a_z];

            // 'word' 안 각 문자의 등장 횟수(빈도)를 계산합니다.
            for (int j = 0; j < word.length(); j++) {
                wordToChar[word.charAt(j) - 'a']++;
            }

            String computedWord = String.valueOf(wordToChar);

            if (result.containsKey(computedWord)) {
                result.get(computedWord).add(word);
            } else {
                List<String> anagrams = new ArrayList<>();
                anagrams.add(word);
                result.put(computedWord, anagrams);
            }
        }

        System.out.println(result.values());
    }

    // 단어의 문자를 정렬하는 헬퍼 메서드
    private static String sortWordChars(String word) {
        char[] wordToChar = word.toCharArray();
        Arrays.sort(wordToChar);

        return String.valueOf(wordToChar);
    }
}