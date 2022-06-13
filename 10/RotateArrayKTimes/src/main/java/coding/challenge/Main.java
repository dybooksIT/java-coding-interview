package coding.challenge;

public class Main {
    public static void main(String[] args) {
        int A1[] = {1, 2, 3, 4, 5};
        int k1 = 3;

        int A2[] = {5, 5, 2, 3, 1, -2, 33, -1};
        int k2 = 5;

        System.out.println("Before: " + java.util.Arrays.toString(A1));
        Arrays.rightRotate(A1, k1);
        System.out.println("After: " + java.util.Arrays.toString(A1));

        System.out.println("Before: " + java.util.Arrays.toString(A2));
        Arrays.rightRotate(A2, k2);
        System.out.println("After: " + java.util.Arrays.toString(A2));
    }
}