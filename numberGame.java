package first;

import java.util.Random;
import java.util.Scanner;

public class numberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1; // 1부터 100 사이의 랜덤 숫자
        int attempts = 0;
        boolean hasGuessedCorrectly = false;

        System.out.println("1부터 100 사이의 숫자를 맞춰보세요!");

        while (!hasGuessedCorrectly) {
            System.out.print("숫자를 입력하세요: ");
            try {
                int guess = scanner.nextInt();
                attempts++;

                if (guess < 1 || guess > 100) {
                    System.out.println("오류: 1부터 100 사이의 숫자를 입력해 주세요.");
                } else if (guess < randomNumber) {
                    System.out.println("더 큰 숫자를 시도해 보세요.");
                } else if (guess > randomNumber) {
                    System.out.println("더 작은 숫자를 시도해 보세요.");
                } else {
                    hasGuessedCorrectly = true;
                    System.out.println("축하합니다! " + attempts + " 번 만에 맞추셨습니다.");
                }
            } catch (Exception e) {
                System.out.println("오류: 유효한 숫자를 입력해 주세요.");
                scanner.next(); // 잘못된 입력을 소비하여 다시 입력 받을 수 있도록 함
            }
        }

        scanner.close();
    }
}
