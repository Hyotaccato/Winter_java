package first;

import java.util.Scanner;

public class SumAndAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("숫자 몇 개를 입력하시겠습니까? ");
        int count = scanner.nextInt();

        if (count <= 0) {
            System.out.println("0보다 큰 숫자를 입력해주세요.");
            return;
        }

        int sum = 0;
        for (int i = 1; i <= count; i++) {
            System.out.print(i + "번째 숫자를 입력하세요: ");
            int number = scanner.nextInt();
            sum += number;
        }

        double average = (double) sum / count;

        System.out.println("총합: " + sum);
        System.out.println("평균: " + average);

        scanner.close();
    }
}