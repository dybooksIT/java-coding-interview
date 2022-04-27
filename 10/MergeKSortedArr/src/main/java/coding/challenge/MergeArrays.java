package coding.challenge;

public class MergeArrays {
    public static int[] merge(int[][] arrs, int k) {
        if (arrs == null) {
            throw new IllegalArgumentException("The given arrays cannot be null");
        }

        if (k <= 0) {
            throw new IllegalArgumentException("The number of given arrays cannot be less or equal to 0");
        }

        // 결과 배열의 총 길이를 계산합니다.
        int len = 0;
        for (int i = 0; i < arrs.length; i++) {
            len += arrs[i].length;
        }

        // 결과 배열을 생성합니다.
        int[] result = new int[len];

        // 최소 힙을 생성합니다.
        MinHeap[] heap = new MinHeap[k];

        // 각 배열의 첫 번째 요소를 힙에 추가합니다.
        for (int i = 0; i < k; i++) {
            heap[i] = new MinHeap(arrs[i][0], i, 0);
        }

        // 병합을 수행합니다.
        for (int i = 0; i < result.length; i++) {
            heapify(heap, 0, k);

            // 최종 결과에 요소를 추가합니다.
            result[i] = heap[0].data;

            heap[0].currentIndex++;
            int[] subarray = arrs[heap[0].heapIndex];
            if (heap[0].currentIndex >= subarray.length) {
                heap[0].data = Integer.MAX_VALUE;
            } else {
                heap[0].data = subarray[heap[0].currentIndex];
            }
        }

        return result;
    }

    // 힙에서 O(logn)인 최소 요소를 제거합니다.
    private static void heapify(MinHeap[] heap, int root, int len) {
        int smallest = root;
        int leftIndex = left(root);
        int rightIndex = right(root);

        if (leftIndex < len && heap[smallest].data > heap[leftIndex].data) {
            smallest = leftIndex;
        }

        if (rightIndex < len && heap[smallest].data > heap[rightIndex].data) {
            smallest = rightIndex;
        }

        // 루트 노드로 가장 작은 요소를 교환
        if (smallest != root) {
            swap(heap, smallest, root);
            heapify(heap, smallest, len);
        }
    }

    private static void swap(MinHeap[] heap, int i, int j) {
        MinHeap aux = heap[i];
        heap[i] = heap[j];
        heap[j] = aux;
    }

    // 인덱스 i에서 노드의 왼쪽 자식 인덱스를 얻습니다.
    private static int left(int i) {
        return (2 * i + 1);
    }

    // 인덱스 i에서 노드의 오른쪽 자식 인덱스를 얻습니다.
    private static int right(int i) {
        return (2 * i + 2);
    }
}