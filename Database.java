package win_login;

import java.sql.*;
import javax.swing.JOptionPane;

public class Database {
    Connection con = null;
    Statement stmt = null;
    String url = "jdbc:mysql://localhost/dbstudy?serverTimezone=Asia/Seoul"; // dbstudy 스키마
    String user = "root";
    String passwd = "101026"; // 본인이 설정한 root 계정의 비밀번호를 입력하면 된다.

    public Database() { // 데이터베이스에 연결한다.
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, passwd);
            stmt = con.createStatement();
            System.out.println("MySQL 서버 연동 성공");
        } catch (Exception e) {
            System.out.println("MySQL 서버 연동 실패 > " + e.toString());
        }
    }

    /* 로그인 정보를 확인 */
    boolean logincheck(String ii, String pp) {
        boolean flag = false;

        String id = ii;
        String pw = pp;

        try {
            String checkingStr = "SELECT password FROM member WHERE id=?";
            PreparedStatement pstmt = con.prepareStatement(checkingStr);
            pstmt.setString(1, id);
            ResultSet result = pstmt.executeQuery();

            while (result.next()) {
                if (pw.equals(result.getString("password"))) {
                    flag = true;
                } else {
                    flag = false;
                }
            }
        } catch (Exception e) {
            flag = false;
            System.out.println("로그인 실패 > " + e.toString());
        }
        return flag;
    }

    /* 게임 종료 버튼 이벤트 */
    public void handleButtonAction(String buttonText) {
        if (buttonText.equals("프로그램 종료")) {
            System.out.println("프로그램 종료");
            System.exit(0);
        }
        /* 회원가입 버튼 이벤트 */
        else if (buttonText.equals("회원가입")) {
            System.out.println("회원 가입");
        }
        /* 로그인 버튼 이벤트 */
        else if (buttonText.equals("로그인")) {
            // uid와 upass는 적절한 변수로 대체해야 합니다.
            String uid = ""; // 사용자 입력 아이디
            String upass = ""; // 사용자 입력 비밀번호

            if (uid.equals("") || upass.equals("")) {
                JOptionPane.showMessageDialog(null, "아이디와 비밀번호 모두 입력해주세요", "로그인 실패", JOptionPane.ERROR_MESSAGE);
                System.out.println("로그인 실패 > 로그인 정보 미입력");
            } else if (uid != null && upass != null) {
                if (logincheck(uid, upass)) { // 데이터베이스에 접속해 로그인 정보를 확인
                    System.out.println("로그인 성공");
                    JOptionPane.showMessageDialog(null, "로그인에 성공하였습니다");
                } else {
                    System.out.println("로그인 실패 > 로그인 정보 불일치");
                    JOptionPane.showMessageDialog(null, "로그인에 실패하였습니다");
                }
            }
        }
    }
}
