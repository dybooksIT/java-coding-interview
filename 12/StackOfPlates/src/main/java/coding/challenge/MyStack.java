package coding.challenge;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Stack;

public class MyStack {
    private static final int STACK_SIZE = 3;

    private final LinkedList<Stack<Integer>> stacks = new LinkedList<>();

    public void push(int value) {
        // 스택이 없거나 마지막 스택이 가득 찬 경우
        if (stacks.isEmpty() || stacks.getLast().size() >= STACK_SIZE) {
            // 새로운 스택을 생성하고 값을 푸시합니다.
            Stack<Integer> stack = new Stack<>();
            stack.push(value);

            // 새로운 스택을 스택 리스트에 추가합니다.
            stacks.add(stack);
        } else {
            // 마지막 스택에 값을 추가합니다.
            stacks.getLast().push(value);
        }
    }

    public Integer pop() {
        if (stacks.isEmpty()) {
            throw new EmptyStackException();
        }

        // 마지막 스택을 찾습니다.
        Stack<Integer> lastStack = stacks.getLast();

        // 마지막 스택에서 값을 팝합니다.
        int value = lastStack.pop();

        // 마지막 스택이 비어 있으면 스택 리스트에서 제거합니다.
        removeStackIfEmpty();

        return value;
    }

    public Integer popAt(int stackIndex) {
        if (stacks.isEmpty()) {
            throw new EmptyStackException();
        }

        if (stackIndex < 0 || stackIndex >= stacks.size()) {
            throw new IllegalArgumentException("The given index is out of bounds");
        }

        // 해당 스택에서 값을 가져옵니다.
        int value = stacks.get(stackIndex).pop();

        // 요소를 팝하면 나머지 요소가 이동해야 합니다.
        shift(stackIndex);

        // 마지막 스택이 비어 있으면 스택 리스트에서 제거합니다.
        removeStackIfEmpty();

        return value;
    }

    private void shift(int index) {
        for (int i = index; i < stacks.size() - 1; ++i) {
            Stack<Integer> currentStack = stacks.get(i);
            Stack<Integer> nextStack = stacks.get(i + 1);

            currentStack.push(nextStack.remove(0));
        }
    }

    private void removeStackIfEmpty() {
        if (stacks.getLast().isEmpty()) {
            stacks.removeLast();
        }
    }

    public void printStacks() {
        for (int i = 0; i < stacks.size(); i++) {
            System.out.println("\nStack " + (i) + ": ");
            System.out.print("BOTTOM -> ");

            for (int value : stacks.get(i)) {
                System.out.print(value + " ");
            }

            System.out.print(" <- TOP\n");
        }
    }
}