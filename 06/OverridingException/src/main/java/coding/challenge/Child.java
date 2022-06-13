package coding.challenge;

import java.sql.BatchUpdateException;

public class Child extends Parent {
    // BatchUpdateException은 물론 SQLException의 서브클래스입니다.
    // SQLException이나 다른 서브클래스를 발생시킬 수 있습니다.
    @Override
    public void foo() throws BatchUpdateException { 
        System.out.println("Executing Child#foo() that throws BatchUpdateException");
        throw new BatchUpdateException("Child#foo() did this!", new int[0]);
    }

    // RuntimeException을 발생시킬 수 있습니다.
    @Override
    public void buzz() {
        throw new RuntimeException("Child#buzz() did this!");
    }
}