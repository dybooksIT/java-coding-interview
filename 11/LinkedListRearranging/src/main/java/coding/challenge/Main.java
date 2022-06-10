package coding.challenge;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList sll1 = new SinglyLinkedList();
        // SinglyLinkedList sll2 = new SinglyLinkedList();

        sll1.insertFirst(7);
        sll1.insertFirst(2);
        sll1.insertFirst(3);
        sll1.insertFirst(4);
        sll1.insertFirst(5);
        sll1.insertFirst(1);

        /* 원서 예제 코드
        sll2.insertFirst(11);
        sll2.insertFirst(10);
        sll2.insertFirst(9);
        sll2.insertFirst(8);
        sll2.insertFirst(8);
        sll2.insertFirst(8);
        sll2.insertFirst(7);
        sll2.insertFirst(6);
        sll2.insertFirst(5);
        sll2.insertFirst(4);
        sll2.insertFirst(-3);
        sll2.insertFirst(2);
        sll2.insertFirst(1);
        sll2.insertFirst(11);
        sll2.insertFirst(90); */

        sll1.print();
        sll1.rearrange(3);
        sll1.print();

        /*
        sll2.print();
        sll2.rearrange(7);
        sll2.print(); */
    }
}