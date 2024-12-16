package Mypackage;
//To create a new user or login to existing one.

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class User extends JFrame implements ActionListener {
    JLabel image_label;
    JButton back_button_1, login, signup, check_Reservation;
    JPanel right_panel, left_panel;
    Border border;

    User() {
        border = BorderFactory.createLineBorder(Color.BLACK, 1);
        ImageIcon userlogin = new ImageIcon("User_login.PNG");
        image_label = new JLabel(userlogin);
        image_label.setIcon(userlogin);
        image_label.setBounds(140, 40, 160, 160);
        image_label.setBorder(border);

        check_Reservation = new JButton("Check Reservation");
        check_Reservation.setFocusable(false);
        check_Reservation.setBounds(50, 150, 180, 30);
        check_Reservation.addActionListener(this);

        back_button_1 = new JButton();
        back_button_1.setText("Back");
        back_button_1.setBounds(50, 200, 100,  30);
        back_button_1.setFocusable(false);
        back_button_1.addActionListener(this);

        login = new JButton();
        login.setText("Login - Already Existing");
        login.setBounds(50, 70, 180, 30);
        login.setFocusable(false);
        login.addActionListener(this);

        signup = new JButton();
        signup.setText("Signup - New User");
        signup.setFocusable(false);
        signup.setBounds(50, 110, 180, 30);
        signup.addActionListener(this);

        left_panel = new JPanel();
        left_panel.setBackground(Color.WHITE);
        left_panel.setLayout(null);
        left_panel.setBounds(0, 0, 300, 300);
        left_panel.add(image_label);

        right_panel = new JPanel();
        right_panel.setBackground(Color.WHITE);
        right_panel.setLayout(null);
        right_panel.setBounds(300, 0, 400, 300);
        right_panel.add(back_button_1);
        right_panel.add(login);
        right_panel.add(signup);
        right_panel.add(check_Reservation);

        this.setSize(600, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.add(left_panel);
        this.add(right_panel);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back_button_1) {
            new Registration();
            this.setVisible(false);
        }

        else if(e.getSource() == signup) {
            new UserNew();
            this.setVisible(false);
        }

        else if(e.getSource() == login) {
            new UserLogin();
            this.setVisible(false);
        }

        else if(e.getSource() == check_Reservation) {
            new FindReservation();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new User();
    }
}
