package coding.challenge;
 
public final class Bits {
    private Bits() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void findNonRepeatable(int arr[]) {
        // 주어진 배열에 있는 모든 요소를 XOR(^)로 연산합니다.
        int xor = arr[0];
        for (int i = 1; i < arr.length; i++) {
            xor ^= arr[i];
        }

        // 값이 1인 비트 중 가장 오른쪽에 있는 비트를 선택합니다(다른 비트를 선택해도 상관없습니다).
        int setBitNo = xor & ~(xor - 1);

        // XOR[^] 결과에서 가장 오른쪽에 있는 1 비트와
        // 각 요소에서 해당 위치에 있는 비트를 비교하여 배열을 두 집합으로 나눕니다.
        int p = 0;
        int q = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & setBitNo) != 0) {
                // 첫 번째 집합에서 xor를 계산합니다.
                p = p ^ arr[i];
            } else {
                // 두 번째 집합에서 xor를 계산합니다.
                q = q ^ arr[i];
            }
        }

        System.out.println("The numbers are: " + p + " and " + q);
    }
}