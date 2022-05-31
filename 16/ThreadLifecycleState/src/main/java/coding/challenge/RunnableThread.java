package coding.challenge;

/* RUNNABLE(실행 대기) 상태의 시나리오:
   다음 코드는 RUNNABLE 상태를 출력해야 합니다. start 메서드를 호출한 후
   스레드의 상태를 출력하기 때문입니다. 단, 스레드 스케줄러 내부 구조 때문에
   항상 스레드의 상태를 출력함을 보장하지 않습니다.
*/

public class RunnableThread {
    public void runnableThread() {
        Thread t1 = new Thread(() -> { });
        t1.start();

        System.out.println("RunnableThread t1: " + t1.getState());

        Runnable runnable1 = () -> { };
        Thread t2 = new Thread(runnable1);
        t2.start();
        System.out.println("RunnableThread t2: " + t2.getState());

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() { }
        });
        t3.start();
        System.out.println("RunnableThread t3: " + t3.getState());

        Thread t4 = new Thread(new Thread() {
            @Override
            public void run() { }
        });
        t4.start();
        System.out.println("RunnableThread t4: " + t4.getState() + "\n");
    }
}