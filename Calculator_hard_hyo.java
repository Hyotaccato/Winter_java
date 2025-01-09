package day1;
import java.util.Scanner;
public class Calculator_hard_hyo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("계산기 프로그램입니다.");
        
        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            double num1 = sc.nextDouble();

            System.out.print("연산자를 입력하세요 (+, -, *, /): ");
            char operator = sc.next().charAt(0);

            System.out.print("두 번째 숫자를 입력하세요: ");
            double num2 = sc.nextDouble();

            double result;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    System.out.println("결과: " + result);
                    break;
                case '-':
                    result = num1 - num2;
                    System.out.println("결과: " + result);
                    break;
                case '*':
                    result = num1 * num2;
                    System.out.println("결과: " + result);
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                        System.out.println("결과: " + result);
                    } else {
                        System.out.println("0으로 나눌 수 없습니다.");
                    }
                    break;
                default:
                    System.out.println("유효하지 않은 연산자입니다.");
            }

            System.out.print("계속 하시겠습니까? (1.네, 2.아니오)");
            int continueCalc = sc.nextInt();
            if (continueCalc != 1) {
                break;
            }
        }

        System.out.println("계산기를 종료합니다.");
        sc.close();
    }
}
