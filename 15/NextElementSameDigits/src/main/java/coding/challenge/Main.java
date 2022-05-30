package coding.challenge;

public class Main {
    public static void main(String[] args) {
        int digits1[] = { 6 };
        int digits2[] = { 1, 2, 3, 4 };
        int digits3[] = { 1, 2, 3, 2 };
        int digits4[] = { 3, 2, 1 };
        int digits5[] = { 6, 2, 7, 8, 6, 3 };
        int digits6[] = { 6, 2, 1, 8, 7, 3 };

        Numbers.findNextGreater(digits1);
        Numbers.findNextGreater(digits2);
        Numbers.findNextGreater(digits3);
        Numbers.findNextGreater(digits4);
        Numbers.findNextGreater(digits5);
        Numbers.findNextGreater(digits6);
    }
}