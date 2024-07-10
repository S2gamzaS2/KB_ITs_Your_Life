package ch02.sec12;

public class PrintExample {
    public static void main(String[] args) {
        int value = 123;
        System.out.printf("상품 가격: %d원\n", value); //123
        System.out.printf("상품 가격: %6d원\n", value); //___123
        System.out.printf("상품 가격: %-6d원\n", value); //123___
        System.out.printf("상품 가격: %06d원\n", value); //000123
        System.out.printf("상품 가격: %06d원\n", value); //000123

        //컴파일러가 표현식을 평가하면서 자동으로 타입 처리
        System.out.printf("반지름이 %d인 원의 넓이: %10.2f\n", 10, 3.14159 * 10 * 10 ); //반지름이 10인 원의 넓이:     314.16
        System.out.printf("%6d | %-10s | %10s", 1, "홍길동", "도적"); //     1 | 홍길동        |         도적

    }
}
