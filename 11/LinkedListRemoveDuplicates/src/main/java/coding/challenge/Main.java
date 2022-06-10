package coding.challenge;

public class Main {
    public static void main(String[] args) {
       SinglyLinkedList sll1 = new SinglyLinkedList();
       SinglyLinkedList sll2 = new SinglyLinkedList();
       // SinglyLinkedList sll3 = new SinglyLinkedList();

       // removeDuplicates1 관련 연결 리스트
       sll1.insertFirst(7);
       sll1.insertFirst(5);
       sll1.insertFirst(5);
       sll1.insertFirst(1);

       // removeDuplicates2 관련 연결 리스트
       sll2.insertFirst(7);
       sll2.insertFirst(4);
       sll2.insertFirst(5);
       sll2.insertFirst(3);
       sll2.insertFirst(5);
       sll2.insertFirst(1);

       /* 원서 예제 코드
       sll3.insertFirst(5);
       sll3.insertFirst(2);
       sll3.insertFirst(12);
       sll3.insertFirst(2);
       sll3.insertFirst(12);
       sll3.insertFirst(5);
       sll3.insertFirst(5);
       sll3.insertFirst(12);
       sll3.insertFirst(1);
       sll3.insertFirst(4);
       sll3.insertFirst(12); */

       System.out.println("\nLinked list before removing duplicates:");
       sll1.print();
       sll1.removeDuplicates1();
       System.out.println("\nLinked list after removing duplicates:");
       sll1.print();

       System.out.println("\nSize: " + sll1.size());

       System.out.println("\nLinked list before removing duplicates:");
       sll2.print();
       sll2.removeDuplicates2();
       System.out.println("\nLinked list after removing duplicates:");
       sll2.print();

       System.out.println("\nSize: " + sll2.size());

       /*
       System.out.println("\nLinked list before removing duplicates:");
       sll3.print();
       sll3.removeDuplicates1();
       // sll3.removeDuplicates1();
       System.out.println("\nLinked list after removing duplicates:");
       sll3.print();

       System.out.println("\nSize: " + sll3.size()); */
    }
}