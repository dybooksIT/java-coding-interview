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

    private final class PairNode {
        private final Node head;
        private final Node tail;

        public PairNode(Node head, Node tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    private Node head;
    private Node tail;

    public int intersection() {
        // 다음 코드는 풀이법과 관련된 코드는 아니고
        // 교차점이 있는 임의의 연결 리스트 2개를 생성하려고 호출합니다.
        PairNode pair = generateTwoLinkedListWithInterection();

        // 첫 번째 리스트의 머리 노드
        Node currentNode1 = pair.head;

        // 두 번째 리스트의 머리 노드
        Node currentNode2 = pair.tail;

        // 두 연결 리스트의 길이를 계산합니다.
        // linkedListSize는 헬퍼 메서드입니다.
        int s1 = linkedListSize(currentNode1);
        int s2 = linkedListSize(currentNode2);

        // 첫 번째 연결 리스트의 길이가 두 번째 연결 리스트의 길이보다 깁니다.
        if (s1 > s2) {
            for (int i = 0; i < (s1 - s2); i++) {
                currentNode1 = currentNode1.next;
            }
        } else {
            // 두 번째 연결 리스트의 길이가 첫 번째 연결 리스트의 길이보다 깁니다.
            for (int i = 0; i < (s2 - s1); i++) {
                currentNode2 = currentNode2.next;
            }
        }

        // 끝 또는 교차 노드를 만날 때까지 두 리스트를 순회합니다.
        while (currentNode1 != null && currentNode2 != null) {
            // 값이 아닌 참조를 비교합니다!
            if (currentNode1 == currentNode2) {
                return currentNode1.data;
            }

            currentNode1 = currentNode1.next;
            currentNode2 = currentNode2.next;
        }

        return -1;
    }

    private PairNode generateTwoLinkedListWithInterection() {
        // 1개에서 10개 노드 사이의 리스트에 대해 임의 크기를 선택합니다.
        int size1 = new Random().nextInt(10) + 1;
        int size2 = new Random().nextInt(10) + 1;
        int size3 = new Random().nextInt(10) + 1;

        PairNode firstList = generateLinkedList(size1);
        PairNode secondList = generateLinkedList(size2);

        PairNode commonList = generateLinkedList(size3);

        // 교차점에 더미 값 설정
        commonList.head.data = 9999;

        // 교차점 생성
        firstList.tail.next = commonList.head;
        secondList.tail.next = commonList.head;

        System.out.println("\nFirst linked list size: " + (size1 + size3));
        print(firstList.head, commonList.tail);

        System.out.println("\nSecond linked list size: " + (size2 + size3));
        print(secondList.head, commonList.tail);

        return new PairNode(firstList.head, secondList.head);
    }

    private PairNode generateLinkedList(int size) {
        head = null;
        tail = null;

        for (int i = 1; i <= size; i++) {
            Node newNode = new Node();

            newNode.data = i;
            newNode.next = head;
            head = newNode;

            if (tail == null) {
                tail = newNode;
            }
        }

        return new PairNode(head, tail);
    }

    private int linkedListSize(Node head) {
        Node currentNode = head;
        int count = 0;

        while (currentNode != null) {
            count++;
            currentNode = currentNode.next;
        }

        return count;
    }

    private void print(Node head, Node tail) {
        System.out.println("\nHead (" + head + ") ----------> Last (" + tail + "):");

        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode);
            currentNode = currentNode.next;
        }

        System.out.println();
    }
}