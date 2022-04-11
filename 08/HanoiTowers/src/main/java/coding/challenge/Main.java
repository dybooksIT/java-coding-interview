package coding.challenge;

public class Main {
    public static void main(String[] args) {
        int n = 3;  // Number of disks
        
        // A - 원점(또는 원본) 막대
        // B - 중간(또는 보조) 막대
        // C - 대상(또는 목표) 막대
        Hanoi.moveDisks(n, 'A', 'C', 'B');  
    }
}
