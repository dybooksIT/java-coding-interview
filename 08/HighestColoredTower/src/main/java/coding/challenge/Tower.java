package coding.challenge;
 
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class Tower {
    private Tower() {
        throw new AssertionError("Cannot be instantiated");
    }

    // 일반 재귀 알고리즘
    public static int build(List<Box> boxes) {
        if (boxes == null) {
            return -1;
        }

        // 폭을 기준으로 상자를 정렬합니다(높이로 정렬해도 좋습니다).
        Collections.sort(boxes, new Comparator<Box>() {
            @Override
            public int compare(Box b1, Box b2) {
                return Integer.compare(b2.getWidth(), b1.getWidth());
            }
        });

        // 폭 기준으로 상자를 내림차순으로 정렬합니다.
        boxes.forEach(System.out::println);

        // 각 상자를 기본 상자(가장 아래에 위치한 상자)로
        // 놓고 나머지 상자를 배치합니다.
        int highest = 0;
        for (int i = 0; i < boxes.size(); i++) {
            int height = build(boxes, i);
            highest = Math.max(highest, height);
        }

        return highest;
    }

    // 일반 재귀 알고리즘
    private static int build(List<Box> boxes, int base) {
        Box current = boxes.get(base);

        int highest = 0;
        // 상자가 정렬되어 있기 때문에 [0, base + 1) 범위는 고려히지 않습니다.
        for (int i = base + 1; i < boxes.size(); i++) {
            if (boxes.get(i).canBeNext(current)) {
                int height = build(boxes, i);
                highest = Math.max(height, highest);
            }
        }

        highest = highest + current.getHeight();

        return highest;
    }

    // Memoization
    public static int buildViaMemoization(List<Box> boxes) {
        if (boxes == null) {
            return -1;
        }

        // 폭을 기준으로 상자를 정렬합니다(높이로 정렬해도 좋습니다).
        Collections.sort(boxes, new Comparator<Box>() {
            @Override
            public int compare(Box b1, Box b2) {
                return Integer.compare(b2.getWidth(), b1.getWidth());
            }
        });

        // 폭 기준으로 상자를 내림차순으로 정렬합니다.
        boxes.forEach(System.out::println);

        // 각 상자를 기본 상자(가장 아래에 위치한 상자)로
        // 놓고 나머지 상자를 배치합니다.
        int highest = 0;
        int[] cache = new int[boxes.size()];
        for (int i = 0; i < boxes.size(); i++) {
            int height = buildMemoization(boxes, i, cache);
            highest = Math.max(highest, height);
        }

        return highest;
    }

    // 메모이제이션
    private static int buildMemoization(List<Box> boxes, int base, int[] cache) {
        if (base < boxes.size() && cache[base] > 0) {
            return cache[base];
        }

        Box current = boxes.get(base);

        int highest = 0;
        // 상자가 정렬되어 있기 때문에 [0, base]의 범위는 고려하지 않습니다.
        for (int i = base + 1; i < boxes.size(); i++) {
            if (boxes.get(i).canBeNext(current)) {
                int height = buildMemoization(boxes, i, cache);
                highest = Math.max(height, highest);
            }
        }

        highest = highest + current.getHeight();
        cache[base] = highest;

        return highest;
    }
}