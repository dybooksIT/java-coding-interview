package coding.challenge;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(2);
        queue.add(5);
        queue.add(8);
        queue.add(1);
        queue.add(9);
        queue.add(3);

        /* 원서 예제 코드의 큐 삽입 예
        queue.add(7);
        queue.add(1);
        queue.add(-7);
        queue.add(3);
        queue.add(9);
        queue.add(2);
        queue.add(1);
        queue.add(-1);
        queue.add(0);
        queue.add(0);
        queue.add(9);
        queue.add(2);
        queue.add(3);
        queue.add(1); */

        System.out.println("Given queue: " + queue);

        Queues.sort(queue);

        System.out.println("Sorted queue: " + queue);
    }
}