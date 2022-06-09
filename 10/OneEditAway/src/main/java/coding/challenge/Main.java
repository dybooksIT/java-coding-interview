package coding.challenge;

public class Main {
    public static void main(String[] args) {
        String q1 = "tank";
        String p1 = "tanc";

        String q2 = "tnk";
        String p2 = "tank";

        String q3 = "tank";
        String p3 = "tinck";

        String q4 = "tank";
        String p4 = "tankist";

        String q5 = "tank";
        String p5 = "tlank";

        System.out.println("Result: " + Strings.isOneEditAway(q1, p1));
        System.out.println("Result: " + Strings.isOneEditAway(q2, p2));
        System.out.println("Result: " + Strings.isOneEditAway(q3, p3));
        System.out.println("Result: " + Strings.isOneEditAway(q4, p4));
        System.out.println("Result: " + Strings.isOneEditAway(q5, p5));
    }
}