package coding.challenge;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Logger;

public class ExecuteTask {
    private static final Logger logger = Logger.getLogger(ExecuteTask.class.getName());

    // Runnable 인터페이스의 사용 예
    public void runnableExample() {
        Thread t = new Thread(() -> {
            System.out.println("Entered Runnable");

            // 일부 연산 수행
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                logger.severe(() -> "Exception: " + ex);
            }

            System.out.println("Hello from Runnable");
        });
        t.start();
    }

    // Callable 인터페이스의 사용 예
    public void callableExample() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> callable = () -> {
            System.out.println("Entered Callable");

            // 일부 연산 수행
            Thread.sleep(2000);

            return "Hello from Callable";
        };

        System.out.println("Submitting Callable");
        Future<String> future = executorService.submit(callable);

        // 다음 행은 바로 실행됩니다.
        System.out.println("Do something else while callable is getting executed");

        System.out.println("Retrieve the result of the future");

        // Future.get은 결과를 사용할 수 있을 때까지 차단합니다.
        String result = future.get();

        System.out.println(result);

        executorService.shutdown();
    }
}