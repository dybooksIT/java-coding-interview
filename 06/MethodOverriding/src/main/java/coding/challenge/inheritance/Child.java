package coding.challenge.inheritance;

public class Child extends Parent {
    @Override
    public void execute() {
        // super.execute(); - 슈퍼클래스의 코드를 먼저 실행하려는 경우
        System.out.println("Execute child code ...");
    }
}