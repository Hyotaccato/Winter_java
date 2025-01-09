package day2;
import java.util.*;
import java.util.Scanner;
class NumberQA{
    private int randomNumber;
    private int numberOfTries;

    public NumberQA(){
        Random ran = new Random();
        this.randomNumber = ran.nextInt(100)+1;
        this.numberOfTries = 0;
    }
    public void starGame(){
        Scanner sc = new Scanner(System.in);
        boolean hasGuessedCorrectly = false;
        System.out.println("=========숫자 맞추기 게임==========");
        System.out.println("1부터 100사이의 숫자를 맞춰보세요.");
        System.out.println("=============================");
        while(!hasGuessedCorrectly){
            System.out.println("숫자를 입력하세요. : ");
            int playGuess = sc.nextInt();
            numberOfTries++;

            if(playGuess < randomNumber){
                System.out.println("더 큰 숫자를 시도해보세요.");
            }else if(playGuess > randomNumber){
                System.out.println("더 작은 숫자를 시도해보세요.");
            }else{
                hasGuessedCorrectly = true;
                System.out.println("축하합니다! 정답입니다: "+randomNumber);
                System.out.println("시도횟수: "+numberOfTries);
            }
        }
    }
}
public class GuessingGame_hard_hyo {
    public static void main(String[] args) {
        NumberQA game = new NumberQA();
        game.starGame();
    }
}
