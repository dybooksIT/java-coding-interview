package coding.challenge;

public class Main {
    public static void main(String[] args) {
        int[] ropesLength = {1, 3, 4, 6};
        MinHeap heap = new MinHeap();

        int result = heap.minimumCost(ropesLength);

        System.out.println("Result: " + result);
    }
}