package coding.challenge;

import coding.challenge.exception.OverflowException;
import coding.challenge.exception.UnderflowException;

public class Main {
    public static void main(String[] args) throws OverflowException, UnderflowException {
        ThreeStack ts = new ThreeStack(10);

        // 0 - 첫 번째 스택
        // 1 - 두 번째 스택
        // 2 - 세 번째 스택

        // 두 번째 스택에서 2, 12, 5를 푸시합니다.
        ts.push(1, 2);
        ts.push(1, 12);
        ts.push(1, 5);
        ts.printStacks();

        System.out.println("----------------------------------------");

        // 세 번째 스택에서 91, 21을 푸시하고 두 번째 스택에서 팝합니다.
        ts.push(2, 91);
        ts.push(2, 21);
        int value = ts.pop(1);
        System.out.println("\nPop from second stack: " + value);
        ts.printStacks();

        System.out.println("----------------------------------------");

        // 첫 번째 스택에서 23, 11, 3을 푸시합니다.
        ts.push(0, 23);
        ts.push(0, 11);
        ts.push(0, 3);
        ts.printStacks();

        System.out.println("----------------------------------------");

        // 각 스택에서 노드 하나를 팝합니다.
        int value1 = ts.pop(0);
        int value2 = ts.pop(1);
        int value3 = ts.pop(2);
        ts.printStacks();

        System.out.println();
        System.out.println("Pop: " + value1);
        System.out.println("Pop: " + value2);
        System.out.println("Pop: " + value3);
    }
}