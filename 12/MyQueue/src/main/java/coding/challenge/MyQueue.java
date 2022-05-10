package coding.challenge;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EmptyStackException;

public final class MyQueue<E> {
    private static final int DEFAULT_CAPACITY = 10;

    // 큐의 맨 앞 요소를 제거하고 반환하거나 제거하지 않고 반환할 때 사용합니다.
    private int front;

    // 큐의 맨 뒤에 요소를 추가할 때 사용합니다.
    private int rear;

    // 큐의 크기(큐의 요소 개수)
    private int count;

    // 큐의 용량(용량을 초과하면 2배가 됩니다).
    private int capacity;

    // 큐를 위한 배열
    private E[] queue;

    // 큐를 초기화하는 생성자
    MyQueue() {
        // 자바의 일반 배열은 인스턴스화할 수 없기 때문에
        // 자바 리플렉션(Reflection)을 사용합니다.
        queue = (E[]) Array.newInstance(
                Object[].class.getComponentType(), DEFAULT_CAPACITY);

        // 큐를 초기화했을 때의 크기(스택의 요소 개수)는 0입니다.
        count = 0;

        // 첫 번째 요소의 인덱스는 0입니다.
        front = 0;

        // 큐를 초기화했을 때는 요소가 없습니다.
        rear = -1;

        // 큐를 초기화했을 때의 용량은 10(요소 10개 저장 가능)입니다.
        capacity = DEFAULT_CAPACITY;
    }

    // 요소 'e'를 큐에 추가합니다.
    public void enqueue(E e) {
        // 큐가 가득 찼다면 용량을 2배로 늘립니다.
        if (isFull()) {
            ensureCapacity();
        }

        // 큐의 맨 뒤(rear)에 요소를 추가합니다.
        rear = (rear + 1) % capacity;
        queue[rear] = e;

        // 큐의 크기를 업데이트합니다.
        count++;
    }

    // 큐에서 맨 앞에 있는 요소(front)를 제거하고 반환합니다.
    public E dequeue() {
        // 큐가 비어 있으면 의미가 있는 예외를 던집니다.
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        // 큐의 맨 앞에서 요소를 추출합니다.
        E e = queue[front];
        queue[front] = null;

        // 새로운 맨 앞 요소(front)를 지정합니다.
        front = (front + 1) % capacity;

        // 큐의 크기를 줄입니다.
        count--;

        return e;
    }

    // 큐의 맨 앞 요소(front)를 제거하지 않고 반환합니다.
    public E peek() {
        // 큐가 비어 있으면 의미가 있는 예외를 던집니다.
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return queue[front];
    }

    // 큐의 크기(큐의 요소 개수)를 반환합니다.
    public int size() {
        return count;
    }

    // 큐가 비어 있는지를 확인합니다.
    public boolean isEmpty() {
        return size() == 0;
    }

    // 큐가 가득 찼는지를 확인합니다.
    public boolean isFull() {
        return size() == capacity;
    }

    // 큐의 용량을 2배로 늘리기 위해 클래스 내부에서 사용하는 메서드입니다.
    private void ensureCapacity() {
        int newSize = queue.length * 2;
        queue = Arrays.copyOf(queue, newSize);

        // 용량을 newSize에 저장된 값으로 설정합니다.
        capacity = newSize;
    }
}