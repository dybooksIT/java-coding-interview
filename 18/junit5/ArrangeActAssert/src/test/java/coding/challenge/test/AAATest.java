package coding.challenge.test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class AAATest {
    @Test
    public void givenStreamWhenSumThenEquals6() {
        // 준비(Arrange)
        Stream<Integer> theStream = Stream.of(1, 2, 3);

        // 실행(Act)
        int sum = theStream.mapToInt(i -> i).sum();

        // 단언(Assert)
        assertEquals(6, sum);
    }
}