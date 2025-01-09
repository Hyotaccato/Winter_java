package day1;

import java.util.Scanner;
import java.util.Random;

public class Dice_hard_hyo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.println("===========주사위게임2===========");
        System.out.print("플레이어1의 이름을 입력하세요: ");
        String play1Name = sc.nextLine();
        System.out.print("플레이어2의 이름을 입력하세요: ");
        String play2Name = sc.nextLine();

        int play1Sum, play2Sum;
        int Whether;

        do {
            int play1Ran_1 = random.nextInt(6) + 1;
            System.out.println(play1Name + "의 첫번째 값입니다: " + play1Ran_1);
            int play2Ran_1 = random.nextInt(6) + 1;
            System.out.println(play2Name + "의 첫번째 값입니다: " + play2Ran_1);
            int play1Ran_2 = random.nextInt(6) + 1;
            System.out.println(play1Name + "의 두번째 값입니다: " + play1Ran_2);
            int play2Ran_2 = random.nextInt(6) + 1;
            System.out.println(play2Name + "의 두번째 값입니다: " + play2Ran_2);

            play1Sum = play1Ran_1 + play1Ran_2;
            play2Sum = play2Ran_1 + play2Ran_2;

            System.out.println("합을 계산합니다.");
            System.out.println(play1Name + "님 주사위 눈의 합: " + play1Sum);
            System.out.println(play2Name + "님 주사위 눈의 합: " + play2Sum);

            if (play1Sum > 10 && play2Sum > 10) {
                System.out.println("두 플레이어 모두 패배했습니다.");
            } else if (play1Sum > 10) {
                System.out.println(play2Name + "님의 우승입니다.");
            } else if (play2Sum > 10) {
                System.out.println(play1Name + "님의 우승입니다.");
            } else if (play1Sum == play2Sum) {
                System.out.println("무승부입니다.");
            } else if (play1Sum > play2Sum) {
                System.out.println(play1Name + "님의 우승입니다.");
            } else {
                System.out.println(play2Name + "님의 우승입니다.");
            }

            System.out.println("1. 한번 더 하기  2. 그만하기");
            Whether = sc.nextInt();
            sc.nextLine();
            
        } while (Whether == 1);

        System.out.println("게임이 종료되었습니다.");
        sc.close();
    }
}
