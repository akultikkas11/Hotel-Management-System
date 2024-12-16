package Mypackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserLogin extends JFrame implements ActionListener {
    static String c_idd;
    JPasswordField pass_field;
    JToggleButton toggleButton;
    ImageIcon showIcon, hideIcon;
    boolean passwordVisible = false;
    JButton login_button;
    JTextField email_field, password_field, cus_id_field;
    JLabel email_label, password_label, customer_id_label;
    JPanel upper_panel, lower_panel;

    UserValidateLogin uv;
    UserLogin() {
        login_button = new JButton("Login");
        login_button.setBounds(130, 230, 120, 50);
        login_button.setFocusable(false);
        login_button.setFont(new Font("Arial", Font.PLAIN, 20));
        login_button.addActionListener(this);

        customer_id_label = new JLabel("Customer_id");
        customer_id_label.setBounds(50, 50, 80, 30);

        email_label = new JLabel("Email");
        email_label.setBounds(50, 90, 80, 30);

        password_label = new JLabel("Password");
        password_label.setBounds(50, 140, 80, 30);

        cus_id_field = new JTextField();
        cus_id_field.setBounds(220, 50, 80, 30);

        email_field = new JTextField();
        email_field.setBounds(220, 90, 80, 30);

        pass_field = new JPasswordField();
        pass_field.setBounds(220, 140, 80, 30);
        showIcon = new ImageIcon("show.png");
        hideIcon = new ImageIcon("hide.png");

        toggleButton = new JToggleButton(hideIcon);
        toggleButton.setBounds(320, 140, 30, 30);
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

        //password_field = new JTextField();
        //password_field.setBounds(220, 140, 80, 30);

        upper_panel = new JPanel();
        upper_panel.setBounds(0, 0, 400, 200);
        upper_panel.setBackground(Color.CYAN);

        lower_panel = new JPanel();
        lower_panel.setLayout(null);
        lower_panel.setBounds(0, 200, 400, 400);
        lower_panel.setBackground(Color.YELLOW);
        lower_panel.add(customer_id_label);
        lower_panel.add(email_label);
        lower_panel.add(password_label);
        lower_panel.add(cus_id_field);
        lower_panel.add(email_field);
        lower_panel.add(pass_field);
        lower_panel.add(toggleButton);
        lower_panel.add(login_button);

        this.setSize(400, 600);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(upper_panel);
        this.add(lower_panel);
        this.setVisible(true);

        uv = new UserValidateLogin();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String c_id, mail, pass;
        int id;
        if(e.getSource() == login_button) {
            c_id = cus_id_field.getText();
            c_idd = c_id;
            id = Integer.parseInt(c_id);
            mail = email_field.getText();

            char[] password = pass_field.getPassword();
            pass = new String(password);
            //pass = password_field.getText();

            try {
                uv.connect();
                int valid = uv.validate(id, mail, pass);
                uv.disconnect();

                if(valid == 1) {
                    this.setVisible(false);
                    new Book_Select_Rooms();
                }
                else if(valid == 0) {
                    this.setVisible(false);
                    new UserLogin();
                }
            }
            catch(Exception e1) {
                System.out.println(e1);
            }
        }
    }

    public static void main(String[] args) {
        new UserLogin();
    }
}

