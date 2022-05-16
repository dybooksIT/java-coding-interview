package coding.challenge;

public class Main {
    // 이 코드는 교착 상태로 이어진다는 점에 주의하세요!!!

    static class FirstThread implements Runnable {
        @Override
        public void run() {
            synchronized (Double.class) {
                System.out.println("Double.class locked by " + Thread.currentThread().getName());
                synchronized (Float.class) {
                    System.out.println("Float.class locked by " + Thread.currentThread().getName());
                }
            }
        }
    }

    static class SecondThread implements Runnable {
        @Override
        public void run() {
            synchronized (Float.class) {
                System.out.println("Float.class locked by " + Thread.currentThread().getName());
                synchronized (Double.class) {
                    System.out.println("Double.class locked by " + Thread.currentThread().getName());
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new FirstThread(), "First-thread").start();
        new Thread(new SecondThread(), "Second-thread").start();
    }
}