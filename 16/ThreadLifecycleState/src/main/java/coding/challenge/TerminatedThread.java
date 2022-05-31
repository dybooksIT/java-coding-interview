package coding.challenge;

/* TERMINATED(종료) 상태의 시나리오:
   애플리케이션의 메인 스레드는 스레드의 상태 t를 출력합니다.
   상태 t를 출력하면 스레드 t가 작업을 완료한 것입니다.
*/

public class TerminatedThread {
    public void terminatedThread() {
        Thread t = new Thread(() -> { });
        t.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            // 로그 관련 코드 삽입
        }

        System.out.println("TerminatedThread t: " + t.getState() + "\n");
    }
}