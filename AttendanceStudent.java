package day3;

import java.util.HashMap;
import java.util.Scanner;

public class AttendanceStudent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Boolean> attendance = new HashMap<>();
        String command;

        while (true) {
            System.out.println("======출석 관리 프로그램======");
            System.out.print("1. 등록");
            System.out.print(" 2. 목록");
            System.out.print(" 3. 출석 체크");
            System.out.print(" 4. 출석 현황");
            System.out.println(" 5. 종료");
            System.out.print("선택: ");
            command = sc.nextLine();

            switch (command) {
                case "1": // 등록
                    System.out.print("학생의 이름을 입력하세요: ");
                    String name = sc.nextLine();
                    if (!attendance.containsKey(name)) {
                        attendance.put(name, false); // 초기 출석 여부를 false로 설정
                        System.out.println(name + " 학생이 추가되었습니다.");
                    } else {
                        System.out.println("이미 등록된 학생입니다.");
                    }
                    break;

                case "2": // 목록
                    System.out.println("등록된 학생 목록:");
                    if (attendance.isEmpty()) {
                        System.out.println("등록된 학생이 없습니다.");
                    } else {
                        int index = 1; // 인덱스 초기화
                        for (String student : attendance.keySet()) {
                            System.out.println(index + ". " + student); // 인덱스와 학생 이름 출력
                            index++; // 인덱스 증가
                        }
                    }
                    break;

                case "3": // 출석 체크
                    System.out.print("출석 학생 이름: ");
                    String studentName = sc.nextLine();
                    if (attendance.containsKey(studentName)) {
                        attendance.put(studentName, true); // 출석 여부를 true로 설정
                        System.out.println(studentName + "의 출석이 처리되었습니다.");
                    } else {
                        System.out.println("등록되지 않은 학생입니다.");
                    }
                    break;

                case "4": // 출석 현황
                    System.out.println("출석 현황:");
                    if (attendance.isEmpty()) {
                        System.out.println("등록된 학생이 없습니다.");
                    } else {
                        for (String student : attendance.keySet()) {
                            String status = attendance.get(student) ? "출석" : "결석";
                            System.out.println(student + ": " + status);
                        }
                    }
                    break;

                case "5": // 종료
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    return;

                default:
                    System.out.println("유효하지 않은 선택입니다. 다시 시도하세요.");
            }
        }
    }
}