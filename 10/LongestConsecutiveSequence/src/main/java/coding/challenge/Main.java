package coding.challenge;

public class Main {
    public static void main(String[] args) {
        int[] sequence1 = {4, 2, 9, 5, 12, 6, 8};
        int[] sequence2 = {2, 0, 6, 1, 4, 3, 8};

        int longestSequence1 = Sequences.findLongestConsecutive(sequence1);
        System.out.println("Longest sequence has " + longestSequence1 + " element(s)");

        int longestSequence2 = Sequences.findLongestConsecutive(sequence2);
        System.out.println("Longest sequence has " + longestSequence2 + " element(s)");
    }
}