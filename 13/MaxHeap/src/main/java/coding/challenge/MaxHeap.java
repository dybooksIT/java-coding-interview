package coding.challenge;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class MaxHeap<T extends Comparable<T>> {
    private static final int DEFAULT_CAPACITY = 5;

    private int capacity;
    private int size;
    private T[] heap;

    public MaxHeap() {
        capacity = DEFAULT_CAPACITY;
        this.heap = (T[]) Array.newInstance(
            Comparable[].class.getComponentType(), DEFAULT_CAPACITY
        );
    }

    // 요소 추가는 O(log n) 시간에 완료됩니다.
    public void add(T element) {
        ensureCapacity();

        heap[size] = element;
        size++;

        heapifyUp();
    }

    private void ensureCapacity() {
        if (size == capacity) {
            heap = Arrays.copyOf(heap, capacity * 2);
            capacity = capacity * 2;
        }
    }

    // 요소 피크(Peeking)는 O(1) 시간에 완료됩니다.
    public T peek() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        return heap[0];
    }

    // 요소 폴(Polling)은 O(log n) 시간에 완료됩니다.
    public T poll() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        T element = heap[0];

        heap[0] = heap[size - 1];
        heap[size - 1] = null;

        size--;

        heapifyDown();

        return element;
    }

    public void printHeap() {
        System.out.print("ROOT NODE: " + heap[0] + "\n");
        for (int i = 0; i < size; i++) {
            System.out.print("NODE: " + heap[i]);

            if (hasLeftChild(i)) {
                System.out.print(" LEFT NODE: " + heap[getLeftChildIndex(i)]);
            }

            if (hasRightChild(i)) {
                System.out.print(" RIGHT NODE: " + heap[getRightChildIndex(i)]);
            }

            System.out.println();
        }

        System.out.println();
    }

    // 요소를 폴한 후 힙 수정
    private void heapifyDown() {
        // 1단계: 힙의 루트를 현재 노드로 설정하여 시작합니다.
        int index = 0;

        while (hasLeftChild(index)) {
            // 2단계: 현재 노드의 자식 중 가장 큰 노드를 찾습니다.
            int largestChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index).compareTo(leftChild(index)) > 0) {
                largestChildIndex = getRightChildIndex(index);
            }

            // 3단계: 현재 노드가 가장 큰 자식보다 작으면 두 노드를 교환하고 2단계부터 반복합니다.
            if (heap[index].compareTo(heap[largestChildIndex]) < 0) {
                swap(index, largestChildIndex);
            } else {
                // 3단계: 그렇지 않으면 더 작업할 내용이 없으므로 알고리즘을 중단합니다.
                break;
            }

            index = largestChildIndex;
        }
    }

    // 새로운 요소를 추가한 후 힙을 수정
    private void heapifyUp() {
        // 1단계: 힙의 끝을 현재 노드로 설정하여 시작합니다.
        int index = size - 1;

        // 2단계: 2.	현재 노드에 부모가 있고 부모가 현재 노드보다 작다면 노드를 교환하고,
        // 부모가 현재 노드보다 클 때까지 반복합니다.
        while (hasParent(index) && parent(index).compareTo(heap[index]) < 0) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private T leftChild(int parentIndex) {
        return heap[getLeftChildIndex(parentIndex)];
    }

    private T rightChild(int parentIndex) {
        return heap[getRightChildIndex(parentIndex)];
    }

    private T parent(int childIndex) {
        return heap[getParentIndex(childIndex)];
    }

    private void swap(int index1, int index2) {
        T element = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = element;
    }

    public int size() {
        return size;
    }
}