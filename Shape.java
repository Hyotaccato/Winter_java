package first;

public class Shape {

    // 사각형의 넓이 계산
    public double Area(double Length, double Width) {
        return Length * Width;
    }

    // 원의 넓이 계산
    public double Area(double radius) {
        return Math.PI * radius * radius;
    }

    // 삼각형의 넓이 계산
    public double Area(double Base, double Height) {
        return 0.5 * Base * Height;
    }

    public static void main(String[] args) {
        Shape shape = new Shape();

        // 사각형 넓이
        System.out.println("사각형의 넓이: " + shape.Area(5.0, 3.0));

        // 원의 넓이
        System.out.println("원의 넓이: " + shape.Area(4.0));

        // 삼각형 넓이
        System.out.println("삼각형의 넓이: " + shape.Area(4.0, 5.0));
    }
}
