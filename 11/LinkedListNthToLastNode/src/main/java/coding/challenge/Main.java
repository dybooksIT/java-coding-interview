package coding.challenge;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList sll1 = new SinglyLinkedList();
        // SinglyLinkedList sll2 = new SinglyLinkedList();

        sll1.insertFirst(7);
        sll1.insertFirst(3);
        sll1.insertFirst(8);
        sll1.insertFirst(9);
        sll1.insertFirst(5);
        sll1.insertFirst(1);
        sll1.insertFirst(2);

        /* 원서 예제 코드
        sll.insertFirst(11);
        sll.insertFirst(10);
        sll.insertFirst(9);
        sll.insertFirst(8);
        sll.insertFirst(7);
        sll.insertFirst(6);
        sll.insertFirst(5);
        sll.insertFirst(4);
        sll.insertFirst(3);
        sll.insertFirst(2);
        sll.insertFirst(1); */

        sll1.print();

        int n1 = 5;
        int resultIterative1 = sll1.nthToLastIterative(n1);
        int resultRecursive1 = sll1.nthToLastRecursive(n1);

        System.out.println("\nIterative: The " + n1 + "th to last node has the value: " + resultIterative1);
        System.out.println("\nRecursive: The " + n1 + "th to last node has the value: " + resultRecursive1);

        /*
        sll2.print();

        int n2 = 1;
        int resultIterative2 = sll2.nthToLastIterative(n2);
        int resultRecursive2 = sll2.nthToLastRecursive(n2);

        System.out.println("\nIterative: The " + n2 + "th to last node has the value: " + resultIterative2);
        System.out.println("\nRecursive: The " + n2 + "th to last node has the value: " + resultRecursive2); */
    }
}