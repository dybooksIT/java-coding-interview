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

    public void merge(SinglyLinkedList sll) {
        if(sll == null) {
            throw new IllegalArgumentException("Cannot merge null linked list");
        }

        // 2개의 리스트
        Node list1 = head;      // 병합된 연결 리스트(최종 결과)
        Node list2 = sll.head;  // 이 리스트에 있는 노드를 list1의 적절한 위치에 추가합니다.

        // 병합된 연결 리스트의 머리 노드가 list2의 머리 노드보다 크면 머리 노드를 교체합니다.
        if (list1.data < list2.data) {
            head = list1;
        } else {
            head = list2;
            list2 = list1;
            list1 = head;
        }

        // list1의 노드와 list2의 노드를 비교합니다.
        while (list1.next != null) {
            if (list1.next.data > list2.data) {
                Node auxNode = list1.next;
                list1.next = list2;
                list2 = auxNode;
            }
        
            // 병합된 연결 리스트의 마지막 노드로 이동합니다.
            list1 = list1.next;
        }

        // list2의 나머지 리스트를 추가합니다.
        if (list1.next == null) {
            list1.next = list2;
        }
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