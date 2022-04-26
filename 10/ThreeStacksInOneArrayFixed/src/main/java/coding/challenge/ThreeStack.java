package coding.challenge;

import coding.challenge.exception.OverflowException;
import coding.challenge.exception.UnderflowException;

public class ThreeStack {
    private static final int NO_OF_STACKS = 3;    // 고정된 영역의 수

    private final int stackCapacity;    // 스택 크기
    private final int[] values;         // 고정된 영역에 있는 노드
    private final int[] stacks;         // 고정된 영역

    public ThreeStack(int stackSize) {
        stackCapacity = stackSize;
        values = new int[stackSize * NO_OF_STACKS];
        stacks = new int[NO_OF_STACKS];
    }

    public void push(int stackNumber, int value) throws OverflowException {
        if (isFull(stackNumber)) {
            throw new OverflowException("Stack Overflow");
        }

        // 스택 포인터를 증가한 후 톱 값을 업데이트합니다.
        stacks[stackNumber]++;
        values[fetchTopIndex(stackNumber)] = value;
    }

    public int pop(int stackNumber) throws UnderflowException {
        if (isEmpty(stackNumber)) {
            throw new UnderflowException("Stack Underflow");
        }

        int topIndex = fetchTopIndex(stackNumber);
        int value = values[topIndex];

        values[topIndex] = 0;
        stacks[stackNumber]--;

        return value;
    }

    public int peek(int stackNumber) throws UnderflowException {
        if (isEmpty(stackNumber)) {
            throw new UnderflowException("Stack Underflow");
        }

        return values[fetchTopIndex(stackNumber)];
    }

    public boolean isEmpty(int stackNumber) {
        return stacks[stackNumber] == 0;
    }

    public boolean isFull(int stackNumber) {
        return stacks[stackNumber] == stackCapacity;
    }

    private int fetchTopIndex(int stackNumber) {
        int offset = stackNumber * stackCapacity;
        int size = stacks[stackNumber];

        return offset + size - 1;
    }

    public void printStacks() {
        for (int i = 0; i < NO_OF_STACKS; i++) {
            System.out.println("\nStack number: " + (i+1));

            if (!isEmpty(i)) {
                int topIndex = fetchTopIndex(i);
                while (values[topIndex] != 0 && topIndex > 0) {
                    System.out.println(values[topIndex]);
                    topIndex--;
                }
            } else {
                System.out.println("\nStack number: " + (i+1) + " is empty!");
            }
        }
    }
}