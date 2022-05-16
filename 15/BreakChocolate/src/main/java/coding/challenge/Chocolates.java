package coding.challenge;

public final class Chocolates {
    private Chocolates() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int breakit(int width, int height, int nTiles) {
        if (width <= 0 || height <= 0 || nTiles <= 0) {
            return -1;
        }

        // 예제 1의 경우
        if (width * height < nTiles) {
            return -1;
        }

        // 예제 4의 경우
        if (width * height == nTiles) {
            return 0;
        } 

        // 예제 5와 6의 경우
        if ((nTiles % width == 0 && (nTiles / width) < height)
          || (nTiles % height == 0 && (nTiles / height) < width)) {
            return 1;
        }

        // 예제 7의 경우
        for (int i = 1; i <= Math.sqrt(nTiles); i++) {
            if (nTiles % i == 0) {
                int a = i;
                int b = nTiles / i;
                if ((a <= width && b <= height)
                  || (a <= height && b <= width)) {
                    return 2;
                }
            }
        }

        // 예제 2와 3의 경우
        return -1;
    }
}