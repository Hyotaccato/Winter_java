package Attendance;

import java.sql.*;

public class DatabaseManager {
    private Connection connection;

    public DatabaseManager(String url, String user, String password) {
        try {
            connection = DriverManager.getConnection(url, user, password);
            createTables();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTables() {
        try (Statement stmt = connection.createStatement()) {
            String createStudentsTable = "CREATE TABLE IF NOT EXISTS students (name VARCHAR(100), studentId VARCHAR(20) PRIMARY KEY)";
            String createAttendanceTable = "CREATE TABLE IF NOT EXISTS attendance (studentId VARCHAR(20), date DATE, isPresent BOOLEAN, FOREIGN KEY (studentId) REFERENCES students(studentId))";
            stmt.execute(createStudentsTable);
            stmt.execute(createAttendanceTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addStudent(Student student) {
        String sql = "INSERT INTO students (name, studentId) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getStudentId());
            pstmt.executeUpdate();
            System.out.println("학생이 등록되었습니다.");
        } catch (SQLException e) {
            System.out.println("학생 등록 실패: " + e.getMessage());
        }
    }

    public void markAttendance(Attendance attendance) {
        String sql = "INSERT INTO attendance (studentId, date, isPresent) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, attendance.getStudentId());
            pstmt.setDate(2, Date.valueOf(attendance.getDate()));
            pstmt.setBoolean(3, attendance.isPresent());
            pstmt.executeUpdate();
            System.out.println("출석이 기록되었습니다.");
        } catch (SQLException e) {
            System.out.println("출석 기록 실패: " + e.getMessage());
        }
    }

    public void markDeparture(String studentId, String date) {
        String sql = "INSERT INTO attendance (studentId, date, isPresent) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, studentId);
            pstmt.setDate(2, Date.valueOf(date));
            pstmt.setBoolean(3, false); 
            pstmt.executeUpdate(); 
            System.out.println("결석이 기록되었습니다."); 
        } catch (SQLException e) {
            System.out.println("결석 기록 실패: " + e.getMessage());
        }
    }

    public void viewAttendance(String studentId) {
        String sql = "SELECT date, isPresent FROM attendance WHERE studentId = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, studentId);
            ResultSet rs = pstmt.executeQuery();
            System.out.println("출석 내역:");
            while (rs.next()) {
                String date = rs.getDate("date").toString();
                boolean isPresent = rs.getBoolean("isPresent");
                System.out.println(date + ": " + (isPresent ? "출석" : "결석"));
            }
        } catch (SQLException e) {
            System.out.println("출석 조회 실패: " + e.getMessage());
        }
    }

    public void viewAllStudents() {
        String sql = "SELECT * FROM students";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("학생 목록:");
            while (rs.next()) {
                String name = rs.getString("name");
                String studentId = rs.getString("studentId");
                System.out.println("이름: " + name + ", 학생 ID: " + studentId);
            }
        } catch (SQLException e) {
            System.out.println("학생 목록 조회 실패: " + e.getMessage());
        }
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
