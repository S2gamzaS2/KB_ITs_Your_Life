package afternoon.lang.wrapper;

public class PerformanceMain {
    public static void main(String[] args) {
        int max = 1_000_000_000;
        long startTime, endTime;
        long sum1 = 0;

        startTime = System.currentTimeMillis();

        for(int i = 0; i < max; i++) {
            sum1 += i;
        }

        endTime = System.currentTimeMillis();

        System.out.println("원시: " + (endTime - startTime));
        ///////////
        Long sum2 = 0L;

        startTime = System.currentTimeMillis();

        for(int i = 0; i < max; i++) {
            sum2 += i;
        }

        endTime = System.currentTimeMillis();

        System.out.println("래퍼: " + (endTime - startTime));
    }
}
