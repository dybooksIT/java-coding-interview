package coding.challenge;
 
public class Main {
    public static void main(String[] args) {
        int[] arr1 = {3, 2, 7, 4, 5, 1, 6, 7, 9};
        int[] arr2 = {5, 1, 6, 10, 7, 11, 2};

        int[] subset = new int[arr1.length];

        System.out.println("Recursive approach:");
        Subsets.findSumRecursive(arr1, 0, 0, 7, subset);

        System.out.println("\n\nDynamic Programming approach:");
        Subsets.findSumDP(arr2, 9);
    }
}