package day2;
import java.util.Scanner;
public class ExchangeRate_hyo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("달러로 환절할 원화를 입력하세요. ");
        double won = sc.nextDouble();
        System.out.println(+won +"원은 달러로 "+won*0.00068+"입니다.");
    }
}