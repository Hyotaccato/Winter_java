package day8;

import java.sql.*;

public class JDBConnection {
	public Connection con; //연결된 드라이버에 SQL을 요청할 객체를 생성하는 클래스
	public Statement stmt = null; //SQL 실행 요청을 하는 클래스
	public PreparedStatement psmt; //Statement에서 파라미터 확장기능을 추가 제공하는 클래스
	public ResultSet rs; //SQL 실행결과를 받아오는 클래스
	
	public JDBConnection() {
		try {
			// MySQL 드라이버의 클래스를 로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			// DB에 연결
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopdb", "root", "101026");
			
			System.out.println("DB 연결 완료");
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from member");
			printData(rs, "id", "name", "addr");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
		} catch (SQLException e) {
			System.out.println("DB 연결 오류");
		}
	}
	
	private static void printData(ResultSet rs, String col1, String col2, String col3) throws SQLException {
		while (rs.next()) {
			if (!col1.equals(""))
				System.out.print(rs.getString("id"));
			if (!col2.equals(""))
				System.out.print("\t|\t" + rs.getString("name"));
			if (!col3.equals(""))
				System.out.println("\t|\t" + rs.getString("addr"));
		}
	}
	
	public static void main(String[] args) {
		JDBConnection jdbc = new JDBConnection();
	}
}