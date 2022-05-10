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

    public void insertFirst(int data) {
        Node newNode = new Node();

        newNode.data = data;
        newNode.next = head;
        head = newNode;
    }

    public void moveLastToFront1() {
        if (head == null || head.next == null) {
            throw new IllegalArgumentException("Linked list cannot be null or with a single node");
        }

        Node currentNode = head;

        // 1단계: 뒤에서 두 번째 노드로 포인터를 이동합니다.
        while (currentNode.next.next != null) {
            currentNode = currentNode.next;
        }

        // 2단계: currentNode.next를 nextNode에 저장합니다.
        Node nextNode = currentNode.next;

        // 3단계: currentNode.next의 데이터를 null로 만듭니다(꼬리 노드로 만듦)..
        currentNode.next = null;

        // 4단계: 저장한 노드를 새로운 머리 노드로 설정합니다.
        nextNode.next = head;
        head = nextNode;
    }

    public void moveLastToFront2() {
        if (head == null || head.next == null) {
            throw new IllegalArgumentException("Linked list cannot be null or with a single node");
        }

        Node currentNode = head;

        // 1단계: 뒤에서 두 번째 노드로 포인터를 이동합니다.
        while (currentNode.next.next != null) {
            currentNode = currentNode.next;
        }

        // 2단계: 연결 리스트를 원형 단일 연결 리스트로 변환합니다.
        currentNode.next.next = head;

        // 3단계: currentNode.next를 새로운 머리 노드로 설정합니다.
        head = currentNode.next;

        // 4단계: currentNode.next를 null로 설정하여 원형 연결을 끊습니다.
        currentNode.next = null;
    }

    public void print() {
        Node currentNode = head;

        while (currentNode != null) {
            System.out.print(currentNode);
            currentNode = currentNode.next;
        }

        System.out.println();
    }
}