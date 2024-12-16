package Mypackage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Book_Select_Rooms extends JFrame implements ActionListener {
    static String type_of_room;
    static int per_day_cost;
    JButton luxurry, delu, kig;
    JLabel heading, lux, king, delux;
    JPanel left_panel, right_panel;
    Book_Select_Rooms() {
        heading = new JLabel("Book Room");
        heading.setFont(new Font("Candara", Font.ITALIC, 25));
        heading.setBounds(10, 10, 500, 50);

        ImageIcon i1 = new ImageIcon("luxury.PNG");
        lux = new JLabel();
        lux.setIcon(i1);
        lux.setBounds(20, 30, 200, 100);

        ImageIcon i2 = new ImageIcon("delux.PNG");
        delux = new JLabel();
        delux.setIcon(i2);
        delux.setBounds(20, 150, 200, 100);

        ImageIcon i3 = new ImageIcon("king.PNG");
        king = new JLabel();
        king.setIcon(i3);
        king.setBounds(20, 270, 200, 100);

        luxurry = new JButton("Luxury");
        luxurry.setBounds(20, 55, 100, 30);
        luxurry.setFocusable(false);
        luxurry.addActionListener(this);

        delu = new JButton("Delux");
        delu.setBounds(20, 180, 100, 30);
        delu.setFocusable(false);
        delu.addActionListener(this);

        kig = new JButton("Standard");
        kig.setBounds(20, 300, 100, 30);
        kig.setFocusable(false);
        kig.addActionListener(this);

        left_panel = new JPanel();
        left_panel.setBounds(0, 60, 250, 500);
        left_panel.setBackground(Color.WHITE);
        left_panel.setLayout(null);
        left_panel.add(lux);
        left_panel.add(delux);
        left_panel.add(king);

        right_panel = new JPanel();
        right_panel.setLayout(null);
        right_panel.setBounds(250, 60, 250, 500);
        right_panel.add(luxurry);
        right_panel.add(delu);
        right_panel.add(kig);
        right_panel.setBackground(Color.GREEN);

        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.add(heading);
        this.add(left_panel);
        this.add(right_panel);
        this.setResizable(false);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == luxurry) {
            type_of_room = "Luxury";
            per_day_cost = 1200;
            this.setVisible(false);
            new BookRoom();
        }

        else if(e.getSource() == delu) {
            type_of_room = "Delux";
            per_day_cost = 1000;
            this.setVisible(false);
            new BookRoom();
        }

        else if(e.getSource() == kig) {
            per_day_cost = 800;
            type_of_room = "Standard";
            this.setVisible(false);
            new BookRoom();
        }
    }

    public static void main(String[] args) {
        new Book_Select_Rooms();
    }
}
