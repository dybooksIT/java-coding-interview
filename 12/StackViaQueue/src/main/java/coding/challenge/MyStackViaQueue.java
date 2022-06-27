package coding.challenge;

import java.util.ArrayDeque;
import java.util.EmptyStackException;
import java.util.Queue;

public class MyStackViaQueue<E> {
    private final Queue<E> queue1;
    private final Queue<E> queue2;
    private E peek;
    private int size;

    public MyStackViaQueue() {
        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
    }

    /* 원서 예제 코드를 실행하려면 주석 처리를 풀고 아래 push 메서드를 주석처리 하세요.
    public void push(E e) {
        if (!queue1.isEmpty()) {
            if (peek != null) {
                queue1.add(peek);
            }
            queue1.add(e);
        } else {
            if (peek != null) {
                queue2.add(peek);
            }
            queue2.add(e);
        }

        size++;
        peek = null;
    } */

    public void push(E e) {
        if (!queue1.isEmpty()) {
            if (peek != null) {
                queue1.add(peek);
            }

            queue1.add(e);
            System.out.println("queue1 push: " + e);
            showQueuesStatus();
        } else {
            if (peek != null) {
                queue2.add(peek);
            }
            queue2.add(e);
            System.out.println("queue2 push: " + e);
            showQueuesStatus();
        }

        size++;
        peek = null;
    }

    /* 원서 예제 코드를 실행하려면 주석 처리를 풀고 아래 pop 메서드를 주석처리 하세요.
    public E pop() {
        if (size() == 0) {
            throw new EmptyStackException();
        }

        if (peek != null) {
            E e = peek;
            peek = null;
            size--;

            return e;
        }

        E e;
        if (!queue1.isEmpty()) {
            e = switchQueue(queue1, queue2);
        } else {
            e = switchQueue(queue2, queue1);
        }

        size--;
        return e;
    } */

    public E pop() {
        if (size() == 0) {
            throw new EmptyStackException();
        }

        if (peek != null) {
            E e = peek;
            peek = null;
            size--;

            return e;
        }

        E e;
        if (!queue1.isEmpty()) {
            e = switchQueue(queue1, queue2);
            System.out.println("queue1 pop: " + e);
            showQueuesStatus();
        } else {
            e = switchQueue(queue2, queue1);
            System.out.println("queue2 pop: " + e);
            showQueuesStatus();
        }

        size--;
        return e;
    }

    // 원서 예제 코드를 실행하려면 showQueuesStatus 메서드 전체를 주석 처리하세요.
    public void showQueuesStatus() {
        System.out.println("====================");
        System.out.println("queue1 Status");
        System.out.println(queue1);
        System.out.println("Size: " + queue1.size());
        System.out.println("queue2 Status");
        System.out.println(queue2);
        System.out.println("Size: " + queue2.size());
        System.out.println("--------------------");
        System.out.println("");
    }

    public E peek() {
        if (size() == 0) {
            throw new EmptyStackException();
        }

        if (peek == null) {
            if (!queue1.isEmpty()) {
                peek = switchQueue(queue1, queue2);
            } else {
                peek = switchQueue(queue2, queue1);
            }
        }

        return peek;
    }

    public int size() {
        return size;
    }

    private E switchQueue(Queue from, Queue to) {
        while (from.size() > 1) {
            to.add(from.poll());
        }

        return (E) from.poll();
    }
}