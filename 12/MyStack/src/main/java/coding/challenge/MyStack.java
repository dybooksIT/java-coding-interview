package coding.challenge;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EmptyStackException;

public final class MyStack<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private int top;   // 스택의 톱 요소
    private E[] stack; // 스택 뒤에 있는 배열

    // 스택을 초기화하는 생성자
    MyStack() {
        // 자바의 일반 배열은 인스턴스화할 수 없기 때문에 자바 리플렉션(Reflection)을 사용합니다.
        stack = (E[]) Array.newInstance(
                Object[].class.getComponentType(), DEFAULT_CAPACITY);

        top = 0; // 스택을 초기화했을 때의 크기(스택의 요소 개수)는 0입니다.
    }

    // 요소 'e'를 스택에 추가합니다.
    public void push(E e) {
        // 스택이 가득 찼다면 용량을 2배로 늘립니다.
        if (isFull()) {
            ensureCapacity();
        }

        // 스택의 맨 위에 요소를 추가합니다.
        stack[top++] = e;
    }

    // 스택에서 톱 요소를 꺼냅니다.
    public E pop() {
        // 스택이 비어 있으면 의미가 있는 예외를 던집니다.
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        // 스택에서 톱 요소를 추출합니다.
        E e = stack[--top];

        // 메모리 누수를 방지합니다.
        stack[top] = null;

        return e;
    }

    // 스택의 톱 요소를 제거하지 않고 반환합니다.
    public E peek() {
        // 스택이 비어 있으면 의미가 있는 예외를 던집니다.
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return stack[top - 1];
    }

    // 스택의 크기(스택의 요소 개수)를 반환합니다.
    public int size() {
        return top;
    }

    // 스택이 비어 있는지를 확인합니다.
    public boolean isEmpty() {
        return top == 0;
    }

    // 스택이 가득 찼는지를 확인합니다.
    public boolean isFull() {
        return top == stack.length;
    }

    // 스택의 용량을 2배로 늘리기 위해 클래스 내부에서 사용하는 메서드입니다.
    private void ensureCapacity() {
        int newSize = stack.length * 2;
        stack = Arrays.copyOf(stack, newSize);
    }
}