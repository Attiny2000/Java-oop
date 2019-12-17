import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main{

    public static void main(String args[]) {
        JFrame frame = new JFrame("Lab 1 oop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,200);
        JButton btn=new JButton("Start!");
        frame.getContentPane().add(btn, BorderLayout.EAST);
        JTextField input = new JTextField();
        frame.getContentPane().add(input, BorderLayout.CENTER);
        frame.setVisible(true);
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String inputline = input.getText();
                
                input.setText(inputline.substring(0, inputline.length()/2).toUpperCase() + inputline.substring(inputline.length()/2));
            }
        });
    }
}