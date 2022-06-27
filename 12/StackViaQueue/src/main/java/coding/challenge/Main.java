package coding.challenge;

public class Main {
    public static void main(String[] args) {
        MyStackViaQueue<Integer> stack = new MyStackViaQueue();

        stack.push(2);
        stack.push(5);
        stack.push(3);
        stack.push(1);
        stack.push(6);
        stack.pop();

        /* 원서 예제 코드를 실행하려면 이 주석 처리를 해제하고 위 stack.push와 pop 메서드를 주석 처리하세요.
        stack.push(25);
        stack.push(35);
        stack.push(15);

        System.out.println("Size: " + stack.size());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Size: " + stack.size());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Size: " + stack.size());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Size: " + stack.size());
        System.out.println("Push 17");
        stack.push(17);
        System.out.println("Push 12");
        stack.push(12);
        System.out.println("Peek: " + stack.peek());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Size: " + stack.size());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Size: " + stack.size());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Size: " + stack.size());
        System.out.println("Push 55");
        stack.push(55);
        System.out.println("Size: " + stack.size());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Size: " + stack.size());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Size: " + stack.size());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Size: " + stack.size());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Size: " + stack.size()); */
    }
}