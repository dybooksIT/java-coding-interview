package coding.challenge;

public final class DoublyLinkedList {
    // 이중 연결 리스트의 단일 노드입니다.
    private final class Node {
        private int data;  // 노드에 들어 있는 데이터
        private Node next; // 다음 노드를 가리키는 포인터
        private Node prev; // 이전 노드를 가리키는 포인터

        @Override
        public String toString() {
            return " " + data + " ";
        }
    }

    private Node head; // 연결 리스트의 왼쪽 머리 노드
    private Node tail; // 연결 리스트의 오른쪽 꼬리 노드
    private int size;  // 연결 리스트의 크기(노드 개수)

    // 머리 노드가 null이면 연결 리스트가 비어 있는 것입니다.
    public boolean isEmpty() {
        return (head == null);
    }

    // 연결 리스트의 시작 부분에 노드를 삽입합니다.
    public void insertFirst(int data) {
        // newNode를 생성합니다.
        Node newNode = new Node();

        // newNode에 data 인수로 설정한 값을 저장합니다.
        newNode.data = data;

        // newNode를 첫 번째 노드로 리스트에 연결합니다.
        newNode.next = head;

        // 머리 노드의 데이터가 비어(null) 있지 않으면 newNode는 머리 노드의 이전 노드가 됩니다.
        if (head != null) {
            head.prev = newNode;
        }

        // newNode가 머리 노드가 됩니다.
        head = newNode;

        // 꼬리 노드의 데이터가 비어(null) 있으면 newNode는 꼬리 노드가 됩니다.
        if (tail == null) {
            tail = newNode;
        }

        // 연결 리스트의 크기를 1만큼 늘립니다.
        size++;
    }

    // 연결 리스트의 끝 부분에 노드를 삽입합니다.
    public void insertLast(int data) {
        // newNode를 생성합니다.
        Node newNode = new Node();

        // newNode에 data 인수로 설정한 값을 저장합니다.
        newNode.data = data;

        // newNode를 마지막 노드로 리스트에 연결합니다.
        // 꼬리 노드의 데이터가 비어(null) 있지 않으면 newNode는 꼬리 노드의 이전 노드가 됩니다.
        if (tail != null) {
            tail.next = newNode;
            newNode.prev = tail;
        }

        // newNode가 꼬리 노드가 됩니다.
        tail = newNode;

        // 머리 노드의 데이터가 비어(null) 있으면 newNode는 머리 노드가 됩니다.
        if (head == null) {
            head = newNode;
        }

        // 연결 리스트의 크기를 1만큼 늘립니다.
        size++;
    }

    // 특정 인덱스에 노드를 삽입합니다.
    public void insertAt(int index, int data) {
        // 머리 노드를 currentNode로 저장합니다.
        Node currentNode = head;

        // index값이 0이면 머리 노드가 삽입됩니다.
        if (index == 0 && currentNode != null) {
            insertFirst(data);
            return;
        }

        // index = size면 꼬리 노드가 삽입됩니다.
        if (index == size && currentNode != null) {
            insertLast(data);
            return;
        }

        // index > size면 안 되므로 RuntimeException을 처리합니다.
        if (index > size) {
            throw new RuntimeException("Index is larger than size!");
        }

        // index > 0이고 index <= size이면 다음을 처리합니다.
        int pointer = 0;
        while (currentNode != null) {
            if (pointer == index) {
                // newNode를 생성합니다.
                Node newNode = new Node();

                // newNode에 data 인수로 설정한 값을 저장합니다.
                newNode.data = data;

                // newNode를 currentNode 이전 노드의 다음 노드로 저장합니다.
                currentNode.prev.next = newNode;

                // currentNode의 이전 노드를 newNode의 이전 노드로 저장합니다.
                newNode.prev = currentNode.prev;

                // currentNode를 newNode의 다음 노드로 저장합니다.
                newNode.next = currentNode;

                // newNode를 currentNode의 이전 노드로 저장합니다.
                currentNode.prev = newNode;

                // 연결 리스트의 크기를 1만큼 늘립니다.
                size++;

                return;
            } else {
                // 다음 노드를 계속 검색합니다.
                currentNode = currentNode.next;

                pointer++;
            }
        }
    }

