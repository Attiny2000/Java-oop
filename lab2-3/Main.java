import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class Main {
    public static void main(String[] args) {
        
        Key key = new Key("T button", "3656564", "Black", 't', 34);
        JFrame frame = new JFrame("Lab 2 oop");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(340,300);

        JTextField input = new JTextField();
        frame.getContentPane().add(input);
        frame.setVisible(true);
        input.setBounds(10,120, 300, 100);

        JButton btn1=new JButton("Btn1");
        frame.getContentPane().add(btn1);
        btn1.setBounds(10,10, 100, 100);
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                input.setText(key.getKeyName());
            }
        });

        JButton btn2=new JButton("Btn2");
        frame.getContentPane().add(btn2);
        btn2.setBounds(110,10, 100, 100);
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Color initialcolor = Color.RED; 
                Color color = JColorChooser.showDialog(btn2, "Select a color", initialcolor); 
                btn2.setBackground(color);
                key.keyColor = btn2.getBackground().toString();
                input.setText(btn2.getBackground().toString()); 
            }
        });

        JButton btn3=new JButton("Btn3");
        frame.getContentPane().add(btn3);
        btn3.setBounds(210,10, 100, 100);
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                input.setText(key.getKeyCode());
            }
        });
    }
}

class Key {
    String keyName;
    String keyCode;
    String keyColor;
    char keyChar;
    int keyNumber;


    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(String keyCode) {
        this.keyCode = keyCode;
    }

    public String getKeyColor() {
        return keyColor;
    }

    public void setKeyColor(String keyColor) {
        this.keyColor = keyColor;
    }

    public char getKeyChar() {
        return keyChar;
    }

    public void setKeyChar(char keyChar) {
        this.keyChar = keyChar;
    }

    public int getKeyNumber() {
        return keyNumber;
    }

    public void setKeyNumber(int keyNumber) {
        this.keyNumber = keyNumber;
    }

    public Key(String keyCode, char keyChar) {
        this.keyCode = keyCode;
        this.keyChar = keyChar;
    }

    public Key(String keyCode, char keyChar, int keyNumber) {
        this(keyCode, keyChar);
        this.keyNumber = keyNumber;
    }

    public Key(String keyName, String keyCode, String keyColor, char keyChar, int keyNumber) {
        this(keyCode, keyChar, keyNumber);
        this.keyName = keyName;
        this.keyColor = keyColor;
    }

}