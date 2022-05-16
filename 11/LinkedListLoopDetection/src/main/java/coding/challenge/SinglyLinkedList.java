package coding.challenge;

import java.util.Random;

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
    private int size;

    public void insertFirst(int data) {
        Node newNode = new Node();

        newNode.data = data;
        newNode.next = head;
        head = newNode;

        if (tail == null) {
            tail = newNode;
        }

        size++;
    }

    // 반복 실행 예: 반복 실행은 값이 3인 노드에서 시작합니다.
    // 0 -> 1 -> 2 -> 3 -> 4 -> 5
    //               /           \
    //              10            6
    //               \           /
    //                9 <- 8 <- 7
    // 이것은 랜덤 반복 실행을 생성하기 위한 헬퍼일 뿐입니다.
    public void generateLoop() {
        if (size < 2) {
            throw new RuntimeException("The linked list size must be at least 2");
        }

        Node currentNode = head;
        int rnd = new Random().nextInt(size - 1);

        for (int i = 0; i < rnd; i++) {
            currentNode = currentNode.next;
        }

        System.out.println("The generated loop starts at the node with value: " + currentNode);

        // 반복 실행 생성
        tail.next = currentNode;
    }

    public void findLoopStartNode() {
        Node slowRunner = head;
        Node fastRunner = head;

        // 빠른 러너가 느린 러너와 마주칩니다.
        while (fastRunner != null && fastRunner.next != null) {
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
            if (slowRunner == fastRunner) { // 두 노드가 만났습니다.
                System.out.println("\nThe meet point is at the node with value: " + slowRunner);
                break;
            }
        }

        // 만나는 지점이 없다면 고리가 없는 것입니다.
        if (fastRunner == null || fastRunner.next == null) {
            return;
        }

        // 느린 러너가 연결 리스트의 머리 노드로 이동합니다.
        // 빠른 러너는 충돌한 지점에 멈춰 있습니다.
        // 두 노드는 한 노드씩 동시에 이동하면서 고리의 시작점에서 만납니다.
        slowRunner = head;
        while (slowRunner != fastRunner) {
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next;
        }

        // 두 포인터 모두 고리의 시작점을 가리킵니다.
        System.out.println("\nLoop start detected at the node with value: " + fastRunner);
    }

    public void print() {
        System.out.println("\nHead (" + head + ") ----------> Last (" + tail + "):");

        Node currentNode = head;
        for (int i = 0; i < size; i++) {
            System.out.print(currentNode);
            currentNode = currentNode.next;
        }

        System.out.println();
    }
}