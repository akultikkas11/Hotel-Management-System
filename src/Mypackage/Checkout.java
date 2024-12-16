package Mypackage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Checkout  extends JFrame implements ActionListener {
    CheckoutJDBC co;
    JLabel id;
    JTextField id_field;
    JButton checkOut, back;
    Checkout() {
        id = new JLabel("Customer id");
        id.setBounds(20, 50, 100, 30);

        id_field = new JTextField();
        id_field.setBounds(130, 50, 100, 30);

        checkOut = new JButton("Check-out");
        checkOut.setBounds(30, 100, 200, 50);
        checkOut.addActionListener(this);
        checkOut.setFocusable(false);

        back = new JButton("Back");
        back.addActionListener(this);
        back.setFocusable(false);
        back.setBounds(30, 170, 200, 50);

        this.setSize(500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.add(id_field);
        this.add(id);
        this.add(checkOut);
        this.add(back);
        this.setVisible(true);

        co = new CheckoutJDBC();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == checkOut) {
            String eid = id_field.getText();
            int c_id = Integer.parseInt(eid);
            //System.out.println(c_id);

            try{
                co.connect();
                co.Checkk_out(c_id);
                co.disconnect();
            }
            catch (Exception e2) {
                System.out.println(e2);
            }
        }

        if(e.getSource() == back) {
            this.setVisible(false);
            new Admin();
        }
    }

    public static void main(String[] args) {
        new Checkout();
    }
}
