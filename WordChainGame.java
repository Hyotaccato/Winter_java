package first;

import java.util.ArrayList;
import java.util.Scanner;

public class WordChainGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> usedWords = new ArrayList<>();
        boolean isPlaying = true;
        int currentPlayer = 1; // Player 1부터 시작

        System.out.println("🎮 [끝말잇기 게임]");
        System.out.println("규칙:");
        System.out.println("1. 단어의 마지막 글자로 시작하는 단어를 입력하세요.");
        System.out.println("2. 중복된 단어는 사용할 수 없습니다.");
        System.out.println("3. 규칙에 어긋나면 게임이 종료됩니다.");
        System.out.println("게임을 종료하고 싶으면 '끝'이라고 입력하세요.\n");
        System.out.println("게임을 시작합니다! 🚀\n");

        String previousWord = ""; // 첫 단어는 없음

        while (isPlaying) {
            System.out.println("Player " + currentPlayer + " 차례입니다!");
            System.out.print("👉 단어를 입력하세요: ");
            String input = scanner.nextLine().trim();

            // 게임 종료 조건
            if (input.equals("끝")) {
                System.out.println("🛑 Player " + currentPlayer + "이(가) 게임을 종료했습니다!");
                break;
            }

            // 단어 검증
            if (!isValidWord(input, previousWord, usedWords)) {
                System.out.println("❌ 규칙에 어긋났습니다! Player " + currentPlayer + "이(가) 졌습니다.");
                break;
            }

            // 단어를 목록에 추가하고 다음 차례로 넘어감
            usedWords.add(input);
            previousWord = input; // 현재 단어를 다음 플레이어의 이전 단어로 설정
            System.out.println("✅ 올바른 단어입니다! 다음 차례로 넘어갑니다.\n");

            // 차례 변경
            currentPlayer = (currentPlayer == 1) ? 2 : 1;
        }

        System.out.println("\n🎉 게임이 끝났습니다!");
        System.out.println("사용된 단어들: " + String.join(", ", usedWords));
        System.out.println("감사합니다! 다음에 또 만나요! 👋");
        scanner.close();
    }

    // 단어 검증 메서드
    public static boolean isValidWord(String word, String previousWord, ArrayList<String> usedWords) {
        // 첫 번째 단어는 이전 단어와 상관없이 통과
        if (previousWord.isEmpty()) {
            return !usedWords.contains(word); // 중복만 확인
        }

        // 1. 이전 단어의 마지막 글자와 현재 단어의 첫 글자가 일치해야 함
        if (!word.startsWith(previousWord.substring(previousWord.length() - 1))) {
            return false;
        }

        // 2. 이미 사용된 단어인지 확인
        return !usedWords.contains(word);
    }
}

