//1111 이효은

package homework;
import java.util.Scanner;

class Rectangle{
	private double width;
	private double height;
	
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	public double getWidth() {
		return width;
	}
	public double getHeight() {
		return height;
	}
	
	public double Area() {
		return width*height;
	}
	
	public double PeriM() {
		return 2 * (width + height);
	}
}

public class Ex2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("생성할 사각형의 개수를 입력하세요: ");
		int num = sc.nextInt();
		
		Rectangle[] nums = new Rectangle[num];
		
		for(int i = 0; i < num; i++) {
			System.out.printf("%d번 사각형\n", i+1);
			System.out.print("가로길이 입력 : ");
			double width = sc.nextDouble();
			System.out.print("세로길이 입력 : ");
			double height = sc.nextDouble();
			
			nums[i] = new Rectangle(width, height);
		}
		
		for(int i = 0; i<num; i++) {
			double Area = nums[i].Area();
			double periM = nums[i].PeriM();
			System.out.printf("가로 %.2f이고, 세로 %.2f인 사각형의 둘레 : %.2f, 면적 : %s\n", nums[i].getWidth(), nums[i].getHeight(), periM, Area);
		}
		sc.close();
	}
}