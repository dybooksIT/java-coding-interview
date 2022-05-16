package coding.challenge;

public class Main {
    // 모든 예제를 실행합니다.
    public static void main(String[] args) throws InterruptedException {
        // NEW 상태에 대한 시나리오를 실행합니다.
        System.out.println("Run scenario for the NEW state");
        NewThread nt = new NewThread();
        nt.newThread();

        Thread.sleep(5000);

        // RUNNABLE 상태에 대한 시나리오를 실행합니다.
        System.out.println("Run scenario for the RUNNABLE state");
        RunnableThread rt = new RunnableThread();
        rt.runnableThread();

        Thread.sleep(5000);

        // WAITING 상태에 대한 시나리오를 실행합니다.
        System.out.println("Run scenario for the WAITING state");
        WaitingThread wt = new WaitingThread();
        wt.waitingThread();

        Thread.sleep(5000);

        // TIME_WAITING 상태에 대한 시나리오를 실행합니다.
        System.out.println("Run scenario for the TIME_WAITING state");
        TimedWaitingThread twt = new TimedWaitingThread();
        twt.timedWaitingThread();

        Thread.sleep(5000);

        // TERMINATED 상태에 대한 시나리오를 실행합니다.
        System.out.println("Run scenario for the TERMINATED state");
        TerminatedThread tt = new TerminatedThread();
        tt.terminatedThread();
        
        // BLOCKED 상태에 대한 시나리오를 실행합니다.
        System.out.println("Run scenario for the BLOCKED state");
        BlockedThread bt = new BlockedThread();
        bt.blockedThread();
    }
}