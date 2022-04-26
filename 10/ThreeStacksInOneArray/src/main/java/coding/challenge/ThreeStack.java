package coding.challenge;

import coding.challenge.exception.OverflowException;
import coding.challenge.exception.UnderflowException;

public class ThreeStack {
    private static final int STACK_CAPACITY = 15;

    private int size;                               // 스택 크기
    private int nextFreeSlot;                       // 배열에 있는 다음 빈 슬롯
    private final StackNode[] theArray;             // 스택 배열
    private final int[] backLinks = {-1, -1, -1};   // 각 노드의 부모를 관리합니다.

    ThreeStack() {
        theArray = new StackNode[STACK_CAPACITY];
        initializeSlots();
    }

    public void push(int stackNumber, int value) throws OverflowException {
        if(stackNumber < 1 || stackNumber > 3) {
            throw new IllegalArgumentException("Choose between stack number 1, 2 or 3");
        }

        int stack = stackNumber - 1;
        int free = fetchIndexOfFreeSlot();
        int top = backLinks[stack];
        StackNode node = theArray[free];

        // 빈 슬롯을 현재 스택에 연결합니다.
        node.value = value;
        node.backLink = top;

        // 새로운 톱 노드를 설정합니다.
        backLinks[stack] = free;
    }

    public StackNode pop(int stackNumber) throws UnderflowException {
        if(stackNumber < 1 || stackNumber > 3) {
            throw new IllegalArgumentException("Choose between stack number 1, 2 or 3");
        }

        int stack = stackNumber - 1;
        int top = backLinks[stack];

        if (top == -1) {
            throw new UnderflowException("Stack Underflow");
        }

        StackNode node = theArray[top]; // 톱 노드를 가져옵니다.

        backLinks[stack] = node.backLink;
        freeSlot(top);

        return node;
    }

    public void printStacks() {
        for (int i = 0; i < 3; i++) {
            System.out.println("\nStack number: " + (i + 1));
            int s = backLinks[i];
            while (s != -1) {
                System.out.println(theArray[s]);
                s = theArray[s].backLink;
            }
        }
    }

    private int fetchIndexOfFreeSlot() throws OverflowException {
        if (size >= STACK_CAPACITY) {
            throw new OverflowException("Stack Overflow");
        }

        // 배열에 있는 다음 빈 슬롯을 가져옵니다.
        int free = nextFreeSlot;

        // 배열에서 다음 빈 슬롯을 설정하고 크기를 증가시킵니다.
        nextFreeSlot = theArray[free].backLink;
        size++;

        return free;
    }

    private void freeSlot(int index) {
        theArray[index].backLink = nextFreeSlot;
        nextFreeSlot = index;

        size--;
    }

    private void initializeSlots() {
        for (int i = 0; i < STACK_CAPACITY; i++) {
            theArray[i] = new StackNode(0, i + 1);
        }
    }
}