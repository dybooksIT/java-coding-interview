package coding.challenge;

public class Main {
    public static void main(String[] args) {
        int[] integers1 = {1, 34, 21, 7, 4, 8, 10};
        int[] integers2 = {17, 9, 2, 26, 32, 27, 3};
        int[] integers3 = {3, 7, 9, 11};
        int[] integers4 = {11, 9, 7, 6};
        int[] integers5 = {3, 5, 2, 1, 7, 4};
        int[] integers6 = {4, 1, 8, 3, 8, 2, 6, 7, 4, 9};

        int md1 = Arrays.maxDiff(integers1);
        System.out.println("integers1 Max diff: " + md1);

        int md2 = Arrays.maxDiff(integers2);
        System.out.println("integers2 Max diff: " + md2);

        int md3 = Arrays.maxDiff(integers3);
        System.out.println("integers3 Max diff: " + md3);

        int md4 = Arrays.maxDiff(integers4);
        System.out.println("integers4 Max diff: " + md4);

        int md5 = Arrays.maxDiff(integers5);
        System.out.println("integers5 Max diff: " + md5);

        int md6 = Arrays.maxDiff(integers6);
        System.out.println("integers6 Max diff: " + md6);
    }
}