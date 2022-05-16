package coding.challenge.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    TestConnect.class,
    TestHeartbeat.class,
    TestDisconnect.class
})
public class TestSuite {
    // 이 클래스는 빈 클래스입니다.
}