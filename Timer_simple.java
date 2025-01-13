package day6;
import java.util.Scanner;

public class Timer_simple {

	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("타이머 설정(초): ");
		int seconds = sc.nextInt();
		
		System.out.println("타이머가 시작됩니다!");
		
        try {
            for (int i = seconds; i > 0; i--) {
                System.out.println(i + "초 남음");
                Thread.sleep(1000); // 1초 대기
            }
        } catch (InterruptedException e) {
            System.out.println("타이머가 중단되었습니다.");
        }
        
        System.out.println("타이머 종료!");
	}
}
