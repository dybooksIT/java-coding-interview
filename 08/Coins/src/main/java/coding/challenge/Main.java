package coding.challenge;

public class Main {
    public static void main(String[] args) {
        System.out.println("Count (plain recursion): " + Coins.calculateChange(50));
        System.out.println("Count (Memoization): " + Coins.calculateChangeMemoization(50));
    }
}