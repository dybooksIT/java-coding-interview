package coding.challenge;

/* New 상태의 예:
   다음 코드에는 람다를 포함한 다양한 생성 기술을 통해
   New 상태를 나타내는 4개의 코드가 포함되어 있습니다.
*/

public class NewThread {
    public void newThread() {
        // 생성 1
        Thread t1 = new Thread(() -> { });
        System.out.println("New thread t1: " + t1.getState());

        // 생성 2
        Runnable runnable1 = () -> { };
        Thread t2 = new Thread(runnable1);
        System.out.println("New thread t2: " + t2.getState());

        // 생성 3
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
            }
        });
        System.out.println("New thread t3: " + t3.getState());

        // 생성 4
        Thread t4 = new Thread(new Thread() {
            @Override
            public void run() { }
        });
        System.out.println("New thread t4: " + t4.getState() + "\n");
    }
}