import java.util.Scanner;

public class AdvancedCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculating = true;

        while (continueCalculating) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            double num1 = scanner.nextDouble();

            System.out.print("연산자를 입력하세요 (+, -, *, /, ^, sqrt): ");
            String operator = scanner.next();

            double result;

            switch (operator) {
                case "+":
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    double num2 = scanner.nextDouble();
                    result = num1 + num2;
                    System.out.println("결과: " + result);
                    break;
                case "-":
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    num2 = scanner.nextDouble();
                    result = num1 - num2;
                    System.out.println("결과: " + result);
                    break;
                case "*":
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    num2 = scanner.nextDouble();
                    result = num1 * num2;
                    System.out.println("결과: " + result);
                    break;
                case "/":
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    num2 = scanner.nextDouble();
                    if (num2 != 0) {
                        result = num1 / num2;
                        System.out.println("결과: " + result);
                    } else {
                        System.out.println("0으로 나눌 수 없습니다.");
                    }
                    break;
                case "^":
                    System.out.print("지수를 입력하세요: ");
                    double exponent = scanner.nextDouble();
                    result = Math.pow(num1, exponent);
                    System.out.println("결과: " + result);
                    break;
                case "sqrt":
                    if (num1 >= 0) {
                        result = Math.sqrt(num1);
                        System.out.println("결과: " + result);
                    } else {
                        System.out.println("음수의 제곱근은 계산할 수 없습니다.");
                    }
                    break;
                default:
                    System.out.println("유효하지 않은 연산자입니다.");
                    break;
            }

            System.out.print("계속 계산하시겠습니까? (y/n): ");
            char choice = scanner.next().charAt(0);
            if (choice != 'y' && choice != 'Y') {
                continueCalculating = false;
            }
        }

        scanner.close();
        System.out.println("계산기를 종료합니다.");
    }
}
