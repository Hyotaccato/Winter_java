package day1;
import java.util.Scanner;
public class Calculator_easy_hyo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double first = 0;
        while (true) {
            System.out.println("첫번째 수를 입력하세요. : ");
            String input = sc.nextLine();

            try {
                first = Double.parseDouble(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("다시 입력하세요.");
            }
        }

        System.out.println("연산자를 입력하세요.(+,-,*,/,%) :   ");
        String operator = sc.next();

        double second = 0;
        while (true) {
            System.out.print("두번째 수를 입력하세요. : ");
            String input = sc.next();

            try {
                second = Double.parseDouble(input); // 문자열을 double로
                break;
            } catch (NumberFormatException e) {
                System.out.println("다시 입력하세요. 유효한 숫자가 아닙니다.");
            }
        }
        sc.close();

        switch (operator) {
            case "+":
                System.out.println("계산결과 \n" + (first + second));
                break;
            case "-":
                System.out.println("계산결과 \n" + (first - second));
                break;
            case "*":
                System.out.println("계산결과 \n" + (first * second));
                break;
            case "/":
                if (second != 0) {
                    System.out.println("계산결과: " + (first / second));
                } else {
                    System.out.println("0으로 나눌 수 없습니다.");
                }
                break;
            case "%":
                if (second != 0) {
                    System.out.println("계산결과: " + (first % second));
                } else {
                    System.out.println("0으로 나눌 수 없습니다.");
                }
                break;
            default:
                System.out.println("유효하지 않은 연산자입니다.");
        }
    }
}