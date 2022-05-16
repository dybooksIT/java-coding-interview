package coding.challenge.login.test;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SuiteDisplayName("TEST LOGIN AND CONNECTION")
@SelectPackages({
    "coding.challenge.connection.test",
    "coding.challenge.login.test"
})
public class TestLoginSuite {
    // 이 클래스는 빈 클래스입니다.
}