package coding.challenge;

/* TIME_WAITING 상태의 시나리오:
   1. t1 스레드를 생성합니다.
   2. start 메서드를 통해 t1 실행을 시작합니다.
   3. t1의 run 메서드에 2초(임의 시간)의 휴면 시간을 추가합니다.
   4. t1이 실행되는 동안 메인 스레드는 t1 상태를 출력합니다.
      t1은 2초 후에 만료되는 sleep 메서드가 관리하므로 상태는 TIME_WAITING이어야 합니다.
*/

public class TimedWaitingThread {
    public void timedWaitingThread() {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                // 로그 관련 코드 삽입
            }
        });
        t.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            // 로그 관련 코드 삽입
        }

        System.out.println("TimedWaitingThread t: " + t.getState() + "\n");
    }
}