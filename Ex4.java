//1111 이효은

package homework;

abstract class Member {
    protected String id;
    protected String name; 

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
    }


    public abstract void showInfo();
}

class Teacher extends Member {
    private String subject;
    private int years;

    public Teacher(String id, String name, String subject, int years) {
        super(id, name);
        this.subject = subject;
        this.years = years;
    }

    @Override
    public void showInfo() {
        System.out.printf("%-4s  %-6s  %-10s  %2d\n", id, name, subject, years);
    }
}

class Student extends Member {
    private String major;
    private int grade;

    public Student(String id, String name, String major, int grade) {
        super(id, name);
        this.major = major.equals("D") ? "디자인" : "소프트웨어";
        this.grade = grade;
    }

    @Override
    public void showInfo() {
        String gradeInfo = (grade >= 1 && grade <= 3) ? String.valueOf(grade) : "오류(" + grade + ")";
        System.out.printf("%-4s  %-6s  %-10s  %s\n", id, name, major, gradeInfo);
    }
}

class Admin extends Member {
    private String duty;
    private int years;

    public Admin(String id, String name, String duty, int years) {
        super(id, name);
        this.duty = duty;
        this.years = years;
    }

    @Override
    public void showInfo() {
        System.out.printf("%-4s  %-6s  %-10s  %2d\n", id, name, duty, years);
    }
}

public class Ex4 {
    public static void main(String[] args) {
        String[][] data = {
            {"MS1", "강서연", "D", "10"},{"MS2", "고주원", "S", "7"},{"MT1", "양민서", "영어", "21"},{"MA1", "송하준", "정보보호", "11"},{"MT2", "방서현", "운영체제", "25"},{"MS3", "김예준", "S", "3"},{"MT3", "이지민", "컴퓨터그래픽", "8"}
        };

        Member[] members = new Member[data.length];

        for (int i = 0; i < data.length; i++) {
            String id = data[i][0];
            String name = data[i][1];

            if (id.charAt(1) == 'T') {
                String subject = data[i][2];
                int years = Integer.parseInt(data[i][3]);
                members[i] = new Teacher(id, name, subject, years);
            } else if (id.charAt(1) == 'S') {
                String major = data[i][2];
                int grade = Integer.parseInt(data[i][3]);
                members[i] = new Student(id, name, major, grade);
            } else if (id.charAt(1) == 'A') {
                String duty = data[i][2];
                int years = Integer.parseInt(data[i][3]);
                members[i] = new Admin(id, name, duty, years);
            }
        }

        System.out.println("선생님*************************");
        for (Member member : members) {
            if (member instanceof Teacher) {
                member.showInfo();
            }
        }
        System.out.println("********************************");
        System.out.println("학생*************************");
        for (Member member : members) {
            if (member instanceof Student) {
                member.showInfo();
            }
        }
        System.out.println("********************************");
        System.out.println("관리자*************************");
        for (Member member : members) {
            if (member instanceof Admin) {
                member.showInfo();
            }
        }
        System.out.println("********************************");
    }
}
