package day5;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class AnonymousClassListener extends JFrame {
    public AnonymousClassListener() {
        setTitle("Action 이벤트 리스너 작성");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        JButton btn = new JButton("Action");
        c.add(btn);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (btn.getText().equals("Action")) // btn 사용
                    btn.setText("액션");
                else
                    btn.setText("Action");
                
                setTitle(btn.getText()); // btn 사용
            }
        });

        setSize(350, 150);
        setVisible(true);
    }
    public static void main(String[] args) {
        new AnonymousClassListener();
    }
}
