package coding.challenge;

import java.util.Stack;

public class MyQueueViaStack<E> {
    private final Stack<E> stackEnqueue;
    private final Stack<E> stackDequeue;

    public MyQueueViaStack() {
        stackEnqueue = new Stack<>();
        stackDequeue = new Stack<>();
    }

    /* 원서 예제 코드를 실행하려면 주석 처리를 풀고 아래 enqueue를 주석처리 하세요.
    public void enqueue(E e) {
        stackEnqueue.push(e);
    } */

    public void enqueue(E e) {
        stackEnqueue.push(e);
        System.out.println("enqueued: " + e);
        showQueuesStatus();
    }

    /* 원서 예제 코드를 실행하려면 주석 처리를 풀고 아래 dequeue를 주석처리 하세요.
    public E dequeue() {
        reverseStackEnqueue();
        return stackDequeue.pop();
    } */

    public E dequeue() {
        reverseStackEnqueue();
        E r = stackDequeue.pop();
        System.out.println("dequeued: " + r);
        showQueuesStatus();
        return r;
    }

    public void showQueuesStatus() {
        System.out.println("====================");
        System.out.println("Enqueue stack Status");
        System.out.println(stackEnqueue);
        System.out.println("Size: " + stackEnqueue.size());
        System.out.println("Dequeue stack Status");
        System.out.println(stackDequeue);
        System.out.println("Size: " + stackDequeue.size());
        System.out.println("--------------------");
        System.out.println("");
    }

    public E peek() {
        reverseStackEnqueue();
        return stackDequeue.peek();
    }

    public int size() {
        return stackEnqueue.size() + stackDequeue.size();
    }

    private void reverseStackEnqueue() {
        if (stackDequeue.isEmpty()) {
            while (!stackEnqueue.isEmpty()) {
                stackDequeue.push(stackEnqueue.pop());
            }
        }
    }
}