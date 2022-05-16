package coding.challenge.test;

import java.io.File;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class AssumptionsTest {
    @Test
    public void givenFolderWhenGetAbsolutePathThenSuccess() {
        assumingThat(File.separatorChar == '/',
            () -> {
                assertThat(new File(".").getAbsolutePath(),
                  is("D:/GitHub/dybooksIT/java-coding-interview/18/junit5"));
            });

        // 일반 테스트와 마찬가지로 항상 이 어셔션(assertion)을 실행합니다.
        assertTrue(true);
    }
}