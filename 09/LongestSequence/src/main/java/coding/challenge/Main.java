package coding.challenge;

public class Main {
    public static void main(String[] args) {
        int n1 = 67534;
        int n2 = 67;
        int n3 = 339809;

        int result1 = Bits.sequence(n1);
        int result2 = Bits.sequence(n2);
        int result3 = Bits.sequence(n3);

        System.out.println("A sequence of 101 is considered 111!");
        System.out.println("The longest sequence of 1 in "
          + Integer.toBinaryString(n1) + " is equal to " + result1);

        System.out.println("A sequence of 101 is considered 111!");
        System.out.println("The longest sequence of 1 in "
          + Integer.toBinaryString(n2) + " is equal to " + result2);

        System.out.println("A sequence of 101 is considered 111!");
        System.out.println("The longest sequence of 1 in "
          + Integer.toBinaryString(n3) + " is equal to " + result3);
    }
}