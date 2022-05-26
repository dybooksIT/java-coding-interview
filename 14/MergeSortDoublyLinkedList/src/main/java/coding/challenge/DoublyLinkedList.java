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
    private int size;

    public boolean isEmpty() {
        return (head == null);
    }

    public void insertFirst(int data) {
        Node newNode = new Node();

        newNode.data = data;
        newNode.next = head;

        if (head != null) {
            head.prev = newNode;
        }

        head = newNode;

        size++;
    }

    // 병합 정렬 알고리즘으로 주어진 연결 리스트를 정렬합니다.
    public void sort() {
        head = sort(head);
    }

    private Node sort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 머리 노드를 'head1' and 'head2'라는 하위 리스트로 분할합니다.
        Node head1 = head;
        Node head2;

        Node headResult = divide(head);
        head2 = headResult.next;
        headResult.next = null;

        // 재귀적으로 하위 리스트를 정렬합니다.
        head1 = sort(head1);
        head2 = sort(head2);

        // 정렬된 리스트 2개를 병합합니다.
        head = merge(head1, head2);

        return head;
    }

    // 주어진 연결 리스트를 동일한 하위 리스트 2개로 나눕니다.
    // 주어진 연결 리스트의 길이가 홀수면,
    // 남은 노드는 첫 번째 하위 리스트에 포함합니다.
    private Node divide(Node sourceNode) {
        Node fastRunner = sourceNode.next;  // 빠른 러너입니다.
        Node slowRunner = sourceNode;       // 느린 러너입니다.

        // 'firstRunner'는 두 노드씩 이동하고 'secondRunner'는 한 노드씩 이동합니다.
        while (fastRunner != null) {
            fastRunner = fastRunner.next;
            if (fastRunner != null) {
                slowRunner = slowRunner.next;
                fastRunner = fastRunner.next;
            }
        }

        return slowRunner;
    }

    // 오름차순으로 정렬된 리스트 2개를 가져와서
    // 반환된 노드를 함께 병합합니다.
    private Node merge(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        // 'head1' 또는 'head2'를 선택합니다.
        if (head1.data <= head2.data) {
            head1.next = merge(head1.next, head2);
            head1.next.prev = head1;
            head1.prev = null;

            return head1;
        } else {
            head2.next = merge(head1, head2.next);
            head2.next.prev = head2;
            head2.prev = null;

            return head2;
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

    public int size() {
        return size;
    }
}