package first;

//Student 클래스 정의
class Student {
 // 필드(멤버 변수)
 private String name;
 private int age;
 private String major;

 // 생성자(Constructor)
 public Student(String name, int age, String major) {
     this.name = name;
     this.age = age;
     this.major = major;
 }

 // Getter 메서드
 public String getName() {
     return name;
 }

 public int getAge() {
     return age;
 }

 public String getMajor() {
     return major;
 }

 // Setter 메서드
 public void setName(String name) {
     this.name = name;
 }

 public void setAge(int age) {
     this.age = age;
 }

 public void setMajor(String major) {
     this.major = major;
 }

 // 학생 정보 출력 메서드
 public void printInfo() {
     System.out.println("학생 이름: " + name);
     System.out.println("나이: " + age);
     System.out.println("전공: " + major);
 }
}

//메인 클래스
public class class_easy {
 public static void main(String[] args) {
     // Student 객체 생성
     Student student1 = new Student("이효은", 20, "컴퓨터공학");
     Student student2 = new Student("김이레", 22, "전자공학");

     // 객체 메서드 호출
     student1.printInfo();
     System.out.println("-------------------");
     student2.printInfo();

     // 객체의 데이터 수정
     student1.setMajor("소프트웨어공학");
     System.out.println("\n수정 후 학생 정보:");
     student1.printInfo();
 }
}

