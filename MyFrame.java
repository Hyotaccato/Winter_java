package day4;
import javax.swing.*;

public class MyFrame extends JFrame{
	public MyFrame() {
		setTitle("300X300 스윙 프레임 만들기");
		setSize(300,300);//프레임 크키 300X300
		setVisible(true);
	}
	public static void main(String args[]) {
		MyFrame frame = new MyFrame();
	}
}
