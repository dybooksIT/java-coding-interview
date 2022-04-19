package coding.challenge;

public class Main {
    public static void main(String[] args) {
        // 두 번째 숫자는 2의 거듭제곱이어야 합니다.
        System.out.println(Bits.compute(3, 4));
        System.out.println(Bits.compute(10, 8));
        System.out.println(Bits.compute(7, 8));
        System.out.println(Bits.compute(9, 4));
        System.out.println(Bits.compute(128, 16));
        System.out.println(Bits.compute(125, 16));
    }
}