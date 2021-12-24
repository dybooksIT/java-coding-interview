package coding.challenge.bad;

public class RectangleAreaCalculator {
    private static final double INCH_TERM = 0.0254d;
    
    private final int width;
    private final int height;

    public RectangleAreaCalculator(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    public int area() {
        return width * height;
    }

    // 이 메서드는 단일 책임 원칙에 맞지 않습니다. 이 클래스는 면적 계산과 면적 변환
    // 두 가지 작업을 수행하므로 수정해야 하는 두 가지 이유가 있는 것입니다
    public double metersToInches(int area) {
        return area / INCH_TERM;
    }
}
