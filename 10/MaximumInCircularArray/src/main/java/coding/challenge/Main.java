package coding.challenge;

public class Main {
    public static void main(String[] args) {
        int[] m1 = {11, 14, 23, 24, -1, 3, 5, 6, 8, 9, 10};
        int[] m2 = {7, 11, 12, 13, 15, -4, -3, -2, 0, 1, 1, 3, 4, 7, 7};

        int max1 = Arrays.findMax(m1);

        System.out.println("Array 1: " + java.util.Arrays.toString(m1));
        System.out.println("Max 1 value is: " + max1);

        int max2 = Arrays.findMax(m2);

        System.out.println("Array 2: " + java.util.Arrays.toString(m2));
        System.out.println("Max 2 value is: " + max2);
    }
}