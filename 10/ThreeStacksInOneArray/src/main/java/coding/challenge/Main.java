package coding.challenge;

import coding.challenge.exception.OverflowException;
import coding.challenge.exception.UnderflowException;

public class Main {
    public static void main(String[] args) throws OverflowException, UnderflowException {
        ThreeStack ts = new ThreeStack();

        // 1 - 첫 번째 스택입니다.
        // 2 - 두 번째 스택입니다.
        // 3 - 세 번째 스택입니다.

        // 두 번째 스택에서 2, 12, 1을 푸시합니다.
        ts.push(2, 2);
        ts.push(2, 12);
        ts.push(2, 1);
        ts.printStacks();

        System.out.println("----------------------------------------");

        // 세 번째 스택에서 91, 21을 푸시하고 두 번째 스택에서 팝합니다.
        ts.push(3, 91);
        ts.push(3, 21);
        StackNode sn = ts.pop(2);
        System.out.println("\nPop from second stack: " + sn.value);
        ts.printStacks();

        System.out.println("----------------------------------------");

        // 첫 번째 스택에서 23, 11, 3을 푸시합니다.
        ts.push(1, 23);
        ts.push(1, 11);
        ts.push(1, 3);
        ts.printStacks();

        System.out.println("----------------------------------------");

        // 각 스택에서 노드 하나를 팝합니다.
        StackNode sn1 = ts.pop(1);
        StackNode sn2 = ts.pop(2);
        StackNode sn3 = ts.pop(3);
        ts.printStacks();

        System.out.println();
        System.out.println("Pop: " + sn1.value);
        System.out.println("Pop: " + sn2.value);
        System.out.println("Pop: " + sn3.value);
    }
}