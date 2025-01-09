package day1;
import java.util.Scanner;
import java.util.Random;

public class Dice_hyo{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        System.out.println("===========주사위 게임을 시작합니다.============");
        System.out.print("사용자의 닉네임을 입력해주세요: ");
        String playername = sc.nextLine();

        int retry;
        int life = 10;
        int score = 0;

        do {
            System.out.println("현재 life: "+life+", score: "+score);
            int computerRan = random.nextInt(6) + 1;
            System.out.println("상대의 주사위는 " + computerRan + "입니다.");
            int playerRan = random.nextInt(6) + 1;
            System.out.println(playername + "의 주사위는 " + playerRan + "입니다.");

            if (playerRan > computerRan) {
                System.out.println("축하합니다. 이겼습니다!");
                life += 1;
                score += 10;
            } else if (playerRan == computerRan) {
                System.out.println("비겼습니다.");
                life += 1;
            } else {
                System.out.println("졌습니다.");
                life -= 1;
            }

            // 게임 종료 조건 확인
            if (score == 100) {
                System.out.println("축하합니다! 점수가 100에 도달했습니다.");
                break; // 점수가 100에 도달하면 루프 종료
            } else if (life == 0) {
                System.out.println("생명이 0이 되었습니다. 게임 종료.");
                break; // 생명이 0이 되면 루프 종료
            }

            System.out.println("1. 게임 다시하기, 2. 게임 끝내기");
            retry = sc.nextInt();
        } while (retry == 1);

        System.out.println("게임이 종료되었습니다. 감사합니다!");
        sc.close(); // Scanner 객체 닫기
    }
}
