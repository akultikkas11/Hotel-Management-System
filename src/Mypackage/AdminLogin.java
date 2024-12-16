package Mypackage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLogin extends JFrame implements ActionListener {
    JPanel left_panel, right_panel;
    JButton login_button, back;
    JLabel admin_id, password;
    JTextField admin_id_field;
    JPasswordField pass_field;
    JToggleButton toggleButton;
    ImageIcon showIcon, hideIcon;
    boolean passwordVisible = false;
    AdminLogin() {
        login_button = new JButton("Login");
        login_button.addActionListener(this);
        login_button.setFocusable(false);
        login_button.setBounds(0, 180, 100, 40);

        back = new JButton("Back");
        back.addActionListener(this);
        back.setFocusable(false);
        back.setBounds(0, 250, 100, 40);

        admin_id = new JLabel("Admin ID ");
        admin_id.setBounds(80, 40, 100, 30);

        password = new JLabel("Password ");
        password.setBounds(80, 80, 100, 30);

        admin_id_field = new JTextField();
        admin_id_field.setBounds(0, 40, 100, 30);

        pass_field = new JPasswordField();
        pass_field.setBounds(0, 80, 100, 30);
        showIcon = new ImageIcon("show.png");
        hideIcon = new ImageIcon("hide.png");
        toggleButton = new JToggleButton(hideIcon);
        toggleButton.setBounds(140, 80, 30, 30);
        toggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passwordVisible = !passwordVisible;
                if (passwordVisible) {
                    pass_field.setEchoChar((char) 0); // Show password
                    toggleButton.setIcon(showIcon); // Set icon to show
                } else {
                    pass_field.setEchoChar('\u25cf'); // Hide password with bullet character
                    toggleButton.setIcon(hideIcon); // Set icon to hide
                }
            }
        });

        left_panel = new JPanel();
        left_panel.setLayout(null);
        left_panel.setBounds(0, 0, 250, 400);
        left_panel.add(admin_id);
        left_panel.add(password);

        right_panel = new JPanel();
        right_panel.setLayout(null);
        right_panel.setBounds(250, 0, 250, 400);
        right_panel.add(pass_field);
        right_panel.add(toggleButton);
        right_panel.add(admin_id_field);
        right_panel.add(login_button);
        right_panel.add(back);

        this.setSize(500, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.add(left_panel);
        this.add(right_panel);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String id, pass, passwrd;
        char[] password;
        int admin_id;
        int id_admin = 12345;
        pass = "SunShineHotel";
        if(e.getSource() == login_button) {
            id = admin_id_field.getText();
            admin_id = Integer.parseInt(id);

            password = pass_field.getPassword();
            passwrd = new String(password);

            if(admin_id == id_admin && (passwrd.compareTo(pass) == 0)) {
                JOptionPane.showMessageDialog(null, "Login Successfull");
                this.setVisible(false);
                new Admin();
            }
            else {
                JOptionPane.showMessageDialog(null, "Login Failed, Try Again");
                this.setVisible(false);
                new AdminLogin();
            }
        }

        if(e.getSource() == back) {
            this.setVisible(false);
            new Registration();
        }
    }

    public static void main(String[] args) {
        new AdminLogin();
    }
}

