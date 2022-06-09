package coding.challenge;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {4, 4, 3, 1, 7, 7, 7, 1, 1, 4};

        int result1 = Elements.unique1(arr1);
        int result2 = Elements.unique2(arr1);
        System.out.println("Result: " + result1 + "  |  " + result2);

        int[] arr2 = {51, 14, 14, 51, 98, 7, 14, 98, 51, 98};

        int result3 = Elements.unique1(arr2);
        int result4 = Elements.unique2(arr2);
        System.out.println("Result: " + result3 + "  |  " + result4);
    }
}