package coding.challenge;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        // Executor 인터페이스의 사용 예
        SimpleExecutor se = new SimpleExecutor();
        se.execute(() -> {
            System.out.println("Simple task executed via Executor interface\n\n\n");
        });

        // ThreadPoolExecutor 인터페이스의 사용 예(ExecutorService의 본격적인 구현)
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(5);

        final AtomicInteger counter = new AtomicInteger();
        ThreadFactory threadFactory = (Runnable r) -> {
            System.out.println("Creating a new Cool-Thread-" + counter.incrementAndGet());
            return new Thread(r, "Cool-Thread-" + counter.get());
        };

        RejectedExecutionHandler rejectedHandler = (Runnable r, ThreadPoolExecutor executor) -> {
            if (r instanceof SimpleThreadPoolExecutor) {
                SimpleThreadPoolExecutor task = (SimpleThreadPoolExecutor) r;
                System.out.println("Rejecting task " + task.getTaskId());
            }
        };

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
          10, 20, 1, TimeUnit.SECONDS, queue, threadFactory, rejectedHandler);
        for (int i = 0; i < 50; i++) {
            executor.execute(new SimpleThreadPoolExecutor(i));
        }

        executor.shutdown();

        try {
            executor.awaitTermination(Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            // 로그 관련 코드 삽입
        }
    }
}