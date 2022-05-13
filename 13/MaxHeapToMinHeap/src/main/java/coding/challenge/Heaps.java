package coding.challenge;

public class Heaps {
    // 최대 힙을 최소 힙으로 변환(O(n))
    public static void convertToMinHeap(int[] maxHeap) {
        if (maxHeap == null) {
            throw new IllegalArgumentException("The given max heap cannot be null");
        }

        // 마지막 노드에서 루트 노드 방향으로 힙을 구축합니다.
        int p = (maxHeap.length - 2) / 2;
        while (p >= 0) {
            heapifyMin(maxHeap, p--, maxHeap.length);
        }
    }

    // 인덱스 p에 있는 노드와 2개의 직계 자식 노드를 힙화합니다.
    private static void heapifyMin(int[] maxHeap, int p, int size) {
        // 인덱스 p에 있는 노드의 왼쪽 및 오른쪽 자식 노드를 가져옵니다.
        int left = leftChild(p);
        int right = rightChild(p);

        int smallest = p;

        // maxHeap[p]를 왼쪽 및 오른쪽 자식 노드와 비교하고 가장 작은 값을 찾습니다.
        if ((left < size) && (maxHeap[left] < maxHeap[p])) {
            smallest = left;
        }

        if ((right < size) && (maxHeap[right] < maxHeap[smallest])) {
            smallest = right;
        }

        // 가장 작은 노드(smallest)와 p 노드를 바꾸고 힙화합니다.
        if (smallest != p) {
            swap(maxHeap, p, smallest);
            heapifyMin(maxHeap, smallest, size);
        }
    }

    // 최소 힙을 최대 힙으로 변환(O(n))
    public static void convertToMaxHeap(int[] minHeap) {
        if (minHeap == null) {
            throw new IllegalArgumentException("The given min heap cannot be null");
        }

        // 마지막 노드에서 루트 노드 방향으로 힙을 구축합니다.
        int p = (minHeap.length - 2) / 2;
        while (p >= 0) {
            heapifyMax(minHeap, p--, minHeap.length);
        }
    }

    // 인덱스 p에 있는 노드와 2개의 직계 자식 노드를 힙화합니다.
    private static void heapifyMax(int[] minHeap, int p, int size) {
        // 인덱스 p에 있는 노드의 왼쪽 및 오른쪽 자식 노드를 가져옵니다.
        int left = leftChild(p);
        int right = rightChild(p);

        int largest = p;

        // maxHeap[p]를 왼쪽 및 오른쪽 자식 노드와 비교하고 가장 큰 값을 찾습니다.
        if ((left < size) && (minHeap[left] > minHeap[p])) {
            largest = left;
        }

        if ((right < size) && (minHeap[right] > minHeap[largest])) {
            largest = right;
        }

        // 가장 큰 노드(largest)와 p 노드를 바꾸고 힙화합니다.
        if (largest != p) {
            swap(minHeap, p, largest);
            heapifyMax(minHeap, largest, size);
        }
    }

    // 헬퍼 메서드
    private static int leftChild(int parentIndex) {
        return (2 * parentIndex + 1);
    }

    private static int rightChild(int parentIndex) {
        return (2 * parentIndex + 2);
    }

    // 배열의 두 인덱스를 교환하는 유틸리티 메서드입니다.
    private static void swap(int heap[], int i, int j) {
        int aux = heap[i];
        heap[i] = heap[j];
        heap[j] = aux;
    }
}