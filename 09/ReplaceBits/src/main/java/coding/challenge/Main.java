package coding.challenge;

public class Main {
    private static final int q = 4914;
    private static final int p = 63;
    private static final int i = 4;
    private static final int j = 9;

    public static void main(String[] args) {
        System.out.println("q (in q, we replace the bits between positions " + i + " to " + j + "): "
          + Integer.toString(q, 2) + "(" + q + ")");
        System.out.println("p (new bits that will be inserted in positions " + i + " to " + j + "): "
          + Integer.toString(p, 2) + "(" + p + ")");

        System.out.println();

        int result = Bits.replace(q, p, i, j);

        System.out.println("Result: " + Integer.toString(result, 2));
    }
}