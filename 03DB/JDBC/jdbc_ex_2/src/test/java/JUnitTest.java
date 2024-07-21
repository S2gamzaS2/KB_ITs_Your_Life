import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JUnitTest {

    @DisplayName("1 + 2 는 3이다") // 메서드별로 이름을 붙여줌
    @Test
    public void junitTest() {
        int a = 1;
        int b = 2;
        int sum = 4;

        Assertions.assertEquals(a + b, sum); // 기대값, 실제값
    }
}
