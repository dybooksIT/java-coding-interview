package coding.challenge;
 
public class Main {
    public static void main(String[] args) {
        // 15명 중 1명만 남을 때까지 세 번째 사람을 제거. 생존자는 5번
        int n = 15;
        int k = 3;
     
        System.out.println("Using recursion! Survivor: " + Josephus.josephus(n, k) + "\n");

        Josephus.printJosephus(n, k);
    }
}