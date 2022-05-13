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
    private int size;

    public boolean isEmpty() {
        return (head == null);
    }

    public void insertFirst(int data) {
        Node newNode = new Node();

        newNode.data = data;
        newNode.next = head;
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

        // 머리 노드를 2개의 하위 리스트로 분할합니다.
        Node[] headsOfSublists = divide(head);

        Node head1 = headsOfSublists[0];  // head of the first sublist
        Node head2 = headsOfSublists[1];  // head of the second sublist

        // 재귀적으로 하위 리스트를 정렬합니다.
        head1 = sort(head1);
        head2 = sort(head2);

        // 2개의 정렬된 리스트를 병합합니다.
        return merge(head1, head2);
    }

    // 주어진 연결 리스트를 2개의 동일한 하위 리스트로 나눕니다.
    // 주어진 연결 리스트의 길이가 홀수면,
    // 남은 노드는 첫 번째 하위 리스트에 포함합니다.
    private Node[] divide(Node sourceNode) {
        // 길이가 2보다 작을 경우
        if (sourceNode == null || sourceNode.next == null) {
            return new Node[]{sourceNode, null};
        }

        Node fastRunner = sourceNode.next;  // 빠른 순회 노드입니다.
        Node slowRunner = sourceNode;       // 느린 순회 노드입니다.

        // 'firstRunner'는 두 노드씩 이동하고 'secondRunner'는 한 노드씩 이동합니다.
        while (fastRunner != null) {
            fastRunner = fastRunner.next;
            if (fastRunner != null) {
                slowRunner = slowRunner.next;
                fastRunner = fastRunner.next;
            }
        }

        // 'secondRunner'는 리스트의 중간 지점 바로 앞에 있으므로
        // 해당 지점에서 리스트를 둘로 나눕니다.
        Node[] headsOfSublists = new Node[]{sourceNode, slowRunner.next};
        slowRunner.next = null;

        return headsOfSublists;
    }

    // 오름차순으로 정렬된 2개의 리스트를 가져와서
    // 반환된 노드를 함께 병합합니다.
    private Node merge(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }

        Node merged;

        // 'head1' 또는 'head2'를 선택합니다.
        if (head1.data <= head2.data) {
            merged = head1;
            merged.next = merge(head1.next, head2);
        } else {
            merged = head2;
            merged.next = merge(head1, head2.next);
        }

        return merged;
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