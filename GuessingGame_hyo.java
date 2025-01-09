package day2;
import java.util.Scanner;
public class GuessingGame_hyo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("=========게임시작=========");
        System.out.println("1부터 100까지 숫자중에 숫자를 맞추세요.");
        int ran = (int)(Math.random() * 100) + 1;
        int get;
        do{
            System.out.println("숫자를 입력하세요.(맞추면 종료) : ");
            get = sc.nextInt();
            if(ran>get){
                System.out.println(get+"보다 커요!");
            }else if(ran<get){
                System.out.println(get+"보다 작아요!");
            }
        }while (ran!=get);
        System.out.println("정답입니다.");
    }
}