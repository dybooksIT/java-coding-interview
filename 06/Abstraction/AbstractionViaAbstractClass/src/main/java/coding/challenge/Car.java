package coding.challenge;

abstract class Car {
    private final String carType;

    // 추상 클래스는 생성자를 갖습니다.
    public Car(String carType) {
        this.carType = carType;
    }
    
    // 다음부터 추상 메서드입니다.
    abstract void speedUp();
    abstract void slowDown();
    abstract void turnRight();
    abstract void turnLeft();

    // 이것은 구상 메서드입니다.
    public String getCarType() {
        return carType;
    }
}
