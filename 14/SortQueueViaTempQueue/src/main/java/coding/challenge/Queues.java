package coding.challenge;

import java.util.ArrayDeque;
import java.util.Queue;

public final class Queues {
    private Queues() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void sort(Queue<Integer> queue) {
        if (queue == null || queue.size() < 2) {
            return;
        }
 
        // 이것은 추가 큐입니다.
        Queue<Integer> extraQueue = new ArrayDeque();

        int count = 0;            // 처리한 요소의 개수를 셉니다.
        boolean sorted = false;   // 정렬 완료 여부를 기록합니다.

        int queueSize = queue.size();   // 주어진 큐의 크기
        int lastElement = queue.peek(); // 주어진 큐의 프런트에서부터 시작합니다.

        while (!sorted) {
            // 1단계: 추가 큐에 추가된 마지막 요소가
            // 주어진 큐의 앞 요소보다 작거나 같으면 지정된 큐에서
            // 앞 요소를 폴링하고 추가 큐에 푸시합니다.
            if (lastElement <= queue.peek()) {
                lastElement = queue.poll();
                extraQueue.add(lastElement);
            } // 2단계: 추가 큐에 추가된 마지막 요소가
              // 주어진 큐의 앞 요소보다 크면 지정된 큐에서
              // 앞 요소를 폴링하여 지정된 큐의 뒤쪽에 다시 넣습니다(나중에 처리됨).
            else {
                queue.add(queue.poll());
            }

            // 아직 처리할 요소가 남아있습니다.
            count++;
            if (count != queueSize) {
                continue;
            }

            // 4단계: 작업을 완료했는지 확인하기 위해 추가(정렬된) 큐의 길이를 확인합니다.
            if (extraQueue.size() == queueSize) {
                sorted = true;
            }

            // 3단계: 주어진 큐에 모든 요소를 넘깁니다.
            while (extraQueue.size() > 0) {
                queue.add(extraQueue.poll());
                lastElement = queue.peek();
            }

            count = 0;
        }
    }
}