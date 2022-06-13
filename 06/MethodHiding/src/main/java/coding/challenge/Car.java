package coding.challenge;

public class Car extends Vehicle {
    // 이 메서드는 Vehicle의 move() 메서드를 숨깁니다.
    public static void move() {
        System.out.println("Moving a car");
    }
}