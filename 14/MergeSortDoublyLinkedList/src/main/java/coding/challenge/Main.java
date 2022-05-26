package coding.challenge;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.insertFirst(7);
        dll.insertFirst(3);
        dll.insertFirst(8);
        dll.insertFirst(9);
        dll.insertFirst(4);
        dll.insertFirst(1);
        dll.insertFirst(2);

        /* 원서 예제 코드에 있는 연결 리스트 삽입
        dll.insertFirst(2);
        dll.insertFirst(12);
        dll.insertFirst(9);
        dll.insertFirst(10);
        dll.insertFirst(-9);
        dll.insertFirst(56);
        dll.insertFirst(1);
        dll.insertFirst(-2);
        dll.insertFirst(10);
        dll.insertFirst(0);
        dll.insertFirst(10); */

        System.out.println("Initial list:");
        dll.print();

        dll.sort();

        System.out.println("\nSorted list:");
        dll.print();
    }
}