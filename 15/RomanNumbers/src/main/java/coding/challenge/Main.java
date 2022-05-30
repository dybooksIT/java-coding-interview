package coding.challenge;

public class Main {
    public static void main(String[] args) {
        int n1 = 73;
        int n2 = 558;
        int n3 = 145;
        int n4 = 34;
        int n5 = 49;

        System.out.println("\n" + n1 + " is:\n"
          + RomanNumbers.convert1(n1) + "\n" + RomanNumbers.convert2(n1));
        System.out.println("\n" + n2 + " is:\n"
          + RomanNumbers.convert1(n2) + "\n" + RomanNumbers.convert2(n2));
        System.out.println("\n" + n3 + " is:\n"
          + RomanNumbers.convert1(n3) + "\n" + RomanNumbers.convert2(n3));
        System.out.println("\n" + n4 + " is:\n"
          + RomanNumbers.convert1(n4) + "\n" + RomanNumbers.convert2(n4));
        System.out.println("\n" + n5 + " is:\n"
                + RomanNumbers.convert1(n5) + "\n" + RomanNumbers.convert2(n5));
    }
}