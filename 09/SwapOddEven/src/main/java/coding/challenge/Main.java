package coding.challenge;

public class Main {
    public static void main(String[] args) {
        int number = 663;

        int result = Bits.swap(number);

        System.out.println("Initial:\t\t" + Integer.toBinaryString(number));
        System.out.println("Swapped:\t\t" + Integer.toBinaryString(result));
        
        /* n = 663일 때 그림 9-34와 같은 최종 결과를 출력하는 코드
        System.out.println("Initial:\t\t" + String.format("%10s", Integer.toBinaryString(number)).replace(' ', '0'));
        System.out.println("Swapped:\t\t" + String.format("%10s", Integer.toBinaryString(result)).replace(' ', '0'));
        */
    }
}