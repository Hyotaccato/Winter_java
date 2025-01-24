package first;

//Transport 클래스 정의 (부모 클래스)
class Transport {
 String brand;
 String model;
 int year;

 // 생성자
 Transport(String brand, String model, int year) {
     this.brand = brand;
     this.model = model;
     this.year = year;
 }

 // 메서드: 차량 정보 출력 (가상 메서드)
 void displayInfo() {
     System.out.println("브랜드: " + brand);
     System.out.println("모델: " + model);
     System.out.println("연도: " + year);
 }
}

//자동차 클래스 정의 (자식 클래스)
class Car extends Transport {
 int doors;

 // 생성자
 Car(String brand, String model, int year, int doors) {
     super(brand, model, year);
     this.doors = doors;
 }

 // 메서드 재정의
 @Override
 void displayInfo() {
     super.displayInfo();
     System.out.println("문 개수: " + doors);
 }
}

//자전거 클래스 정의 (자식 클래스)
class Bike extends Transport {
 boolean hasCarrier;

 // 생성자
 Bike(String brand, String model, int year, boolean hasCarrier) {
     super(brand, model, year);
     this.hasCarrier = hasCarrier;
 }

 // 메서드 재정의
 @Override
 void displayInfo() {
     super.displayInfo();
     System.out.println("캐리어 여부: " + (hasCarrier ? "있음" : "없음"));
 }
}

public class VehicleInfo {
 public static void main(String[] args) {
     // 자동차 객체 생성
     Car myCar = new Car("벤츠", "제네시스", 2022, 4);
     // 자전거 객체 생성
     Bike myBike = new Bike("스페셜라이즈드", "트렉", 2021, true);

     // 차량 정보 출력
     System.out.println("자동차 정보:");
     myCar.displayInfo();
     System.out.println();

     System.out.println("자전거 정보:");
     myBike.displayInfo();
 }
}
