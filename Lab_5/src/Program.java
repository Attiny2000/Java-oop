import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Program {

    private static Ticket t;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lab 5 oop");
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 460);

        t = new Ticket("000000", 0.00);
        frame.getContentPane().add(t);
        t.setBounds(0, 0, 150, 150);

        JComboBox comboBox = new JComboBox();
        frame.getContentPane().add(comboBox);
        comboBox.setBounds(10, 130, 210, 20);
        comboBox.addItem("Ticket");
        comboBox.addItem("Bus ticket");

        // 1
        JLabel l1 = new JLabel();
        frame.getContentPane().add(l1);
        l1.setBounds(10, 150, 210, 20);
        l1.setText("Number");
        JTextArea text1 = new JTextArea();
        frame.getContentPane().add(text1);
        text1.setBounds(10, 170, 210, 20);
        // 2
        JLabel l2 = new JLabel();
        frame.getContentPane().add(l2);
        l2.setBounds(10, 190, 210, 20);
        l2.setText("Price");
        JTextArea text2 = new JTextArea();
        frame.getContentPane().add(text2);
        text2.setBounds(10, 210, 210, 20);
        // 3
        JLabel l3 = new JLabel();
        frame.getContentPane().add(l3);
        l3.setBounds(10, 230, 210, 20);
        l3.setText("Launch station");
        JTextArea text3 = new JTextArea();
        frame.getContentPane().add(text3);
        text3.setBounds(10, 250, 210, 20);
        // 4
        JLabel l4 = new JLabel();
        frame.getContentPane().add(l4);
        l4.setBounds(10, 270, 210, 20);
        l4.setText("Destination station");
        JTextArea text4 = new JTextArea();
        frame.getContentPane().add(text4);
        text4.setBounds(10, 290, 210, 20);
        // 5
        JLabel l5 = new JLabel();
        frame.getContentPane().add(l5);
        l5.setBounds(10, 310, 210, 20);
        l5.setText("Launch time");
        JTextArea text5 = new JTextArea();
        frame.getContentPane().add(text5);
        text5.setBounds(10, 330, 210, 20);

        JButton button = new JButton();
        frame.getContentPane().add(button);
        button.setBounds(120, 10, 100, 100);
        button.setText("Create!");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                frame.getContentPane().remove(t);
                if (comboBox.getSelectedItem() == "Ticket") {
                    if (text1.getText().length() > 0 && text2.getText().length() > 0) {
                        t = new Ticket(text1.getText(), Double.parseDouble(text2.getText()));
                        frame.getContentPane().add(t);
                        t.setBounds(0, 0, 150, 150);
                        frame.getContentPane().revalidate();
                        frame.getContentPane().repaint();
                    }
                }
                if (comboBox.getSelectedItem() == "Bus ticket") {
                    if (text1.getText().length() > 0 && text2.getText().length() > 0 && text3.getText().length() > 0 && text4.getText().length() > 0 && text5.getText().length() > 0)
                        t = new BusTicket(text1.getText(), Double.parseDouble(text2.getText()), text3.getText(), text4.getText(), text5.getText());
                    frame.getContentPane().add(t);
                    t.setBounds(0, 0, 150, 150);
                    frame.getContentPane().revalidate();
                    frame.getContentPane().repaint();
                }
            }
        });

        JButton button2 = new JButton();
        frame.getContentPane().add(button2);
        button2.setBounds(10, 360, 105, 40);
        button2.setText("Edit!");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (comboBox.getSelectedItem() == "Ticket") {
                    if (text1.getText().length() > 0 && text2.getText().length() > 0) {
                        t.setId(text1.getText());
                        t.setPrice(Double.parseDouble(text2.getText()));
                        frame.getContentPane().revalidate();
                        frame.getContentPane().repaint();
                    }
                }
                if (comboBox.getSelectedItem() == "Bus ticket") {
                    if (t instanceof BusTicket && text1.getText().length() > 0 && text2.getText().length() > 0 && text3.getText().length() > 0 && text4.getText().length() > 0 && text5.getText().length() > 0){
                        BusTicket b = (BusTicket) t;
                        b.setId(text1.getText());
                        b.setPrice(Double.parseDouble(text2.getText()));
                        b.setLaunchStation(text3.getText());
                        b.setDestinationStation(text4.getText());
                        b.setLaunchTime(text5.getText());
                        //t = b;

                        frame.getContentPane().revalidate();
                        frame.getContentPane().repaint();
                    }
                }
            }
        });

        JButton button3 = new JButton();
        frame.getContentPane().add(button3);
        button3.setBounds(115, 360, 105, 40);
        button3.setText("Refresh!");
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (t instanceof BusTicket){
                    text1.setText(t.getId());
                    text2.setText("" + t.getPrice());
                    text3.setText(((BusTicket) t).getLaunchStation());
                    text4.setText(((BusTicket) t).getDestinationStation());
                    text5.setText(((BusTicket) t).getLaunchTime());
                }
                else{
                    text1.setText(t.getId());
                    text2.setText("" + t.getPrice());
                }
            }
        });
    }
}
