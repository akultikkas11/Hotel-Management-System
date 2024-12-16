package Mypackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserNew extends JFrame implements ActionListener {
    String emailPassword;  //To get email password
    UserInsert u;
    JPanel left_panel, right_panel;
    JTextField first_name, middle_name, last_name, emaill, cityy, statee, pincodee, c1, c2;
    JPasswordField passwordField;
    JToggleButton toggleButton;
    ImageIcon showIcon, hideIcon;
    boolean passwordVisible = false;
    JButton create;
    UserNew() {
        create = new JButton("Create Account");
        create.setBounds(10, 500, 150, 30);
        create.addActionListener(this);

        JLabel f_name, m_name, l_name, city, state, pincode, email, passwordLabel, contact1, contact2;
        f_name = new JLabel("First Name");
        f_name.setBounds(50, 50, 100, 30);

        m_name = new JLabel("Middle Name");
        m_name.setBounds(50, 90, 100, 30);

        l_name = new JLabel("Last Name");
        l_name.setBounds(50, 130, 100, 30);

        city = new JLabel("City");
        city.setBounds(50, 170, 100, 30);

        state = new JLabel("State");
        state.setBounds(50, 210, 100, 30);

        pincode = new JLabel("Pincode");
        pincode.setBounds(50, 250, 100, 30);

        contact1 = new JLabel("Phone no 1");
        contact1.setBounds(50, 290, 100, 30);

        contact2 = new JLabel("Phone no 2");
        contact2.setBounds(50, 330, 100, 30);

        email = new JLabel("Email");
        email.setBounds(50, 370, 100, 30);

        passwordLabel = new JLabel("Password"); // Added for password
        passwordLabel.setBounds(50, 410, 100, 30); // Adjusted position for password

        first_name = new JTextField();
        first_name.setBounds(50, 50, 100, 30);
        middle_name = new JTextField();
        middle_name.setBounds(50, 90, 100, 30);
        last_name = new JTextField();
        last_name.setBounds(50, 130, 100, 30);
        cityy = new JTextField();
        cityy.setBounds(50, 170, 100, 30);
        statee = new JTextField();
        statee.setBounds(50, 210, 100, 30);
        pincodee = new JTextField();
        pincodee.setBounds(50, 250, 100, 30);
        c1 = new JTextField();
        c1.setBounds(50, 290, 100, 30);
        c2 = new JTextField();
        c2.setBounds(50, 330, 100, 30);
        emaill = new JTextField();
        emaill.setBounds(50, 370, 100, 30);
        passwordField = new JPasswordField(); // Added for password
        passwordField.setBounds(50, 410, 100, 30);

        showIcon = new ImageIcon("show.png");
        hideIcon = new ImageIcon("hide.png");

        toggleButton = new JToggleButton(hideIcon);
        toggleButton.setBounds(160, 410, 30, 30);
        toggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passwordVisible = !passwordVisible;
                if (passwordVisible) {
                    passwordField.setEchoChar((char) 0); // Show password
                    toggleButton.setIcon(showIcon); // Set icon to show
                } else {
                    passwordField.setEchoChar('\u25cf'); // Hide password with bullet character
                    toggleButton.setIcon(hideIcon); // Set icon to hide
                }
            }
        });

        left_panel = new JPanel();
        left_panel.setBounds(0, 0, 200, 600);
        left_panel.setLayout(null);
        left_panel.setBackground(Color.WHITE);
        left_panel.add(f_name);
        left_panel.add(m_name);
        left_panel.add(l_name);
        left_panel.add(city);
        left_panel.add(state);
        left_panel.add(pincode);
        left_panel.add(contact1);
        left_panel.add(contact2);
        left_panel.add(email);
        left_panel.add(passwordLabel);

        right_panel = new JPanel();
        right_panel.setBounds(200, 0, 300, 600);
        right_panel.setLayout(null);
        right_panel.setBackground(Color.WHITE);
        right_panel.add(first_name);
        right_panel.add(middle_name);
        right_panel.add(last_name);
        right_panel.add(cityy);
        right_panel.add(statee);
        right_panel.add(pincodee);
        right_panel.add(emaill);
        right_panel.add(c1);
        right_panel.add(c2);
        right_panel.add(passwordField);
        right_panel.add(toggleButton);
        right_panel.add(create);

        this.setSize(500, 600);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.add(left_panel);
        this.add(right_panel);
        this.setVisible(true);

        u = new UserInsert();
    }

    public boolean isNotEmpty() {
        boolean TextField = true; //Text Field is not empty.
        if(first_name.getText().isEmpty())
            TextField = false;

        else if(middle_name.getText().isEmpty())
            TextField = false;

        else if(last_name.getText().isEmpty())
            TextField = false;

        else if(cityy.getText().isEmpty())
            TextField = false;

        else if(statee.getText().isEmpty())
            TextField = false;

        else if(pincodee.getText().isEmpty())
            TextField = false;

        else if (emaill.getText().isEmpty())
            TextField = false;

        else if (passwordField.getText().isEmpty())
            TextField = false;

        return TextField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String f_naam, m_naam, l_naam, city_text, state_text, email_text, pincod, cnt1, cnt2;
        int pin;
        long con1, con2;
        if(e.getSource() == create) {
            if(isNotEmpty()) {
                f_naam = first_name.getText();
                m_naam = middle_name.getText();
                l_naam = last_name.getText();
                city_text = cityy.getText();
                state_text = statee.getText();
                pincod = pincodee.getText();
                cnt1 = c1.getText();
                con1 = Long.parseLong(cnt1);
                cnt2 = c2.getText();
                con2 = Long.parseLong(cnt2);
                email_text = emaill.getText();

                char[] password = passwordField.getPassword();
                emailPassword = new String(password);

                try {
                    //Invokes the connection
                    u.connect();

                    //Insert the required values
                    u.insertUser(f_naam, m_naam, l_naam, city_text, state_text, pincod, email_text, emailPassword, con1, con2);

                    //After insertion, dis-connect the database.
                    u.disconnect();

                    this.setVisible(false);
                    new User();
                }
                catch (Exception e1) {
                    System.out.println(e1);
                }
            }

            else{
                JOptionPane.showMessageDialog(null, "Field cannot be Empty");
            }
//            try {
//                u.connect();
//                u.insertUser(f_naam, m_naam, l_naam, city_text, state_text, pincode_text, email_text, emailPassword);
//                u.disconnect();
//                JOptionPane.showMessageDialog(this, "Account Created");
//                this.setVisible(false);
//                new User();
//            }
//            catch (Exception e1) {
//                System.out.println(e1);
//            }
        }
    }

    public static void main(String[] args) {
        new UserNew();
    }
}
