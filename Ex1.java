//1111 이효은

package homework;

class Point{
	private int x;
	private int y;
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}

class Circle{
	private Point cen;
	private double rad;
	
	public Circle(Point cen, double rad) {
		this.cen = cen;
		this.rad = rad;
	}
	
	public double OneWide() {
		return Math.PI * rad * rad;
	}
	public Point getCen() {
		return cen;
	}
	public double getRad() {
		return rad;
	}
}

public class Ex1{
	public static void main(String[] args) {
		Point p = new Point(33, 27);
		Circle cir = new Circle(p, 2);
		double Wide = cir.OneWide();
		
		System.out.printf("점의 좌표<%d, %d>인 반지름 %d인 원의 넓이 : %.3f\n", p.getX(), p.getY(), (int)cir.getRad(), Wide);
	}
}