package coding.challenge;

import coding.challenge.inheritance.Child;
import coding.challenge.inheritance.Parent;
import coding.challenge.polymorphism.Concrete;

public class Main {
    public static void main(String[] args) {
        // 상속의 메서드 오버라이딩
        Parent parent = new Parent();
        Child child = new Child();

        parent.execute();
        child.execute();

        // 런타임 다형성의 메서드 상속
        Concrete concrete = new Concrete();
        concrete.execute();
    }
}