package coding.challenge;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {1, 4, 5, 4, 2, 3};
        int[] arr2 = {1, 4, 5, 3, 0, 2, 0};

        boolean arr1_r1 = Arrays.checkDuplicates1(arr1);
        boolean arr1_r2 = Arrays.checkDuplicates2(arr1);
        boolean arr1_r3 = Arrays.checkDuplicates3(arr1);
        boolean arr1_r4 = Arrays.checkDuplicates4(arr1);
        boolean arr1_r5 = Arrays.checkDuplicates5(arr1);
        boolean arr1_r6 = Arrays.checkDuplicates6(arr1);

        boolean arr2_r1 = Arrays.checkDuplicates1(arr2);
        boolean arr2_r2 = Arrays.checkDuplicates2(arr2);
        boolean arr2_r3 = Arrays.checkDuplicates3(arr2);
        boolean arr2_r4 = Arrays.checkDuplicates4(arr2);
        boolean arr2_r5 = Arrays.checkDuplicates5(arr2);
        boolean arr2_r6 = Arrays.checkDuplicates6(arr2);

        System.out.println("arr1_r1: " + arr1_r1);
        System.out.println("arr1_r2: " + arr1_r2);
        System.out.println("arr1_r3: " + arr1_r3);
        System.out.println("arr1_r4: " + arr1_r4);
        System.out.println("arr1_r5: " + arr1_r5);
        System.out.println("arr1_r6: " + arr1_r6);

        System.out.println("");

        System.out.println("arr2_r1: " + arr2_r1);
        System.out.println("arr2_r2: " + arr2_r2);
        System.out.println("arr2_r3: " + arr2_r3);
        System.out.println("arr2_r4: " + arr2_r4);
        System.out.println("arr2_r5: " + arr2_r5);
        System.out.println("arr2_r6: " + arr2_r6);
    }
}