package coding.challenge;

import java.util.Stack;

public final class SinglyLinkedList {
    private final class Node {
        private int data;
        private Node next;

        @Override
        public String toString() {
            return " " + data + " ";
        }
    }

    private Node head;
    private Node tail;

    public void insertFirst(int data) {
        Node newNode = new Node();

        newNode.data = data;
        newNode.next = head;
        head = newNode;

        if (tail == null) {
            tail = newNode;
        }
    }

    public boolean isPalindrome() {
        Node fastRunner = head;
        Node slowRunner = head;

        Stack<Integer> firstHalf = new Stack<>();

        // 연결 리스트의 왼쪽 절반이 스택에 쌓입니다.
        while (fastRunner != null && fastRunner.next != null) {
            firstHalf.push(slowRunner.data);

            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
        }

        // 요소 개수가 홀수라면 중간 노드를 건너 뛰어야 합니다.
        if (fastRunner != null) {
            slowRunner = slowRunner.next;
        }

        // 스택에서 값을 꺼내 연결 리스트의 오른쪽 절반의 노드와 비교합니다.
        while (slowRunner != null) {
            int top = firstHalf.pop();

            // 값이 일치하지 않으면 연결 리스트는 회문이 아닙니다.
            if (top != slowRunner.data) {
                return false;
            }

            slowRunner = slowRunner.next;
        }

        return true;
    }

    public void print() {
        System.out.println("\nHead (" + head + ") ----------> Last (" + tail + "):");

        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode);
            currentNode = currentNode.next;
        }

        System.out.println();
    }
}