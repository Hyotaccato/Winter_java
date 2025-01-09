package day2;
import java.util.Scanner;
public class Rate_hyo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("환율을 입력하세요. : ");
        double rate = sc.nextDouble();
        System.out.println("바꿀 금액을 입력하세요. : ");
        double money = sc.nextDouble();
        System.out.println("변환되 금액은"+rate*money);
    }
}
