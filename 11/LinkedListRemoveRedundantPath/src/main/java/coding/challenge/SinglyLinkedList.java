package coding.challenge;

public final class SinglyLinkedList {
    private final class Node {
        private int r;
        private int c;
        private Node next;

        @Override
        public String toString() {
            return " (" + r + ", " + c + ") ";
        }
    }

    private Node head;
    private Node tail;

    public void insertFirst(int r, int c) {
        Node newNode = new Node();

        newNode.r = r;
        newNode.c = c;
        newNode.next = head;
        head = newNode;

        if (tail == null) {
            tail = newNode;
        }
    }

    public void removeRedundantPath() {
        Node currentNode = head;

        while (currentNode.next != null && currentNode.next.next != null) {
            Node middleNode = currentNode.next.next;

            // 동일한 열에 있는 연속된 3개의 수직 경로 노드를 확인합니다.
            if (currentNode.c == currentNode.next.c && currentNode.c == middleNode.c) {
                // 중간 노드를 삭제합니다.
                currentNode.next = middleNode;
            }
            // 동일한 행에 있는 연속된 3개의 수평 노드를 확인합니다.
            else if (currentNode.r == currentNode.next.r && currentNode.r == middleNode.r) {
                // 중간 노드를 삭제합니다.
                currentNode.next = middleNode;
            } else {
                currentNode = currentNode.next;
            }
        }
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