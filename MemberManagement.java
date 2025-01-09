package day3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class Member {
    private String id;
    private String pw;
    private int age;
    private String gender;
    private String name;
    private String address;
    private String contact;
    private String notes;

    public Member(String id, String pw, int age, String gender, String name, String address, String contact, String notes) {
        this.id = id;
        this.pw = pw;
        this.age = age;
        this.gender = gender;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.notes = notes;
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getDetails() {
        return "아이디: " + id + ", 이름: " + name + ", 나이: " + age + ", 성별: " + gender + ", 주소: " + address + ", 연락처: " + contact + ", 비고: " + notes;
    }
}

public class MemberManagement {
    private HashMap<String, Member> userMap = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public void addMember() {
        System.out.print("아이디: ");
        String id = scanner.nextLine();
        System.out.print("비밀번호: ");
        String pw = scanner.nextLine();
        System.out.print("나이: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("성별: ");
        String gender = scanner.nextLine();
        System.out.print("이름: ");
        String name = scanner.nextLine();
        System.out.print("주소: ");
        String address = scanner.nextLine();
        System.out.print("연락처: ");
        String contact = scanner.nextLine();
        System.out.print("비고: ");
        String notes = scanner.nextLine();

        if (userMap.containsKey(id)) {
            System.out.println("이미 존재하는 아이디입니다.");
        } else {
            userMap.put(id, new Member(id, pw, age, gender, name, address, contact, notes));
            System.out.println("회원가입 성공!");
        }
    }

    public void updateMember() {
        System.out.print("수정할 아이디: ");
        String id = scanner.nextLine();

        if (userMap.containsKey(id)) {
            System.out.print("새 비밀번호: ");
            String newPw = scanner.nextLine();
            System.out.print("새 나이: ");
            int newAge = Integer.parseInt(scanner.nextLine());
            System.out.print("새 성별: ");
            String newGender = scanner.nextLine();
            System.out.print("새 이름: ");
            String newName = scanner.nextLine();
            System.out.print("새 주소: ");
            String newAddress = scanner.nextLine();
            System.out.print("새 연락처: ");
            String newContact = scanner.nextLine();
            System.out.print("새 비고: ");
            String newNotes = scanner.nextLine();

            Member updatedMember = new Member(id, newPw, newAge, newGender, newName, newAddress, newContact, newNotes);
            userMap.put(id, updatedMember);
            System.out.println("회원 정보 수정 완료!");
        } else {
            System.out.println("아이디가 존재하지 않습니다.");
        }
    }

    public void deleteMember() {
        System.out.print("삭제할 아이디: ");
        String id = scanner.nextLine();

        if (userMap.remove(id) != null) {
            System.out.println("회원 삭제 완료!");
        } else {
            System.out.println("아이디가 존재하지 않습니다.");
        }
    }

    public void searchMember() {
        System.out.print("검색할 아이디: ");
        String id = scanner.nextLine();

        if (userMap.containsKey(id)) {
            Member member = userMap.get(id);
            System.out.println(member.getDetails());
        } else {
            System.out.println("아이디가 존재하지 않습니다.");
        }
    }

    public void listMembers() {
        if (userMap.isEmpty()) {
            System.out.println("회원 목록이 비어 있습니다.");
        } else {
            System.out.println("회원 목록:");
            for (Member member : userMap.values()) {
                System.out.println(member.getDetails());
            }
        }
    }

    public void displayMenu() {
        while (true) {
            System.out.println("\n회원 관리 프로그램");
            System.out.println("1. 회원 가입");
            System.out.println("2. 회원 수정");
            System.out.println("3. 회원 삭제");
            System.out.println("4. 회원 검색");
            System.out.println("5. 회원 목록 확인");
            System.out.println("6. 종료");
            System.out.print("선택: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기

            switch (choice) {
                case 1:
                    addMember();
                    break;
                case 2:
                    updateMember();
                    break;
                case 3:
                    deleteMember();
                    break;
                case 4:
                    searchMember();
                    break;
                case 5:
                    listMembers();
                    break;
                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 입력하세요.");
            }
        }
    }

    public static void main(String[] args) {
        MemberManagement management = new MemberManagement();
        management.displayMenu();
    }
}
