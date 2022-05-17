package coding.challenge;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();

        sll.insertFirst(2);
        sll.insertFirst(1);
        sll.insertFirst(4);
        sll.insertFirst(9);
        sll.insertFirst(4);
        sll.insertFirst(1);
        sll.insertFirst(2);

        /*
        sll.insertFirst(11);
        sll.insertFirst(10);
        sll.insertFirst(9);
        sll.insertFirst(8);
        sll.insertFirst(9);
        sll.insertFirst(10);
        sll.insertFirst(11); */

        sll.print();

        boolean result = sll.isPalindrome();

        System.out.println("\nIs it palindrome? " + result);
    }
}