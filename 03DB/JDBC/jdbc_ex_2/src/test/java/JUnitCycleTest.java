import org.junit.jupiter.api.*;

public class JUnitCycleTest {
    @BeforeAll // 전체 테스트 시작 전 1회 실행, static
    static void beforeAll() {
        System.out.println("@BeforeAll");
    }
    @BeforeEach // 테스트케이스 시작 전 마다 실행
    public void beforeEach() {
        System.out.println("@BeforeEach");
    }
    @Test // 1번 테스트 케이스
    public void test1() {
        System.out.println("test 1");
    }
    @Test // 2번 테스트 케이스
    public void test2() {
        System.out.println("test 2");
    }
    @AfterEach // 테스트 케이스 종료 전 마다 실행
    public void afterEach() {
        System.out.println("@AfterEach");
    }
    @AfterAll // 전체 테스트를 마치고 종료하기 전 1회, static
    static void afterAll() {
        System.out.println("@AfterAll");
    }
}
