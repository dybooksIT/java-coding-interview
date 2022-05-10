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

    public void merge(SinglyLinkedList[] slls, int n) {
        if (slls == null) {
            throw new IllegalArgumentException("Cannot merge null linked lists");
        }

        head = mergeLists(slls, n);
    }

    private Node mergeLists(SinglyLinkedList linkedlists[], int n) {
        int last = n - 1;

        // 연결 리스트 하나만 남을 때까지 반복 실행합니다.
        while (last != 0) {
            int p = 0;
            int q = last;
 
            // (p, q)는 한 쌍의 연결 리스트를 형성합니다.
            while (p < q) {
                // 리스트 p를 리스트 q와 병합하고 병합된 연결 리스트를 리스트 p에 저장합니다.
                linkedlists[p].head = merge(linkedlists[p].head, linkedlists[q].head);

                // 다음 쌍으로 이동합니다.
                p++;
                q--;

                // 모든 쌍이 병합되므로 마지막으로 업데이트합니다.
                if (p >= q) {
                    last = q;
                }
            }
        }

        return linkedlists[0].head;
    }

    private Node merge(Node list1, Node list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        Node resultNode;

        if (list1.data <= list2.data) {
            resultNode = list1;
            resultNode.next = merge(list1.next, list2);
        } else {
            resultNode = list2;
            resultNode.next = merge(list1, list2.next);
        }

        return resultNode;
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