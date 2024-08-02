package 재귀;

public class recursionExample {
    public static void main(String[] args) {

        System.out.println(factorial(3));
        System.out.println(fibonacci(7));
    }
    // 팩토리얼
    public static int factorial(int n) {
        if(n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    // 피보나치수열
    public static int fibonacci(int n) {
        if(n == 1 | n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
