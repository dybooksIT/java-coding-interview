package coding.challenge;

import java.awt.Point;

public final class Rectangles {
    private Rectangles() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static boolean overlap1(Point r1lt, Point r1rb, Point r2lt, Point r2rb) {
        return (r1lt.x <= r2rb.x && r1rb.x >= r2lt.x && r1lt.y >= r2rb.y && r1rb.y <= r2lt.y);
    }
    
    public static boolean overlap2(Point r1lt, Point r1rb, Point r2lt, Point r2rb) {
        // r1이 r2의 오른쪽에 완전히 떨어져 있거나 r2가 r1의 오른쪽에 완전히 떨어져 있는 경우
        if (r1lt.x > r2rb.x || r2lt.x > r1rb.x) {
            return false;
        }

        // r1이 r2의 위쪽에 완전히 떨어져 있거나 r2가 r1의 위쪽에 완전히 떨어져 있는 경우
        if (r1rb.y > r2lt.y || r2rb.y > r1lt.y) {
            return false;
        }

        return true;
    }
}