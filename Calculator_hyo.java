package day1;
import java.util.Scanner;
public class Calculator_hyo{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("두 수를 입력하세요 : ");
            double first = sc.nextDouble();
            double second = sc.nextDouble();
            sc.nextLine();
            System.out.println("연산자를 입력사에요 : ");
            String operator = sc.nextLine();
            if (operator.equals("+")){
                System.out.println("결과 : "+(first+second));
            }
            else if(operator.equals("-")){
                System.out.println("결과 : "+(first-second));
            }
            else if(operator.equals("*")){
                System.out.println("결과 : "+(first*second));
            }
            else if(operator.equals("/")){
                System.out.println("결과 : "+(first/second));
            }
            else if(operator.equals("%")){
                System.out.println("결과 : "+(first%second));
            }
            System.out.print("계속하시겠습니까?     (1:예, 2:아니요)");
            int answer = sc.nextInt();
            if(answer == 2){
                break;
            }
        }
    }
}