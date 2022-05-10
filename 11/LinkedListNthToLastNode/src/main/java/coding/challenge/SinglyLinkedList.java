package coding.challenge;

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

    // 반복문을 활용한 풀이법: 시간 복잡도가 O(n), 공간 복잡도가 O(1)
    public int nthToLastIterative(int n) {
        // n > size일 때도 n을 추가할 수 있지만 연결 리스트 크기를 알 수 없음으로 간주합니다.
        if (n <= 0) {
            throw new IllegalArgumentException("The given n index is out of bounds");
        }

        // 2개의 순회 노드 포인터는 처음에 머리 노드를 가리킵니다.
        Node firstRunner = head;
        Node secondRunner = head;

        // 순회 노드 1이 n번째 위치로 이동합니다.
        for (int i = 0; i < n; i++) {
            if (firstRunner == null) {
                throw new IllegalArgumentException("The given n index is out of bounds");
            }
            firstRunner = firstRunner.next;
        }

        // 순회 노드 1이 null이 아닐 때까지 순회 노드 2가 이동합니다.
        // 순회 노드 1이 더 이상 이동할 수 없는 경우(null인 경우)
        // 순회 노드 2가 뒤에서 n번째 노드에 위치합니다.
        while (firstRunner != null) {
            firstRunner = firstRunner.next;
            secondRunner = secondRunner.next;
        }

        return secondRunner.data;
    }

    // 재귀 알고리즘을 활용한 풀이법: 시간 복잡도와 공간 복잡도가 O(n)
    int nthToLastRecursive(int n) {
        // n > size일 때도 n을 추가할 수 있지만 연결 리스트 크기를 알 수 없음으로 간주합니다.
        if (n <= 0) {
            throw new IllegalArgumentException("The given n index is out of bounds");
        }

        Node nodeResult = nthToLastRecursive(head, n);

        return nodeResult.data;
    }

    private static int position;

    private Node nthToLastRecursive(Node node, int n) {
        if (node == null) {
            return null;
        }

        Node nextNode = nthToLastRecursive(node.next, n);

        position++;
        if (position == n) {
            return node;
        }

        return nextNode;
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