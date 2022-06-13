package coding.challenge;

public class Foo {
    public void foozzy(String p, int q) {
        System.out.println("Called foozzy(" + p + ", " + q + ")");
    }

    // 인수의 개수가 다름
    public void foozzy(String p, int q, int w) {
        System.out.println("Called foozzy(" + p + ", " + q + ", " + w + ")");
    }

    // 인수의 순서가 다름
    public void foozzy(int q, String p) {
        System.out.println("Called foozzy(" + q + ", " + p + ")");
    }

    // 인수의 유형이 다름
    public void foozzy(int p, int q) {
        System.out.println("Called foozzy(" + p + ", " + q + ")");
    }

    // 유효하지 않음 - 다른 반환 유형
    /*
    public boolean foozzy(String p, int q) {
        System.out.println("Called foozzy(" + p + ", " + q + ")");
    }
    */
}