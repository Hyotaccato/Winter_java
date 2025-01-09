package day3;
import java.util.HashMap;
import java.util.Scanner;

class IdPw {
    private String id;
    private String pw;

    public IdPw(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }
}

public class LoginSystem {
    public static void main(String[] args) {
        // 아이디와 비밀번호를 저장하는 HashMap 생성
        HashMap<String, IdPw> userMap = new HashMap<>();
        
        // 사용자 정보 추가 (예시)
        userMap.put("hge", new IdPw("hge", "1111"));
        userMap.put("KGM", new IdPw("KGM", "2354"));
        userMap.put("PJW", new IdPw("PJW", "6479"));

        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("로그인 하시겠습니까?(y or n): ");
            String response = scanner.nextLine();

            if (response.equalsIgnoreCase("y")) {
                System.out.print("id: ");
                String id = scanner.nextLine();
                
                System.out.print("pw: ");
                String pw = scanner.nextLine();
                
                // 로그인 체크
                if (userMap.containsKey(id)) {
                    IdPw user = userMap.get(id);
                    if (user.getPw().equals(pw)) {
                        System.out.println("로그인 성공!");
                    } else {
                        System.out.println("비밀번호 불일치");
                    }
                } else {
                    System.out.println("아이디가 존재하지 않습니다.");
                }
            } else {
                break; // 사용자 입력이 'n'일 경우 루프 종료
            }
        }

        scanner.close();
    }
}
