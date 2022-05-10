package coding.challenge;

public final class DoublyLinkedList {
    private final class Node {
        private int data;
        private Node next;
        private Node prev;

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

        if (head != null) {
            head.prev = newNode;
        }

        head = newNode;
    }

    public void reverse() {
        Node currentNode = head;
        Node prevNode = null;

        while (currentNode != null) {
            // 현재 노드의 다음 포인터와 이전 포인터를 바꿉니다.
            Node prev = currentNode.prev;
            currentNode.prev = currentNode.next;
            currentNode.next = prev;

            // 다음 노드로 이동하기 전에 이전 노드를 업데이트합니다.
            prevNode = currentNode;

            // 이중 연결 리스트의 다음 노드로 이동합니다.
            currentNode = currentNode.prev;
        }

        // 머리 노드가 마지막 노드를 가리키도록 업데이트합니다.
        if (prevNode != null) {
            head = prevNode;
        }
    }

    public void print() {
        System.out.println("\nHead (" + head + ") ----------> Last:");

        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode);
            currentNode = currentNode.next;
        }

        System.out.println();
    }
}