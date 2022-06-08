package coding.challenge;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = new int[]{-5, -4, -2, 0, 1, 2, 3, 5, 6, 7, 9, 11, 13, 20, 22, 24, 25, 27};
        int[] arr2 = new int[]{1, 4, 4, 4, 5, 5, 6, 6, 6, 11, 12, 12, 12, 15, 17, 20, 21, 21};

        int resultIndex1 = MagicIndex.find(arr1);
        int resultIndex2 = MagicIndex.find(arr2);

        System.out.println("Index " + resultIndex1 + " has value " + arr1[resultIndex1]);
        System.out.println("Index " + resultIndex2 + " has value " + arr2[resultIndex2]);
    }
}