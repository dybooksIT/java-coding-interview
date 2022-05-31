package coding.challenge;

/* WAITING(일시 정지) 상태의 예:
   1. t1 스레드를 생성합니다.
   2. start 메서드를 통해 t1 실행을 시작합니다.
   3. t1의 run 메서드에서 다음을 수행합니다.
      1. 다른 스레드 t2를 생성합니다.
      2. start 메서드를 통해 t2 실행을 시작합니다.
      3. t2가 실행되는 동안 t2.join을 호출합니다. t2는 t1에
         조인(t1은 t2 실행이 종료될 때까지 대기해야 함)해야 하므로
         t1은 WAITING 상태입니다.
   4. t2의 run 메서드에서 t2는 t1의 상태를 출력합니다.
      이 상태는 WAITING이어야 합니다(t1 상태를 출력하는 동안 t2는 실행 중이므로 t1은 대기 중입니다).
*/

public class WaitingThread {
    private static final Thread t1 = new CodeT1();

    public void waitingThread() {
        t1.start();
    }

    private static class CodeT1 extends Thread {
        @Override
        public void run() {
            Thread t2 = new Thread(new CodeT2());
            t2.start();

            try {
                t2.join();
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                // 로그 관련 코드 삽입
            }
        }
    }

    private static class CodeT2 implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                // 로그 관련 코드 삽입
            }

            System.out.println("WaitingThread t1: " + t1.getState() + " \n");
        }
    }
}

/* 다른 구현 코드
    public void waitingThread() {
        new Thread(() -> {
            Thread t1 = Thread.currentThread();
            Thread t2 = new Thread(() -> {
                try {
                    Thread.sleep(2000);
                    System.out.println("WaitingThread t1: " + t1.getState() + "\n");
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    // 로그 관련 코드 삽입
                }
            });
            t2.start();
            try {
                t2.join();
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                // 로그 관련 코드 삽입
            }
        }).start();
    }
*/