package coding.challenge;

import java.util.Queue;

public final class Queues {
    private Queues() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void sort(Queue<Integer> queue) {
        if (queue == null || queue.size() < 2) {
            return;
        }

        // 큐의 정렬되지 않은 부분을 순회합니다.
        for (int i = 1; i <= queue.size(); i++) {
            moveMinToRear(queue, queue.size() - i);
        }
    }

    // 정렬되지 않은 부분에서 최소 요소를 찾고 이 요소를 큐의 뒤쪽으로 옮깁니다.
    private static void moveMinToRear(Queue<Integer> queue, int sortIndex) {
        int minElement = Integer.MAX_VALUE;
        boolean flag = false;

        int queueSize = queue.size();
        for (int i = 0; i < queueSize; i++) {
            int currentElement = queue.peek();

            // 요소를 추출(dequeue)합니다.
            queue.poll();

            // 큐의 정렬된 부분을 순회하지 않도록 합니다.
            if (currentElement <= minElement && i <= sortIndex) {
                // 이전에 최솟값을 찾았다면
                // 현재 새로운 최솟값을 찾았으므로
                // 이전 최솟값을 큐에 다시 삽입합니다.
                if (flag) {
                    queue.add(minElement);
                }

                flag = true;
                minElement = currentElement;
            } else {
                // 최솟값이 아닌 현재 요소를 큐에 삽입(enqueue)합니다.
                queue.add(currentElement);
            }
        }

        // 최소 요소를 큐에 삽입(enqueue)합니다.
        queue.add(minElement);
    }
}