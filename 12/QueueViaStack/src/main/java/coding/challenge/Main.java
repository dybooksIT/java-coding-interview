package coding.challenge;

public class Main {
    public static void main(String[] args) {
        MyQueueViaStack<Integer> stack = new MyQueueViaStack();

        stack.enqueue(2);
        stack.enqueue(5);
        stack.enqueue(3);
        stack.enqueue(1);
        stack.enqueue(6);
        stack.dequeue();

        /* 원서 예제 코드를 실행하려면 이 주석 처리를 해제하고 위 stack.enqueue와 dequeue 메서드를 주석 처리하세요.
        stack.enqueue(25);
        stack.enqueue(35);
        stack.enqueue(15);

        System.out.println("Size: " + stack.size());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Size: " + stack.size());
        System.out.println("Pop: " + stack.dequeue());
        System.out.println("Size: " + stack.size());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Size: " + stack.size());
        System.out.println("Push 17");
        stack.enqueue(17);
        System.out.println("Peek: " + stack.peek());
        System.out.println("Size: " + stack.size());
        System.out.println("Pop: " + stack.dequeue());
        System.out.println("Size: " + stack.size());
        System.out.println("Pop: " + stack.dequeue());
        System.out.println("Size: " + stack.size());
        System.out.println("Push 55");
        stack.enqueue(55);
        System.out.println("Size: " + stack.size());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Size: " + stack.size());
        System.out.println("Pop: " + stack.dequeue());
        System.out.println("Size: " + stack.size());
        System.out.println("Pop: " + stack.dequeue());
        System.out.println("Size: " + stack.size()); */
    }
}