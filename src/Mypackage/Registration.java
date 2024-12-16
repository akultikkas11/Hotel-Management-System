package Mypackage;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registration extends JFrame implements ActionListener {
    JButton back_button, admin_button, user_button;
    ImageIcon imagee;
    JLabel image_label;
    JPanel left_panel, right_panel;
    Border border;

    Registration() {
        border = BorderFactory.createLineBorder(Color.BLACK, 1);
        imagee = new ImageIcon("admin_login_2.PNG");

        image_label = new JLabel();
        image_label.setIcon(imagee);
        image_label.setBounds(200, 92, 166, 150);
        image_label.setBorder(border);

        user_button = new JButton();
        user_button.setText("User");
        user_button.setFocusable(false);
        user_button.setBounds(50, 100, 100, 30);
        user_button.addActionListener(this);

        back_button = new JButton();
        back_button.setText("Back");
        back_button.setFocusable(false);
        back_button.addActionListener(this);
        back_button.setBounds(50, 200, 100, 30);

        admin_button = new JButton();
        admin_button.setText("Admin");
        admin_button.setFocusable(false);
        admin_button.setBounds(50, 150, 100, 30);
        admin_button.addActionListener(this);

        left_panel = new JPanel();
        left_panel.setLayout(null);
        left_panel.setBounds(0, 0, 400, 500);
        left_panel.setBackground(Color.WHITE);
        left_panel.add(image_label);
        left_panel.setBackground(new Color(100, 200, 200));

        right_panel = new JPanel();
        right_panel.setLayout(null);
        right_panel.setBounds(400, 0, 400, 500);
        right_panel.setBackground(Color.WHITE);
        right_panel.add(back_button);
        right_panel.add(admin_button);
        right_panel.add(user_button);
        right_panel.setBackground(new Color(100, 200, 200));

        this.setSize(800, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(left_panel);
        this.add(right_panel);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back_button) {
            new Welcome();
            this.setVisible(false);
        }

        else if(e.getSource() == user_button) {
            new User();
            this.setVisible(false);
        }

        else if(e.getSource() == admin_button) {
            new AdminLogin();
            this.setVisible(false);
        }
    }

    //Here create the main method and all..........
    //public static void main(String[] args)...........
    public static void main(String[] args) {
        new Registration();
    }
}
