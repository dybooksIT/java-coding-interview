package coding.challenge;

public class Main {
    public static void main(String[] args) {
        int result1 = Chocolates.breakit(3, 6, 20);
        int result2 = Chocolates.breakit(3, 6, 7);
        int result3 = Chocolates.breakit(3, 6, 18);
        int result4 = Chocolates.breakit(3, 6, 6);
        int result5 = Chocolates.breakit(3, 6, 4);

        System.out.println("tiles = 20: " + result1);
        System.out.println("tiles = 7: " + result2);
        System.out.println("tiles = 18: " + result3);
        System.out.println("tiles = 6: " + result4);
        System.out.println("tiles = 4: " + result5);

        /* int result = Chocolates.breakit(12, 10, 8);

        System.out.println("(-1: not possible; 0: no breaks needed; " + "1: one break; 2: two breaks): " + result); */
    }
}