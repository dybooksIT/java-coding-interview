package coding.challenge;

/* BLOCKED 상태의 시나리오:
   1) t1과 t2라는 스레드 2개를 생성합니다.
   2) start 메서드를 통해 t1 실행을 시작합니다:
      1) t1은 run 메서드를 실행하고 동기화 메서드 syncMethod에 대한 잠금 권한을 얻습니다.
      2) syncMethod 메서드는 무한 루프가 있기 때문에 t1을 영원히 내부에 유지합니다.
   3) 2초(임의 시간) 후 start 메서드를 통해 t2 실행을 시작합니다.
      1) t2는 run 메서드를 실행하고 syncMethod 메서드의 잠금을 얻지 못하므로 BLOCKED 상태로 완료됩니다.
*/

public class BlockedThread {
    public void blockedThread() {
        Thread t1 = new Thread(new SyncBlockCode());
        Thread t2 = new Thread(new SyncBlockCode());

        t1.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            // 로그 관련 코드 삽입
        }

        t2.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            // 로그 관련 코드 삽입
        }

        System.out.println("Blocked thread t1: " 
          + t1.getState() + "(" + t1.getName() + ")");
        System.out.println("Blocked thread t2: " 
          + t2.getState() + "(" + t2.getName() + ")");

        System.exit(0);
    }

    private static class SyncBlockCode implements Runnable {
        @Override
        public void run() {
            System.out.println("Thread " 
              + Thread.currentThread().getName() + " is in run() method");
            syncMethod();
        }

        public static synchronized void syncMethod() {
            System.out.println("Thread " 
              + Thread.currentThread().getName() + " is in syncMethod() method");
            while (true) {
                // t1은 여기에 영원히 유지되므로 t2의 접근은 차단됩니다.
            }
        }
    }
}