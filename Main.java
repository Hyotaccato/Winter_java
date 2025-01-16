package Attendance;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DatabaseManager dbManager = new DatabaseManager("jdbc:mysql://localhost:3306/attendance_db", "root", "101026");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. 학생 등록");
            System.out.println("2. 출석 체크");
            System.out.println("3. 결석 체크"); 
            System.out.println("4. 내역 조회");
            System.out.println("5. 학생 전체 보기");
            System.out.println("6. 종료");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("학생 이름: ");
                    String name = scanner.nextLine();
                    System.out.print("학생 ID: ");
                    String studentId = scanner.nextLine();
                    dbManager.addStudent(new Student(name, studentId));
                    System.out.println(name + "님 등록되었습니다.");
                    break;
                case 2:
                    System.out.print("학생 ID: ");
                    studentId = scanner.nextLine();
                    System.out.print("날짜 (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    dbManager.markAttendance(new Attendance(studentId, date, true));
                    break;
                case 3: 
                    System.out.print("학생 ID: ");
                    studentId = scanner.nextLine();
                    System.out.print("날짜 (YYYY-MM-DD): ");
                    date = scanner.nextLine();
                    dbManager.markDeparture(studentId, date);
                    break;
                case 4: 
                    System.out.print("학생 ID: ");
                    studentId = scanner.nextLine();
                    dbManager.viewAttendance(studentId);
                    break;
                case 5:
                    dbManager.viewAllStudents();
                    break;
                case 6:
                    System.out.println("프로그램을 종료합니다."); 
                    dbManager.close(); 
                    scanner.close(); 
                    return; 
                default:
                    System.out.println("유효하지 않은 선택입니다.");
            }
        }
    }
}
