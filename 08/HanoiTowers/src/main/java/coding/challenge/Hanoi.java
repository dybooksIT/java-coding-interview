package coding.challenge;

public final class Hanoi {
    private Hanoi() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void moveDisks(int n, char origin, char target, char intermediate) {
        if (n <= 0) {
            return;
        }

        if (n == 1) {
            System.out.println("Move disk 1 from rod " + origin + " to rod " + target);
            return;
        }

        // 원점 막대의 상위 n − 1개 원반을 중간 막대로 옮기고, 대상 막대를 중간 막대 역할로 활용합니다.
        moveDisks(n - 1, origin, intermediate, target);

        System.out.println("Move disk " + n + " from rod " + origin + " to rod " + target);

        // 중간 막대의 상위 n − 1개 원반을 대상 막대로 옮기고, 원점 막대를 중간 막대 역할로 활용합니다.
        moveDisks(n - 1, intermediate, target, origin);
    }
}