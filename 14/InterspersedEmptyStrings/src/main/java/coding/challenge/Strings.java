package coding.challenge;

public final class Strings {
    private Strings() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int search(String[] stringsArr, String str) {
        if (stringsArr == null || str == null || str.isBlank()) {
            return -1;
        }

        return search(stringsArr, str, 0, stringsArr.length - 1);
    }

    private static int search(String[] stringsArr, String str, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;

        // mid가 비어 있으므로 mid에서 가장 가까운 비지 않은 문자열을 찾습니다.
        if (stringsArr[mid].isEmpty()) {
            int leftMid = mid - 1;
            int rightMid = mid + 1;

            while (true) {
                if (leftMid < left && rightMid > right) {
                    return -1;
                } else if (rightMid <= right && !stringsArr[rightMid].isEmpty()) {
                    mid = rightMid;
                    break;
                } else if (leftMid >= left && !stringsArr[leftMid].isEmpty()) {
                    mid = leftMid;
                    break;
                }

                rightMid++;
                leftMid--;
            }
        }

        if (str.equals(stringsArr[mid])) {
            // 검색할 문자열을 찾았습니다.
            return mid;
        } else if (stringsArr[mid].compareTo(str) < 0) {
            // 오른쪽에서 검색합니다.
            return search(stringsArr, str, mid + 1, right);
        } else {
            // 왼쪽에서 검색합니다.
            return search(stringsArr, str, left, mid - 1);
        }
    }
}