    // data값이 들어 있는 노드를 삭제합니다.
    public boolean delete(int data) {
        // 머리 노드를 currentNode로 저장합니다.
        Node currentNode = head;

        // data값이 머리 노드의 데이터와 같은지 확인합니다.
        if (currentNode != null && currentNode.data == data) {
            head = currentNode.next;

            // 머리 노드가 비어(null) 있지 않으면 머리 노드의 이전 노드 데이터를 null로 설정합니다.
            if (head != null) {
                head.prev = null;
            } else {
                // 머리 노드가 비어 있으면 꼬리 노드의 데이터를 null로 설정합니다.
                tail = null;
            }

            // 연결 리스트의 크기를 1만큼 줄입니다.
            size--;

            return true;
        }

        // data값이 머리 노드가 아닌 다른 위치에 있는지 확인합니다.
        while (currentNode != null && currentNode.data != data) {
            // currentNode.next를 currentNode로 저장(다음 노드로 이동)합니다.
            currentNode = currentNode.next;
        }

        // currentNode의 데이터가 비어 있지 않으면 data값은 currentNode에 있어야 합니다.
        if (currentNode != null) {
            if (currentNode != tail) {
                // currentNode.next를 currentNode.prev.next로 저장(이전 노드에서 currentNode의 연결을 해제)합니다.
                currentNode.prev.next = currentNode.next;

                // currentNode.prev를 currentNode.next.prev로 저장(다음 노드에서 currentNode의 연결을 해제)합니다.
                currentNode.next.prev = currentNode.prev;
            } else {
                // currentNode.prev를 꼬리 노드로 저장(꼬리 노드의 연결을 해제)합니다.
                tail = currentNode.prev;

                // 꼬리 노드가 비어(null) 있지 않으면 꼬리 노드의 다음 노드 데이터를 null로 설정합니다.
                if (tail != null) {
                    tail.next = null;
                } else {
                    // 꼬리 노드가 비어 있으면 머리 노드의 데이터를 null로 설정합니다.
                    head = null;
                }
            }

            // 연결 리스트의 크기를 1만큼 줄입니다.
            size--;

            return true;

        }

        // 주어진 data값을 찾을 수 없으면 false를 반환합니다.
        return false;
    }

    // index 위치의 노드를 삭제합니다.
    public boolean deleteByIndex(int index) {
        // 머리 노드를 currentNode로 저장합니다.
        Node currentNode = head;

        // index값이 0이면 머리 노드가 삭제됩니다.
        if (index == 0 && currentNode != null) {
            head = currentNode.next;

            // 머리 노드가 비어(null) 있지 않으면 머리 노드의 이전 노드 데이터를 null로 설정합니다.
            if (head != null) {
                head.prev = null;
            } else {
                // 머리 노드가 비어 있으면 꼬리 노드의 데이터를 null로 설정합니다.
                tail = null;
            }

            // 연결 리스트의 크기를 1만큼 줄입니다.
            size--;

            return true;
        }

        // index > 0이면 다음을 처리합니다.
        int pointer = 0;
        while (currentNode != null) {
            if (pointer == index) {
                if (pointer < (size - 1)) {
                    // currentNode.next를 currentNode.prev.next로 저장(이전 노드에서 currentNode의 연결을 해제)합니다.
                    currentNode.prev.next = currentNode.next;

                    // currentNode.prev를 currentNode.next.prev로 저장(다음 노드에서 currentNode의 연결을 해제)합니다.
                    currentNode.next.prev = currentNode.prev;
                } else {
                    // currentNode.prev를 꼬리 노드로 저장(꼬리 노드의 연결을 해제)합니다.
                    tail = currentNode.prev;

                    // 꼬리 노드가 비어(null) 있지 않으면 꼬리 노드의 다음 노드 데이터를 null로 설정합니다.
                    if (tail != null) {
                        tail.next = null;
                    } else {
                        // 꼬리 노드가 비어 있으면 머리 노드의 데이터를 null로 설정합니다.
                        head = null;
                    }
                }

                // 연결 리스트의 크기를 1만큼 줄입니다.
                size--;

                return true;

            } else {
                // 다음 노드를 계속 검색합니다.
                currentNode = currentNode.next;

                pointer++;
            }
        }

        // 주어진 index값을 찾을 수 없으면 false를 반환합니다.
        return false;
    }

    public void printHeadToLast() {
        System.out.println("\nHead (" + head + ") ----------> Last (" + tail + "):");

        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode);
            currentNode = currentNode.next;
        }

        System.out.println();
    }

    public void printLastToHead() {
        System.out.println("\nLast (" + tail + ") ----------> Head (" + head + "):");

        Node currentNode = tail;
        while (currentNode != null) {
            System.out.print(currentNode);
            currentNode = currentNode.prev;
        }

        System.out.println();
    }

    public int size() {
        return size;
    }
}