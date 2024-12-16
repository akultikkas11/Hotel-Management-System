package Mypackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends JFrame implements ActionListener {
    JButton hotel_details, cust_details, back, checkout;
    Admin() {
        hotel_details = new JButton("Hotel Details");
        hotel_details.setBounds(20, 50, 150, 30);
        hotel_details.addActionListener(this);

        back = new JButton("Back");
        back.addActionListener(this);
        back.setFocusable(false);
        back.setBounds(20, 200, 100, 40);

        checkout = new JButton("Check-out Customer");
        checkout.setBounds(20, 130, 180, 30);
        checkout.addActionListener(this);
        checkout.setFocusable(false);

        cust_details = new JButton("Customer Details");
        cust_details.setBounds(20, 90, 180, 30);
        cust_details.addActionListener(this);
        cust_details.setFocusable(false);

        this.setSize(400, 300);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        //this.add(hotel_details);
        this.add(cust_details);
        this.add(back);
        this.add(checkout);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cust_details) {
            new CustDetails();
            this.setVisible(false);
        }

        else if(e.getSource() == back) {
            this.setVisible(false);
            new Registration();
        }

        else if(e.getSource() == checkout) {
            this.setVisible(false);
            new Checkout();
        }
    }

    public static void main(String[] args) {
        new Admin();
    }
}
